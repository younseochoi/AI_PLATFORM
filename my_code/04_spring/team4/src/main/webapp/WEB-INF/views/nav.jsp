<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.min.js"></script>
<link href="resources/css/nav.css" rel="stylesheet">
<script>
$(document).ready(function(){
	$('#search_detail_btn').on('click',function(){
		location.href= 'productsearchlist';
	}); //search_detail_btn
});

</script>

</head>
<body>
 <header class="header">
        <nav class="nav">
            <div class="logo"><a href="/bookstore">T E A M 4</a></div>
            <div class="menu">
                <%
                String login = request.getParameter("login");
                if(login.equals("true")){%>
                    <div class="menu1"><a class="a1" href="/mypage">마이페이지</a></div>
                    <div class="menu1"><a class="a1" href="/cart">장바구니</a></div>
                    <div class="menu1"><a class="a1" href="/logout">로그아웃</a></div>
                    <%}else{%>
                 <!--        <div class="menu1"><a class="a1" href="/admin">회원가입</a></div> -->
                        <div class="menu1"><a class="a1" href="/register">회원가입</a></div>
                        <div class="menu1"><a class="a1" href="/loginform">로그인</a></div>
                 <%} %>
            </div>
        </nav>
    </header>
 <header class="header2">
        <nav class="nav2">
          <div class="logo"><img src="resources/images/logo.png" ></div>
            <div class="menu">
           
                <form action="search" method="get">
                <select id="search_select"  name="search_select">
                	<option value="title">제목</option>
                	<option value="writer">지은이</option>
                	<option value="publisher">출판사</option>
                </select>
                    <input type="text" placeholder="검색어 입력" name="keyword">
                    <button type="submit">검색</button>
                </form>
           			<button type="submit" id="search_detail_btn">상세검색</button>
            </div>
        </nav>
    </header>
</body>
</html>