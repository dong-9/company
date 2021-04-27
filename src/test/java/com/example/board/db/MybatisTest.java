package com.example.board.db;

import com.example.board.mapper.BoardMapper;
import com.example.board.service.BoardService;
import com.example.board.vo.BoardVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisTest {

	@Autowired
	BoardService boardService;

	@Test
	public void boardListTest(){
		boardService.selectList().stream().forEach(System.out::println);
	}


	//seq=1, userId=test1, title=test1제목, content=test1내용, regDate=2021-04-27)
	@Test
	public void boardDetail(){
		BoardVO vo = new BoardVO();
		vo.setSeq(1);
		Assertions.assertEquals("test1내용", boardService.selectOne(vo).getContent());
	}
}
