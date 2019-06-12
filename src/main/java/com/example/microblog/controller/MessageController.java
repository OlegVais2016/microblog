package com.example.microblog.controller;

import com.example.microblog.model.entity.Message;
import com.example.microblog.model.entity.MicroUser;
import com.example.microblog.model.web.MessageRequest;
import com.example.microblog.model.web.MessageResponse;
import com.example.microblog.model.web.MessageWeb;
import com.example.microblog.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

import static com.example.microblog.model.web.MessageWeb.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping("/create/{id}")
    public MessageResponse createMessage
            (@PathVariable Long id,@RequestBody @Valid MessageRequest messageRequest){
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
    @PostMapping("/update/{id}/{messageId}")
    public MessageResponse updateMessage(@PathVariable Long id,
                                    @PathVariable Long messageId,
                                    @RequestBody @Valid MessageRequest messageRequest){
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
