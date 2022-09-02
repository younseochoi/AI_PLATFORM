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
	var obj = '${result}'; //obj 변수 타입 String(내부데이터 json규격)
	//js 내부 객체<--String 함수 존재
	var json = JSON.parse(obj);
	$("h1").html("사람수 = " + json.info.faceCount +"<br>");
	//사람수만큼 유명인 이름 출력
	for(var i = 0; i < json.info.faceCount; i++){
		if(json.faces[i].celebrity.confidence >= 0.5){
		$("h1").append(json.faces[i].celebrity.value + "<br>");
		$("h1").append(parseInt(json.faces[i].celebrity.confidence  * 100 ) + "%<br>");
		}
	}
	
	//참고 객체--> String 변환 함수
	/*var str = JSON.stringify({"a":"aa"});
	str.a 접근 불가*/
	
});//ready end
</script>
</head>
<body>
<h3>${result }</h3>
<h1></h1>
</body>
</html>








