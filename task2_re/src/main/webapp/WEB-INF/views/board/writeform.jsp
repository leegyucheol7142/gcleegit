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
	<jsp:include page="/WEB-INF/views/main.jsp" />
		<div id="container">
			<div class="writemodal">
				<form role="form" action="write" method="post" enctype="multipart/form-data">
					<div class="one">
						<label for="title">제목</label> 
						<input id="btitle" type="text" name="title" placeholder="제목을 입력하세요">
					</div>
			<div class="two">
				<label for="content">내용</label>
				<textarea id="content" name="content" rows="15" placeholder="내용을 입력하세요"></textarea>
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
</body>
</html>