<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/task2/resources/css/common.css">
<link rel="stylesheet" href="/task2/resources/css/list.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<meta charset="UTF-8">
<title>답변 게시물 작성</title>
<script type="text/javascript">
	$(function() {
		$('#cancel').on('click', function(event) {
			event.preventDefault()
			location.href = "list";
		});
	});
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/main.jsp" />
	    <div style="padding-top:25px;text-align:center;width: 550px;margin: 0 auto">
            <div>
                <div>
                    <div>답변 작성</div>
                    <br>
                    <form id="writeForm" action="rewrite" method="post" enctype="multipart/form-data">
                    	<input type="hidden" name="board_no" value="${read.board_no}" />
                    	<input type="hidden" name="step_No" value="${read.step_No }" />
                        <table>
                            <tr>
                                <th>제목</th>
                                <td>
                                    <input type="text" name="title" />
                                </td>
                            </tr>
                            <tr>
                                <th>작성자</th>
                                <td>
                                    <input type="hidden" name="user_no" value="${ loginuser.name }" />
                                    ${ loginuser.name }
                                </td>
                            </tr>
                            <tr>
                                <th>첨부자료</th>
                                <td>
                                    <input type="file" name="attach" />
                                </td>
                            </tr>
                            <tr>
                                <th>내용</th>
                                <td>
                                    <textarea id="content" name="content" rows="20" cols="50"></textarea>
                                </td>
                            </tr>
                        </table>
                        <div class="buttons">
                            <input type="submit" value="등록" style="height:25px" />
                            <input id="cancel" type="button" value="취소" style="height:25px" />
                        </div>
                    </form>
                </div>
            </div>

        </div>
    </div>
</body>
</html>