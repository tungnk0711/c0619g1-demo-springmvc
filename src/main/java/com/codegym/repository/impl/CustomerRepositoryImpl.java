package com.codegym.repository.impl;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    List<Customer> customerList = new ArrayList<>();

    {
        customerList.add(new Customer(1, "Long","Ha Noi", "Nam"));
        customerList.add(new Customer(2, "Hoang","Ha Long", "Nam"));
        customerList.add(new Customer(3, "Phong","Hai Duong", "Nam"));
        customerList.add(new Customer(4, "Binh", "Hai Phong", "Nu"));
        customerList.add(new Customer(5, "An", "Nam Dinh", "Nu"));
    }


    @Override
    public List<Customer> findAll() {
        return customerList;
    }
}
