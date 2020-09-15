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
	
	// 게시글 작성
	@Override
	public void setWrite(BoardBean bb) {
		
			boardMapper.setWrite(bb);
	}
	// 게시물 목록 조회
	@Override
	public List<BoardBean> list() throws Exception {
		
			return boardMapper.list();
	}
	//게시글  조회
	@Override
	public BoardBean read(int board_no) throws Exception {
		
			return boardMapper.read(board_no);
	}
	//게시글  수정
	@Override
	public void update(BoardBean bb) throws Exception {

			boardMapper.update(bb);
	}
	//게시글 삭제
	@Override
	public void delete(int board_no) throws Exception {
		
			boardMapper.delete(board_no);
	}
}