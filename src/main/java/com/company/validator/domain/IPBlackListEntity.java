package com.company.validator.domain;

import javax.persistence.*;

@Entity
@Table(name = "IP_BLACKLIST")
public class IPBlackListEntity extends Auditable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Active")
    private String active;

    @OneToOne
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String ip) {
        this.active = ip;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
