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
<jsp:useBean id="dto" class="dto.MemberDTO" />
<jsp:setProperty property="id" name="dto" value="newid" /> 
<jsp:setProperty property="password" name="dto" value="1111"/>
<jsp:setProperty property="name" name="dto" value="newname" />
<jsp:setProperty property="phone" name="dto" value="newphone"  />
<jsp:setProperty property="email" name="dto"  value="newemail" />
<jsp:setProperty property="regdate" name="dto" value="2022-08-11" />

<H1> 회원정보를 생성 완료했습니다. 확인해 볼까요?(액션태그)</H1>
<h3>아이디:<jsp:getProperty property="id" name="dto"/> </h3>
<h3>암호:<jsp:getProperty property="password" name="dto"/> </h3>
<h3>이름:<jsp:getProperty property="name" name="dto"/> </h3>
<h3>폰:<jsp:getProperty property="phone" name="dto"/> </h3>
<h3>이메일:<jsp:getProperty property="email" name="dto"/> </h3>
<h3>가입일:<jsp:getProperty property="regdate" name="dto"/> </h3>

<hr>
<H1> 회원정보를 생성 완료했습니다. 확인해 볼까요?(el)</H1>
<h3>아이디:${dto.id } </h3>
<h3>암호: ${dto.password }</h3> 
<h3>이름: ${dto.name }</h3>
<h3>폰: ${dto.phone }</h3>
<h3>이메일: ${dto.email }</h3>
<h3>가입일:${dto.regdate } </h3>

<%=dto.getId() %>
</body>
</html>




