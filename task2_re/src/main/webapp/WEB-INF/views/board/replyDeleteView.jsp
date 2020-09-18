<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 	<title>게시판</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='updateForm']");
			
			/* $(".delete_btn").on("click", function(){
				formObj.attr("action", "replyDelete");
				formObj.attr("method", "post");
				formObj.submit();
			}) */
			
			$(".cancel_btn").on("click", function(){
				location.href = "/task2/board/lookup?board_no=${replyDelete.board_no}"
					   + "&page=${sb.page}"
					   + "&perPageNum=${sb.perPageNum}"
					   + "&searchType=${sb.searchType}"
					   + "&keyword=${sb.keyword}";
			})
			
		})
		
	</script>
	<body>
	
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			<hr />
			
			<section id="container">
				<form name="updateForm" role="form" method="post" action="replyDelete">
					<input type="hidden" name="board_no" value="${replyDelete.board_no}" readonly="readonly"/>
					<input type="hidden" id="comment_no" name="comment_no" value="${replyDelete.comment_no}" />
					<input type="hidden" id="page" name="page" value="${sb.page}"> 
					<input type="hidden" id="perPageNum" name="perPageNum" value="${sb.perPageNum}"> 
					<input type="hidden" id="searchType" name="searchType" value="${sb.searchType}"> 
					<input type="hidden" id="keyword" name="keyword" value="${sb.keyword}"> 
						
					<div>
						<p>삭제 하시겠습니까?</p>
						<button type="submit" class="delete_btn">예 삭제합니다.</button>
						<button type="button" class="cancel_btn">아니오. 삭제하지 않습니다.</button>
					</div>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>