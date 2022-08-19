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
<h1> aa.jsp 실행결과입니다. </h1>
<c:if test="${empty model }">
	<h1> 전달받은 모델은 없습니다. </h1>
</c:if>
<c:if test="${!empty model }" >
	<h1> 전달받은 모델은 ${model} 입니다.</h1>
</c:if>
</body>
</html>







