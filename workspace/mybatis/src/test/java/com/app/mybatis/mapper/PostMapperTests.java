package com.app.mybatis.mapper;

import com.app.mybatis.domain.PostDTO;
import com.app.mybatis.domain.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostMapperTests {
    @Autowired
    private PostMapper postMapper;

    @Test
    public void testInsert(){
        PostVO postVO =
                new PostVO(
                        null, "안녕하세요?", "안녕한 내용",
                        0, true,
                        null, null, 5L);

        postMapper.insert(postVO);
    }

    @Test
    public void testSelectAll(){
        postMapper.selectAll().stream().map(PostDTO::toString).forEach(log::info);
    }

    @Test
    public void testSelectById(){
        log.info("{}", postMapper.selectById(4L).toString());
    }
    @Test
    public void testUpdate() {
        PostVO postVO = new PostVO(4L, "수정된 제목", "수정된 내용", 0, true, null, null, 3L);
        postMapper.update(postVO);
    }

    @Test
    public void testDelete() {
        postMapper.delete(1L);
    }

    @Test
    public void testIncreaseReadCount() {
        postMapper.increaseReadCount(4L);
    }

    @Test
    public void testSelectAllOrderByDate() {
        postMapper.selectAllOrderByDate().stream().map(PostDTO::toString).forEach(log::info);
    }
}


















