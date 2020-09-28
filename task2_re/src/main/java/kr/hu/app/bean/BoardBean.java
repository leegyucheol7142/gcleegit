package kr.hu.app.bean;

import java.sql.Timestamp;

public class BoardBean {

		private int board_no;
		private String title;
		private String user_no;
		private String content;
		private Timestamp reg;
		private Boolean delyn;
		private int group_No;
		private int step_No;
		private int depth;
		
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
		public int getGroup_No() {
			return group_No;
		}
		public void setGroup_No(int group_No) {
			this.group_No = group_No;
		}
		public int getStep_No() {
			return step_No;
		}
		public void setStep_No(int step_No) {
			this.step_No = step_No;
		}
		public int getDepth() {
			return depth;
		}
		public void setDepth(int depth) {
			this.depth = depth;
		}
		@Override
		public String toString() {
			return "BoardBean [board_no=" + board_no + ", title=" + title + ", user_no=" + user_no + ", content="
					+ content + ", reg=" + reg + ", delyn=" + delyn + ", group_No=" + group_No + ", step_No=" + step_No
					+ ", depth=" + depth + "]";
		}
		
		
}
