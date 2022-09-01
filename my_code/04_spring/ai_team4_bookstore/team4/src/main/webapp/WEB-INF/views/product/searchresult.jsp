<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.min.js" ></script>
<link href="resources/css/product/simplesearchresult.css" rel="stylesheet">
<script>
$(document).ready(function(){

});
</script>
<style>
#searchresult_contents{
	position : relative;
	display: flex;
	flex-flow: column;
	justify-content: center;
	align-items:center;
	border: 1px solid black;
	margin: 0 auto;
}
#detail_search{
	padding: 20px;
}
</style>
</head>
<body>
<!-- 상단바  -->
<jsp:include page="../nav.jsp"> <jsp:param value="false" name="login"/></jsp:include>
<main class="main">
      
         <section class="section1">
         	<div class="left">
         		<div class="category_list">
         		
         			<div class="list1 text1">국내도서</div>
         			<div class="list1"><a href="booklist?category_id=3">소설</a></div>	
         			<div class="list1"><a href="booklist?category_id=4">시</a></div>
         			<div class="list1"><a href="booklist?category_id=5">인문학</a></div>
         			<div class="list1"><a href="booklist?category_id=2">과학</a></div>
         			<div class="list1"><a href="booklist?category_id=1">IT</a></div>
         		</div>
         		<hr>
         		<div class="category_list">
         			<div class="list1 text1">해외도서</div>
         			<div class="list1"><a href="booklist?category_id=8">소설</a></div>	
         			<div class="list1"><a href="booklist?category_id=9">시</a></div>
         			<div class="list1"><a href="booklist?category_id=10">인문학</a></div>
         			<div class="list1"><a href="booklist?category_id=7">과학</a></div>
         			<div class="list1"><a href="booklist?category_id=6">IT</a></div>
         		</div>
         	</div>
         	
         	
         	<div class="right">
         	<div id="detail_search">
         	<h1> 다음과 같이 검색해 주세요 </h1>
			<form action="productsearchlistresult" >
			카테고리선택:<select name="category_id">
			<option value="1">국내it</option>
			<option value="2">국내과학</option>
			<option value="3">국내소설</option>
			<option value="4">국내시</option>
			<option value="5">국내인문학</option>
			<option value="6">해외it</option>
			<option value="7">해외과학</option>
			<option value="8">해외소설</option>
			<option value="9">해외시</option>
			<option value="10">해외인문학</option>
			</select><br>
			키워드선택:<select name="item"> 
			<option> 제목 검색</option>
			<option> 지은이 검색</option>
			<option> 출판사 검색</option>
			<option> 가격 검색</option>
			</select>
			검색어입력:<input type=text name="searchword">
			<input type=submit value="검색요청" >
			</form>
         	</div>
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

<%-- <!-- 상단바  -->
<jsp:include page="../nav.jsp"/>
<div id="searchresult_contents">
<h1> 다음과 같이 검색해 주세요 </h1>
<form action="productsearchlistresult" >
카테고리선택:<select name="category_id">
<option value="1">국내it</option>
<option value="2">국내과학</option>
<option value="3">국내소설</option>
<option value="4">국내시</option>
<option value="5">국내인문학</option>
<option value="6">해외it</option>
<option value="7">해외과학</option>
<option value="8">해외소설</option>
<option value="9">해외시</option>
<option value="10">해외인문학</option>
</select><br>
키워드선택:<select name="item"> 
<option> 제목 검색</option>
<option> 지은이 검색</option>
<option> 출판사 검색</option>
<option> 가격 검색</option>
</select>
검색어입력:<input type=text name="searchword">
<input type=submit value="검색요청" >
</form>
 </div>
<h1> 검색 결과</h1>
<c:forEach items="${productlist }" var="dto">
<h3> ${dto }</h3>
 </c:forEach> --%>
</body>
</html>