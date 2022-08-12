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
<% String id2 = "jsp"; %>
<c:set var="id" value="jstl" />
<c:set var="pw" value="100" />
<c:set var="id22" value="<%=id2 %>" />
<c:set var="result" value="${ pw +200 }" />
<h1>${id }</h1>
<h1>${pw }</h1>
<h1>${id22 }</h1>
<h1>${result }</h1>

<h1> 요청ip=<%=request.getRemoteAddr()%></h1>
<h1> 요청파일명=<%=request.getRequestURI()%></h1>

<c:set var="clientip" value="${ pageContext.request.remoteAddr }" />
<c:set var="clientfile" value="${ pageContext.request.requestURI }" />

<h1> 요청ip=${ clientip }</h1>
<h1> 요청파일명=${ clientfile }</h1>


<c:remove var="clientip"  /> 
<c:remove var="clientfile"  />

<h1> 요청ip=${ clientip }</h1>
<h1> 요청파일명=${ clientfile }</h1>

<%--
<c:set var="i" value="100" />
<c:out var="i"  />
${i }
<c:remove
 --%>

<!-- 조건문태그 -->
<c:if test="${empty clientip }">
	<h1> clientip는 이미 삭제되었습니다. </h1>
	<% System.out.println("clientip는 이미 삭제되었습니다. "); %>
	
</c:if>
<c:if test="${!empty clientip }">
	<h1> clientip는 가용 가능합니다 </h1>
	${clientip }
</c:if>

<c:if test="<%=10 > 5 %>" >
<h1> 10 > 5 </h1>


</c:if>
</body>
</html>










