<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<style>
body{
		background-color: rgb(240,240,240);
		margin : 0 auto ;
	}
	#modify_container{
		position:relative;
		display: flex;
		flex-flow: column; 
		height: 500px;
		width:100%;
		margin: 0 auto;
		justify-content: center;
		align-items:center;		
		
	}
	#modify_item{
		margin-top: 50px;
		width:400px;
		height:400px;
		border-radius:10px;
		background-color:white;
	}
	#modify_header{
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
<div id=modify_container>
	<div id="modify_item">
		<form action="memberModify" name="modifyForm" method="POST">
			<div id="modify_header">회원정보 수정</div>
			<hr>
			<table>
					<tr>
						<td>아이디</td><td><input type="text" value="${modify.id }" id="id" name="id" readonly="readonly"></td>
					</tr>
					<tr>
						<td>비밀번호</td><td><input type="password" id="pw" name="pw" ></td>	
					</tr>
					<tr>
						<td>이름</td><td><input type="text" value="${modify.name}" id="name" name="name" ></td>				
					</tr>
					<tr>
						<td>전화번호</td><td><input type="text" value="${modify.phone}" id="phone" name="phone" ></td>					
					</tr>
					<tr>
						<td>이메일</td><td><input type="text" value="${modify.email}" id="email" name="email" ></td>
					</tr>
					<tr>
						<td>주소</td><td><input type="text" value="${modify.address}" id="address" name="address" ></td>
					</tr>
					<tr><td><br></td></tr>
					<tr>
						<td>
							<input type="button" onclick="memberModify()" value="수정완료">
							<input type="button" onclick="back()" value="뒤로가기">
						</td>
					</tr>
			</table>				
		</form>
	</div>
</div>

<script>
	function back(){
		history.back();
	}
	function memberModify(){
		if($("#pw").val()==""){
			alert("비밀번호를 입력해주세요");
			$("#pw").focus();
			return false		
		}
		modifyForm.submit();
	}
</script>
</body>

</html>