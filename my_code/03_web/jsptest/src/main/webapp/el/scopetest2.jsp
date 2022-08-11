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

<%=pageContext.getAttribute("a") %><br>
<%= request.getAttribute("a") %><br>
<%=session.getAttribute("a") %><br>
<%=application.getAttribute("a") %><br>
<hr>
1. pageScope에서 찾는다 2. requestScope에서 찾는다. 3. sessionScope에서 찾는다. 4. applicationScope에서 찾는다.
4번까지 못찾으면 공백처리<br>

현재 페이지에서 전달=  ${a } <br>
이동전 페이지에서 전달=  ${requestScope.a } <br>
세션에서 전달=  ${sessionScope.a } <br>
어플리케이션에서 전달=  ${applicationScope.a } <br>
</body>
</html>