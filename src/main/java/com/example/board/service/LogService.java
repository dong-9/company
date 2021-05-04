package com.example.board.service;

import com.example.board.model.Log;

public interface LogService {
	int insertLog(Log log);
	int deleteLog(String startDate, String endDate);
}
