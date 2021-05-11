package com.jonathan.springjavasample.board.service;

import com.jonathan.springjavasample.board.mapper.BoardMyBatisMapper;
import com.jonathan.springjavasample.board.model.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardMyBatisMapper mapper;

    @Override
    public List<PostDto> selectPostList() throws Exception {
        return mapper.selectPostList();
    }

    @Override
    public void insertPost(PostDto post) throws Exception {
        mapper.insertPost(post);
    }

    @Override
    public PostDto selectPostDetail(int idx) throws Exception {
        mapper.updateHitCount(idx);

        return mapper.selectPostDetail(idx);
    }

    @Override
    public void updateHitCount(int idx) throws Exception {
        mapper.updateHitCount(idx);
    }

    @Override
    public void updatePost(PostDto post) throws Exception {
        mapper.updatePost(post);
    }

    @Override
    public void deletePost(int idx) throws Exception {
        mapper.deletePost(idx);
    }
}
