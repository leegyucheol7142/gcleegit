package kr.hu.app.bean;

import java.util.List;

public class BoardListBean {
	
	private int BoardTotalCount; // �� �� ����
	private int currentPageNum; // ���� ������
	private List<BoardBean> BoardList; // ����Ʈ ������� �Խñ� 10���� ����
	private int pageTotalCount; // ������ ��
	private int BoardCountPerPage; // �������� �������� �� 10��
	private int firstRow; // �������� ù ��
	
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
