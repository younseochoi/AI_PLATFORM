<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
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
<% 

MemberDTO dto = new MemberDTO();
dto.setId("id");
dto.setPassword(1111);
dto.setName("name");
dto.setPhone("01034551234");
dto.setEmail("email@gamil.com");
dto.setRegdate("2022-08-10");

//dto 에 저장된 정보는 현재 파일에서만 사용가능 

session.setAttribute("member",dto); 
//dto 에 저장된 정보는 브라우저 실행 같은 서버 같은 컨텍스트 모든파일에서 사용가능 
out.print("<h1>세션정보를 저장했습니다.</h1>");
%>
<h1><%="세션정보를 저장했습니다." %></h1>
</body>
</html>