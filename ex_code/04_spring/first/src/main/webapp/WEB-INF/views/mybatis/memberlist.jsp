<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.min.js" ></script>
<script>
$(document).ready(function(){

});
</script>
</head>
<body>
<h1> 다음과 같이 검색해 주세요 </h1>

<form action="membermybatissearchlist" >
<select name="item"> 
<option> 이름 검색</option>
<option> 이메일 검색</option>
<option> 폰번호 검색</option>
<option> 아이디 검색</option>
</select>
검색어입력:<input type=text name="searchword">
<input type=submit value="검색요청" >
</form>
<h1>전체 회원 정보를 가져옵니다. </h1>
<c:forEach items="${memberlist }" var="dto">
<h3> ${dto }</h3>
 </c:forEach>
</body>
</html>






