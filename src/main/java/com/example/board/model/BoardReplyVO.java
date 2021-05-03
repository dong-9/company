package com.example.board.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class BoardReplyVO {
	private int idx;
	private int seq;
	@NotBlank(message = "댓글을 입력해주세요")
	@Length(max = 50, message = "50글자 밑으로 입력해주세요")
	private String reply;
	private String replyInsertTime;
	private String replyUpdateTime;
	private int root;
	private int indent;
}
