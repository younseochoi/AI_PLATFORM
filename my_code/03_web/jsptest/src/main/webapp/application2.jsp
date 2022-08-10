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
<h1> 필요한 정보를 조회합니다.</h1>
전체 파일에서 사용할 메뉴는
<% String[] menu = (String []) application.getAttribute("menu"); 
	for(int i =0;i<menu.length;i++){
		%>
		 <%=menu[i]+ "  "%>
		<%
	}
%>

입니다.<br>
현재 로그인 한 사용자는  <%=session.getAttribute("id") %> 입니다.
</body>
</html>