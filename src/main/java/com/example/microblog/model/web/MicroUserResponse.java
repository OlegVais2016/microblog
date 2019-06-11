package com.example.microblog.model.web;

import com.example.microblog.model.entity.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MicroUserResponse {

    private Long id;
    private String firstName;
    private String lastName;

    private UserType userType;
}
