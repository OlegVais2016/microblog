package com.example.microblog.controller;

import com.example.microblog.model.entity.Message;
import com.example.microblog.model.entity.MicroUser;
import com.example.microblog.model.web.MessageRequest;
import com.example.microblog.model.web.MessageResponse;
import com.example.microblog.model.web.MessageWeb;
import com.example.microblog.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.Cacheable;


import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;



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
    @GetMapping("/posts")
    public List<MessageWeb> getAll(){
        return messageRepository.findAll()
                .stream()
                .map(x -> transform(x))
                .collect(Collectors.toList());

    }
    @Cacheable(value = "post-top")
    @GetMapping("/posts/top")
    public List<MessageWeb> getTop10(){
        List<Message> coll = messageRepository.findAll();
        return coll.stream()
                .skip(coll.size() - 10)
                .map(x -> transform(x))
                .collect(Collectors.toList());
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







   /* @PostMapping("/upvote/{id}/{messageId}")
    public void upVoteMessage (@PathVariable Long id,
                               @PathVariable Long messageId){
        messageRepository.upVoteMessage(id,messageId);
    }*/
}
