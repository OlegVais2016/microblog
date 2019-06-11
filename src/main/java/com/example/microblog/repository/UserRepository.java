package com.example.microblog.repository;

import com.example.microblog.model.entity.MicroUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MicroUser, Long> {
}
