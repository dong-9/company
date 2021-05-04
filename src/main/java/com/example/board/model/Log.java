package com.example.board.model;

import lombok.Data;

@Data
public class Log {
	private int idx;
	private String http;
	private String httpTime;
	private String packageName;
	private String methodName;
	private int resultTime;
}
