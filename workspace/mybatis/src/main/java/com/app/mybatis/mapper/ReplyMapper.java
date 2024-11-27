package com.app.mybatis.mapper;

import com.app.mybatis.domain.ReplyVO;
import com.app.mybatis.domain.ReplyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ReplyMapper {
    // 댓글 작성
    public void insertReply(ReplyVO replyVO);

    // 대댓글 작성
    public void insertSubReply(ReplyVO replyVO);

    // 댓글 목록 조회
    public List<ReplyDTO> selectRepliesByPostId(Long postId);

    // 대댓글 목록 조회
    public List<ReplyDTO> selectSubRepliesByGroupId(Long groupId);

    // 대댓글의 부모 댓글 조회 (댓글 ID로 부모 댓글 조회)
    public ReplyVO selectById(Long id);

    // 댓글 삭제
    public void deleteReply(Long id);

    // 대댓글 삭제
    public void deleteSubRepliesByGroupId(Long groupId);

    // 댓글 수정
    public void updateReply(ReplyVO replyVO);
}
