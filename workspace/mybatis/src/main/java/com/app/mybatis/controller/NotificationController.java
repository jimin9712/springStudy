package com.app.mybatis.controller;

import com.app.mybatis.domain.NotificationVO;
import com.app.mybatis.mapper.NotificationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationMapper notificationMapper;

    // 사용자별 알림 조회
    @GetMapping("/notifications")
    public void getNotifications( Long userId, Model model) {
        List<NotificationVO> notifications = notificationMapper.selectNotificationsByUserId(userId);
        model.addAttribute("notifications", notifications);
    }

    // 알림 읽음 처리
    @GetMapping("/notifications/read")
    public void  markNotificationAsRead(Long notificationId) {
        notificationMapper.updateNotificationReadStatus(notificationId);
    }
}
