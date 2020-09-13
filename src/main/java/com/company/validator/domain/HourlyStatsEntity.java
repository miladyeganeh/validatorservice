package com.company.validator.domain;

import javax.persistence.*;

@Entity
@Table(
        name = "HOURLY_STATS",
        uniqueConstraints = @UniqueConstraint(columnNames = {"CUSTOMER_ID", "TIME"}, name = "UK_CUSTOMER_TIME")
)
public class HourlyStatsEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "TIME")
    private String time;

    @Column(name = "REQUEST_COUNT")
    private Long requestCount;

    @Column(name = "INVALID_REQUEST_COUNT")
    private Long invalidRequestCount;

    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerEntity customer;

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

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
}
