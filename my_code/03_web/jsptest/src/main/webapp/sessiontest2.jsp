<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
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

MemberDTO member =null;
if(session.getAttribute("member")!=null){
	member = (MemberDTO) session.getAttribute("member"); 
	//session.removeAttribute("member");
}
//dto 에 저장된 정보는 브라우저 실행 같은 서버 같은 컨텍스트 모든파일에서 사용가능 
%>
<%if(member != null){ %>
<h1><%="세션정보를 조회합니다." %></h1>
<table border=1>
	<tr><td>아이디</td><td><%=member.getId() %></td></tr>
	<tr><td>이름</td><td><%=member.getName() %></td></tr>
	<tr><td>폰</td><td><%=member.getPhone() %></td></tr>
	<tr><td>이메일</td><td><%=member.getEmail() %></td></tr>
	<tr><td>가입일</td><td><%=member.getRegdate() %></td></tr>
</table>
<%}else{%>
	<h1>조회할 정보가 없습니다.</h1>
<%} %>

</body>
</html>