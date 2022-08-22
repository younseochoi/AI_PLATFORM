<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="membermybatisupdate" method="post" >
	 아이디:<input type=text name=id value="${param.id}" readonly="readonly"><br>
	 이름입력:<input type=text name=name ><br>
	 주소입력:<input type=text name=address ><br>
	 <input type=submit value=정보수정  ><br>
</form>
</body>
</html>