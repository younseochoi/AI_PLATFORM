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
<form action="loginage.jsp" >
이름입력:<input type=text name=name ><br>
나이입력:<input type=text name=age pattern="[0-9]+"><br>
<input type=submit value=성인인증 ><br>
</form>
</body>
</html>