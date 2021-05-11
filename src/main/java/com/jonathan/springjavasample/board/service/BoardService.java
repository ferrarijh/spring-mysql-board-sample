package com.jonathan.springjavasample.board.service;

import com.jonathan.springjavasample.board.model.PostDto;

import java.util.List;

public interface BoardService {
    List<PostDto> selectPostList() throws Exception;
    void insertPost(PostDto post) throws Exception;

    PostDto selectPostDetail(int idx) throws Exception;

    void updateHitCount(int idx) throws Exception;

    void updatePost(PostDto post) throws Exception;

    void deletePost(int idx) throws Exception;
}
