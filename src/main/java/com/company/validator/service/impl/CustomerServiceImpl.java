package com.company.validator.service.impl;

import com.company.validator.domain.CustomerEntity;
import com.company.validator.repository.CustomerRepository;
import com.company.validator.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<CustomerEntity> findById(Long id) {
        return this.customerRepository.findById(id);
    }
}
