package kr.hu.app.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.hu.app.bean.BoardBean;
import kr.hu.app.bean.SearchBean;
import kr.hu.app.mapper.BoardMapper;
import kr.hu.app.util.FileUtils;

@Service
@Qualifier("boardService")
public class BoardServiceImp implements BoardService {

	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Autowired
	@Qualifier("boardMapper")
	private BoardMapper boardMapper;
	
	// 게시글 작성
	@Override
	public void setWrite(BoardBean bb, MultipartHttpServletRequest mpRequest) throws Exception {
		boardMapper.setWrite(bb);
	
			List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(bb, mpRequest); 
			int size = list.size();
			for(int i=0; i<size; i++){ 
				boardMapper.insertFile(list.get(i)); 
			}
	}
	
	// 답변 작성
	@Override
	public int rewriteBoard(BoardBean bb, int board_no) throws Exception {
			
			BoardBean Board = boardMapper.read(board_no);
			
			for (int i = 0; i < bb.getStep_No(); i++) {
				bb.setTitle("RE : " + bb.getTitle());
			}
			
			bb.setTitle("└" + bb.getTitle());
			
			bb.setGroup_No(Board.getBoard_no());
			bb.setStep_No(Board.getStep_No() + 1);
			bb.setDepth(Board.getDepth() + 1);
			
			boardMapper.updateSno(Board);
			
			boardMapper.setAnswer(bb);
			int newNum = bb.getBoard_no();

			return newNum;
	}
	
	// 게시물 목록 조회
	@Override
	public List<BoardBean> listPage(SearchBean sb) throws Exception {
			
			return boardMapper.listPage(sb);
	}
	
	// 게시물 총 갯수
	@Override
	public int listCount(SearchBean sb) throws Exception {
		
			return boardMapper.listCount(sb);
	}
	// 게시글  조회
	@Override
	public BoardBean read(int board_no) throws Exception {
		
			return boardMapper.read(board_no);
	}
	// 게시글  수정
	@Override
	public void update(BoardBean bb) throws Exception {

			boardMapper.update(bb);
	}
	// 게시글 삭제
	@Override
	public void delete(int board_no) throws Exception {
		
			boardMapper.delete(board_no);
	}
	
	// 엑셀 다운로드
	@Override
	public List<BoardBean> excelselect(int board_no) throws Exception {
		return boardMapper.excelselect(board_no);
	}
	
	// 첨부파일 조회
	public List<Map<String, Object>> selectFileList(int board_no) throws Exception {
		
			return boardMapper.selectFileList(board_no);
	}
	
	// 첨부파일 다운로드
	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		return boardMapper.selectFileInfo(map);
	}

	@Override
	public void setAnswer(BoardBean bb) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSno(BoardBean board_no) throws Exception {
		// TODO Auto-generated method stub
		
	}
}