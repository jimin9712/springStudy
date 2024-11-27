package com.app.task2.mapper;
import com.app.task2.domain.PostVO;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class PostMapperTests {

    @Autowired
    private PostMapper postMapper;

    @Test
    public void testInsertPost() {
        PostVO postVO = new PostVO(null, "제목1", "내용1", 0, 1, null, null);
        postMapper.insertPost(postVO);
    }

    @Test
    public void testSelectPostById() {
        Long postId = 1L;
        PostVO post = postMapper.selectPostById(postId);
    }

    @Test
    public void testSelectAllPosts() {
        List<PostVO> posts = postMapper.selectAllPosts();
    }

    @Test
    public void testUpdatePost() {
        Long postId = 1L;
        PostVO post = postMapper.selectPostById(postId);

        post.setPostTitle("Updated Title");
        post.setPostContent("Updated Content");
        postMapper.updatePost(post);

        PostVO updatedPost = postMapper.selectPostById(postId);
    }

    @Test
    public void testDeletePost() {
        Long postId = 1L;
        postMapper.deletePost(postId);
        PostVO post = postMapper.selectPostById(postId);
    }

    @Test
    public void testSoftDeletePost() {
        Long postId = 1L;
        PostVO post = postMapper.selectPostById(postId);
        postMapper.softDelete(post);
    }

    @Test
    public void testIncreaseReadCount() {
        Long postId = 1L;
        PostVO post = postMapper.selectPostById(postId);

        postMapper.increaseReadCount(postId);
    }
}
