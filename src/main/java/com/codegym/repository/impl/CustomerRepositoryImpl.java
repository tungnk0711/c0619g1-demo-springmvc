package com.codegym.repository.impl;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    List<Customer> customerList = new ArrayList<>();

    {
        customerList.add(new Customer(1, "Long"));
        customerList.add(new Customer(2, "Hoang"));
        customerList.add(new Customer(3, "Phong"));
        customerList.add(new Customer(4, "Binh"));
        customerList.add(new Customer(5, "Dai"));
    }


    @Override
    public List<Customer> findAll() {
        return customerList;
    }
}
