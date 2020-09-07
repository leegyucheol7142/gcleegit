package kr.hu.app.web.login;

public class UserBean {
		
		private int no;
		private String name;
		private String email;
		private String password;
		
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
		
		@Override
		public String toString() {
			return "UserBean [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + "]";
		}
		
}
