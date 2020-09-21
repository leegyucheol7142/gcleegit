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
	
	// �Խñ� �ۼ�
	@Override
	public void setWrite(BoardBean bb, MultipartHttpServletRequest mpRequest) throws Exception {
			boardMapper.setWrite(bb);
	
			List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(bb, mpRequest); 
			int size = list.size();
			for(int i=0; i<size; i++){ 
				boardMapper.insertFile(list.get(i)); 
			}
	}
	
	// �Խù� ��� ��ȸ
	@Override
	public List<BoardBean> listPage(SearchBean sb) throws Exception {
		
			return boardMapper.listPage(sb);
	}
	
	//�Խù� �� ����
	@Override
	public int listCount(SearchBean sb) throws Exception {
		
			return boardMapper.listCount(sb);
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
	
	// ÷������ ��ȸ
	public List<Map<String, Object>> selectFileList(int board_no) throws Exception {
		
			return boardMapper.selectFileList(board_no);
	}
	
	// ÷������ �ٿ�ε�
	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		return boardMapper.selectFileInfo(map);
	}
}