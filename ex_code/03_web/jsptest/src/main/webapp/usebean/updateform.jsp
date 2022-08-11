<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<% SimpleDateFormat sdf = new SimpleDateFormat("yyyy년도MM월dd일");
String regdate = sdf.format(new Date());
%>
<body>
<h1> 회원정보 수정폼입니다(이름, 폰, 이메일 수정 가능합니다)</h1>
<form action="updateprocess.jsp" >
아이디:<input type=text name="id" value='<%=request.getParameter("id") %>' readonly><br>
암호:<input type=password name="password" value='<%=request.getParameter("pw") %>' readonly><br>
이름:<input type=text name="name" ><br>
폰:<input type=tel name="phonenumber" ><br>
이메일:<input type=tel name="email" ><br>
회원가입(수정)일:<input type="date" name="regdate" >
<input type=submit value="회원정보수정">
</form>
</body>
</html>