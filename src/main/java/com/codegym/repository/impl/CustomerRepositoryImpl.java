package com.codegym.repository.impl;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    List<Customer> customerList = new ArrayList<>();

    {
        customerList.add(new Customer(1, "Long","Ha Noi", "Nam","1"));
        customerList.add(new Customer(2, "Hoang","Ha Long", "Nam","2"));
        customerList.add(new Customer(3, "Phong","Hai Duong", "Nam","3"));
        customerList.add(new Customer(4, "Binh", "Hai Phong", "Nu","4"));
        customerList.add(new Customer(5, "An", "Nam Dinh", "Nu","5"));
    }


    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        customerList.add(customer);
    }
}
