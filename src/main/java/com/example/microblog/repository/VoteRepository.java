package com.example.microblog.repository;

import com.example.microblog.model.entity.MicroUser;
import com.example.microblog.model.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VoteRepository extends JpaRepository<Vote,Long> {

    @Query("select  v from Vote v where v.createdBy = :user and v.messageId = :messageId")
    Vote getVote(@Param("user")MicroUser user,
                 @Param("messageId")Long messageId);

}
