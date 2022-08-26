<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.min.js" ></script>
<script>
$(document).ready(function(){
$("#ajaxbtn").on("click", function(){
	//alert(this.value);
	//ajax 방식 요청
	$.ajax({
		url : 'loginajax', 
		data : {id:$("#id").val(),'password':$("#password").val()},
		type : 'post',
		////////////////서버로 요청 완료/////////////////
		///////////////서버로부터 응답 시작/////////////////
		dataType: 'json', //서버로부터 응답형태
		success : function(server){ //response = {"process": "정상로그인사용자"}
		//alert(server.process);
		$("#ajaxresult").html("<h3>"+server.process+"</h3>");
		if(server.process.indexOf("success") >= 0){
			$("#ajaxresult").css("color", 'green');
		}
		else if(server.process.indexOf("fail") >= 0){
			$("#ajaxresult").css("color", 'red');
		}
		}//success 
//자바스크립트+jquery(String = '',   "")   와 서버단 클래스(String - "" ) 동일명 메소드
// 문자열동등성비교 => '=='                   equals
// 문자열 포함 여부 =>  indexOf('success')>=0     contains/indexOf
	});//ajax
})//on
});//ready
</script>
</head>
<body>

<h1>로그인 폼</h1>
<!--  action+submit 버튼(form 입력값 자동 전달) : 동기적 ajax 구현 x(http ajax 지원x)  
-->
<form action="loginajax" method=post >
	아이디<input type=text name="id" id="id"><br>
	암호<input type=password name="password" id="password"><br>
	<input type="submit" value="로그인"><br>
</form>

<input id="ajaxbtn" type="button" value="ajax로그인"><br>

<div id="ajaxresult"> </div>

</body>
</html>








