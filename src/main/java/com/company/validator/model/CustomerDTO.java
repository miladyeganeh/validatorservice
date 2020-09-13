package com.company.validator.model;

import com.company.validator.domain.CustomerEntity;

public class CustomerDTO {

    private Long id;
    private String name;
    private Boolean active;
    private Long userID; //Todo change to UserDTO

    public static CustomerDTO from(CustomerEntity customerEntity){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customerEntity.getId());
        customerDTO.setActive(customerEntity.getActive());
        customerDTO.setName(customerEntity.getName());
        customerDTO.setUserID(customerEntity.getUser().getId());
        return customerDTO;
    }

    public static CustomerEntity from(CustomerDTO customerDTO){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customerDTO.getId());
        customerEntity.setActive(customerDTO.getActive());
        customerEntity.setName(customerDTO.getName());
//        customerEntity.setUser(); //Todo change to UserDTO
        return customerEntity;
    }

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

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}
