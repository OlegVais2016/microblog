package com.example.microblog.service;

import com.example.microblog.model.web.VoteResponse;

public interface VoteService {
    VoteResponse vote( Long id,  Long  messageId,Byte vote);
}
