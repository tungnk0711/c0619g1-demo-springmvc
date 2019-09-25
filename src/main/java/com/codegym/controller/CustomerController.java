package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.CustomerForm;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    Environment env;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/list*", method = RequestMethod.GET)
    public ModelAndView listCustomer(){
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        List<Customer> customerList = customerService.findAll();
        modelAndView.addObject("customers", customerList);
        modelAndView.addObject("message", true);
        modelAndView.addObject("year", false);
        modelAndView.addObject("role", "admin");
        modelAndView.addObject("gender", "J");

        return modelAndView;
    }

    @GetMapping("/create")
    public String createCustomerForm(Model model){

        model.addAttribute("customer", new CustomerForm());
        return "/customer/create";
    }

    @PostMapping("/save-customer")
    public ModelAndView saveCustomer(@ModelAttribute CustomerForm customer, BindingResult result){

        // thong bao neu xay ra loi
        if (result.hasErrors()) {
            System.out.println("Result Error Occured" + result.getAllErrors());
        }

        customerService.saveObjectToDatabase(customer);

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

    @GetMapping("/edit-customer/{id}")
    public String editCustomer(@PathVariable("id") Long id){

        return "";
    }
}
