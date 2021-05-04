package com.example.board.mapper;

import com.example.board.model.Log;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LogMapper {
	int insertLog(Log log);
	int deleteLog(String startDate, String endDate);

	List<String> logTest();
	int test(String data);
	List<String> t1();
}
