package com.company.validator.service.impl;

import com.company.validator.domain.HourlyStatsEntity;
import com.company.validator.model.HourlyStatsDTO;
import com.company.validator.model.response.ResponseDTO;
import com.company.validator.repository.HourlyStatsRepository;
import com.company.validator.service.HourlyStatsService;
import com.company.validator.util.DateUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HourlyStatsServiceImpl implements HourlyStatsService {

    private final HourlyStatsRepository hourlyStatsRepository;

    public HourlyStatsServiceImpl(HourlyStatsRepository hourlyStatsRepository) {
        this.hourlyStatsRepository = hourlyStatsRepository;
    }

    @Override
    public HourlyStatsEntity save(HourlyStatsEntity hourlyStatsEntity) {
        return this.hourlyStatsRepository.save(hourlyStatsEntity);
    }

    @Override
    public HourlyStatsEntity persist(HourlyStatsEntity hourlyStatsEntity) {
        Optional<HourlyStatsEntity> hourlyStatsEntityOptional = Optional.empty();
        if (hourlyStatsEntity.getId() != null){
            hourlyStatsEntityOptional = this.hourlyStatsRepository.findById(hourlyStatsEntity.getId());
        }
        return hourlyStatsEntityOptional.map(hourlyStats -> {
            hourlyStats.setRequestCount(hourlyStatsEntity.getRequestCount());
            hourlyStats.setInvalidRequestCount(hourlyStatsEntity.getInvalidRequestCount());
            return this.hourlyStatsRepository.save(hourlyStats);
        }).orElse(save(hourlyStatsEntity));
    }

    @Override
    public Optional<HourlyStatsEntity> findByTimeAndAndCustomer(String time, Long customerID) {
        return this.hourlyStatsRepository.findByTimeAndCustomer(time, customerID);
    }

    @Override
    public List<HourlyStatsDTO> findCustomerID(Long customerID) {
        List<HourlyStatsDTO> hourlyStatsDTO = new ArrayList<>();
        List<HourlyStatsEntity> stats = this.hourlyStatsRepository.findCustomerID(customerID);
        stats.forEach(statsEntity -> hourlyStatsDTO.add(HourlyStatsDTO.from(statsEntity)));
        return hourlyStatsDTO;
    }

    @Override
    public List<HourlyStatsDTO> findByTimeStamp(Long timeStamp) {
        List<HourlyStatsDTO> hourlyStatsDTO = new ArrayList<>();
        List<HourlyStatsEntity> stats = this.hourlyStatsRepository.findByTime(DateUtil.getRoundHour(timeStamp));
        stats.forEach(statsEntity -> hourlyStatsDTO.add(HourlyStatsDTO.from(statsEntity)));
        return hourlyStatsDTO;
    }
}
