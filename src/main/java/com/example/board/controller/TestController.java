package com.example.board.controller;

import com.example.board.mapper.BoardMapper;
import com.example.board.model.BoardReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@Autowired
	private BoardMapper boardMapper;

	@GetMapping(value = "/list")
	public String test(Model model){
		model.addAttribute("list", boardMapper.selectReplyList());
		return "test";
	}

	@RequestMapping(value = "/insert")
	public String insert(BoardReplyVO vo){
		boardMapper.indentUpdate(vo);
		vo.setIndent(vo.getIndent()+1);
		vo.setStep(vo.getStep()+1);
		boardMapper.insertReply(vo);
		return "redirect:list";
	}
}
