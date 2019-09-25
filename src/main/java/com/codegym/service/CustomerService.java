package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.CustomerForm;

public interface CustomerService extends GeneralService<Customer> {
    void saveObjectToDatabase(CustomerForm customerForm);
}
