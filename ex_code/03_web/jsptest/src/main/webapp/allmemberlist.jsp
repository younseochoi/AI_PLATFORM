<%@page import="dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MemberDAO"%>
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
<% MemberDAO dao = new MemberDAO();
ArrayList<MemberDTO> memberlist = dao.selectAllMember();
%>

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

</body>
</html>