<%@page import="dto.MemberDTO"%>
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
<%-- <jsp:useBean id="user" class="dto.MemberDTO"/>
<jsp:getProperty property="id" name="user"/>
<jsp:getProperty property="password" name="user"/>
<jsp:getProperty property="name" name="user"/>
<jsp:getProperty property="phone" name="user"/>
<jsp:getProperty property="email" name="user"/>
<jsp:getProperty property="regdate" name="user"/> --%>
<% MemberDTO user = (MemberDTO) request.getAttribute("user");%>
<%=user %>
</body>
</html>