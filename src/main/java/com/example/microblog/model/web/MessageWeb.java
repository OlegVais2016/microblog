package com.example.microblog.model.web;

import com.example.microblog.model.entity.MicroUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MessageWeb {

    private Long messageId;

    @NotBlank
    @Length(min = 2, max = 120)
    private String message;

}
