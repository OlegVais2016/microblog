package com.example.microblog.controller;

import com.example.microblog.model.web.VoteRequest;
import com.example.microblog.model.web.VoteResponse;
import com.example.microblog.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping("/vote")
    public VoteResponse vote
            (@RequestBody VoteRequest voteRequest){
        return voteService.vote(voteRequest.getId(),voteRequest.getMessageId(),
                voteRequest.getVote());
    }
}
