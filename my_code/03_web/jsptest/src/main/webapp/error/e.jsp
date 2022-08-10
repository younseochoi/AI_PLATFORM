<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
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
//a b.jsp 오류발생시 "자동" 이동 실행
%>
<h1>========== 오류발생 파일명 ==============</h1>
<%=request.getRequestURI() %> 
<h1>========== toString() ==============</h1>
<%=exception.toString() %> 

<h1>========== getMessage() ==============</h1>
<%=exception.getMessage() %> 

<h1>========== printStackTrace() ==============</h1>
<% exception.printStackTrace(); %> 
</body>
</html>