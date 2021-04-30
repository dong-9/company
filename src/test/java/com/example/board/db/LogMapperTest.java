package com.example.board.db;

import com.example.board.mapper.LogMapper;
import com.example.board.model.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LogMapperTest {
	@Autowired
	LogMapper logMapper;

	@Test
	public void insertTest(){
		Log log = new Log();
		log.setLogMessage("[REQUEST] 2021-04-30 11:27:19.934  com.example.board.service.BoardServiceImplmethod: selectTotalRowCount");
		logMapper.insertLog(log);
	}
}
