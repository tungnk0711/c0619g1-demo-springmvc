package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    //CustomerService customerService = new CustomerServiceImpl();

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ModelAndView listCustomer(){
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        List<Customer> customerList = customerService.findAll();
        modelAndView.addObject("customers", customerList);
        return modelAndView;
    }
}
