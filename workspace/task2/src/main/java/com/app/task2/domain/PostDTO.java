package com.app.task2.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Getter
@Setter
@ToString
public class PostDTO {
    private Long id;
    private String postTitle;
    private String postContent;
    private int postReadCount;
    private int status;

    public PostVO toVO() {
        return new PostVO(id, postTitle, postContent, postReadCount, status, new Date(), new Date());
    }
}

