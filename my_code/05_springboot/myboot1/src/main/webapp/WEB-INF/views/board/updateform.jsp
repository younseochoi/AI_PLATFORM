<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){

});
</script>
</head>
<body>
<form action="boardupdate" method="post">
	<table border=1>
		<tr style="display: none;"><td>글번호</td><td><input type=hidden name="seq" value="${updateform.seq }"></td></tr>
		<tr><td>제목</td><td><input type=text name="title" value="${updateform.title }"></td></tr>
		<tr><td>내용</td><td><textarea rows="5" cols="50" name="contents">${updateform.contents }</textarea> </td></tr>
		<tr style="display: none;"><td>글암호</td><td><input type=hidden name="pw"  value="${updateform.pw }" ></td></tr>
		<tr><td>작성자</td><td><input type=text name="writer" value="${updateform.writer }" readonly="readonly"></td></tr>
		<tr><td>조회수</td><td><input type=text name="viewcount" value="${updateform.viewcount }" readonly="readonly"></td></tr>
		<tr><td colspan="2" style="text-align:center;"><input type =submit value="수정"></td></tr>
	</table>
</form>
</body>
</html>