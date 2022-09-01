<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){

});
</script>
</head>
<body>
<h1>로그인폼</h1>
<form action="boardlogin" method="post">
<p>id 입력 : <input type=text name="id"></p>
<p>암호 입력 : <input type=password name="password"></p>
<input type=submit value="로그인"> 
</form>
</body>
</html>