package com.buythebookstore.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Name cannot be empty.")
    @Size(min = 3, max = 50, message = "Name length should be between 3 and 50.")
    @Column(name = "userName", nullable = false)
    private String userName;

    @NotBlank(message = "Surname cannot be empty.")
    @Column(name = "surname", nullable = false)
    @Size(min = 3, max = 50, message = "Surname length should be between 3 and 50.")
    private String surname;

    @Column(name = "email", unique = true)
    @Email(message = "Wrong email format!")
    @NotEmpty
    @NotBlank(message = "Email can not be empty!")
    private String email;

    @Column(name = "password")
    @NotEmpty
    @NotBlank(message = "Password can not be empty!")
    @Size(min = 6, max = 10, message = "Password length should be between 6-10.")
    private String password;

    @NotBlank(message = "Password check cannot be empty.")
    @Column(name = "passwordCheck")
    @Size(min = 6, max = 10, message = "Password length should be between 6-10.")
    private String passwordCheck;


}
