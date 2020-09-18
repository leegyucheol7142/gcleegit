package kr.hu.app.bean;

import java.util.Date;

public class ReplyBean {
	
	private int board_no;
	private int comment_no;
	private String content;
	private String user_no;
	private Date reg;
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getComment_no() {
		return comment_no;
	}
	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUser_no() {
		return user_no;
	}
	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}
	public Date getReg() {
		return reg;
	}
	public void setReg(Date reg) {
		this.reg = reg;
	}
	@Override
	public String toString() {
		return "ReplyBean [board_no=" + board_no + ", comment_no=" + comment_no + ", content=" + content + ", user_no="
				+ user_no + ", reg=" + reg + "]";
	}
	
}
