package kr.hu.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

import kr.hu.app.bean.BoardBean;
import kr.hu.app.bean.SearchBean;

@Mapper
@Qualifier("boardMapper")
public interface BoardMapper {
	//게시글 작성
	public void setWrite(BoardBean bb);
	
	//게시판 전체 조회
	List<BoardBean> selectBoards();
	
	//게시글 목록 조회
	public List<BoardBean> listPage(SearchBean sb) throws Exception;
	
	//게시물 총 갯수
	public int listCount(SearchBean bb) throws Exception;
	
	//게시글  조회
	public BoardBean read(int board_no) throws Exception;
	
	//게시글  수정
	public void update(BoardBean bb) throws Exception;
	
	//게시글 삭제
	public void delete(int board_no) throws Exception;
	
	//엑셀
	public List<BoardBean> excelselect(int board_no) throws Exception;
	
	//첨부파일 업로드
	public void insertFile(Map<String, Object> map) throws Exception;
	
	//첨부파일 조회
	public List<Map<String, Object>> selectFileList(int board_no) throws Exception;
	
	//첨부파일 다운
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;
	
	int rewriteBoard(BoardBean bb, int board_no) throws Exception;
	
	//답변 작성
	public void setAnswer(BoardBean bb) throws Exception;
	
	//스텝 넘버 임의로 올리기
	public void updateSno(BoardBean board_no) throws Exception;
	
}

