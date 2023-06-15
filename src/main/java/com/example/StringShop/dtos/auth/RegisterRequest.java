package com.example.StringShop.dtos.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public record RegisterRequest(String firstName,String lastname,String email,String password){
//    private String firstName;
//    private String lastname;
//    private String email;
//    private String password;

}
