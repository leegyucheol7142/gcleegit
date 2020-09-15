package kr.hu.app.service;

import java.util.List;

import kr.hu.app.bean.BoardBean;

public interface BoardService {
	
	//�Խñ� �ۼ�
	public void setWrite(BoardBean bb);
	
	//�Խù� ��� ��ȸ
	public List<BoardBean> list() throws Exception;
	
	//�Խñ�  ��ȸ
	public BoardBean read(int board_no) throws Exception;

	//�Խñ�  ����
	public void update(BoardBean bb) throws Exception;
	
	//�Խñ� ����
	public void delete(int board_no) throws Exception;
}
