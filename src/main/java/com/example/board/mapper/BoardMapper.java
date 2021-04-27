package com.example.board.mapper;

import com.example.board.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {
	List<BoardVO> selectList();
	BoardVO selectOne(BoardVO vo);
}
