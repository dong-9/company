package com.example.board.model;

import lombok.Data;

@Data
public class Log {
	private int idx;
	private String httpRequest;
	private String requestTime;
	private String packageName;
	private String methodName;
	private String httpResponse;
	private String responseTime;
	private String resultData;
	private int resultTime;
}
