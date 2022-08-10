<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"errorPage="e.jsp"%>
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
int index = Integer.parseInt(request.getParameter("index"));
%>
<h1><%=menu[index] %></h1>
</body>
</html>