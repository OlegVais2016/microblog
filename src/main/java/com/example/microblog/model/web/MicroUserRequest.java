package com.example.microblog.model.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MicroUserRequest {

    @NotBlank
    @Length(min = 2, max = 50)
    private String firstName;

    @NotBlank
    @Length(min = 2, max = 50)
    private String lastName;

    @Email
    @NotBlank
    @Length(min = 2, max = 50)
    private String email;
}
