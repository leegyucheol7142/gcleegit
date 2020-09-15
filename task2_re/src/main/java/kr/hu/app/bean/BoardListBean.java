package kr.hu.app.bean;

import java.util.List;

public class BoardListBean {
	
	private int BoardTotalCount; // 글 총 갯수
	private int currentPageNum; // 현재 페이지
	private List<BoardBean> BoardList; // 리스트 방식으로 게시글 10개씩 담음
	private int pageTotalCount; // 페이지 수
	private int BoardCountPerPage; // 페이지당 보여지는 글 10개
	private int firstRow; // 페이지당 첫 줄
	
	public int getBoardTotalCount() {
		return BoardTotalCount;
	}
	public void setBoardTotalCount(int boardTotalCount) {
		BoardTotalCount = boardTotalCount;
	}
	public int getCurrentPageNum() {
		return currentPageNum;
	}
	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}
	public List<BoardBean> getBoardList() {
		return BoardList;
	}
	public void setBoardList(List<BoardBean> boardList) {
		BoardList = boardList;
	}
	public int getPageTotalCount() {
		return pageTotalCount;
	}
	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	public int getBoardCountPerPage() {
		return BoardCountPerPage;
	}
	public void setBoardCountPerPage(int boardCountPerPage) {
		BoardCountPerPage = boardCountPerPage;
	}
	public int getFirstRow() {
		return firstRow;
	}
	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}
	@Override
	public String toString() {
		return "BoardListBean [BoardTotalCount=" + BoardTotalCount + ", currentPageNum=" + currentPageNum
				+ ", BoardList=" + BoardList + ", pageTotalCount=" + pageTotalCount + ", BoardCountPerPage="
				+ BoardCountPerPage + ", firstRow=" + firstRow + "]";
	}

}
