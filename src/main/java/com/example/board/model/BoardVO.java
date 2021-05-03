package com.example.board.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class BoardVO {
	private int seq;
	@NotBlank(message = "id를 입력해주세요")
	@Length(max = 15, message = "15자리 밑으로 입력해주세요")
	private String id;
	@NotBlank(message = "제목을 입력해주세요")
	@Length(max = 20, message = "20자리 밑으로 입력해주세요")
	private String title;
	@NotBlank(message = "내용을 입력해주세요")
	@Length(max = 100, message = "100자리 밑으로 입력해주세요")
	private String content;
	private String boardInsertTime;
	private String boardUpdateTime;
	private List<BoardReplyVO> boardReplyVO;
}

