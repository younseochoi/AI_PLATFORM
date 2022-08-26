<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	$('#ajaxbtn').on("click",function(){
		/* alert(this.value); */
		//ajax 요청
		$.ajax({
			url :'loginajax',
			data : {'id':$("#id").val(), 'password':$("#password").val()},
			type :'post',
			datatype :'json', /* 서버로 부터 받아오는거 json이야 */
			success: function(server){
				$("#ajaxresult").html("<h3>"+server.process+"</h3>");
				if(server.process.indexOf("success")>=0){
					$("#ajaxresult").css("color","green");
				}else if(server.process.indexOf("fail")>=0){
					$("#ajaxresult").css("color","red");
				}
				//alert(response.process);
			}
		}); //ajax
	});
});
</script>
</head>
<body>
<form action="loginajax" method="post">
아이디 : <input type=text name="id" id="id"> <br>
pw : <input type=password name="password" id="password"> <br>
<input type=submit value="로그인">
</form>
<input id="ajaxbtn" type=button value="ajax로그인">
<div id="ajaxresult"> 로그인 결과 출력</div>
</body>
</html>