<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
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
	#cart_container{
		background-color: rgb(240,240,240);
		min-height: 90vh;
		border :1px solid black;
		position:relative;
		display: flex;
		flex-flow: column; 
		margin: 0 auto;
		
	}
	#cart_list{
		text-align: center;
		margin-top: 50px;
	}
	#cart_total{
		text-align: center;
		margin-top: 50px;
	}
	#cart_btn{
		text-align: center;
		margin-top: 50px;
	}
	#cart_list table, #cart_total table{
		margin : 0 auto;
		text-align: center;
		border: 2px solid black;
		background-color:white;
		border-collapse: collapse;
	}
	#cart_total_table th,#cart_total_table td{
		width:100px;
		border: 1px solid black;
		padding: 15px ;
	}
	#cart_list_table th, #cart_list_table td{
		border: 1px solid black;
		padding: 8px ;
	}
	#cart_btn input[type=button]{
		margin: 10px;
		width:80px;
		height: 50px;
	}
</style>
</head>
<body>
<!-- 상단바  -->
<jsp:include page="../nav.jsp"> <jsp:param value="false" name="login"/></jsp:include>
<div class="cart_container">
	<div id="cart_list">
		<table id="cart_list_table">
			<tr><th>책 이미지</th><th>책 제목</th><th>가격</th><th>수량</th><th>합계</th><th>삭제</th></tr>
			<tr><td>test</td><td>test</td><td>price</td><td>quantity</td><td>total</td><td><input type=button value="삭제"></td></tr>
			
		</table>
	</div>
	<div id= "cart_total">
		<table id="cart_total_table">
			<tr><th>총 상품수</th><th>총 상품금액</th><th>총 배송비</th><th>=</th><th>최종 금액</th></tr>
			<tr><td>test</td><td>test</td><td>price</td><td>=</td><td>total</td></tr>
			
		</table>
	</div>
	
	<div id="cart_btn">
		<input type="button" value="돌아가기"><input type="button" value="주문하기">
	</div>
</div>	
</body>
</html>