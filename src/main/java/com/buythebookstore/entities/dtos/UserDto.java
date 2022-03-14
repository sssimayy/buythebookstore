package com.buythebookstore.entities.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserDto {

    private int userId;

    @NotBlank
    private String userName;

    @NotBlank
    private String surname;

    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String passwordCheck;
}
