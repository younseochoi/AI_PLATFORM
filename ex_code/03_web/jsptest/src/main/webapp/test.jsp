<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page 
contentType="text/html; charset=UTF-8" 

%>
<!--  jsp를 서블릿 변환할 때 알려주는 내용  --> 	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>나는 jsp 파일입니다.</h1>
<% 
String type="servlet";
type = request.getParameter("type");
%>
<h1>나는 <%=type %> 파일입니다.</h1>
<% 
	Date now = new Date(); 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분 ss초입니다");
	String nowstring = sdf.format(now);
%>
<h1><%=nowstring%></h1>
</body>
</html>










