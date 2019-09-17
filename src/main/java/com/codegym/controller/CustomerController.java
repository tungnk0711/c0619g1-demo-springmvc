package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    //CustomerService customerService = new CustomerServiceImpl();

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/list*", method = RequestMethod.GET)
    public ModelAndView listCustomer(){
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        List<Customer> customerList = customerService.findAll();
        modelAndView.addObject("customers", customerList);
        return modelAndView;
    }

    @GetMapping("/create")
    public String createCustomerForm(Model model){

        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    @PostMapping("/save-customer")
    public ModelAndView saveCustomer(@ModelAttribute Customer customer){

        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @GetMapping("/search")
    public String searchCustomerForm(){
        return "/customer/search";
    }

    @GetMapping("/search-customer")
    public String searchCustomer(@RequestParam("search-by-name") String search){

        return "/customer/search";
    }

    @GetMapping("/edit-customer/{id}/{name}")
    public String editCustomer(@PathVariable("id") Long id, @PathVariable("name") String name){

        return "";
    }
}
