package com.example.microblog.model.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    private String message;

    @ManyToOne
    private MicroUser createdBy;

    @CreatedDate
    private LocalDateTime createdOn;
}
