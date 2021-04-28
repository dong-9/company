package com.example.board.service;

import com.example.board.vo.BoardReplyVO;
import com.example.board.vo.BoardVO;

import java.util.List;

public interface BoardService {
	List<BoardVO> selectList();
	BoardVO selectOne(BoardVO vo);
	int insert(BoardVO vo);
	int delete(int seq);
	int update(BoardVO vo);
	List<BoardReplyVO> selectReplyList(BoardVO vo);
	int insertReply(BoardReplyVO vo);
}
