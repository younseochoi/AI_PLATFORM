<%@page import="springmvc.HelloDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://127.0.0.1:8080/nonspringmvc/js/jquery-3.6.0.min.js" ></script>
<script>
$(document).ready(function(){

});
</script>
</head>
<body>

<% HelloDTO dto = (HelloDTO)request.getAttribute("model"); %>
<h1>컨트롤러로부터 전달받은 모델 데이터(스크립트태그)</h1>
<h3><%=dto.getMessage() %></h3>
<hr>
<h1>컨트롤러로부터 전달받은 모델 데이터(el)</h1>
<h3>${model.message }</h3>
</body>
</html>






