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
<form action="memberdbinsert" method=post>  
아이디<input type=text name="id" value=""><br>
암호<input type=password name="password"><br>
이름<input type=text name="name"><br>
폰<input type=text name="phone" pattern="010[0-9]{4}[0-9]{4}"><br>
이메일<input type=email name="email"><br>
<input type=submit value="회원가입">
</form>
</body>
</html>