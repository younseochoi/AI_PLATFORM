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
	document.getElementById("myaudio").play();
});//ready end
</script>
</head>
<body>
<h3>Q. ${param.question}</h3>
<h3>A. ${textresult }</h3>
<audio id="myaudio" src="/naverai/${voiceresult }" controls="controls"></audio>
</body>
</html>