package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.model.CustomerForm;
import com.codegym.repository.CustomerRepository;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {


    @Autowired
    Environment env;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }


    @Override
    public void saveObjectToDatabase(CustomerForm customerForm){
        // lay ten file
        MultipartFile multipartFile = customerForm.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();

        // luu file len server
        try {
            //multipartFile.transferTo(imageFile);
            FileCopyUtils.copy(customerForm.getAvatar().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // tham khảo: https://github.com/codegym-vn/spring-static-resources

        // tao doi tuong de luu vao db
        Customer customerObject = new Customer(customerForm.getId(),customerForm.getName(), customerForm.getAddress(), customerForm.getGender(), fileName);

        customerRepository.save(customerObject);
    }
}
