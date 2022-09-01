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
	
	$('#cancelbtn').on('click',function(e){
		$('#id').val("");
		$('#password').val("");
		
	});
	
	
	$('#loginbtn').on("click", function(event){
		alert("zmfflr");
		 event.preventDefault(); // form 안에 버튼 들어가있으면 submit동작을 하기때문에 취소해라.
		
			$.ajax({
				type:'post' , 
				data : {'id':$("#id").val(), 'password':$("#password").val()},
				url : 'backendlogin',
				dataType : 'json',
				success : function(response){ //{"result":"..."}
		 			alert(response.result);
	
				}
			}); //ajax	
	 });//on
	 

	 
});
</script>
<style>
#loginform{
	text-align:center;
}
#loginform table{
	margin: 0 auto;
}
#loginform tr td{
	padding: 10px 10px 10px  10px;
}

</style>
</head>
<body>
<div id="loginform">
<h1>로그인</h1>
<hr>
<form id="loginform" action="/login">
<table>
	<tr><td>아이디</td><td><input type=text name="id" id="id"></td></tr>
	<tr><td>비밀번호</td><td><input type=password name="password" id="password"></td></tr>
	<tr><td></td><td><input id="loginbtn" type=button value="로그인">&nbsp;&nbsp; <input type=button  id="cancelbtn" value="취소"></td></tr>
</table>
</form>
</div>

</body>
</html>