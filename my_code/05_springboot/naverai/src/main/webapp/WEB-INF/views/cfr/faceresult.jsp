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
	var obj = '${result}'; //내부규격 json 규격
	//js 내부 객체 <---String 함수 존재 
	var json = JSON.parse(obj);
	$("div").html("사람수는"+json.info.faceCount);
	
	//참고객체 -->String
		/* var str-JSON.stringify({"a":"aas"}); */
		
		for(var i =0;i<json.info.faceCount;i++){
			if(json.faces[i].celebrity.confidence >= 0.5){
			$('h1').append(json.faces[i].celebrity.value +" ");
			$('h1').append((parseInt)(json.faces[i].celebrity.confidence*100)+"%<br>");
			}
		}
});//ready end
</script>
</head>
<body>
<%-- <h1>${result }</h1> --%>
<h1></h1>
<div></div>
</body>
</html>