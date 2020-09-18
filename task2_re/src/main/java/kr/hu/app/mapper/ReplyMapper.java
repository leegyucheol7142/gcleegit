package kr.hu.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

import kr.hu.app.bean.ReplyBean;
import kr.hu.app.bean.SearchBean;

@Mapper
@Qualifier("replyMapper") 
public interface ReplyMapper {
	
	//´ñ±Û Á¶È¸
	public List<ReplyBean>readReply(int board_no) throws Exception;
	
	//´ñ±Û ÀÛ¼º
	public void writeReply(ReplyBean rb) throws Exception;

	//´ñ±Û ¼öÁ¤
	public void updateReply(ReplyBean rb) throws Exception;
	
	//´ñ±Û »èÁ¦
	public void deleteReply(ReplyBean rb) throws Exception;
	
	//¼±ÅÃ ´ñ±Û Á¶È¸
	public ReplyBean selectReply(int comment_no) throws Exception;
}
