package com.example.board.mapper;

import com.example.board.model.Log;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LogMapper {
	int insertLog(Log log);
	int deleteLog(String date);

}
