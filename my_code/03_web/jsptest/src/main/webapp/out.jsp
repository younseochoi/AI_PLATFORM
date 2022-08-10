<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="8kb" autoFlush="true" isErrorPage="true"%>
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
자바문장 실행결과 + html태그 --> 응답 내용 모아서 서버내로 임시저장 -예외 발생 출력 변경하거나 취소가능 -->최종 1번 클라이언트 응답
out.print();
out.flush() ; //지금까지 해놓은거 당장 클라이언트로 응답 - 취소 불가능
예외 발생하면 print 

<h1>총 버퍼 크기 : <%= out.getBufferSize() %></h1>
<h1>남은 버퍼 크기 : <%= out.getRemaining() %></h1>
<%
String name = request.getParameter("name");
out.println(name);
out.flush(); //이전에 출력 내용 클라이언트 전송 - 버퍼 비워
%>
<h1>남은 버퍼 크기 : <%= out.getRemaining() %></h1>
<%=exception %>
</body>
</html>