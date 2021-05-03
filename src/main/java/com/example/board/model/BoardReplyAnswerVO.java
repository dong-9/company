package com.example.board.model;

import lombok.Data;

@Data
public class BoardReplyAnswerVO {
	private int idx;
	private int root;
	private int indent;
	private String replyAnswer;
}
