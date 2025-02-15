package com.apnatiffin.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private long customerId;
    private String name;
    private String email;
    private String phone;
    private String address;

}
