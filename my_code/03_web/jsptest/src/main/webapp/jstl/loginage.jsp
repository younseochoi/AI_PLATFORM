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
</head>
<body>
<%-- <% request.setCharacterEncoding("utf-8"); %>
${param.name }
${param.age }
<c:if test="${empty param.age||empty param.name}">
	<h1>필요한 데이터를 입력하세요</h1>
</c:if>
<c:if test="${!empty param.age && !empty param.name}">
	<c:if test="${param.age>=20 }">
		<h1>${param.name }님, 성인인증 되셨습니다.</h1>
	</c:if>
	<c:if test="${param.age>=17 && param.age<20 }">
		<h1>${param.name }님, 고등학생입니다.</h1>
	</c:if>
	<c:if test="${param.age>=1&&param.age<17 }">
		<h1>${param.name }님, 미성년입니다.</h1>
	</c:if>
	<c:if test="${param.age<=0}">
		<h1>잘못된 나이입니다.</h1>
	</c:if>
</c:if> --%>
<!-- el jstl 사용위주
1. name, age 파라미터 입력받는다.
2. name, age 모두 입력되었다면 
	2-1. age>=20 xxx님 성인인증되셨습니다.
	2-2. age>=17 xxx님 고등학생입니다.
	2-3. age>=1 xxx님 미성년입니다.
	2-4. 나머지 잘못된 나이입니다.
3. 2번 외, 필요한 데이터를 입력하세요.	 -->


<c:if test="${!empty param.age && !empty param.name }">
<c:choose>
	<c:when test="${param.age>=20 }">
		<h1 style="color:blue";>성인입니다.</h1>
	</c:when>
	<c:when test="${param.age>=17 }">
		<h1 style="color:green";>고등학생입니다.</h1>
	</c:when>
	<c:when test="${param.age>=1 }">
		<h1 style="color:red";>중학생 이하입니다.</h1>
	</c:when>
	<c:otherwise>
		<h1 style="color:red";>잘못된 나이입니다.</h1>
	</c:otherwise>
</c:choose>
</c:if>
</body>
</html>