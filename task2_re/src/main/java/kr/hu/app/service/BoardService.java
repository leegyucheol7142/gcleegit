package kr.hu.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.hu.app.bean.BoardBean;
import kr.hu.app.bean.SearchBean;

public interface BoardService {
	
	//�Խñ� �ۼ�
	public void setWrite(BoardBean bb, MultipartHttpServletRequest mpRequest) throws Exception;
	
	//�Խù� ��� ��ȸ
	public List<BoardBean> listPage(SearchBean sb) throws Exception;
	
	//�Խù� �� ����
	public int listCount(SearchBean sb) throws Exception;
	
	//�Խñ�  ��ȸ
	public BoardBean read(int board_no) throws Exception;

	//�Խñ�  ����
	public void update(BoardBean bb) throws Exception;
	
	//�Խñ� ����
	public void delete(int board_no) throws Exception;
	
	//����
	public List<BoardBean> excelselect(int board_no) throws Exception;
	
	//÷������ ��ȸ
	public List<Map<String, Object>> selectFileList(int bno) throws Exception;
	
	//÷������ �ٿ�
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;
	
	//�亯 �ۼ�
	public void setAnswer(BoardBean bb) throws Exception;
	
	//���� �ѹ� ���Ƿ� �ø���
	public void updateSno(BoardBean board_no) throws Exception;

	public int rewriteBoard(BoardBean bb, int board_no) throws Exception;
}
