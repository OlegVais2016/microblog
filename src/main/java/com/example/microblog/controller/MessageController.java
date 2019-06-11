package com.example.microblog.controller;

import com.example.microblog.model.entity.Message;
import com.example.microblog.model.entity.MicroUser;
import com.example.microblog.model.web.MessageWeb;
import com.example.microblog.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static com.example.microblog.model.web.MessageWeb.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping("/create&update")
    public MessageWeb createMessage(@AuthenticationPrincipal MicroUser user,
                                    @RequestBody @Valid MessageWeb messageWeb){
        Message message = Message
                .builder()
                .message(messageWeb.getMessage())
                .build();
        messageRepository.save(message);
        user.setId(message.getMessageId());
        return messageWeb;
    }
    private MessageWeb transform(Message x){
        return  MessageWeb
                .builder()
                .messageId(x.getMessageId())
                .message(x.getMessage())
                .build();
    }
    @GetMapping("/{id}")
    public MessageWeb getById(@PathVariable("id") Long messageId) {
        return messageRepository
                .findById(messageId)
                .map(x -> transform(x))
                .orElse(null);
    }
}
