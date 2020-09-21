<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<link rel="stylesheet" href="/task2/resources/css/common.css">
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 	<title>게시판</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='updateForm']");
				
			$(".cancel_btn").on("click", function(){
				location.href = "/task2/board/lookup?board_no=${replyUpdate.board_no}"
					   + "&page=${sb.page}"
					   + "&perPageNum=${sb.perPageNum}"
					   + "&searchType=${sb.searchType}"
					   + "&keyword=${sb.keyword}";
			})
			
		})
		
	</script>
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
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			<hr />
			
			<section id="container">
				<form name="updateForm" role="form" method="post" action="replyUpdate">
					<input type="hidden" name="board_no" value="${replyUpdate.board_no}" readonly="readonly"/>
					<input type="hidden" id="comment_no" name="comment_no" value="${replyUpdate.comment_no}" />
					<input type="hidden" id="page" name="page" value="${sb.page}"> 
					<input type="hidden" id="perPageNum" name="perPageNum" value="${sb.perPageNum}"> 
					<input type="hidden" id="searchType" name="searchType" value="${sb.searchType}"> 
					<input type="hidden" id="keyword" name="keyword" value="${sb.keyword}"> 
					<table>
						<tbody>
							<tr>
								<td>
									<label for="content">댓글 내용</label><input type="text" id="content" name="content" value="${replyUpdate.content}"/>
								</td>
							</tr>	
							
						</tbody>			
					</table>
					<div>
						<button type="submit" class="update_btn">저장</button>
						<button type="button" class="cancel_btn">취소</button>
					</div>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>