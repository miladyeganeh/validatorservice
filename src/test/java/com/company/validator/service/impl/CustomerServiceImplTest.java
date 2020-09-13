package com.company.validator.service.impl;

import com.company.validator.domain.CustomerEntity;
import com.company.validator.repository.CustomerRepository;
import com.company.validator.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class CustomerServiceImplTest {

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Test
    void success_findById(){
        CustomerEntity mockedCustomerEntity = createCustomerEntity();
        when(this.customerRepository.findById(any())).thenReturn(Optional.of(mockedCustomerEntity));
        Optional<CustomerEntity> obtainedEntity = this.customerService.findById(1L);
        assertThat(obtainedEntity.get().getName(), is(mockedCustomerEntity.getName()));
        assertThat(obtainedEntity.get().getActive(), is(mockedCustomerEntity.getActive()));
    }

    @Test
    void not_found_findById(){
        when(this.customerRepository.findById(any())).thenReturn(Optional.empty());
        Optional<CustomerEntity> obtainedEntity = this.customerService.findById(1L);
        assertThat(obtainedEntity.isEmpty(), is(true));
    }

    private CustomerEntity createCustomerEntity() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setActive(Boolean.TRUE);
        customerEntity.setId(1L);
        customerEntity.setName("Test");
        return customerEntity;
    }
}