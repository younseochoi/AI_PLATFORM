<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="boardsuccess.jsp">
	<table border=1>
		<tr><td>제목</td><td><input type=text name="title"></td></tr>
		<tr><td>내용</td><td><textarea rows="5" cols="50"></textarea></td></tr>
		<tr><td>작성자</td><td> <input type=text name="writer"></td></tr>
		<tr><td colspan="2"> <input type=submit value="글쓰기"></td></tr>
	</table>
</form>

</body>
</html>