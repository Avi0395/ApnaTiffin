package com.apnatiffin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;

	@Column(nullable = false, length = 100)
	private String name;

	@Email
	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false, unique = true, length = 15)
	private String phone;

	@Column(nullable = false)
	private String address;

}
