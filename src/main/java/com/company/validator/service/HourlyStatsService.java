package com.company.validator.service;


import com.company.validator.domain.HourlyStatsEntity;
import com.company.validator.model.HourlyStatsDTO;

import java.util.List;
import java.util.Optional;

public interface HourlyStatsService {
    HourlyStatsEntity save(HourlyStatsEntity hourlyStatsEntity);
    HourlyStatsEntity persist(HourlyStatsEntity hourlyStatsEntity);
    Optional<HourlyStatsEntity> findByTimeAndAndCustomer(String time, Long customerID);
    List<HourlyStatsDTO> findCustomerID(Long customerID);
    List<HourlyStatsDTO> findByTimeStamp(Long customerID);
}
