package kr.hu.app.service;

import java.util.List;

import kr.hu.app.bean.BoardBean;

public interface BoardService {
	
	//게시글 작성
	public void setWrite(BoardBean bb);
	
	//게시물 목록 조회
	public List<BoardBean> list() throws Exception;
	
	//게시글  조회
	public BoardBean read(int board_no) throws Exception;

	//게시글  수정
	public void update(BoardBean bb) throws Exception;
	
	//게시글 삭제
	public void delete(int board_no) throws Exception;
}
