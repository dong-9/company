package com.example.board.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BoardReplyVO extends BoardVO {
	private int idx;
	private String reply;
}
