<%@page import="dto.MemberDTO"%>
<%@ page 
contentType="text/html; charset=UTF-8"
session="true"
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">I
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
dto.setPhone("01011112222");
dto.setEmail("email@a.com");
dto.setRegdate("2022-08-10");

// dto 정보는 현재파일에서만 사용 가능

session.setAttribute("member", dto); 
//dto 정보는 동일 브라우저 실행 같은 서버 같은 컨텍스트 모든 파일에서 사용 가능
//out.println("<h1>세션 정보를 저장했습니다</h1>");
%>
<h1><%="세션 정보를 저장했습니다" %></h1>
</body>
</html>





