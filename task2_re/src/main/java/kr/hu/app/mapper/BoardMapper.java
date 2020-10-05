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
	//�Խñ� �ۼ�
	public void setWrite(BoardBean bb);
	
	//�Խ��� ��ü ��ȸ
	List<BoardBean> selectBoards();
	
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
	
	//����
	public List<BoardBean> excelselect(int board_no) throws Exception;
	
	//÷������ ���ε�
	public void insertFile(Map<String, Object> map) throws Exception;
	
	//÷������ ��ȸ
	public List<Map<String, Object>> selectFileList(int board_no) throws Exception;
	
	//÷������ �ٿ�
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;
	
	int rewriteBoard(BoardBean bb, int board_no) throws Exception;
	
	//�亯 �ۼ�
	public void setAnswer(BoardBean bb) throws Exception;
	
	//���� �ѹ� ���Ƿ� �ø���
	public void updateSno(BoardBean board_no) throws Exception;
	
}

