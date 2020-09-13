package com.company.validator.biz.queue;

import com.company.validator.domain.CustomerEntity;
import com.company.validator.domain.HourlyStatsEntity;
import com.company.validator.model.enums.RequestType;
import com.company.validator.model.request.RequestDTO;
import com.company.validator.repository.CustomerRepository;
import com.company.validator.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.function.BiFunction;
import java.util.function.Function;

public class RequestConsumer implements Runnable {

    @Autowired
    private CustomerRepository customerRepository;

    private final BlockingQueue<RequestDTO> toBeSaveStats;
    private final Function<Long , Optional<CustomerEntity>> getCustomerFunc;
    private final Function<HourlyStatsEntity, HourlyStatsEntity> statsPersistFunc;
    private final BiFunction<String, Long, Optional<HourlyStatsEntity>> getHourlyStatsFunc;

    public RequestConsumer(BlockingQueue<RequestDTO> toBeSaveStats,
                           Function<Long, Optional<CustomerEntity>> getCustomerFunc,
                           Function<HourlyStatsEntity, HourlyStatsEntity> statsPersistFunc,
                           BiFunction<String, Long, Optional<HourlyStatsEntity>> getHourlyStatsFunc) {

        this.toBeSaveStats = toBeSaveStats;
        this.getCustomerFunc = getCustomerFunc;
        this.statsPersistFunc = statsPersistFunc;
        this.getHourlyStatsFunc = getHourlyStatsFunc;
    }

    @Override
    public void run() {
        while (toBeSaveStats.size() > 0) {
            try {
                RequestDTO requestDTO = toBeSaveStats.take();
                String roundHour = DateUtil.getRoundHour(requestDTO.getTimestamp());
                Optional<HourlyStatsEntity> hourlyStatsEntityOptional = this.getHourlyStatsFunc.apply(roundHour, requestDTO.getCustomerID());
                hourlyStatsEntityOptional.ifPresentOrElse(hourlyStatsEntity -> {
                    Long requestCount = hourlyStatsEntity.getRequestCount();
                    hourlyStatsEntity.setRequestCount(requestCount + 1);
                    if (requestDTO.getType().equals(RequestType.INVALID)) {
                        Long invalidRequestCount = hourlyStatsEntity.getInvalidRequestCount() == null ? 0 : hourlyStatsEntity.getInvalidRequestCount();
                        hourlyStatsEntity.setInvalidRequestCount(invalidRequestCount + 1);
                    }
                    this.statsPersistFunc.apply(hourlyStatsEntity);
                }, () -> this.statsPersistFunc.apply(createStats(requestDTO)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private HourlyStatsEntity createStats(RequestDTO requestDTO){
        Optional<CustomerEntity> customerEntityOptional = this.getCustomerFunc.apply(requestDTO.getCustomerID());
        HourlyStatsEntity hourlyStatsEntity = new HourlyStatsEntity();
        Set<HourlyStatsEntity> hourlyStatsEntitySet = new HashSet<>();
        customerEntityOptional.ifPresentOrElse(customerEntity -> {
            hourlyStatsEntity.setCustomer(customerEntity);
            hourlyStatsEntity.setTime(DateUtil.getRoundHour(requestDTO.getTimestamp()));
            hourlyStatsEntity.setRequestCount(1L);
            if (requestDTO.getType().equals(RequestType.INVALID)) {
                hourlyStatsEntity.setInvalidRequestCount(1L);
            }
            hourlyStatsEntitySet.add(hourlyStatsEntity);
            customerEntity.setHourlyStats(hourlyStatsEntitySet);
        }, () -> {throw new RuntimeException("Cannot find task with given id");});
        return hourlyStatsEntity;
    }
}
