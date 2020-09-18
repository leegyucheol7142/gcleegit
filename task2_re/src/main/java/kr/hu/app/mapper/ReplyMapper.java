package kr.hu.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

import kr.hu.app.bean.ReplyBean;
import kr.hu.app.bean.SearchBean;

@Mapper
@Qualifier("replyMapper") 
public interface ReplyMapper {
	
	//��� ��ȸ
	public List<ReplyBean>readReply(int board_no) throws Exception;
	
	//��� �ۼ�
	public void writeReply(ReplyBean rb) throws Exception;

	//��� ����
	public void updateReply(ReplyBean rb) throws Exception;
	
	//��� ����
	public void deleteReply(ReplyBean rb) throws Exception;
	
	//���� ��� ��ȸ
	public ReplyBean selectReply(int comment_no) throws Exception;
}
