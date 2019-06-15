package com.example.microblog.service;

import com.example.microblog.model.web.MessageRequest;
import com.example.microblog.model.web.MessageResponse;

public interface CreateMessageService {

    MessageResponse createMessage(Long id, MessageRequest messageRequest);


}
