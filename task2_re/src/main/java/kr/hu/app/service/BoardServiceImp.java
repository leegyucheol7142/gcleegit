package kr.hu.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import kr.hu.app.bean.BoardBean;
import kr.hu.app.mapper.BoardMapper;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	@Qualifier("boardMapper")
	private BoardMapper boardMapper;
	
	// �Խñ� �ۼ�
	@Override
	public void setWrite(BoardBean bb) {
		
			boardMapper.setWrite(bb);
	}
	// �Խù� ��� ��ȸ
	@Override
	public List<BoardBean> list() throws Exception {
		
			return boardMapper.list();
	}
	//�Խñ�  ��ȸ
	@Override
	public BoardBean read(int board_no) throws Exception {
		
			return boardMapper.read(board_no);
	}
	//�Խñ�  ����
	@Override
	public void update(BoardBean bb) throws Exception {

			boardMapper.update(bb);
	}
	//�Խñ� ����
	@Override
	public void delete(int board_no) throws Exception {
		
			boardMapper.delete(board_no);
	}
}