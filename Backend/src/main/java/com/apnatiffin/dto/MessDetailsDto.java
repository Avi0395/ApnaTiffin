package com.apnatiffin.dto;

import lombok.Data;

@Data
public class MessDetailsDto {

	private long id;
	private String messName;
	private String address;
	private String contactNumber;
	private double tiffinRate;
	private double monthlyRate;
	private String openingTime;
	private String closingTime;
}
