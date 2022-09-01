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

});//ready end
</script>
</head>
<body>
<h1>이미지1 모음</h1>
<c:forEach items="${img1 }" var="img">
	<img src="/upload/${img }" style="width:200px" height="200px">
</c:forEach>
<hr>
<h1>이미지2 모음</h1>
<c:forEach items="${img2 }" var="img">
	<img src="/upload/${img }">
</c:forEach>
</body>
</html>