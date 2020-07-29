package com.example.PhotoAppUser.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotNull(message = "can't be null")
    @Size(min = 2,message = "should be 2 characters atleast")
    private String firstName;
    private String lastName;
    @NotNull
    @Size(min = 4,max = 10,message = "password should be greater than 4 and less than 8")
    private String password;

    @NotNull
    @Email
    private String email;

}
