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
	$("#order").on("click", function(){
		//alert('q');
		$.ajax({
			url : '${cart}', 
			data : {count:$("#count").val()},
			type : 'post',
			dataType: 'json',
			success : function(data){ 
			alert();
			}//success
		})//ajax
		})
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
		width: 80px;
		height: 50px;
	}
	#cart_delivery{
		margin: auto;
	}
	#order{
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
<tr><th>책 이미지</th><th>제목</th><th>가격</th><th>수량</th><th>합계</th><th>삭제</th></tr>
<c:forEach var="cart" items="${cart_list}">
<tr><td>test</td><td>${cart.title}</td><td>${cart.price}</td><td>${cart.count}</td><td>  ${cart.price * cart.count}  </td><td><input type=button value="삭제"></td></tr>

</c:forEach>
</table>



	</div>
	<div id= "cart_total">
		<table id="cart_total_table">
			<tr><th>총 상품수</th><th>총 상품금액</th><th>배송비</th><th>=</th><th>최종 금액</th></tr>
			<tr><td>${totalcount.get(0).totalcount }</td><td>${sumproduct.get(0).sumproduct }</td><td>${delivery }</td><td>=</td><td>${total.get(0).sumproduct + 3000}</td></tr>
			
		</table>
	</div>
	<div id= "cart_delivery">
	* 구매하시는 상품의 총 가격이 50,000원 이상일 경우 배송료는 무료이며,  그 미만은 3,000원 입니다.
	</div>
		
		
<div id="cart_btn">
		<input type="button" value="돌아가기" onclick="history.back(-1);"><button id="order" onclick="location.href='./order';">주문하기</button>
	</div>


</div>	
</body>
</html>