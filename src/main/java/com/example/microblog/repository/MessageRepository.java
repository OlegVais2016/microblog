package com.example.microblog.repository;

import com.example.microblog.model.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MessageRepository extends JpaRepository<Message,Long> {


}
