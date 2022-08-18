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
$('p').css('color','red');
});
</script>
</head>
<body>
<form action="login" method="post">
<p>id 입력 : <input type=text name="id"></p>
<p>암호 입력 : <input type=password name="password"></p>
<input type=submit value="로그인"> 
</form>
</body>
</html>