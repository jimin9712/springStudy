package com.app.mybatis.mapper;


import com.app.mybatis.domain.NotificationVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotificationMapper {

    // 알림 삽입
    void insertNotification(NotificationVO notificationVO);

    // 사용자 알림 조회
    List<NotificationVO> selectNotificationsByUserId(Long userId);

    // 알림 읽음 처리
    void updateNotificationReadStatus(Long notificationId);
}
