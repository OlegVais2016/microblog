package com.example.microblog.controller;

import com.example.microblog.model.entity.Message;
import com.example.microblog.model.entity.MicroUser;
import com.example.microblog.model.web.MessageWeb;
import com.example.microblog.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping("/create")
    public MessageWeb createMessage(@AuthenticationPrincipal MicroUser user,
                                    @RequestBody @Valid MessageWeb messageWeb){
        Message message = Message
                .builder()
                .text(messageWeb.getMessage())
                .build();
        messageRepository.save(message);
        user.setId(message.getId());
        return messageWeb;
    }

}

