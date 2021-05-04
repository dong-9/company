package com.example.board.controller;

import com.example.board.model.BoardReplyAnswerVO;
import com.example.board.model.PageMaker;
import com.example.board.service.BoardService;
import com.example.board.model.BoardReplyVO;
import com.example.board.model.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.Bidi;


@Controller
@RequestMapping(value = "/board")
@Slf4j
public class BoardController {

	@Autowired
	private BoardService boardService;

	// TODO AOP 기능 이용해서 로깅 처리(DB 처리, 로그 파일 관리)
	// TODO log 처리

	// TODO 페이징 처리(완료)
	@GetMapping(value = "/list")
	public String boardList(Model model, PageMaker pageMaker){
		log.info("pageMaker INFO {}", pageMaker);
		pageMaker.setStartEndRowNo();
		model.addAttribute("boardList", boardService.selectList(pageMaker));
		pageMaker.setTotalRowCount(boardService.selectTotalRowCount());
		return "list";
	}

	@RequestMapping(value = "/detail")
	public String boardDetail(Model model, BoardVO vo){
		vo = boardService.selectBoardAll(vo);
		if(vo == null) {
			return "redirect:list";
		}
		model.addAttribute("boardInfo", vo);
		return "detail";
	}

	@GetMapping(value = "/insert")
	public String boardInsertForm(BoardVO vo){
		return "insert";
	}

	// TODO 벨리데이션 추가(완료)
	@PostMapping(value = "/insert")
	public String boardInsert(@Valid BoardVO vo, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "insert";
		}
		boardService.insert(vo);
		return "redirect:list";
	}

	// TODO 댓글 crud
	// TODO 작성 시간, 수정 시간
	// TODO 대댓글
	@PostMapping(value = "/insertReply")
	public String boardInsertReply(@Valid BoardReplyVO vo, BindingResult bindingResult, RedirectAttributes redirectAttributes){
		if(bindingResult.hasErrors()){
			redirectAttributes.addFlashAttribute("msg", "댓글을 입력해주세요");
			return "redirect:detail?seq="+vo.getSeq();
		}
		boardService.insertReply(vo);
		return "redirect:detail?seq="+vo.getSeq();
	}

	@GetMapping(value = "/updateReply")
	public String boardReplyUpdateForm(BoardReplyVO vo, Model model){
		vo = boardService.selectReplyOne(vo);
		if(vo == null) return "redirect:list";
		model.addAttribute("boardReplyVO", vo);
		return "replyUpdate";
	}
	@PostMapping(value = "/updateReply")
	public String boardReplyUpdate(@Valid BoardReplyVO vo, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "replyUpdate";
		}
		boardService.updateReply(vo);
		return "redirect:detail?seq="+vo.getSeq();
	}

	@GetMapping(value = "/deleteReply")
	public String boardDeleteReply(BoardReplyVO vo){
		boardService.deleteReply(vo);
		return "redirect:/board/detail?seq="+vo.getSeq();
	}

	@PostMapping(value = "/insertReplyAnswer")
	public String boardInsertReplyAnswer(BoardVO boardVO,
										 @Valid BoardReplyAnswerVO boardReplyAnswerVO,
										 BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "redirect:/board/detail?seq="+boardVO.getSeq();
		}
		boardService.insertReplyAnswer(boardReplyAnswerVO);
		return "redirect:/board/detail?seq="+boardVO.getSeq();
	}

	@GetMapping(value = "/update")
	public String boardUpdateForm(Model model, BoardVO vo){
		vo = boardService.selectOne(vo);
		if(vo == null){
			return "redirect:list";
		}
		model.addAttribute("boardVO", vo);
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
		return "redirect:/board/list";
	}
}
