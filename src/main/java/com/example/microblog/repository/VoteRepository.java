package com.example.microblog.repository;

import com.example.microblog.model.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote,Long> {



}
