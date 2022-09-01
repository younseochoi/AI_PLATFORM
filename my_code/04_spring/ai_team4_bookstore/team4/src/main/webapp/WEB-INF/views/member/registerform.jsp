<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="resources/js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){

});
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
		width:800px;
		min-height:400px;
		border-radius:10px;
		background-color:white;
	}
	#login_header{
		position:relative;
		height :50px;
		padding:30px 0 30px 0;
		font-weight: 700;
		font-size: 30px;
		/* border:1px solid black; */
	}
	
	#login_item table{
		position:relative;
		margin : 0 auto;
		text-align: center;
		height:400px;
		/* border: 2px solid black; */
		background-color:white;
		border-radius:10px;
		border-collapse: collapse;
	}
	
	#login_item_table th, #login_item_table td{
		margin:0;
		width:300px;
	}
	#login_item_table input[type=text]{
		width:250px;
		height: 25px;
		border-radius:5px;
	}
	#login_item_table input[type=password]{
		width:250px;
		height: 25px;
		border-radius:5px;
	}
	#login_item_table input[type=button]{
		margin: 10px;
		width:300px;
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
	#login_item_table tr .login_table_header{
		text-align:left;
		width:150px;
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
<!-- 
- 아이디
- 비밀번호
- 이름
- 이메일
- 주소
- 폰번호
- 입력받아 members 테이블에 저장
- 아이디 이메일 중복확인할 것 -->
<jsp:include page="../nav.jsp"> <jsp:param value="false" name="login"/></jsp:include>
<div id="login_container">
	<form name="form" action="register" method="post">
		<div id="login_item">
			<div id="login_header">회원가입</div>
			<table id="login_item_table">
				<tr><td class="login_table_header">아이디</td><td><input type=text name="id" placeholder="아이디를 입력하세요"></td></tr>
				<tr><td class="login_table_header">비밀번호</td><td><input type=password name="pw" placeholder="비밀번호를 입력하세요"></td></tr>
				<tr><td class="login_table_header">이름</td><td><input type=text name="name" placeholder="이름을 입력하세요"></td></tr>
				<tr><td class="login_table_header">이메일</td><td><input type=text name="email" placeholder="이메일을 입력하세요"></td></tr>
				<tr><td class="login_table_header">주소</td><td><input type=text name="address" placeholder="주소를 입력하세요"></td></tr>
				<tr><td class="login_table_header">휴대폰</td><td><input type=text name="phone" placeholder="전화번호를 -없이 입력하세요 "></td></tr>
				<tr style="margin-top: 20px;"><td colspan="2" style="text-align:center;"><input type="button" value="회원가입" onclick="check();"></td></tr>
			</table>
		</div>
	</form> 
</div>



<script>
function check(){
	var fm = document.form;
	
	if(fm.id.value == ""){
		alert("아이디를 입력하세요");
		document.form.id.focus();
		return;
	}
	if(fm.pw.value == ""){
		alert("비밀번호를 입력하세요");
		document.form.pw.focus();
		return;
	}
	if(fm.name.value == ""){
		alert("이름을 입력하세요");
		document.form.name.focus();
		return;
	}
	if(fm.phone.value == ""){
		alert("전화번호를 입력하세요 ('-'는 제외)");
		document.form.phone.focus();
		return;
	}
	if(fm.email.value == ""){
		alert("이메일을 입력하세요");
		document.form.email.focus();
		return;
	}
	if(fm.address.value == ""){
		alert("주소를 입력하세요");
		document.form.address.focus();
		return;
	}
	alert("성공적으로 가입되셨습니다.")
	$("form").submit();
	}
</script>	
</body>
</html>