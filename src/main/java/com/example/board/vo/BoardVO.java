package com.example.board.vo;

import lombok.Data;

@Data
public class BoardVO {
	private int seq;
	private String userId;
	private String title;
	private String content;
	private String regDate;
}