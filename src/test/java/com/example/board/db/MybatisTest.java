package com.example.board.db;

import com.example.board.mapper.BoardMapper;
import com.example.board.mapper.LogMapper;
import com.example.board.model.PageMaker;
import com.example.board.service.BoardService;
import com.example.board.model.BoardReplyVO;
import com.example.board.model.BoardVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
public class MybatisTest {
	@Autowired
	BoardService boardService;

	@Autowired
	BoardMapper boardMapper;

	BoardVO vo;

	@BeforeEach
	public void initBoard(){
		vo = new BoardVO();
		vo.setSeq(21);
		vo.setTitle("change");
		vo.setContent("change");
	}

	@Test
	public void boardListTest(){
		//boardService.selectList().stream().forEach(System.out::println);
	}

	@Test
	public void boardDetail(){
		//seq=1, id=test1, title=test1제목, content=test1내용, regDate=2021-04-27)
		System.out.println(boardMapper.selectOne(vo));
	}

	@Test
	@Transactional
	public void boardInsertTest(){
		Assertions.assertEquals(1,boardMapper.insert(vo));
	}

	@Test
	@Transactional
	public void boardDeleteTest(){
		Assertions.assertEquals(1, boardMapper.delete(13));
	}

	@Test
	@Transactional
	public void updateTest(){
		Assertions.assertEquals(1, boardMapper.update(vo));
		//boardMapper.selectList().forEach(System.out::println);
	}


	@Test
	@Transactional
	public void replyInsert(){
		BoardReplyVO vo = new BoardReplyVO();
		vo.setSeq(2);
		vo.setReply("test댓글");
		boardMapper.insertReply(vo);
	}

	@Test
	public void join(){
		System.out.println(boardMapper.selectBoardAll(vo));
	}

	@Test
	public void paging(){
		PageMaker maker = new PageMaker();
		maker.setStartEndRowNo();
		List<BoardVO> list =  boardMapper.selectList(maker);
		maker.setTotalRowCount(boardMapper.selectTotalRowCount());
		list.forEach(System.out::println);
		System.out.println(maker);

		// 19,18,17,16,15

	}

}
