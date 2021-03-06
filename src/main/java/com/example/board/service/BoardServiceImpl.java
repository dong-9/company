package com.example.board.service;

import com.example.board.mapper.BoardMapper;
import com.example.board.model.BoardReplyVO;
import com.example.board.model.BoardVO;
import com.example.board.model.PageMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<BoardVO> selectList(PageMaker pageMaker) { return boardMapper.selectList(pageMaker); }

	@Override
	public BoardVO selectOne(BoardVO vo) { return boardMapper.selectOne(vo); }

	@Override
	public int insert(BoardVO vo) { return boardMapper.insert(vo); }

	@Override
	public int delete(int seq) { return boardMapper.delete(seq); }

	@Override
	public int update(BoardVO vo) {
		return boardMapper.update(vo);
	}

	@Override
	public int insertReply(BoardReplyVO vo) {
		return boardMapper.insertReply(vo);
	}

	@Override
	public int selectTotalRowCount() {
		return boardMapper.selectTotalRowCount();
	}

	@Override
	public int deleteReply(BoardReplyVO vo) {
		return boardMapper.deleteReply(vo);
	}

	@Override
	public BoardReplyVO selectReplyOne(BoardReplyVO vo) {
		return boardMapper.selectReplyOne(vo);
	}

	@Override
	public int updateReply(BoardReplyVO vo) {
		return boardMapper.updateReply(vo);
	}

	@Override
	public int indentUpdate(BoardReplyVO vo) {
		return boardMapper.indentUpdate(vo);
	}

	@Override
	public BoardVO selectBoardAll(BoardVO vo) {
		return boardMapper.selectBoardAll(vo);
	}
}
