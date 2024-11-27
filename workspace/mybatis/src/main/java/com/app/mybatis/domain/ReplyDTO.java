package com.app.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {
    private Long id;
    private String replyContent;
    private Long memberId;
    private String memberName;
    private Long postId;
    private Long groupId;  // 댓글이면 NULL, 대댓글이면 해당 댓글의 ID
    private int replyDepth;
    private String createdDate;
    private String updatedDate;

    public ReplyVO toVO() {
        return new ReplyVO(id, replyContent, memberId, postId, groupId, replyDepth, createdDate, updatedDate);
    }
}

