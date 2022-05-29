package com.jong960107.beans;

public class PageInfo {
	
	//최소페이지번호 
	private int min;
	//최대 페이지 번호
	private int max;
	//이전 버튼의 페이지 번호
	private int prevPage;
	//다음 버튼의 페이지 번호
	private int nextPage;
	//전체 페이지 개수
	private int pageCnt;
	//현재 페이지 번호
	private int currentPage;
	private int nextNum;
	private int prevNum;
	
	
	public PageInfo(int contentCnt,int currentPage,int contentPageCnt,int paginationCnt){
		this.currentPage = currentPage;
		this.pageCnt = contentCnt / contentPageCnt;
		if(contentCnt%contentPageCnt > 0) {
			pageCnt++;
		}
		min = ((currentPage -1)/contentPageCnt)*contentPageCnt + 1;
		max = min + paginationCnt - 1;
		if(max > pageCnt) {
			max = pageCnt;
		}
		prevPage = min - 1;
		nextPage = max + 1;
		if(nextPage > pageCnt) {
			nextPage = pageCnt;
		}
		if(currentPage<10) {
			nextNum = (currentPage%10)+1;
			}else {
			nextNum = 	currentPage+1;
			}
		
		if(currentPage==0) {
			prevNum = currentPage;
			}else {
			prevNum = 	currentPage-1;
			}		
	}
	
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNextNum() {
		return nextNum;
	}

	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}

	public int getPrevNum() {
		return prevNum;
	}

	public void setPrevNum(int prevNum) {
		this.prevNum = prevNum;
	}




}
