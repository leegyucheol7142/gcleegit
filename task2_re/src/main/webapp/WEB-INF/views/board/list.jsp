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
<script type="text/javascript">
	$(function() {
		$('#cancel').on('click', function(event) {
			event.preventDefault()
			location.href = "/task2";
		});
	});
</script>
</head>
<body>
	<section>
			<div class="faq_tb">
				<ul>
					<li class="no title">NO.</li>
					<li class="detail title">제목</li>
					<li class="name title">작성자</li>
					<li class="date title">작성일</li>
				</ul>
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
								<li class="date"><fmt:formatDate value="${list.reg}" pattern="yyyy-MM-dd"/></li>
							</ul>
					</ul>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			</div>
		<c:choose>
           		<c:when test="${ empty loginuser }">
           			<div class="number" style="text-align: center;">
						<a class="left-arrow" href="javascript:void(0);" id="left-arrow">&#60;</a>
						<div id="pagging" style="display: inline-block;"></div>
						<a class="right-arrow" href="javascript:void(0);" id="right-arrow">&#62;</a>
						<a href="/task2/login">글쓰기</a>
					</div>
                </c:when>
                <c:otherwise>
                	<div class="number" style="text-align: center;">
						<a class="left-arrow" href="javascript:void(0);" id="left-arrow">&#60;</a>
						<div id="pagging" style="display: inline-block;"></div>
						<a class="right-arrow" href="javascript:void(0);" id="right-arrow">&#62;</a>
						<a href="write">글쓰기</a>
					</div>
                 </c:otherwise>
        </c:choose>
    </section>
</body>
</html>