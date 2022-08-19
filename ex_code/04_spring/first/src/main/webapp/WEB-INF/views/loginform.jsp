<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.min.js" ></script>
<script>
$(document).ready(function(){
$("h1").css("color", "red");
});
</script>
</head>
<body>
<h1> 로그인폼 </h1>
<!-- 
html 태그 속성 url - "/"시작하면 http://localhost:8080 생략
jsp나 servlet, xml 파일들 url - "/" 시작하면 http://localhost:8080/컨텍스트명 생략

서블릿/jsp  + spring mvc
doGet-요청한글인코딩자동
doPost- request.setCharacterEncoding("utf-8"); 수동설정추가
 -->
<form action="login" method="post">  
아이디:<input type=text name="id" ><br>
암호:<input type=password name="password" ><br>
<input type=submit value="로그인" >
</form>
</body>
</html>



