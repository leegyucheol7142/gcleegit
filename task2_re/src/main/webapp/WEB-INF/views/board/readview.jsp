<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<link rel="stylesheet" href="/task2/resources/css/common.css">
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
		var formObj2 = $("form[name='readForm']");
		// 수정 
		$(".update_btn").on("click", function(){
			formObj.attr("action", "update");
			formObj.attr("method", "get");
			formObj.submit();				
		})
		
		// 삭제
		$(".delete_btn").on("click", function(){
			
			var deleteYN = confirm("삭제하시겠습니까?");
			if(deleteYN == true){
				
			formObj.attr("action", "delete");
			formObj.attr("method", "post");
			formObj.submit();
				
			}
		})
		
		// 답변
		$(".anwser_btn").on('click', function (){
            location.href = "rewrite?board_no=${read.board_no}&step_No=${read.step_No}";
        });
		
		// 목록
		$(".list_btn").on("click", function(){
			
			location.href = "list?page=${sb.page}"
					      +"&perPageNum=${sb.perPageNum}"
					      +"&searchType=${sb.searchType}&keyword=${sb.keyword}";
		})
		
		$(".replyWriteBtn").on("click", function(){
			var formObj = $("form[name='replyForm']");
			formObj.attr("action", "replyWrite");
			formObj.submit();
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
			var deleteYN = confirm("댓글을 삭제하시겠습니까?");
			if(deleteYN == true){
				location.href = "/task2/board/lookup?board_no=${read.board_no}"
					+ "&page=${sb.page}"
					+ "&perPageNum=${sb.perPageNum}"
					+ "&searchType=${sb.searchType}"
					+ "&keyword=${sb.keyword}"
					+ "&comment_no="+$(this).attr("data-comment_no");
				/* formObj2.attr("action", "replyDelete");
				formObj2.attr("method", "post");
				formObj2.submit(); */
				}
		});
		})
		
		//첨부파일 다운로드
		function fn_fileDown(fileNo){
			var formObj = $("form[name='readForm']");
			$("#FILE_NO").attr("value", fileNo);
			formObj.attr("action", "fileDown");
			formObj.submit();
		}
	</script>
	<body>
		<jsp:include page="/WEB-INF/views/main.jsp" />
			<div id="container">
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
						<input type="hidden" id="board_no" name="board_no" value="${read.board_no}" />
						<input type="hidden" id="page" name="page" value="${sb.page}"> 
						<input type="hidden" id="perPageNum" name="perPageNum" value="${sb.perPageNum}"> 
						<input type="hidden" id="searchType" name="searchType" value="${sb.searchType}"> 
						<input type="hidden" id="keyword" name="keyword" value="${sb.keyword}"> 
						<input type="hidden" id="FILE_NO" name="FILE_NO" value="">
					</form>
						<div class="form-group">
							<label for="user_no">작성자:</label>
							<div><c:out value="${read.user_no}"/></div>
						</div>
						<div class="form-group">	
							<label for="title">제목:</label>
							<div><c:out value="${read.title}"/></div>
						</div>	
						<div class="form-group">
							<label for="content">내용:</label>
							<div><c:out value="${read.content}"/></div>
						</div>
						<hr>
						<span>파일 목록</span>
						<div class="form-group" style="border: 1px solid #dbdbdb;">
							<c:forEach var="file" items="${file}">
								<a href="#" onclick="fn_fileDown('${file.FILE_NO}'); return false;">${file.ORG_FILE_NAME}</a>(${file.FILE_SIZE}kb)<br>
							</c:forEach>
						</div>
						<hr>		
						<div>
							<button type="button" class="update_btn">수정</button>
							<button type="button" class="delete_btn">삭제</button>
							<button type="button" class="anwser_btn">답변</button>
							<button type="button" class="list_btn">목록</button>	
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