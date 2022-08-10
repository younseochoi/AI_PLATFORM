<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
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

<H1>=====오류발생파일명 =====</h1>
<%=request.getRequestURI()%>

<H1>=====toString 내용 =====</h1>
<%=exception.toString()%>
<H1>=====getMessage 내용 =====</h1>
<%=exception.getMessage() %>
<H1>=====printStackTrace(서버콘솔)=====</h1>
<% exception.printStackTrace(); %>
</body>
</html>








