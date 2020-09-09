<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/common.css">
<link rel="stylesheet" href="resources/css/user.css">
<title>회원가입</title>
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
		<form action="/task2/signup" method="post">
			<div>
		    	<label for="name">Name:</label>
	      		<input type="text" id="name" name="name" required="required" placeholder="이름을 입력하세요.">
		  	</div>
			<div>
		    	<label for="email">Email:</label>
	      		<input type="email" id="email" name="email" required="required" placeholder="이메일를 입력하세요.">
		  	</div>
		  	<div>
		    	<label for="pwd">Password:</label>
		      	<input type="password" id="password" name="password" required="required" placeholder="비밀번호를 입력하세요.">
		  	</div>		  	
		  	<div>
		      	<button type="submit">가입</button>
			</div>
		</form>
    	</div>
    </div>	
</body>
</html>