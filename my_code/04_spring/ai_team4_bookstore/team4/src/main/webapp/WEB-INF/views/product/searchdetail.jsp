<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.min.js" ></script>
<script>
$(document).ready(function() {

});
</script>

</head>
<body>
<h1 align="center"> 상세 검색 </h1>

<p align="center">
	제목 &nbsp;&nbsp;&nbsp;<input type=text name="title"><br>
	저자 &nbsp;&nbsp;&nbsp;<input type=text name="writer"><br>
	출판사 <input type=text name="publisher"><hr>
</p>

<p align="center">
	<input type=submit value="검색">
	<a href="searchmain"><input type=button value="처음으로"></a>
</p>

<hr>

<h1> 다음과 같이 검색해 주세요 </h1>

<form action="searchdetail" >
<select name="item"> 
<option value="제목"> 제목 검색</option>
<option value="저자"> 저자 검색</option>
<option> 출판사 검색</option>
</select>
검색어입력:<input type=text name="searchword">
<input type=submit value="검색요청" >
</form>
<h1>전체 책 정보를 가져옵니다. </h1>
<c:forEach items="${booklist }" var="dto">
<h3> ${dto }</h3>
 </c:forEach>

 
</body>
</html>

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
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

});
</script>
</head>
<body>

</body>
</html> --%>