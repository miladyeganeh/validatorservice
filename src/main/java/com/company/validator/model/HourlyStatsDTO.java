package com.company.validator.model;

import com.company.validator.domain.HourlyStatsEntity;

public class HourlyStatsDTO {

    private Long id;
    private String time;
    private Long requestCount;
    private Long invalidRequestCount;
    private CustomerDTO customerDTO;

    public static HourlyStatsEntity to(HourlyStatsDTO hourlyStatsDTO){
        HourlyStatsEntity hourlyStatsEntity = new HourlyStatsEntity();
        hourlyStatsEntity.setId(hourlyStatsDTO.getId());
        hourlyStatsEntity.setTime(hourlyStatsDTO.getTime());
        hourlyStatsEntity.setRequestCount(hourlyStatsDTO.getRequestCount());
        hourlyStatsEntity.setInvalidRequestCount(hourlyStatsDTO.getInvalidRequestCount());
        hourlyStatsEntity.setCustomer(CustomerDTO.from(hourlyStatsDTO.getCustomerDTO()));
        return hourlyStatsEntity;
    }

    public static HourlyStatsDTO from(HourlyStatsEntity hourlyStatsEntity){
        HourlyStatsDTO hourlyStatsDTO = new HourlyStatsDTO();
        hourlyStatsDTO.setId(hourlyStatsEntity.getId());
        hourlyStatsDTO.setTime(hourlyStatsEntity.getTime());
        hourlyStatsDTO.setRequestCount(hourlyStatsEntity.getRequestCount());
        hourlyStatsDTO.setInvalidRequestCount(hourlyStatsEntity.getInvalidRequestCount());
        hourlyStatsDTO.setCustomerDTO(CustomerDTO.from(hourlyStatsEntity.getCustomer()));
        return hourlyStatsDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(Long requestCount) {
        this.requestCount = requestCount;
    }

    public Long getInvalidRequestCount() {
        return invalidRequestCount;
    }

    public void setInvalidRequestCount(Long invalidRequestCount) {
        this.invalidRequestCount = invalidRequestCount;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }
}
