package com.apnatiffin.dto.customerdtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {
    private Long customerId;
    private String name;
    private String email;
    private String phone;
    private LocalDateTime localDateTime;
}
