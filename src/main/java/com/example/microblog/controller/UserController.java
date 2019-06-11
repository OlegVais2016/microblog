package com.example.microblog.controller;

import com.example.microblog.model.entity.MicroUser;
import com.example.microblog.model.entity.UserType;
import com.example.microblog.model.web.MicroUserRequest;
import com.example.microblog.model.web.MicroUserResponse;
import com.example.microblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users/save")
    public MicroUserResponse saveUser(@RequestBody @Valid MicroUserRequest userRequest,
                                                   BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors()
                    .forEach(x -> System.out.printf("Field: %s | Message: %s\n",
                            x.getField(),
                            x.getDefaultMessage()));
            return null;
        }

        MicroUser user = MicroUser.builder()
                .email(userRequest.getEmail())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .userType(UserType.REGULAR_BLOGER)
                .build();

        userRepository.save(user);

        return MicroUserResponse
                .builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .id(user.getId())
                .userType(user.getUserType())
                .build();
    }


}
