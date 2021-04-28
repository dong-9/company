package com.example.board.service;

import com.example.board.mapper.BoardMapper;
import com.example.board.vo.BoardReplyVO;
import com.example.board.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<BoardVO> selectList() {
		return boardMapper.selectList();
	}

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
	public List<BoardReplyVO> selectReplyList(BoardVO vo) {
		return boardMapper.selectReplyList(vo);
	}

	@Override
	public int insertReply(BoardReplyVO vo) {
		return boardMapper.insertReply(vo);
	}
}
