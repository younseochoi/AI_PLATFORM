<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){

});
</script>
</head>
<body>
<table border=1>
		<tr><td>글번호</td><td>${board.seq }</td></tr>
		<tr><td>제목</td><td>${board.title }</td></tr>
		<tr><td>내용</td><td><textarea rows="5" cols="50" name="contents" readonly="readonly"> ${board.contents }</textarea> </td></tr>
		<tr><td>작성자</td><td>${board.writer }</td></tr>
		<tr><td>조회수</td><td>${board.viewcount }</td></tr>
		<tr><td>작성시간</td><td>${board.writingtime }</td></tr>
		<tr><td><input type=submit value="수정"></td><td><input type=submit value="삭제"></td></tr>
</table>

</body>
</html>