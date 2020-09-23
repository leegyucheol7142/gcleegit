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
	<jsp:include page="/WEB-INF/views/main.jsp" />
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