package com.example.board.service;

import com.example.board.model.BoardReplyVO;
import com.example.board.model.BoardVO;
import com.example.board.model.PageMaker;

import java.util.List;

public interface BoardService {
	List<BoardVO> selectList(PageMaker pageMaker);
	BoardVO selectBoardAll(BoardVO vo);
	BoardVO selectOne(BoardVO vo);
	int insert(BoardVO vo);
	int delete(int seq);
	int update(BoardVO vo);
	int selectTotalRowCount();

	int insertReply(BoardReplyVO vo);
	int deleteReply(BoardReplyVO vo);
	BoardReplyVO selectReplyOne(BoardReplyVO vo);
	int updateReply(BoardReplyVO vo);
}
