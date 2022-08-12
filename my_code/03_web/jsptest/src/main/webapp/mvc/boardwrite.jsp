<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
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
<style>
	h1{
		text-align: center;
	}
	table, td{
		margin : 0 auto;
		border : 2px solid black;
		border-collapse: collapse;	
		padding : 5px 5px 5px 5px;
	}
</style>
</head>
<body>
<h1>게시글 작성폼</h1>
<form action="/jsptest/mvc/boardsuccess.jsp" method="post"> 
	<table border=1>
		<tr><td>제목</td><td><input type=text name="title"></td></tr>
		<tr><td>내용</td><td><textarea rows="5" cols="50" name="contents"></textarea></td></tr>
		<tr><td>작성자</td><td> <input type=text name="id" value="${session_id }"></td></tr>
		<tr><td colspan="2"> <input type=submit value="글쓰기"></td></tr>
	</table>
</form>

</body>
</html>