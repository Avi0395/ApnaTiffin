package com.apnatiffin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apnatiffin.dto.CustomerDto;
import com.apnatiffin.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:5173")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.status(201).body(customerService.addCustomer(customerDto));
    }

}
