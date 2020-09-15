<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 	<title>게시판</title>
	 	<style>
			ul{
			   list-style:none;
			   }
			</style>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='readForm']");
			
			// 수정 
			$(".update_btn").on("click", function(){
				formObj.attr("action", "rewrite");
				formObj.attr("method", "get");
				formObj.submit();				
			})
			
			// 삭제
			$(".delete_btn").on("click", function(){
				formObj.attr("action", "/board/delete");
				formObj.attr("method", "post");
				formObj.submit();
			})
			
			// 취소
			$(".list_btn").on("click", function(){
				
				location.href = "/board/list";
			})
		})
	</script>
	<body>
	
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			 
			<nav>
			  홈 - 글 작성
			</nav>
			<hr />
			
			<section id="container">
				<form name="readForm" role="form" method="post">
					<input type="hidden" id="bno" name="board_no" value="${read.board_no}" />
				</form>
					<ul>
						<li><label for="title">제목</label></li>
						<li><input type="text" id="title" name="title" value="${read.title}"/></li>
					</ul>	
					<ul>
						<li><label for="user_no">작성자</label></li>
						<li><input type="text" id="writer" name="writer" value="${read.user_no}" /></li>
					</ul>
					<ul>
						<li><label for="content">내용</label></li>
						<li><textarea id="content" name="content"><c:out value="${read.content}" /></textarea></li>
					</ul>
					<ul>
						<li><label for="regdate">작성날짜</label></li>
						<li><fmt:formatDate value="${read.reg}" pattern="yyyy-MM-dd"/></li>
					</ul>		
					<div>
						<button type="submit" class="update_btn">수정</button>
						<button type="submit" class="delete_btn">삭제</button>
						<button type="submit" class="list_btn">목록</button>	
					</div>
			</section>
			<hr />
		</div>
	</body>
</html>