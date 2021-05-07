package com.example.board.json;

import com.example.board.mapper.LogMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class JsonTest {

	@Autowired
	LogMapper logMapper;

	@Test
	public void json() throws JsonProcessingException {

	}

	@Test
	public void deleteTest(){
		//"2021-05-04 15:09:47.920"
//		Assertions.assertEquals(1,logMapper.deleteLog("2021-05-04 15:09:47.920"));
	}

	@Test
	@Transactional
	public void e(){
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime ago = now.minusDays(7);
	}
}