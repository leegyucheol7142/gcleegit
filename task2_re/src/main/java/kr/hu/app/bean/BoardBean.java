package kr.hu.app.bean;

import java.sql.Timestamp;

public class BoardBean {

		private int board_no;
		private String title;
		private String user_no;
		private String content;
		private Timestamp reg;
		private Boolean delyn;
		
		public int getBoard_no() {
			return board_no;
		}
		public void setBoard_no(int board_no) {
			this.board_no = board_no;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getUser_no() {
			return user_no;
		}
		public void setUser_no(String user_no) {
			this.user_no = user_no;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public Timestamp getReg() {
			return reg;
		}
		public void setReg(Timestamp reg) {
			this.reg = reg;
		}
		public Boolean getDelyn() {
			return delyn;
		}
		public void setDelyn(Boolean delyn) {
			this.delyn = delyn;
		}
		@Override
		public String toString() {
			return "BoardBean [board_no=" + board_no + ", title=" + title + ", user_no=" + user_no + ", content="
					+ content + ", reg=" + reg + ", delyn=" + delyn + "]";
		}
		
}
