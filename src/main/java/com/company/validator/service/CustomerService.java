package com.company.validator.service;

import com.company.validator.domain.CustomerEntity;

import java.util.Optional;

public interface CustomerService {
    Optional<CustomerEntity> findById(Long id);
}
