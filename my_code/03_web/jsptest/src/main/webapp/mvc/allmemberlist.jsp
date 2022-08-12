<%@page import="dao.MemberDAO"%>
<%@page import="dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<style>
	h1{
		text-align: center;
	}
	table, td{
		margin : 0 auto;
		font-size: 14pt;
		padding : 5px 5px 5px 5px;
		border : 2px solid navy;
		text-align : center;
		border-collapse: collapse;
	}
	tr:nth-child(2n+1){
		background-color: rgb(230,230,230);
	}
	th{
		font-size: 14pt;
		padding : 5px 5px 5px 5px;
		background-color: rgb(120,150,240);
		color: white;
	}
</style>
</head>
<body>
<%-- <% ArrayList<MemberDTO> memberlist = (ArrayList<MemberDTO>)request.getAttribute("memberlist"); %> --%>

	<h1>가입 회원 명단</h1>
	<table border=1>
		<tr><th>아이디</th><th>이름</th><th>전화번호</th><th>이메일</th><th>가입날짜</th></tr>
	<c:forEach items="${memberlist }" var="dto">
		<tr><td>${dto.id }</td><td>${dto.name }</td>
			<td>${dto.phone }</td><td>${dto.email }></td>
			<td>${dto.regdate }</td>
		</tr>
		
	</c:forEach>	
	</table>
</body>
</html>