package com.apnatiffin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnatiffin.dto.CustomerDto;
import com.apnatiffin.model.Customer;
import com.apnatiffin.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    private CustomerDto convertToDto(Customer customer) {
        CustomerDto dto = new CustomerDto();
        BeanUtils.copyProperties(customer, dto);
        return dto;
    }

    private Customer convertToEntity(CustomerDto dto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(dto, customer);
        return customer;
    }
    public List<CustomerDto> getAllCustomers() {
        List<CustomerDto> customersDtoList = new ArrayList<>();
        List<Customer> customerList = customerRepository.findAll();
        for (Customer customer : customerList) {
            customersDtoList.add(convertToDto(customer));
        }
        return customersDtoList;
    }

    public CustomerDto addCustomer(CustomerDto customerDto){
        Customer newCustomer=customerRepository.save(convertToEntity(customerDto));
        return convertToDto(newCustomer);
    }

}
