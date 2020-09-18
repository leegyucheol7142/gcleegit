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