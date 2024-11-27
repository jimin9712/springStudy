package com.app.mybatis.mapper;

import com.app.mybatis.domain.NotificationDTO;
import com.app.mybatis.domain.NotificationVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class NotificationMapperTests {

    @Autowired
    private NotificationMapper notificationMapper;

    // 알림 삽입 테스트
    @Test
    public void testInsertNotification() {
        NotificationDTO notification = new NotificationDTO();
        notification.setUserId(11L);
        notification.setMessage("새로운 알림이 있습니다!");
        notification.setIsRead(0);

        notificationMapper.insertNotification(notification.toVO());
        log.info("테스트 성공");
    }

    // 사용자별 알림 조회 테스트
    @Test
    public void testSelectNotificationsByUserId() {
        List<NotificationVO> notifications = notificationMapper.selectNotificationsByUserId(11L);

        for (NotificationVO notification : notifications) {
            log.info("{}", notification);
        }
    }

    // 알림 읽음 처리 테스트
    @Test
    public void testUpdateNotificationReadStatus() {
        notificationMapper.updateNotificationReadStatus(1L);
        log.info("테스트 성공");
    }
}
