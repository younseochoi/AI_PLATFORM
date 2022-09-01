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
<h1> ${param.page }책 리스트 </h1>

<c:forEach items="${product_list }" var="product">
${product }  <hr> <!-- 전체product(어노테이션 해둔것) 가져와라 -->
</c:forEach>

<% 
int totalcount = (Integer)request.getAttribute("totalcount"); 
int totalpage = 0;
if(totalcount % 3 == 0){
	totalpage = totalcount / 3;
}
else{
	totalpage = totalcount / 3 + 1;
}
for(int i = 1; i <=totalpage ; i++){
%>
<a href="bookpaginglist?page=<%=i%>"> <%=i %>페이지 </a>
<%} %>
</body>
</html>





