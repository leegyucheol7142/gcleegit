<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/task2/resources/css/common.css">
<link rel="stylesheet" href="/task2/resources/css/list.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<meta charset="UTF-8">
<title>일반 게시판</title>
	<style type="text/css">
				li {list-style: none; float: left;}
	</style>
	<script type="text/javascript">
		$(function() {
			$('#cancel').on('click', function(event) {
				event.preventDefault()
				location.href = "/task2";
			});
		});
		
		$(function(){
	        $('#searchBtn').click(function() {
	          self.location = "list" + '${pageBean.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
	        });
	      });   
	</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/main.jsp" />
		<div id="lcontainer">
			<div style="font-size:12pt;">
	            <a href="upExcel">-Excel Up-</a>
	            <a href="excelform">-Excel Down-</a>
            </div>
			<div class="faq_tb">
				<ul>
					<li class="no title">NO.</li>
					<li class="detail title">제목</li>
					<li class="name title">작성자</li>
					<li class="date title">작성일</li>
				</ul>
			<form role="form" method="get">
					<c:choose>
						<c:when test='${list.isEmpty()}'>
							<ul>
								<li><h3 style="text-align: center;">작성된 게시글이 없습니다.</h3></li>
							</ul>
						</c:when>
						<c:otherwise>
							<c:forEach var="list" items="${list}">
							<ul>
								<li class="body">
									<ul class="accordion">
										<li class="no"><c:out value="${list.board_no}" /></li>
										<li class="detail subject"><a href="lookup?board_no=${list.board_no}"><c:out value="${list.title}" /></a></li>
										<li class="name"><c:out value="${list.user_no}" /></li>
										<li class="date"><fmt:formatDate value="${list.reg}" pattern="yyyy-MM-dd HH:mm:ss"/></li>
									</ul>
							</ul>
							</c:forEach>
						</c:otherwise>
					</c:choose>
			</div>
			<div class="search">
			    <select name="searchType">
			      <option value="n"<c:out value="${sb.searchType == null ? 'selected' : ''}"/>>-----</option>
			      <option value="t"<c:out value="${sb.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
			      <option value="c"<c:out value="${sb.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
			      <option value="w"<c:out value="${sb.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
			      <option value="tc"<c:out value="${sb.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
			    </select>
			
			    <input type="text" name="keyword" id="keywordInput" value="${sb.keyword}"/>
			
			    <button id="searchBtn" type="button">검색</button>
		  	</div>
					<div>
					  <ul>
					    <c:if test="${pageBean.prev}">
					    	<li><a href="list${pageBean.makeSearch(pageBean.startPage - 1)}" >이전</a></li>
					    </c:if> 
					
					    <c:forEach begin="${pageBean.startPage}" end="${pageBean.endPage}" var="idx">
					    	<li><a href="list${pageBean.makeSearch(idx)}">${idx}</a></li>
					    </c:forEach>
					
					    <c:if test="${pageBean.next && pageBean.endPage > 0}">
					    	<li><a href="list${pageBean.makeSearch(pageBean.endPage + 1)}">다음</a></li>
					    </c:if> 
					  </ul>
					</div>
				<c:choose>
		           		<c:when test="${ empty loginuser }">
		           			<div class="number" style="text-align: right:;">
								<a href="/task2/login">글쓰기</a>
							</div>
		                </c:when>
		                <c:otherwise>
		                	<div class="number" style="text-align: right;">
								<a href="write">글쓰기</a>
							</div>
		                 </c:otherwise>
		        </c:choose>
    		</form>
   		</div>
</body>
</html>