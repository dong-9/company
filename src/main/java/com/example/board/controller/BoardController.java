package com.example.board.controller;

import com.example.board.service.BoardService;
import com.example.board.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/board")
@Slf4j
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping(value = "/list")
	public String boardList(Model model){
		model.addAttribute("boardList", boardService.selectList());
		return "list";
	}

	@GetMapping(value = "/detail")
	public String boardDetail(BoardVO vo, Model model){
		vo = boardService.selectOne(vo);
		if(vo == null) {
			return "redirect:list";
		}
		model.addAttribute("boardInfo", vo);
		return "detail";
	}
}
