<%@page import="annotation.springmvc.HelloDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 모델</title>
</head>
<body>
<% ArrayList<HelloDTO> list = (ArrayList<HelloDTO>) request.getAttribute("list"); 
	for(int i =0;i<list.size();i++){
		String msg = list.get(i).getMessage();
		%>
		<h3> <%=msg %></h3>
		<%
	}
%>
<hr>
<c:forEach items="${list }" var="dto">
<h3>${dto.message }</h3>
</c:forEach>
</body>
</html>