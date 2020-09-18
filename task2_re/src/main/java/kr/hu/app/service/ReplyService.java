package kr.hu.app.service;

import java.util.List;

import kr.hu.app.bean.ReplyBean;
import kr.hu.app.bean.SearchBean;

public interface ReplyService {
	
	public List<ReplyBean>readReply(int board_no) throws Exception;
	
	public void writeReply(ReplyBean rb) throws Exception;

	public void updateReply(ReplyBean rb) throws Exception;

	public void deleteReply(ReplyBean rb) throws Exception;

	public ReplyBean selectReply(int comment_no) throws Exception;
}
