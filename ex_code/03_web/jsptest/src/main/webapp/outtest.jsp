<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  buffer="8kb" autoFlush="true"
    isErrorPage="true"
    %>
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

자바문장실행결과+html태그 ---> 응답내용 모아서 서버내로 임시 저장- 예외발생 출력 변경하거나  취소 가능  --> 최종 1번 클라이언트 응답	

<h1>총버퍼크기=<%=out.getBufferSize() %></h1>
<h1>남은버퍼크기=<%=out.getRemaining() %></h1>
<%
String name = request.getParameter("name"); 
out.println(name);
out.flush();//이전 출력 내용 클라이언트 전송 - 버퍼 비워
%>

<h1>남은버퍼크기=<%=out.getRemaining() %></h1>

<%=exception %>


</body>
</html>