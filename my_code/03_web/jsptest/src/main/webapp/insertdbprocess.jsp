<%@page import="dao.MemberDAO"%>
<%@page import="dto.MemberDTO"%>
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
<%
if(request.getMethod().equalsIgnoreCase("post")){
	
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
String pw = request.getParameter("pw");//컬럼변수 password
String name = request.getParameter("name");
String phone = request.getParameter("phone");
String email = request.getParameter("email");
//
MemberDTO dto = new MemberDTO();
dto.setId(id);
dto.setPassword(Integer.parseInt(pw));
dto.setName(name);
dto.setPhone(phone);
dto.setEmail(email);
MemberDAO dao = new MemberDAO();
//member 테이블 같은 id 레코드 여러개 생기는 이유 - pk 제약조건 설정x
//id 기존 member 다른 레코드 중복 검사
int condition = dao.selectMember(id, pw);// 1(id o pw x), 2(id, pw o), 3(id x)
if(condition == 3) {
	int rows = dao.insertMember(dto);
	if(rows == 1) {%>
		<h1>정상적으로 회원가입되셨습니다. <a href=logindb.jsp> 로그인하러 가기</a></h1>
	<% } 
}else {%>
	<h1>아이디는 중복되었습니다. <a href=insertdb.jsp> 다시 가입하러 가기</a></h1>
<%}
}//post 
else if(request.getMethod().equalsIgnoreCase("get")){
%> <h1>get 방식은 지원하지 않습니다.</h1>	
<% 
}
%>
</body>
</html>