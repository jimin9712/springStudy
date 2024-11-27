package com.app.task2.mapper;

import com.app.task2.domain.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    // 게시글 작성
    public void insertPost(PostVO postVO);

    // 게시글 ID로 조회
    public PostVO selectPostById(Long id);

    // 게시글 목록
    public List<PostVO> selectAllPosts();

    // 게시글 수정
    public void updatePost(PostVO postVO);

    // 게시글 하드 삭제 (ID로 삭제)
    public void deletePost(Long id);

    // 게시글 소프트 삭제 (STATUS를 0으로)
    public void softDelete(PostVO postVO);

    // 조회수 증가
    public void increaseReadCount(Long id);
}
