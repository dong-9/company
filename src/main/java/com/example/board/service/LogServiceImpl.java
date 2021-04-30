package com.example.board.service;

import com.example.board.mapper.LogMapper;
import com.example.board.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
	@Autowired
	private LogMapper logMapper;

	@Override
	public int insertLog(Log log) {
		return logMapper.insertLog(log);
	}
}
