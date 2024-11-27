package com.app.task2.controller;

import com.app.task2.domain.PostDTO;
import com.app.task2.domain.PostVO;
import com.app.task2.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/post/*")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostMapper postMapper;

    // 게시글 작성
    @GetMapping("create")
    public void create(PostDTO postDTO) {
        postMapper.insertPost(postDTO.toVO());
        log.info("게시글 작성 완료");
    }

    // 게시글 조회 및 조회수 증가
    @GetMapping("view")
    public void view(Long id) {
        postMapper.increaseReadCount(id);
        if (postMapper.selectPostById(id) == null) {
            log.info("게시글 조회 실패");
        } else {
            log.info("게시글 조회 성공");
        }
    }

    // 게시글 목록 조회
    @GetMapping("list")
    public List<PostVO> list() {
        List<PostVO> posts = postMapper.selectAllPosts();
        log.info("게시글 목록 조회 완료");
        return posts;
    }

    // 게시글 삭제 (하드 및 소프트 삭제 선택 가능)
    @GetMapping("delete")
    public void delete(Long id, boolean softDelete) {
        if (softDelete) {
            postMapper.softDelete(new PostDTO().toVO());
            log.info("게시글 소프트 삭제 완료");
        } else {
            postMapper.deletePost(id);
            log.info("게시글 하드 삭제 완료");
        }
    }

    // 게시글 수정
    @GetMapping("update")
    public void update(PostDTO postDTO) {
        postMapper.updatePost(postDTO.toVO());
        log.info("게시글 수정 완료");
    }
}
