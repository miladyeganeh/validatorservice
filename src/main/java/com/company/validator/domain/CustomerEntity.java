package com.company.validator.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CUTOMER")
public class CustomerEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ACTIVE")
    private Boolean active;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UserEntity user;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<HourlyStatsEntity> hourlyStats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Set<HourlyStatsEntity> getHourlyStats() {
        return hourlyStats;
    }

    public void setHourlyStats(Set<HourlyStatsEntity> hourlyStats) {
        this.hourlyStats = hourlyStats;
    }
}
