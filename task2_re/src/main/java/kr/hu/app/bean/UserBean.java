package kr.hu.app.bean;

import java.util.Date;

public class UserBean {
		
		private int no;
		private String name;
		private String email;
		private String password;
		private Boolean same;
		private Date regdate;
		
		public int getNo() {
			return no;
		}
		public void setNo(int no) {
			this.no = no;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Boolean getSame() {
			return same;
		}
		public void setSame(Boolean same) {
			this.same = same;
		}
		public Date getRegdate() {
			return regdate;
		}
		public void setRegdate(Date regdate) {
			this.regdate = regdate;
		}
		@Override
		public String toString() {
			return "UserBean [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", same="
					+ same + ", regdate=" + regdate + "]";
		}
}
