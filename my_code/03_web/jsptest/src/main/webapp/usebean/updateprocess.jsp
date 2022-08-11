<%@page import="dao.MemberDAO"%>
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
<jsp:useBean id="dto" class="dto.MemberDTO" />
<jsp:setProperty property="id" name="dto"/>
<jsp:setProperty property="password" name="dto" param="pw"/>
<jsp:setProperty property="name" name="dto"/>
<jsp:setProperty property="phone" name="dto"/>
<jsp:setProperty property="email" name="dto"/>
<jsp:setProperty property="regdate" name="dto"/>
<%-- <% 
MemberDAO dao = new MemberDAO();
MemberDTO user = dao.updateMember(dto);
request.setAttribute("user", user);
%> --%>
<jsp:useBean id="dao" class="dao.MemberDAO"/>
<%  MemberDTO user = dao.updateMember(dto); 
	request.setAttribute("user", user);
%>

<jsp:forward page="updatesuccess.jsp"></jsp:forward>
</body>
</html>