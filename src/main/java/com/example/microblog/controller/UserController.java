package com.example.microblog.controller;

import com.example.microblog.model.entity.MicroUser;
import com.example.microblog.model.entity.UserType;
import com.example.microblog.model.web.MicroUserRequest;
import com.example.microblog.model.web.MicroUserResponse;
import com.example.microblog.repository.UserRepository;
import com.example.microblog.service.SaveUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/microusers")
public class UserController {



    @Autowired
    private SaveUserService saveUserService;

    @PostMapping("/save")
    public MicroUserResponse saveUser(@RequestBody
                                          @Valid MicroUserRequest userRequest,
                                                   BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors()
                    .forEach(x -> System.out.printf("Field: %s | Message: %s\n",
                            x.getField(),
                            x.getDefaultMessage()));
            return null;
        }

        return saveUserService.saveUser(userRequest);
    }


}
