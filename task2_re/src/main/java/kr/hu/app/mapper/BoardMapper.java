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
	//�Խñ� �ۼ�
	public void setWrite(BoardBean bb);
	
	//�Խñ� ��� ��ȸ
	public List<BoardBean> listPage(SearchBean sb) throws Exception;
	
	//�Խù� �� ����
	public int listCount(SearchBean bb) throws Exception;
	
	//�Խñ�  ��ȸ
	public BoardBean read(int board_no) throws Exception;
	
	//�Խñ�  ����
	public void update(BoardBean bb) throws Exception;
	
	//�Խñ� ����
	public void delete(int board_no) throws Exception;
}

