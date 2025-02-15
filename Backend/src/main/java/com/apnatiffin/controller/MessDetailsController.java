package com.apnatiffin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apnatiffin.dto.MessDetailsDto;
import com.apnatiffin.service.MessDetailsService;


@RestController
@RequestMapping("/mess")
@CrossOrigin(origins = "http://localhost:5173")
public class MessDetailsController {

	@Autowired
	MessDetailsService messDetailsService;

	@GetMapping
	public MessDetailsDto getMessDetails() {
		return messDetailsService.getMessDetails();
	}

}
