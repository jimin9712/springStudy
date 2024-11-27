package com.app.mybatis.controller;

import com.app.mybatis.domain.ReplyDTO;
import com.app.mybatis.domain.ReplyVO;
import com.app.mybatis.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reply/*")
@RequiredArgsConstructor
@Slf4j
public class ReplyController {
    private final ReplyMapper replyMapper;

    // 댓글 작성
    @GetMapping("write")
    public void writeReply(ReplyDTO replyDTO) {
        replyDTO.setReplyDepth(0); // 댓글의 깊이는 0으로 설정
        replyMapper.insertReply(replyDTO.toVO());
        log.info("댓글 작성 완료: " + replyDTO.getReplyContent());
    }

    // 대댓글 작성
    @GetMapping("writeSubReply")
    public void writeSubReply(ReplyDTO replyDTO) {
        // 부모 댓글의 정보를 이용해 replyDepth와 groupId를 설정
        Long parentReplyId = replyDTO.getGroupId();  // 부모 댓글 ID
        ReplyVO parentReply = replyMapper.selectById(parentReplyId);

        if (parentReply != null) {
            replyDTO.setReplyDepth(parentReply.getReplyDepth() + 1);  // 부모 댓글의 깊이에 +1
            replyDTO.setGroupId(parentReply.getId());  // 부모 댓글의 ID를 그룹 ID로 설정
        } else {
            log.info("부모 댓글을 찾을 수 없습니다.");
            return;
        }

        replyMapper.insertSubReply(replyDTO.toVO());
        log.info("대댓글 작성 완료: " + replyDTO.getReplyContent());
    }

    // 댓글 목록 조회
    @GetMapping("list")
    public void listReplies(ReplyDTO replyDTO) {
        log.info("댓글 목록 조회: postId = " + replyDTO.getPostId());
        replyMapper.selectRepliesByPostId(replyDTO.getPostId()).forEach(reply -> {
            log.info(reply.toString());
        });
    }

    // 대댓글 목록 조회
    @GetMapping("subList")
    public void listSubReplies(ReplyDTO replyDTO) {
        log.info("대댓글 목록 조회: groupId = " + replyDTO.getGroupId());
        replyMapper.selectSubRepliesByGroupId(replyDTO.getGroupId()).forEach(subReply -> {
            log.info(subReply.toString());
        });
    }

    // 댓글 삭제 (댓글 삭제 시 대댓글도 함께 삭제되게 함)
    @GetMapping("delete")
    public void deleteReply(ReplyDTO replyDTO) {
        // 먼저 대댓글을 모두 삭제
        replyMapper.deleteSubRepliesByGroupId(replyDTO.getId());

        // 부모 댓글 삭제
        replyMapper.deleteReply(replyDTO.getId());

        log.info("댓글 및 대댓글 삭제 완료: " + replyDTO.getId());
    }

    // 댓글 수정
    @GetMapping("update")
    public void updateReply(ReplyDTO replyDTO) {
        replyMapper.updateReply(replyDTO.toVO());
        log.info("댓글 수정 완료: " + replyDTO.getId());
    }
}
