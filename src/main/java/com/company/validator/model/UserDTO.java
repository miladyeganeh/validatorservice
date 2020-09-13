package com.company.validator.model;

import com.company.validator.domain.UserEntity;

public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String remoteIP;
    private String uuid;
    private Boolean ipBlackList;
    private Boolean uaBlackList;

    public static UserDTO from(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setFirstName(userEntity.getFirstName());
        userDTO.setLastName(userEntity.getLastName());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setUuid(userEntity.getUuid());
        userDTO.setRemoteIP(userEntity.getRemoteIP());
        userDTO.setIpBlackList(userEntity.getIpBlackList() != null);
        userDTO.setUaBlackList(userEntity.getUaBlackList() != null);
        return userDTO;
    }

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

    public Boolean getIpBlackList() {
        return ipBlackList;
    }

    public void setIpBlackList(Boolean ipBlackList) {
        this.ipBlackList = ipBlackList;
    }

    public Boolean getUaBlackList() {
        return uaBlackList;
    }

    public void setUaBlackList(Boolean uaBlackList) {
        this.uaBlackList = uaBlackList;
    }
}
