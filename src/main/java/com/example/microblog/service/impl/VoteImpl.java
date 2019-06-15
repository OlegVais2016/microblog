package com.example.microblog.service.impl;

import com.example.microblog.model.entity.Message;
import com.example.microblog.model.entity.MicroUser;
import com.example.microblog.model.entity.Vote;
import com.example.microblog.model.web.VoteResponse;
import com.example.microblog.repository.MessageRepository;
import com.example.microblog.repository.UserRepository;
import com.example.microblog.repository.VoteRepository;
import com.example.microblog.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteImpl implements VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public VoteResponse vote(Long id, Long messageId, Byte vote) {



        MicroUser user = MicroUser
                .builder()
                .id(id)
                .build();
        Vote like = Vote
                .builder()
                .messageId(messageId)
                .createdBy(user)
                .vote(vote)
                .build();



        voteRepository.save(like);

        return VoteResponse
                .builder()
                .voteId(like.getVoteId())
                .messageId(messageId)
                .vote(vote)
                .build();
    }





}
