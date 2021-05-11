package com.jonathan.springjavasample.board.mapper;

import com.jonathan.springjavasample.board.model.PostDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//DAO
@Mapper //declare it's MyBatis mapper interface.
public interface BoardMyBatisMapper {
    //method names should match those in .xml file (sql-board.xml in this case)
    List<PostDto> selectPostList() throws Exception;

    void insertPost(PostDto post) throws Exception;

    PostDto selectPostDetail(int idx) throws Exception;

    void updateHitCount(int cnt) throws Exception;

    void updatePost(PostDto post) throws Exception;

    void deletePost(int idx) throws Exception;
}