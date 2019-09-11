package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepository;
import com.codegym.repository.impl.CustomerRepositoryImpl;
import com.codegym.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
