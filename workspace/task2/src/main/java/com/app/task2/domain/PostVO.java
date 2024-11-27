package com.app.task2.domain;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter @ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostVO {
    private Long id;
    private String postTitle;
    private String postContent;
    private int postReadCount;
    private int status;
    private Date createdDate;
    private Date updatedDate;
}
