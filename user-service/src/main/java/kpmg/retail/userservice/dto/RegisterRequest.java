package kpmg.retail.userservice.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String mobileNumber;
}