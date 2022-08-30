<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>team4-bookstore</title>
<script src="resources/js/jquery-3.6.0.min.js"></script>
<link href="resources/css/product/simplesearchresult.css" rel="stylesheet">
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<!-- 상단바  -->
<jsp:include page="../nav.jsp"> <jsp:param value="false" name="login"/></jsp:include>
<main class="main">
      
         <section class="section1">
         	<div class="left">
         		<div class="category_list">
         		
         			<div class="list1 text1">국내도서</div>
         			<div class="list1"><a href="">소설</a></div>	
         			<div class="list1"><a href="">시</a></div>
         			<div class="list1"><a href="">인문학</a></div>
         			<div class="list1"><a href="">과학</a></div>
         			<div class="list1"><a href="">IT</a></div>
         		</div>
         		<hr>
         		<div class="category_list">
         			<div class="list1 text1">해외도서</div>
         			<div class="list1"><a href="">소설</a></div>	
         			<div class="list1"><a href="">시</a></div>
         			<div class="list1"><a href="">인문학</a></div>
         			<div class="list1"><a href="">과학</a></div>
         			<div class="list1"><a href="">IT</a></div>
         		</div>
         	</div>
         	<div class="right">
         		<div class="menu1">
         			<div class="top">
         				<div class="title">검색결과</div>
         				<%-- <div class="btn"><input type="button" id ="month_btn_l" value='<'>&nbsp;<input type="button" id ="month_btn_r" value='>'></div>
         			--%></div> 
         			<div class="bottom1" id="month_box">
         				<c:forEach items="${search_result }" var="book" varStatus="b">
         					<c:set var="img_path" value="resources/images/novel/"/>
         					<c:set var="img_src" value="${img_path }${book.image }"/>
         					<div class="item">
         						<img src="${img_src }">
         						<div class="description">
		         					<div class="book_name"><a href="productdetail/${book.book_id}">${book.title }</a></div>
		         					<div class="writer">${book.writer }</div>
         						</div>
         					</div>
						</c:forEach>
         			</div>
         		</div>
         	</div>
        </section>
    </main>
    
    <footer class="footer">
    </footer>

</body>
</html>