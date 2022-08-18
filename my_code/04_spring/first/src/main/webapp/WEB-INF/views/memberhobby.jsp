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
<form action="member" method="post">
아이디 : <input type=text name="id"><br>
암호 : <input type=password name="password"><br>
나이 : <input type=text name="age"><br>
취미 : 
<input type="checkbox" name="hobby" value="it">it개발
<input type="checkbox" name="hobby" value="shopping">쇼핑
<input type="checkbox" name="hobby" value="book">독서
<input type="checkbox" name="hobby" value="music">음악
<input type="checkbox" name="hobby" value="movie">영화
<br>


<input type="submit" value="회원가입">
</form>
</body>
</html>