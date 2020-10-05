package kr.hu.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.hu.app.bean.BoardBean;
import kr.hu.app.bean.SearchBean;

public interface BoardService {
	
	//게시글 작성
	public void setWrite(BoardBean bb, MultipartHttpServletRequest mpRequest) throws Exception;
	
	//게시물 목록 조회
	public List<BoardBean> listPage(SearchBean sb) throws Exception;
	
	//게시물 총 갯수
	public int listCount(SearchBean sb) throws Exception;
	
	//게시글  조회
	public BoardBean read(int board_no) throws Exception;

	//게시글  수정
	public void update(BoardBean bb) throws Exception;
	
	//게시글 삭제
	public void delete(int board_no) throws Exception;
	
	//엑셀
	public List<BoardBean> excelselect(int board_no) throws Exception;
	
	//첨부파일 조회
	public List<Map<String, Object>> selectFileList(int bno) throws Exception;
	
	//첨부파일 다운
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;
	
	//답변 작성
	public void setAnswer(BoardBean bb) throws Exception;
	
	//스텝 넘버 임의로 올리기
	public void updateSno(BoardBean board_no) throws Exception;

	public int rewriteBoard(BoardBean bb, int board_no) throws Exception;
}
