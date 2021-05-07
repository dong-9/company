package com.example.board.mapper;

import com.example.board.model.BoardReplyVO;
import com.example.board.model.BoardVO;
import com.example.board.model.PageMaker;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {
	List<BoardVO> selectList(PageMaker pageMaker);
	BoardVO selectOne(BoardVO vo);
	BoardVO selectBoardAll(BoardVO vo);
	int insert(BoardVO vo);
	int delete(int seq);
	int update(BoardVO vo);
	int selectTotalRowCount();

	int insertReply(BoardReplyVO vo);
	int deleteReply(BoardReplyVO vo);
	BoardReplyVO selectReplyOne(BoardReplyVO vo);
	int updateReply(BoardReplyVO vo);
	int indentUpdate(BoardReplyVO vo);

	List<BoardReplyVO> selectReplyList();
}