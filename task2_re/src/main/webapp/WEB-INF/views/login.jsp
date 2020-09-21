<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/common.css">
<link rel="stylesheet" href="resources/css/user.css">
<title>로그인</title>
</head>
<body>
	<div id="top">
	<div id="title">
		<a href="/task2">휴에이션 과제</a>
	</div>	
	
	<div id="info">
		<c:choose>
			<c:when test="${empty loginuser}">
				<input type='button' onclick='moveLogin();' name='btn' value='login' style="float: right;">
				<input type='button' onclick='moveSignup();' name='btn' value='signup' style="float: right;">
			</c:when>
			<c:otherwise>
				<input type='button' onclick="location.href='./logout'" name='btn' value='logout' style="float: right;">
				<li>${loginuser.name}님 안녕하세요</li>
			</c:otherwise>
		</c:choose>
	</div>
</div>
	<div id="sidebar">
		<div>
			<ul>
				<li><a href="/task2">Home</a></li>
				<li><a href="/task2/board/list">N.board</a></li>
				<li><a href="#">N.board2</a></li>
				<li><a href="#">Bar graph</a></li>
				<li><a href="#">Chat</a></li>
			</ul>
		</div>
	</div>
	<div id="container">    
			<h1 class="text-center">Login</h1>
		<form action="/task2/success" method="post">
			<div>
		    	<label for="name">Id:</label>
		      	<input type="text" id="name" name="name" required="required" placeholder="계정을 입력하세요.">
		  	</div>
		  	<div>
		    	<label for="password">Password:</label>
		      	<input type="password" id="password" name="password" required="required" placeholder="비밀번호를 입력하세요.">
		  	</div>
		  	<div>
		      	<button type="submit">로그인</button>
			</div>
		</form>			  
    	</div>
</body>
</html>