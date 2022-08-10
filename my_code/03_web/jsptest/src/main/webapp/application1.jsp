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
</head>
<body>
<%
	String menu[] = {"회원 관리","게시판 관리","쇼핑몰 관리","챗봇 관리"};
	application.setAttribute("menu", menu);//브라우저가 바껴도 공유가능 
	session.setAttribute("id", "user"); //브라우저 내부 
%>
<h1> 필요한 정보를 제공했습니다.</h1>
</body>
</html>