package com.apnatiffin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apnatiffin.dto.customerdtos.CustomerRequestDto;
import com.apnatiffin.dto.customerdtos.CustomerResponseDto;
import com.apnatiffin.exception.CustomerNotFoundException;
import com.apnatiffin.model.Customer;
import com.apnatiffin.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    // Constructor-based dependency injection for CustomerRepository.
    CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Retrieves a list of all customers from the database.
    public List<CustomerResponseDto> getAllCustomers() {
        // Fetch all customers
        List<Customer> customerList = customerRepository.findAll();

        if (customerList.isEmpty()) {
            return new ArrayList<>();
        }

        List<CustomerResponseDto> customerResponseDtoList = new ArrayList<>();
        for (Customer customer : customerList) {
            customerResponseDtoList.add(convertToDto(customer));
        }

        return customerResponseDtoList;
    }

    // Retrieves a customer by id from database.
    public CustomerResponseDto getCustomerById(Long id) {
        // Retrieve customer or throw exception if not found.
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id :" + id));

        return convertToDto(customer);
    }

    // Adds new customer to the database
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {
        // Check email duplication.
        if (customerRepository.existsByEmail(customerRequestDto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Check phone duplication.
        if (customerRepository.existsByPhone(customerRequestDto.getPhone())) {
            throw new IllegalArgumentException("Phone already exists");
        }

        Customer customer = new Customer(customerRequestDto.getName(),
                customerRequestDto.getEmail(),
                customerRequestDto.getPhone());

        Customer addedCustomer = customerRepository.save(customer);

        return convertToDto(addedCustomer);

    }

    // Updates customer details by id
    public CustomerResponseDto updateCustomer(Long id, CustomerRequestDto customerRequestDto) {
        // Retrieve customer or throw exception if not found.
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(
                        "Cannot update: Customer with ID " + id + " does not exist."));

        // Check email duplication.
        if (!customer.getEmail().equals(customerRequestDto.getEmail()) &&
                customerRepository.existsByEmail(customerRequestDto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Check phone duplication.
        if (!customer.getPhone().equals(customerRequestDto.getPhone()) &&
                customerRepository.existsByPhone(customerRequestDto.getPhone())) {
            throw new IllegalArgumentException("Phone already exists");
        }

        // Update customer details.
        customer.setName(customerRequestDto.getName());
        customer.setEmail(customerRequestDto.getEmail());
        customer.setPhone(customerRequestDto.getPhone());

        Customer updatedCustomer = customerRepository.save(customer);

        return convertToDto(updatedCustomer);
    }

    // converts Customer to CustomerResponseDto
    private CustomerResponseDto convertToDto(Customer customer) {
        return new CustomerResponseDto(
                customer.getCustomerId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getLocalDateTime());
    }

}
