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
<% 
MemberDTO dto = new MemberDTO();
dto.setId("id");
dto.setPassword(1111);
dto.setName("name");
dto.setEmail("test@test.com");
dto.setPhone("010-2421-5153");

%>
<h1>회원정보를 생성완료 했습니다. 확인해볼까요?</h1>
<h3>아이디 : <%=dto.getId() %></h3>
<h3>암호 : <%=dto.getPassword() %></h3>
<h3>이름 : <%=dto.getName() %></h3>
<h3>폰 : <%=dto.getPhone() %></h3>
<h3>이메일 : <%=dto.getEmail() %></h3>
--%>
 <%-- html input 태그  name과 dto의 변수 이름이 같을 때 param 생략 --%>
<jsp:useBean id="dto" class="dto.MemberDTO" scope="session"/>
<%-- <jsp:setProperty property="id" name="dto" value="<%=request.getParameter(\"id\") %>"/> --%>
<%-- <jsp:setProperty property="id" name="dto" param="id"/> --%>
<%-- <jsp:setProperty property="id" name="dto"/>
<jsp:setProperty property="password" name="dto"/>
<jsp:setProperty property="name" name="dto" />
<jsp:setProperty property="phone" name="dto"/>
<jsp:setProperty property="email" name="dto" />
<jsp:setProperty property="regdate" name="dto"/> --%>

<h1>회원정보를 생성완료 했습니다. 확인해볼까요?(beanrequest2.jsp)</h1>
<h3>아이디 :<jsp:getProperty property="id" name="dto"/> </h3>
<h3>암호 :<jsp:getProperty property="password" name="dto"/></h3>
<h3>이름 :<jsp:getProperty property="name" name="dto"/></h3>
<h3>폰 : <jsp:getProperty property="phone" name="dto"/></h3>
<h3>이메일 :<jsp:getProperty property="email" name="dto"/></h3>
<h3>가입일 :<jsp:getProperty property="regdate" name="dto"/></h3>
</body>
</html>