package kr.hu.app.mapper;

import java.util.List;

import kr.hu.app.bean.BoardBean;
import kr.hu.app.bean.Criteria;

public interface BoardMapper {
	//�Խñ� �ۼ�
	public void setWrite(BoardBean bb);
	
	//�Խñ� ��� ��ȸ
	public List<BoardBean> listPage(Criteria cri) throws Exception;
	
	//�Խù� �� ����
	public int listCount() throws Exception;
	
	//�Խñ�  ��ȸ
	public BoardBean read(int board_no) throws Exception;
	
	//�Խñ�  ����
	public void update(BoardBean bb) throws Exception;
	
	//�Խñ� ����
	public void delete(int board_no) throws Exception;
}

