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
<!--el과 jstl 사용 위주
1. name, age 파라미터 입력받는다
2. name, age 모두 입력되었다면
   2-1. age >= 20  xxxx 님 성인인증되셨습니다 출력
   2-2. age >= 17 && age <= 19 xxx님 고등학생입니다 출력
   2-3. age >= 1 xxx님 미성년입니다 출력
   2-4. 나머지 잘못된 나이입니다 출력
3. 2번 외인 경우 필요한 데이터를 입력해 주세요 출력
-->
<c:set var="isName" value="${empty param.name }" />
<c:set var="isAge" value="${empty param.age }" />

<c:if test="${isName || isAge }">
	<h1>필요한 데이터를 입력해 주세요</h1>
</c:if>

<%-- <c:if test="${!isName && !isAge }">
	<c:if test="${param.age >= 20}">
		<h1>${param.name } 님 성인인증되셨습니다.</h1>
	</c:if>
	<c:if test="${param.age >= 17 && param.age <= 19}">
		<h1>${param.name } 님 고등학생입니다. </h1>
	</c:if>
	<c:if test="${param.age >= 1 && param.age <= 16 }">
		<h1>${param.name } 님 중학생이하입니다. </h1>
	</c:if>
	<c:if test="${param.age <=0 }">
		<h1> 잘못된 나이입니다  </h1>
	</c:if>	
</c:if>  --%>

<c:if test="${!isName && !isAge }">
	<c:choose>
		<c:when test="${param.age >= 20}">
			<h1 style="color:blue">${param.name } 님 성인인증되셨습니다.</h1>
		</c:when>
		<c:when test="${param.age >= 17}">
			<h1 style="color:green">${param.name } 님 고등학생입니다.</h1>
		</c:when>
		<c:when test="${param.age >= 1 }">
			<h1 style="color:red">${param.name } 님 중학생이합니다. 사용 불가능합니다.</h1>
		</c:when>
		<c:otherwise>
		<h1 style="color:red"> 잘못된 나이입니다  </h1>
		</c:otherwise>
	</c:choose>
</c:if>
     
</body>
</html>




