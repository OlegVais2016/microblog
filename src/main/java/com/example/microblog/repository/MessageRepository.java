package com.example.microblog.repository;

import com.example.microblog.model.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MessageRepository extends JpaRepository<Message,Long> {

//    @Query("SELECT E.id\n" +
//        "    FROM message E\n" +
//        "    LEFT JOIN \n" +
//        "        messageId\n" +
//        "            WHERE likes\n" +
//        "            GROUP BY messageId\n" +
//        "     L ON L.messageId = E.id")
//    void upVoteMessage(@Param("id") Long id,
//                       @Param("messageId") Long messageId);
}
