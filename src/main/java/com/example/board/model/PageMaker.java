package com.example.board.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PageMaker {
	private int page = 1;
	private final int rowPerPage = 5;	//한페이지당 보여줄 게시글 수
	private final int displayPageNo = 5;
	private int startRowNo;		//limit start
	private int endRowNo;		//limit last
	private int totalRowCount;	//게시글 총 개수
	private int endPageNo;		//마지막페이지번호
	private int startPageNo;	//시작페이지번호
	private int lastPageNo;		//라스트페이지번호
	private boolean next;		//다음
	private boolean prev;		//이전

	public PageMaker(){ this.page = 1; }

	public void setPage(int page){
		if(page < 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public void setStartEndRowNo(){
		startRowNo = (page - 1) * rowPerPage;
		endRowNo = rowPerPage;
	}

	public void makeData(){
		endPageNo = (int)(Math.ceil(page / (double)displayPageNo) * displayPageNo);
		startPageNo = endPageNo - displayPageNo + 1;
		lastPageNo = (int)(Math.ceil(totalRowCount / (double)rowPerPage));

		if(endPageNo > lastPageNo) endPageNo = lastPageNo;
		next = endPageNo == lastPageNo ? false : true;
		prev = startPageNo == 1 ? false : true;
	}

	public void setTotalRowCount(int totalRowCount){
		this.totalRowCount = totalRowCount;
		makeData();
	}
}
