<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
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


${true} <br>
${3.14}<br>
${100}<br>
${"하윙"}<br>
${'헬로우'}<br>
${null}<br>
${"일일일일일일"}<br>

<br>
${100+100 }<br>
${'100'+100 }<br>

<%-- ${'백'+1} --> error --%>
${'백'+=1} -->백1 <br>
${null+1} --> ?<br>
${10/3}<br>
${10%3}<br>

\${empty 0}의 결과는 ${empty 0}
${empty null?"null입니다.":"null 아닙니다."}<br>
<%-- 안녕하세유 --%>
</body>
</html>