package com.example.microblog.service;

import com.example.microblog.model.web.MessageRequest;
import com.example.microblog.model.web.MessageResponse;

public interface UpdateMessageService {

    MessageResponse updateMessage(Long id,
                                  Long messageId,
                                  MessageRequest messageRequest);
}
