<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="resources/js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){

});
</script>
<script>
function check(){
		var fm = document.form;
		if(fm.id.value == ""){
			alert("아이디를 입력하세요");
			document.form.id.focus();
			return ;
		}
		if(fm.pw.value == ""){
			alert("비밀번호를 입력하세요");
			document.form.pw.focus();
			return ;
		}		
		$("form").submit();
		alert("환영합니다")
		}
</script>
<style>
	body{
		background-color: rgb(240,240,240);
		margin : 0 auto ;
	}
	#login_container{
		position:relative;
		display: flex;
		flex-flow: column; 
		height: 500px;
		width:100%;
		margin: 0 auto;
		justify-content: center;
		align-items:center;
		text-align:center
		
	}
	#login_item{
		text-align: center;
		margin-top: 50px;
		width:400px;
		height:400px;
		border-radius:10px;
		background-color:white;
	}
	#login_header{
		position:relative;
		padding:30px 0 10px 0;
		font-weight: 700;
		font-size: 30px;
	}
	
	#login_item table{
		margin : 0 auto;
		text-align: center;
		height:230px;
		/* border: 2px solid black; */
		background-color:white;
		border-radius:10px;
		border-collapse: collapse;
	}
	
	#login_item_table th, #login_item_table td{
		/* border: 1px solid black; */
		margin:0;
		width:300px;
	}
	#login_item_table input[type=text]{
		width:250px;
		height: 40px;
		border-radius:40px;
	}
	#login_item_table input[type=password]{
		width:250px;
		height: 40px;
		border-radius:40px;
	}
	#login_item_table input[type=submit]{
		margin: 10px;
		width:250px;
		height: 40px;
		border-radius:45px;
	}
	#in_login_item{
		/* border: 1px solid black; */
		padding-top: 20px; 
		margin:0 auto;
		text-align:center;
		font-size: 14px;
	}
	#in_login_item a{
		color:black;
		text-decoration: none;
	}
	#in_login_item a:hover{
		color:royalblue;
	}
</style>
</head>
<body>
<!-- 상단바  -->
<jsp:include page="../nav.jsp"> <jsp:param value="false" name="login"/></jsp:include>
<div id="login_container">
	<form action="login" method="post">
		<div id="login_item">
			<div id="login_header">로그인</div>
			<table id="login_item_table">
				<tr><td><input type=text name="id" placeholder=" 아이디를 입력하세요"></td></tr>
				<tr><td><input type=password name="password" placeholder=" 비밀번호를 입력하세요"></td></tr>
				<tr><td><input type="submit" value="로그인"></td></tr>
			</table>
			<div id="in_login_item">
				아직 회원이 아니신가요? &nbsp;&nbsp;
				<a href="registerform">회원가입 바로가기</a>
			</div>
		</div>
	</form> 
</div>	
</body>
</html>