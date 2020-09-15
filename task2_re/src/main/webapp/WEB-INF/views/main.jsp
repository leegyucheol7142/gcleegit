<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" href="resources/css/common.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<title>메인화면</title>
	
	<script type="text/javascript">
	function moveLogin(){
	     location.href = "/task2/login";
	}
	
	function moveSignup(){
	     location.href = "/task2/signup";
	}
	
	function logout(){
	     location.href = "/task2";
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
				<li><a href="/task2">Home</a></li>
				<li><a href="/task2/board/list">N.board</a></li>
				<li><a href="#">N.board2</a></li>
				<li><a href="#">Bar graph</a></li>
				<li><a href="#">Chat</a></li>
			</ul>
		</div>
		<div>
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
		<b><font size="5" color="skyblue">메인화면입니다.</font></b><br><br>
	</div>
</body>
</html>
