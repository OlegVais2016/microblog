package com.example.microblog.model.web;

import com.example.microblog.model.entity.MicroUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VoteResponse {

    private Long voteId;
    private Long messageId;
    private Byte vote;
    private String response;

}
