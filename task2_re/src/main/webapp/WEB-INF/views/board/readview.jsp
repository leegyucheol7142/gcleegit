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
			var formObj2 = $("form[name='replyForm']");
			// 수정 
			$(".update_btn").on("click", function(){
				formObj.attr("action", "rewrite");
				formObj.attr("method", "get");
				formObj.submit();				
			})
			
			// 삭제
			$(".delete_btn").on("click", function(){
				formObj.attr("action", "delete");
				formObj.attr("method", "post");
				formObj.submit();
			})
			
			// 취소
			$(".list_btn").on("click", function(){
				
				location.href = "list";
			})
			
			//댓글 작성
			$(".replyWriteBtn").on("click", function(){
			  formObj2.attr("action", "replyWrite");
			  formObj2.submit();
			});
			
			//댓글 수정 View
			$(".replyUpdateBtn").on("click", function(){
				location.href = "/task2/board/replyUpdateView?board_no=${read.board_no}"
								+ "&page=${sb.page}"
								+ "&perPageNum=${sb.perPageNum}"
								+ "&searchType=${sb.searchType}"
								+ "&keyword=${sb.keyword}"
								+ "&comment_no="+$(this).attr("data-comment_no");
			});
					
			//댓글 삭제 View
			$(".replyDeleteBtn").on("click", function(){
				location.href = "/task2/board/replyDeleteView?bno=${read.board_no}"
								+ "&page=${sb.page}"
								+ "&perPageNum=${sb.perPageNum}"
								+ "&searchType=${sb.searchType}"
								+ "&keyword=${sb.keyword}"
								+ "&comment_no="+$(this).attr("data-comment_no");
			});

	})
	</script>
	<body>
	
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			 
			<nav>
			  홈 - 상세보기 및 댓글
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
						<li><fmt:formatDate value="${read.reg}" pattern="yyyy-MM-dd HH:mm:ss"/></li>
					</ul>		
					<div>
						<button type="submit" class="update_btn">수정</button>
						<button type="submit" class="delete_btn">삭제</button>
						<button type="submit" class="list_btn">목록</button>	
					</div>
					
					<!-- 댓글 -->
					<div id="reply">
					  <ol class="replyList">
					    <c:forEach items="${replyList}" var="replyList">
					      <li>
					        <p>
							        작성자 : ${replyList.user_no}<br />
							        작성 날짜 :  <fmt:formatDate value="${replyList.reg}" pattern="yyyy-MM-dd HH:mm:ss" />
					        </p>
					
					        <p>${replyList.content}</p>
					        <div>
								  <button type="button" class="replyUpdateBtn" data-comment_no="${replyList.comment_no}">수정</button>
								  <button type="button" class="replyDeleteBtn" data-comment_no="${replyList.comment_no}">삭제</button>
							</div>
					      </li>
					    </c:forEach>   
					  </ol>
					</div>
					
					<form name="replyForm" method="post">
					  <input type="hidden" id="bno" name="board_no" value="${read.board_no}" />
					  <input type="hidden" id="page" name="page" value="${sb.page}"> 
					  <input type="hidden" id="perPageNum" name="perPageNum" value="${sb.perPageNum}"> 
					  <input type="hidden" id="searchType" name="searchType" value="${sb.searchType}"> 
					  <input type="hidden" id="keyword" name="keyword" value="${sb.keyword}"> 
					
					  <div>
					    <label for="writer">댓글 작성자</label><input type="text" id="writer" name="user_no" />
					    <br/>
					    <label for="content">댓글 내용</label><input type="text" id="content" name="content" />
					  </div>
					  <div>
					 	 <button type="button" class="replyWriteBtn">작성</button>
					  </div>
					</form>
			</section>
			<hr />
		</div>
	</body>
</html>