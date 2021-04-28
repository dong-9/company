package com.example.board.controller;

import com.example.board.service.BoardService;
import com.example.board.vo.BoardReplyVO;
import com.example.board.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


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
	public String boardDetail(Model model, BoardVO vo){
		vo = boardService.selectOne(vo);
		if(vo == null) {
			return "redirect:list";
		}
		model.addAttribute("replyList", boardService.selectReplyList(vo));
		model.addAttribute("boardInfo", vo);
		return "detail";
	}

	@GetMapping(value = "/insert")
	public String boardInsertForm(BoardVO vo){
		return "insert";
	}

	@PostMapping(value = "/insert")
	public String boardInsert(@Valid BoardVO vo, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "insert";
		}
		boardService.insert(vo);
		return "redirect:list";
	}

	@PostMapping(value = "/insertReply")
	public String boardInsertReply(BoardReplyVO vo){
		boardService.insertReply(vo);
		return "redirect:detail";
	}

	@GetMapping(value = "/update")
	public String boardUpdateForm(Model model, BoardVO vo){
		vo = boardService.selectOne(vo);
		if(vo == null){
			return "redirect:list";
		}
		model.addAttribute("boardInfo", vo);
		return "update";
	}

	@PostMapping(value = "/update")
	public String boardUpdate(@Valid BoardVO vo, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "update";
		}
		boardService.update(vo);
		return "redirect:list";
	}

	@GetMapping(value = "/delete/{seq}")
	public String boardDelete(@PathVariable("seq") int seq){
		boardService.delete(seq);
		return "redirect:list";
	}
}
