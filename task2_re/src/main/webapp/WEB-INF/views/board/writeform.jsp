<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/task2/resources/css/common.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<meta charset="UTF-8">
<title>게시판 글쓰기 폼</title>
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
	<div id="container">
		<section>
				<div class="writemodal">
					<form action="write" method="post" enctype="multipart/form-data">
						<div class="one">
							<label for="title">제목</label> 
							<input id="btitle" type="text" name="title" placeholder="제목을 입력하세요">
						</div>
				<div class="two">
					<label for="content">내용</label>
					<textarea id="content" cols="58" rows="8" name="content" placeholder="내용을 입력하세요"></textarea>
				</div>
				<div>
					<input type="file" name="file">
				</div>
				<div id="b_all">
					<button class="m_button" id="cancel">취소</button>
					<button type="submit" class="m_button" id="sub_b">등록</button>
				</div>
					</form>
				</div>
			</div>
		</section>
			
</body>
</html>