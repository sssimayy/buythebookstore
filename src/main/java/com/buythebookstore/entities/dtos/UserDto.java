package com.buythebookstore.entities.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDto {

    @NotBlank
    private String userName;

    @NotBlank
    private String surname;


    @NotBlank
    private String password;

    @NotBlank
    private String passwordCheck;
}
