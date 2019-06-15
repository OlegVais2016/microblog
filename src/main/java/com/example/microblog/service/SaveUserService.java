package com.example.microblog.service;

import com.example.microblog.model.web.MicroUserRequest;
import com.example.microblog.model.web.MicroUserResponse;

public interface SaveUserService {
    MicroUserResponse saveUser(MicroUserRequest userRequest);
}
