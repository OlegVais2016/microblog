package com.example.microblog.service.impl;

import com.example.microblog.model.entity.Message;
import com.example.microblog.model.entity.MicroUser;
import com.example.microblog.model.web.MessageRequest;
import com.example.microblog.model.web.MessageResponse;
import com.example.microblog.repository.MessageRepository;
import com.example.microblog.service.UpdateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateMessageImpl implements UpdateMessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public MessageResponse updateMessage
            (Long id, Long messageId, MessageRequest messageRequest) {
        MicroUser user = MicroUser.builder()
                .id(id)
                .build();
        Message message = Message
                .builder()
                .messageId(messageId)
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
