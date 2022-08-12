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
<%request.setCharacterEncoding("utf-8");%>
<h1>게시물제목 : ${param.title }</h1>
<h1>게시물작성자 : ${param.id }</h1>  
<h1>게시물작성자 : ${session_id }</h1> 
<h1>게시물내용 : ${param.contents }</h1>
</body>
</html>