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
<!-- 1>6개폼 입력값 가져오기
2>MemberDTO 객체로 생성하기
<useBean setProperty, getProperty
3> MemberDAO 클래스 updateMember() 호출하여 리턴 MemberDTO 객체
4> updatesuccess.jsp 이동하면서 전달
 -->
<jsp:useBean id="member" class="dto.MemberDTO"  />
<jsp:setProperty property="id" name="member"/>
<jsp:setProperty property="password" name="member"/>
<jsp:setProperty property="name" name="member"/>
<jsp:setProperty property="phone" name="member" param="phonenumber"/>
<jsp:setProperty property="email" name="member"/>
<jsp:setProperty property="regdate" name="member"/>

<jsp:useBean id="dao" class="dao.MemberDAO" />
<% MemberDTO returnDto = dao.updateMember(member); 
request.setAttribute("returnDto", returnDto);
%>
<jsp:forward page="updatesuccess.jsp" />
</body>
</html>




