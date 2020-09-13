package com.company.validator.model.response;

import com.company.validator.model.CustomerDTO;
import com.company.validator.model.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class ResponseDTO {

    private UserDTO userDTO;
    private CustomerDTO customerDTO;
    private List<String> validationErrors;

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public List<String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(List<String> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public void addValidationError(String error) {
        if (validationErrors == null) {
            this.validationErrors = new ArrayList<>();
        }
        this.validationErrors.add(error);
    }

}
