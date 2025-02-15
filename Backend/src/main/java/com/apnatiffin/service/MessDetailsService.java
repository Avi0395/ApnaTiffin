package com.apnatiffin.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnatiffin.dto.MessDetailsDto;
import com.apnatiffin.model.MessDetails;
import com.apnatiffin.repository.MessDetailsRepository;

@Service
public class MessDetailsService {

    @Autowired
    MessDetailsRepository messDetailsRepository;

    public MessDetailsDto getMessDetails() {
        MessDetails messDetails = messDetailsRepository.findById(1L).orElse(null);
        MessDetailsDto messDetailsDto = new MessDetailsDto();
        BeanUtils.copyProperties(messDetails, messDetailsDto);
        return messDetailsDto;
    }
}
