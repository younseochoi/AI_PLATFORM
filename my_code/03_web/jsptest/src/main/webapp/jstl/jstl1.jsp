<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<%String id2="jsp"; %>
<c:set var="id" value="jstl"/>
<c:set var="pw" value="1111"/>
<c:set var="id22" value="<%=id2 %>"/>
<c:set var="result" value="${pw+200 }"/>
<h1>${id }</h1>
<h1>${pw }</h1>
<h1>${id22 }</h1>
<h1>${result }</h1>
<h1>요청 ip : <%=request.getRemoteAddr() %></h1>
<h1>요청 파일 : <%=request.getRequestURL() %></h1>
<h1>요청 파일 : <%=request.getRequestURI() %></h1>

<c:set var="clientip" value="${pageContext.request.remoteAddr }"/>
<c:set var="clientfile" value="${pageContext.request.requestURL }"/>
<h1>요청 ip : ${clientip}</h1>
<h1>요청 파일 :${clientfile}</h1>
<h1>요청 파일 : ${pageContext.request.requestURI }</h1>


<c:remove var="clientip"/>
<c:remove var="clientfile"/>
<h1>요청 ip : ${clientip}</h1>
<h1>요청 파일 :${clientfile}</h1>
<hr>
<!-- 조건문태그 -->
<c:if test="${empty clientip }">
	<h1>client ip 는 삭제 되었습니다.</h1>
	<%System.out.println("client ip 는 삭제 되었습니다."); %>
</c:if>
<c:if test="${!empty clientip}">
<h1>client ip 는 사용가능</h1>${clientip }
</c:if>
<c:if test="<%=10>5 %>">
	<h1>10>5</h1>
</c:if>
<hr>
url : http:127.0.0.1:8080/jsptest/jstl1.jsp
uri : /jsptest/jstl1.jsp
</body>
</html>