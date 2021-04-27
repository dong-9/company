package com.example.board.service;

import com.example.board.vo.BoardVO;

import java.util.List;

public interface BoardService {
	List<BoardVO> selectList();
	BoardVO selectOne(BoardVO vo);
}
