package com.company.validator.domain;

import javax.persistence.*;

@Entity
@Table(name = "UA_BLACKLIST")
public class UABlackListEntity extends Auditable{

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
