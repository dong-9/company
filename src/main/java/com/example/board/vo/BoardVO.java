package com.example.board.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BoardVO {
	private int seq;
	@NotBlank(message = "id를 입력해주세요")
	private String id;
	@NotBlank(message = "제목을 입력해주세요")
	private String title;
	@NotBlank(message = "내용을 입력해주세요")
	private String content;
	private String regDate;
}
