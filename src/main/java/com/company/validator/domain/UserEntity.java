package com.company.validator.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "USERS")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Email
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "IP")
    private String remoteIP;

    @Column(name = "UUID", unique = true)
    private String uuid;

    @OneToOne(cascade = CascadeType.ALL)
    private CustomerEntity customer;

    @OneToOne
    private IPBlackListEntity ipBlackList;

    @OneToOne
    private UABlackListEntity uaBlackList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemoteIP() {
        return remoteIP;
    }

    public void setRemoteIP(String remoteIP) {
        this.remoteIP = remoteIP;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public IPBlackListEntity getIpBlackList() {
        return ipBlackList;
    }

    public void setIpBlackList(IPBlackListEntity ipBlackList) {
        this.ipBlackList = ipBlackList;
    }

    public UABlackListEntity getUaBlackList() {
        return uaBlackList;
    }

    public void setUaBlackList(UABlackListEntity uaBlackList) {
        this.uaBlackList = uaBlackList;
    }
}
