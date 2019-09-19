package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.CustomerForm;
import com.codegym.service.CustomerService;
import com.codegym.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    Environment env;

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

        model.addAttribute("customer", new CustomerForm());
        return "/customer/create";
    }

    @PostMapping("/save-customer")
    public ModelAndView saveCustomer(@ModelAttribute CustomerForm customer, BindingResult result){

        // thong bao neu xay ra loi
        if (result.hasErrors()) {
            System.out.println("Result Error Occured" + result.getAllErrors());
        }

        // lay ten file
        MultipartFile multipartFile = customer.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();

        // luu file len server
        try {
            //multipartFile.transferTo(imageFile);
            FileCopyUtils.copy(customer.getAvatar().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // tham khảo: https://github.com/codegym-vn/spring-static-resources

        // tao doi tuong de luu vao db
        Customer customerObject = new Customer(customer.getId(),customer.getName(), customer.getAddress(), customer.getGender(), fileName);

        // luu vao db
        //productService.save(productObject);
        customerService.save(customerObject);

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
