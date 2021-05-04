package com.example.board.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BoardReplyAnswerVO {
	private int idx;
	private int root;
	private int indent;
	@NotBlank
	private String replyAnswer;
}
