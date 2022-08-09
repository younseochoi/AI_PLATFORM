<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.Date, java.text.SimpleDateFormat"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1>나는 jsp 파일입니다.</h1>
<% 
String type = "servlet"; 
type= request.getParameter("type") ;
%> 
<h1>나는 <%=type %> 파일입니다.</h1>
<% 
	Date now = new Date(); 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분 ss초") ;
	String nowString = sdf.format(now);
%>
<h1>현재시각 : <%=nowString %></h1>
<!-- <script>
$document.
</script> -->
</body>

</html>