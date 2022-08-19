<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){

});
</script>
</head>
<body>
<h1> ${param.id } 회원님 ${param.age }살입니다.</h1>
<h1>${model }</h1>
<h1> 취미는
<c:forEach items="${paramValues.hobby }" var="hb">
${hb }
</c:forEach> 
입니다.</h1>
<hr>
<h1> ${dto.id } 회원님 ${dto.age }살입니다.</h1>
<h1>${model }</h1>
<h1> 취미는
<c:forEach items="${dto.hobby }" var="hb">
${hb }
</c:forEach> 
입니다.</h1>

</body>
</html>