package com.example.board.mapper;

import com.example.board.vo.BoardReplyVO;
import com.example.board.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {
	List<BoardVO> selectList();
	BoardVO selectOne(BoardVO vo);
	int insert(BoardVO vo);
	int delete(int seq);
	int update(BoardVO vo);
	List<BoardReplyVO> selectReplyList(BoardVO vo);
	int insertReply(BoardReplyVO vo);
}