<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	$("#jangbagunibtn").on("click", function(){
		$.ajax({
			url : '${contextPath}/cart/cart', 
			data : {count:$("#count").val()},
			type : 'post',
			dataType: 'json',
			success : function(data){ 
			alert("장바구니로 이동합니다.");
			}//success
		})//ajax
		}
});
</script>
</head>
<body>


</body>
</html>