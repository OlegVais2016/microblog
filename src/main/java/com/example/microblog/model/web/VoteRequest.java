package com.example.microblog.model.web;

import com.example.microblog.model.entity.MicroUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VoteRequest {

    private Long messageId;
    private Long id;
    private Byte vote;
}
