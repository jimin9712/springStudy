package com.app.mybatis.mapper;

import com.app.mybatis.domain.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ReplyMapperTests {
    @Autowired
    private ReplyMapper replyMapper;

    // 댓글 작성 테스트
    @Test
    public void testInsertReply() {
        ReplyVO replyVO = new ReplyVO(null, "댓글 내용", 11L, 4L, null, 0, null, null);  // REPLY_DEPTH 0
        replyMapper.insertReply(replyVO);
    }

    // 대댓글 작성 테스트
//
    @Test
    public void testInsertSubReply() {
        // 부모 댓글을 조회하여 대댓글 정보 설정
        // 한 마디로 ↓ 가 그룹 아이디임(4L)
        Long parentReplyId = 4L;
        ReplyVO parentReply = replyMapper.selectById(parentReplyId);

        if (parentReply != null) {
            Long groupId = parentReply.getId();  // 부모 댓글의 ID를 그룹 ID로 설정
            int replyDepth = parentReply.getReplyDepth() + 1;  // 부모 댓글의 깊이 + 1

            ReplyVO subReplyVO = new ReplyVO(null, "대댓글 내용", 21L, 4L, groupId, replyDepth, null, null);
            replyMapper.insertSubReply(subReplyVO);
            log.info("{}", subReplyVO);
        } else {
            log.info("부모 댓글 없음");
        }
    }

    // 부모 댓글 조회 테스트
    @Test
    public void testSelectById() {
        ReplyVO replyVO = replyMapper.selectById(1L);
        log.info(replyVO.toString());
    }

    // 댓글 목록 조회 테스트
    @Test
    public void testSelectRepliesByPostId() {
        replyMapper.selectRepliesByPostId(1L).forEach(reply -> log.info(reply.toString()));
    }

    // 대댓글 목록 조회 테스트
    @Test
    public void testSelectSubRepliesByGroupId() {
        replyMapper.selectSubRepliesByGroupId(1L).forEach(reply -> log.info(reply.toString()));
    }

    // 댓글 수정 테스트
    @Test
    public void testUpdateReply() {
        ReplyVO replyVO = new ReplyVO(9L, "대대댓글 내용", null, null, null, 0, null, null);
        replyMapper.updateReply(replyVO);
    }

    // 댓글 삭제 테스트(ON DELETE CASCADE) 안쓰고 sql에서 연산 안하고
    @Test
    public void testDeleteReplyAndSubReplies() {
        // 부모 댓글 ID 설정 (삭제할 댓글의 ID)
        Long parentReplyId = 1L;

        // 대댓글이 있는지 확인하고 그거부터 삭제
        replyMapper.deleteSubRepliesByGroupId(parentReplyId);

        // 부모 댓글 삭제
        replyMapper.deleteReply(parentReplyId);

    }
}
