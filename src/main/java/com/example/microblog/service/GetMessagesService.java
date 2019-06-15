package com.example.microblog.service;

import com.example.microblog.model.web.MessageWeb;

import java.util.List;

public interface GetMessagesService {

    List<MessageWeb> getTop10();
    MessageWeb getById(Long messageId);
}
