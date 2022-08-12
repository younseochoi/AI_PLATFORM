<%@page import="dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MemberDAO"%>
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
$(document).ready(function(){
	
});
</script>
</head>
<body>
<%-- <% ArrayList<MemberDTO> memberlist = 
(ArrayList<MemberDTO>)request.getAttribute("memberlist", list); %> 
<table border="4">
<% for (int i = 0; i < memberlist.size(); i++){ %>
<tr>
<td><%=memberlist.get(i).getId() %></td>
<td><%=memberlist.get(i).getName() %></td>
<td><%=memberlist.get(i).getPhone() %></td>
<td><%=memberlist.get(i).getEmail() %></td>
<td><%=memberlist.get(i).getRegdate() %></td>
</tr>
<%} %>
</table>
--%>

<table border="4">
	<c:forEach items="${memberlist }" var="dto">
		<tr>
		<td>${dto.id }</td>
		<td>${dto.name }</td>
		<td>${dto.phone }</td>
		<td>${dto.email }</td>
		<td>${dto.regdate }</td>
		</tr>
	</c:forEach>
</table>



</body>
</html>