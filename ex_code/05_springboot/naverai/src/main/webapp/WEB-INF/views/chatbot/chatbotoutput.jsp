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
$(document).ready(function() {
	var json = JSON.parse('${response }');
	$("#text").html(json.bubbles[0].data.description);
});//ready end
</script>
</head>
<body>
<h3>${response }</h3>
<h3 id=text>  </h3>
</body>
</html>