<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
$(document).ready(function(){

});

</script>
<style>
body{
		background-color: rgb(240,240,240);
		margin : 0 auto ;
	}

	#mypage_container{
		position:relative;
		display: flex;
		flex-flow: column; 
		height: 500px;
		width:100%;
		margin: 0 auto;
		justify-content: center;
		align-items:center;		
		
	}
	#mypage_item{		
		margin-top: 50px;
		width:400px;
		height:400px;
		border-radius:10px;
		background-color:white;
	}
	#mypage_header{
		text-align: center;
		position:relative;
		padding:30px 0 10px 0;
		font-weight: 700;
		font-size: 30px;
	}
</style>
</head>
<body>
<jsp:include page="../nav.jsp"> <jsp:param value="false" name="login"/></jsp:include>
<div id="mypage_container">
	<div id="mypage_item">
		<div id="mypage_header">내 정보</div>
		<hr>
			<table >
					<tr>
						<td>아이디</td><td>: ${mypage.id }</td>
					</tr>
					<tr>
						<td>이름</td><td>: ${mypage.name }</td>
					</tr>					
					<tr>
						<td>전화번호</td><td>: ${mypage.phone }</td>
					</tr>
					<tr>
						<td>이메일</td><td>: ${mypage.email }</td>
					</tr>
					<tr>
						<td>주소</td><td>: ${mypage.address }</td>
					</tr>
					<tr><td><br></td></tr>			
				<tr>				
					<td>
						<input type="button" onclick="location.href='modifyForm?id=${sessionid}'" value="수정하기">
						<input type="button" onclick="location.href='delete'" value="회원탈퇴">
						<input type="button" onclick="back()" value="뒤로">
					</td>
				</tr>			
			</table>			
		</div>
	</div>				
<script>
	function back(){
		history.back();
	}
</script>

</body>
</html>