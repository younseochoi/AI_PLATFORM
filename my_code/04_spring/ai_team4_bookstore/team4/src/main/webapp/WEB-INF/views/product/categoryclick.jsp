<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js" ></script>
<script>
$(document).ready(function() {

});
</script>
<style>
#category_detail{
	padding:50px;
}
</style>
</head>
<body>
<!-- 상단바  -->
<jsp:include page="../nav.jsp"> <jsp:param value="false" name="login"/></jsp:include>
<div id="category_detail">
<h1>목록</h1><hr>
<c:forEach items="${booook }" var="books">
	<div><img src="resources/images/novel/${books.image }" width=90 height=120 align=left />&nbsp;
	제목 : <a href="productdetail?book_id=${books.book_id }">${books.title }	</a><BR>
	&nbsp;저자	: ${books.writer }	<br>
	&nbsp;출판사 : ${books.publisher }	<BR>
	&nbsp;내용 : ${books.summary }
	</div><br><br><hr>
</c:forEach>
</div>

</body>
</html>