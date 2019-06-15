package com.example.microblog.service.impl;

import com.example.microblog.model.entity.Message;
import com.example.microblog.model.entity.MicroUser;
import com.example.microblog.model.web.MessageRequest;
import com.example.microblog.model.web.MessageResponse;
import com.example.microblog.repository.MessageRepository;
import com.example.microblog.service.CreateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateMessageImpl implements CreateMessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public MessageResponse createMessage(Long id, MessageRequest messageRequest) {
        MicroUser user = MicroUser
                .builder()
                .id(id)
                .build();
        Message message = Message
                .builder()
                .createdOn(LocalDateTime.now())
                .createdBy(user)
                .message(messageRequest.getMessage())
                .build();
        messageRepository.save(message);

        return MessageResponse
                .builder()
                .messageId(message.getMessageId())
                .message(message.getMessage())
                .build();
    }
}
