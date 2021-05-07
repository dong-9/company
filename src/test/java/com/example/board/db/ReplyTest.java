package com.example.board.db;

import com.example.board.mapper.BoardMapper;
import com.example.board.model.BoardReplyVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReplyTest {

	@Autowired
	BoardMapper boardMapper;

	BoardReplyVO vo;

	@BeforeEach
	public void init(){

	}

	@Test
	public void replyTest(){
//		boardMapper.indentUpdate(vo);
		boardMapper.insertReply(vo);
	}

}
