package com.app.mybatis.domain;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NotificationVO {
    private Long id;
    private Long userId;
    private String message;
    private String createdDate;
    private int isRead;

}

