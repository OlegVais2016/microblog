package com.example.microblog.service.impl;

import com.example.microblog.model.entity.Message;
import com.example.microblog.model.web.MessageWeb;
import com.example.microblog.repository.MessageRepository;
import com.example.microblog.service.GetMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetMessagesImpl implements GetMessagesService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<MessageWeb> getTop10() {
        List<Message> coll = messageRepository.findAll();
        return coll.stream()
                .skip(coll.size() - 10)
                .map(this::transform)
                .collect(Collectors.toList());
    }

    @Override
    public MessageWeb getById(Long messageId) {

        return messageRepository
                .findById(messageId)
                .map(x -> transform(x))
                .orElse(null);
    }

     private MessageWeb transform(Message message){
        return  MessageWeb
                .builder()
                .messageId(message.getMessageId())
                .message(message.getMessage())
                .build();
    }
}
