<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.min.js" ></script>
<script>
$(document).ready(function(){

});
</script>
</head>
<body>
<h1>${param.page } 페이지 회원 정보를 가져옵니다. </h1>

<c:forEach items="${memberlist }" var="dto">
<h3> ${dto }</h3>
 </c:forEach>

<%
int totalmember = (Integer)request.getAttribute("totalmember");
int totalpage = 0;
if(totalmember % 4 == 0){
	totalpage = totalmember / 4 ;
}
else{
	totalpage = totalmember / 4 + 1 ;
}
%>


 <h3>
 <% for(int i = 1; i <= totalpage; i++ ){ %>
 	<a href="membermybatispaginglist?page=<%=i%>"  ><%=i %></a>
 <%}%>
 </h3>
</body>
</html>






