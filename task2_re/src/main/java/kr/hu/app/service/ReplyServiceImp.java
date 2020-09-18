package kr.hu.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.hu.app.bean.ReplyBean;
import kr.hu.app.bean.SearchBean;
import kr.hu.app.mapper.ReplyMapper;

@Service
@Qualifier("replyService")
public class ReplyServiceImp implements ReplyService {
	
	@Autowired 
	@Qualifier("replyMapper")
	private ReplyMapper replyMapper;
	
	@Override
	public List<ReplyBean>readReply(int board_no) throws Exception{
		
		return replyMapper.readReply(board_no);
	}
	
	@Override
	public void writeReply(ReplyBean rb) throws Exception {
		
		replyMapper.writeReply(rb);
	}
	
	@Override
	public void updateReply(ReplyBean rb) throws Exception {
		
		replyMapper.updateReply(rb);
	}
	
	@Override
	public void deleteReply(ReplyBean rb) throws Exception {
		
		replyMapper.deleteReply(rb);
	}
	
	@Override
	public ReplyBean selectReply(int comment_no) throws Exception {
		
		return replyMapper.selectReply(comment_no);
	}
}
