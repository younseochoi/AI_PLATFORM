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
<h1>user.jsp 파일 입니다.</h1>
<h2>사용자용 메뉴</h2>
<%
String[] menu = (String[]) request.getAttribute("menu");
for(int i = 0 ;i <menu.length ; i++){
	out.println("<h3>"+menu[i]+"</h3>");
}
%>
</body>
</html>