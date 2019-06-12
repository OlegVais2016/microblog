package com.example.microblog.model.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Message  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    private String message;

    @ManyToOne
    private MicroUser createdBy;

    @CreatedDate
    private LocalDateTime createdOn;
}
