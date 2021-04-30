package com.example.board.mapper;

import com.example.board.model.Log;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LogMapper {
	List<Log> selectList();
	int insertLog(Log log);
}
