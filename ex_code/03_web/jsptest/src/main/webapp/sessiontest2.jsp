<%@page import="dto.MemberDTO"%>
<%@ page 
contentType="text/html; charset=UTF-8"
session="true"
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">I
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<%  


// dto 정보는 현재파일에서만 사용 가능
MemberDTO member = null;
if(session.getAttribute("member") != null){
	member = (MemberDTO)session.getAttribute("member"); 
	//session.removeAttribute("member");
	//dto 정보는 동일 브라우저 실행 같은 서버 같은 컨텍스트 모든 파일에서 사용 가능
}
%>
<%if(member != null){ %>
	<h1><%="세션 정보를 조회합니다" %></h1>
	<table border=3>
	<tr><td> 아이디 </td><td><%=member.getId()%></td></tr>
	<tr><td> 이름 </td><td><%=member.getName()%></td></tr>
	<tr><td> 폰 </td><td><%=member.getPhone()%></td></tr>
	<tr><td> 이메일 </td><td><%=member.getEmail()%></td></tr>
	<tr><td> 가입일 </td><td><%=member.getRegdate()%></td></tr>
	</table>
<%} else {%>
	<h1><%="조회할 정보가 없습니다" %></h1>
<%} %>	
</body>
</html>





