package com.company.validator.repository;

import com.company.validator.domain.HourlyStatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HourlyStatsRepository extends JpaRepository<HourlyStatsEntity, Long> {

    @Query("SELECT h FROM HourlyStatsEntity h WHERE h.time = ?1 and h.customer.id = ?2")
    Optional<HourlyStatsEntity> findByTimeAndCustomer(String time, Long customerID);

    @Query("SELECT h FROM HourlyStatsEntity h WHERE h.customer.id = ?1")
    List<HourlyStatsEntity> findCustomerID(Long customerID);
    List<HourlyStatsEntity> findByTime(String time);

}
