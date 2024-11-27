package com.app.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReplyVO {
    private Long id;
    private String replyContent;
    private Long memberId;
    private Long postId;
    // 댓글이면 NULL, 대댓글이면 해당 댓글의 ID
    private Long groupId;
    // 1: 댓글, 2~: 대댓글
    private int replyDepth;
    private String createdDate;
    private String updatedDate;
}
