package com.apnatiffin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apnatiffin.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
