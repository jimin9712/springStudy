package com.app.mybatis.domain;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {
    private Long id;
    private Long userId;
    private String message;
    private String createdDate;
    private int isRead;

    public NotificationVO toVO() {
        return new NotificationVO(id, userId, message, createdDate, isRead);
    }

}

