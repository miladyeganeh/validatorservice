package com.company.validator.biz.validation;

import com.company.validator.domain.CustomerEntity;
import com.company.validator.model.CustomerDTO;
import com.company.validator.model.request.RequestDTO;
import com.company.validator.model.response.ResponseDTO;
import com.company.validator.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("customerValidationRule")
public class CustomerValidationRule implements ValidationRule {

    private final CustomerService customerService;

    public CustomerValidationRule(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void validate(ResponseDTO response, RequestDTO request) {
        Optional<CustomerEntity> customerEntityOptional = this.customerService.findById(request.getCustomerID());
        customerEntityOptional.ifPresentOrElse(customerEntity -> {
            if (!customerEntity.getActive()) {
                response.addValidationError("Invalid Customer ...");
            }
            response.setCustomerDTO(CustomerDTO.from(customerEntity));
        }, () -> response.addValidationError("Invalid Customer ..."));
    }
}
