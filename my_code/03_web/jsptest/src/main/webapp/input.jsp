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
<form action="output.jsp" method="get">
	시작단 : <input type=text name=start placeholder="2~9단 가능합니다.">
	종료단 : <input type=text name=end placeholder="2~9단 가능합니다.">
	<input type=submit value="구구단 출력">
</form>
</body>
</html>