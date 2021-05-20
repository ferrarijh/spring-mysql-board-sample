package com.jonathan.springjavasample.board.controller;

import com.jonathan.springjavasample.board.model.PostDto;
import com.jonathan.springjavasample.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @RequestMapping("/board/openPostList.do")
    public ModelAndView openPostList() throws Exception{
        ModelAndView mav = new ModelAndView("/board/postList.html");
        List<PostDto> list = boardService.selectPostList();
        mav.addObject("list", list);    //set attribute name as 'list' for postList.html
        return mav;
    }

    @RequestMapping("/board/openPostWrite.do")
    public String openPostWrite() throws Exception{
        return "/board/postWrite.html";
    }

    @RequestMapping("/board/insertPost.do")
    public String insertPost(PostDto post) throws Exception{
        boardService.insertPost(post);
        return "redirect:/board/openPostList.do";
    }

    @RequestMapping("/board/openPostDetail.do")
    public ModelAndView openPostDetail(@RequestParam int postIdx) throws Exception{
        ModelAndView mv = new ModelAndView("/board/postDetail.html");

        PostDto post = boardService.selectPostDetail(postIdx);
        mv.addObject("post", post);

        return mv;
    }

    @RequestMapping("/board/deletePost.do")
    public String deletePost(@RequestParam int postIdx) throws Exception{
        boardService.deletePost(postIdx);
        return "redirect:/board/openPostList.do";
    }

    @RequestMapping("/board/updatePost.do")
    public String updatePost(PostDto post) throws Exception{
        boardService.updatePost(post);
        return "redirect:/board/openPostList.do";
    }
}
