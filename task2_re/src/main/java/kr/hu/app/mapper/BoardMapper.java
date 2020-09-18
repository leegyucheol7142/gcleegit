package kr.hu.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

import kr.hu.app.bean.BoardBean;
import kr.hu.app.bean.Criteria;
import kr.hu.app.bean.SearchBean;

@Mapper
@Qualifier("boardMapper")
public interface BoardMapper {
	//게시글 작성
	public void setWrite(BoardBean bb);
	
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
}

