$(document).ready(function(){
	function validate() {
		var re = /^[a-zA-Z0-9]{4,12}$/
		var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
		var id = document.getElementById("name");
		var email = document.getElementById("email");
		var pw = document.getElementById("password");
		
		if(!check(re,id,"아이디는 4~12자의 영문 대소문자와 숫자로만 입력")) {
           return false;
       	}
       	
       	if(!check(re,pw,"패스워드는 4~12자의 영문 대소문자와 숫자로만 입력")) {
           return false;
       	}
       	
       	if(email.value=="") {
           alert("이메일을 입력해 주세요");
           email.focus(); // 이메일로 커서를 강제 이동
           return false;
       }
	}
});
