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
$(document).ready(function() {
});//ready end
</script>
</head>
<body>
<c:forEach items="${filenames }" var="onefile">
<h3> <a href="faceresult?image=${onefile }"> ${onefile }</a> </h3>
<img src="http://localhost:8082/naverai/${onefile }" width=200 heght=200>
</c:forEach>

<h1> </h1>
</body>
</html>