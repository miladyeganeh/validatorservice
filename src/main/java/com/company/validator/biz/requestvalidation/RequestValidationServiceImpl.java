package com.company.validator.biz.requestvalidation;

import com.company.validator.biz.aggregator.ValidationAggregator;
import com.company.validator.biz.queue.RequestConsumer;
import com.company.validator.biz.queue.RequestProducer;
import com.company.validator.model.enums.RequestType;
import com.company.validator.model.request.RequestDTO;
import com.company.validator.model.response.ResponseDTO;
import com.company.validator.service.CustomerService;
import com.company.validator.service.HourlyStatsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class RequestValidationServiceImpl implements RequestValidationService{

    private final HourlyStatsService hourlyStatsService;
    private final CustomerService customerService;
    private final ValidationAggregator validationAggregator;
    private static final BlockingQueue<RequestDTO> toBeSaveStats = new LinkedBlockingQueue<>();

    public RequestValidationServiceImpl(ValidationAggregator customerRequestValidator,
                                        HourlyStatsService hourlyStatsService, CustomerService customerService) {
        this.validationAggregator = customerRequestValidator;
        this.hourlyStatsService = hourlyStatsService;
        this.customerService = customerService;
    }

    @Override
    public ResponseDTO persistRequest(RequestDTO request) {
        ResponseDTO response = new ResponseDTO();
        List<String> validate = validate(response, request);
        if (validate != null && !validate.isEmpty()) {
            request.setType(RequestType.INVALID);
        }else {
            request.setType(RequestType.VALID);
        }
        new RequestProducer(toBeSaveStats, request).add();
        ExecutorService consumerExecutor = Executors.newSingleThreadExecutor();
        consumerExecutor.execute(new RequestConsumer(toBeSaveStats, customerService::findById, hourlyStatsService::persist, hourlyStatsService::findByTimeAndAndCustomer));
        consumerExecutor.shutdown();
        return response;
    }

    @Override
    public List<String> validate(ResponseDTO response, RequestDTO request) {
        return this.validationAggregator.aggregate(response, request);
    }
}
