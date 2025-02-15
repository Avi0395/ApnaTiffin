package com.apnatiffin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MessDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String messName;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String contactNumber;

	@Column(nullable = false)
	private double tiffinRate;

	@Column(nullable = false)
	private double monthlyRate;

	@Column(nullable = false)
	private String openingTime;

	@Column(nullable = false)
	private String closingTime;
}
