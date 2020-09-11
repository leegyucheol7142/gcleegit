<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/common.css">
<link rel="stylesheet" href="resources/css/user.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<title>회원가입</title>
<script type="text/javascript">
	function validate() {
		var re = /^[a-zA-Z0-9]{4,12}$/;
		var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
		var id = document.getElementById("name");
		var email = document.getElementById("email");
		var pw = document.getElementById("password");
		
		if(id.value == ""){
			 
			  alert("id를 입력해주세요.");
			 
			  return false;
			 
		}
		
		if(!re.test(id,value)){
			alert("아이디는 4~12자의 영문 대소문자와 숫자로만 입력"); 
	       return false;
	   	}
		
		if(!re.test(pw,value)){
			alert("비밀번호는 4~12자의 영문 대소문자와 숫자로만 입력"); 
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
	    if(!check(re2, email, "적합하지 않은 이메일 형식입니다.")) {
	           return false;
	    }
		
	    alert("회원가입이 완료되었습니다.");
	    
	    function check(re, what, message) {
	        if(re.test(what.value)) {
	            return true;
	        }
	        alert(message);
	        what.value = "";
	        what.focus();
}
</script>
</head>
<body>
	<div id="title">
		<h1>휴에이션 과제</h1>
	</div>
	<div id="middle">
		<div id="side">
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="#">N.board</a></li>
				<li><a href="#">N.board2</a></li>
				<li><a href="#">Bar graph</a></li>
				<li><a href="#">Chat</a></li>
			</ul>
		</div>
		<div id="container">    
			<h2>Sign Up</h2>
		<form action="/task2/signup" method="post" name="join">
			<div>
		    	<label for="name">Name:</label><br>
	      		<input type="text" id="name" name="name" required="required" placeholder="이름을 입력하세요."><br>
		  	</div>
			<div>
		    	<label for="email">Email:</label><br>
	      		<input type="email" id="email" name="email" required="required" placeholder="이메일를 입력하세요."><br>
		  	</div>
		  	<div>
		    	<label for="pwd">Password:</label><br>
		      	<input type="password" id="password" name="password" required="required" placeholder="비밀번호를 입력하세요."><br>
		  	</div>		  	
		  	<div>
		      	<button type="submit">가입</button>
			</div>
		</form>
    	</div>
    </div>	
</body>
</html>