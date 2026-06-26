package com.example.hrms.dto.user_dto;

import lombok.Data;

@Data
public class AddressDto {
    private String houseNo;
    private String village;
    private String postOffice;
    private String tehsil;
    private String district;
    private String state;
    private String country;
    private String pinCode;
    private String landmark;
    private String addressType;
}
