<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작페이지</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
$("#write").on("click", function(ev){
	var sessionid =<%=session.getAttribute("sessionid")%>
	if(sessionid ==null){
		alert("로그인하셔야 합니다.");
		ev.preventDefault();
	}
});
});
</script>
</head>
<body>
<h1>나의 게시판 시작화면 입니다.</h1>
<h1>메뉴</h1>
<h3>
	<ol>
		<li><a href="boardlist">게시물 리스트 보기(로그인 하지 않으셔도 됩니다.)</a></li>
		<li><a id ="write" href="boardwrite">글쓰기(로그인하셔야 가능합니다.)</a></li>
		<li><a href="boardlogin">로그인하기</a></li>
		<li><a href="boardlogout">로그아웃하기</a></li>
	</ol>
</h3>
<%=session.getAttribute("sessionid") %>
${sessionid }
</body>
</html>