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
<%--
<% MemberDTO dto = new MemberDTO();
dto.setId("id");
dto.setPassword(1111);
dto.setName("name");
dto.setPhone("01011112222");
dto.setEmail("email@mul.com");
%>
<H1> 회원정보를 생성 완료했습니다. 확인해 볼까요?</H1>
<h3>아이디:<%=dto.getId() %></h3>
<h3>암호:<%=dto.getPassword() %></h3>
<h3>이름:<%=dto.getName() %></h3>
<h3>폰:<%=dto.getPhone() %></h3>
<h3>이메일:<%=dto.getEmail() %></h3>
 --%>


html-form 입력 name속성명  --> jsp  --> MemberDTO 변수명  저장 
<jsp:useBean id="dto" class="dto.MemberDTO" scope="session"/>
<%-- 
if(request.getAttribute("dto") != null){
MemberDTO dto = (MemberDTO)request.getAttribute("dto")
}
else{
MemberDTO dto = new MemberDTO();
}
--%>




<H1> 회원정보를 생성 완료했습니다. 확인해 볼까요?(BEANREQUEST2.JSP)</H1>
<h3>아이디:<jsp:getProperty property="id" name="dto"/> </h3>
<h3>암호:<jsp:getProperty property="password" name="dto"/> </h3>
<h3>이름:<jsp:getProperty property="name" name="dto"/> </h3>
<h3>폰:<jsp:getProperty property="phone" name="dto"/> </h3>
<h3>이메일:<jsp:getProperty property="email" name="dto"/> </h3>
<h3>가입일:<jsp:getProperty property="regdate" name="dto"/> </h3>

</body>
</html>





