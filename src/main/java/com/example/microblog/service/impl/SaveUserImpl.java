package com.example.microblog.service.impl;

import com.example.microblog.model.entity.MicroUser;
import com.example.microblog.model.entity.UserType;
import com.example.microblog.model.web.MicroUserRequest;
import com.example.microblog.model.web.MicroUserResponse;
import com.example.microblog.repository.UserRepository;
import com.example.microblog.service.SaveUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveUserImpl implements SaveUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public MicroUserResponse saveUser(MicroUserRequest userRequest) {

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
