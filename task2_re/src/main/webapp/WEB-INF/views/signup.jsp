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
	$(function() {
		$('#signup').on('submit', function(e) {
			
		var id = new RegExp("^[a-zA-Z][a-zA-Z0-9]{3,11}$","g");
		var pw = new RegExp("[a-zA-Z][a-zA-Z0-9]{3,11}$","g");
		var email = new RegExp("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$", "g");
		
		if (!id.test($('#name').val())) {
			alert("아이디 형식에 맞지 않습니다.");
			$('#name').val("");
			$('#name').focus();
			return false;
		} else if (!pw.test($('#password').val())) {
			alert("비밀번호 형식에 맞지 않습니다.");
			$('#password').val("");
			$('#password').focus();
			return false;
		} else if ($('#password').val() !== $('#passwordcheck').val()) {
			alert("비밀번호가 일치하지 않습니다.");
			$('#passwordcheck').val("");
			$('#passwordcheck').focus();
			return false;
		} else if (!email.test($('#email').val())) {
			alert("이메일 형식이 맞지 않습니다.");
			$('#email').val("");
			$('#email').focus();
			return false;
		} else {
			return true;
		}
	});
	
});

</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/main.jsp" />
		<div id="container">    
			<h2>Sign Up</h2>
		<form id = "signup" action="/task2/signup" method="post" name="join">
			<div>
		    	<label for="name">Name:</label><br>
	      		<input type="text" id="name" name="name" required="required" placeholder="첫글자는 영문으로 시작해주세요"><br>
		  	</div>
			<div>
		    	<label for="email">Email:</label><br>
	      		<input type="email" id="email" name="email" required="required" placeholder="이메일를 입력하세요."><br>
		  	</div>
		  	<div>
		    	<label for="pwd">Password:</label><br>
		      	<input type="password" id="password" name="password" required="required" placeholder="비밀번호는 영문 or 숫자 4~12자리로 해주세요"><br>
		  	</div>
		  	<div>
		    	<label for="pwd">Password::</label><br>
		      	<input type="password" id="passwordcheck" name="password" required="required" placeholder="비밀번호를 확인하세요."><br>
		  	</div>		  	
		  	<div>
		      	<button type="submit">가입</button>
			</div>
		</form>
    	</div>
</body>
</html>