package com.example.microblog.controller;


import com.example.microblog.model.web.MessageRequest;
import com.example.microblog.model.web.MessageResponse;
import com.example.microblog.model.web.MessageWeb;
import com.example.microblog.service.CreateMessageService;
import com.example.microblog.service.GetMessagesService;
import com.example.microblog.service.UpdateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.Cacheable;


import javax.validation.Valid;

import java.util.List;




@RestController
@RequestMapping("/messages")
public class MessageController {


    @Autowired
    private CreateMessageService createMessageService;

    @Autowired
    private UpdateMessageService updateMessageService;

    @Autowired
    private GetMessagesService getMessagesService;

    @PostMapping("/create/{id}")
    public MessageResponse createMessage
            (@PathVariable Long id,@RequestBody @Valid MessageRequest messageRequest){
        return createMessageService.createMessage(id,messageRequest);
    }


    @GetMapping("/{id}")
    public MessageWeb getById(@PathVariable("id") Long messageId) {
        return getMessagesService.getById(messageId);
    }

    @Cacheable(value = "post-top")
    @GetMapping("/top")
    public List<MessageWeb> getTop10(){
        return getMessagesService.getTop10();
    }

    @PostMapping("/update/{id}/{messageId}")
    public MessageResponse updateMessage(@PathVariable Long id,
                                    @PathVariable Long messageId,
                                    @RequestBody @Valid MessageRequest messageRequest){
        return updateMessageService.updateMessage(id,messageId,messageRequest);
    }


}
