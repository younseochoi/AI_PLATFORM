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
</head>
<body>

<!-- http://localhost:8080/jsptest/start?menu=boardwriting

http://localhost:8080/jsptest/start?menu=board

http://localhost:8080/jsptest/mvc/boardsuccess.jsp -->
<h1> 게시물 작성 폼 </h1>
<form action="start?menu=board" >
제목:<input type=text name="title" ><br>
내용:<textarea name="contents" cols=50 rows=5 ></textarea> 
작성자:<input type=text name="id" value="${session_id }">
<input type="submit" value="게시물작성">
</form>
</body>
</html>





