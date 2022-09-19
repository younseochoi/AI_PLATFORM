<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 게시글보기</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){

});
</script>
</head>
<body>
<h1>전체 게시글 보기</h1>
<table border=1>
	<tr><th></th><th>제목</th><th>작성자</th><th>작성날짜</th></tr>
	<c:forEach items="${boardlist }" var="board" varStatus="b">
	<tr><td>${b.count }</td><td><a href="boarddetail?seq=${board.seq}">${board.title }</a></td><td>${board.writer }</td><td>${board.writingtime }</td></tr>
	</c:forEach>
</table>
<%
	int boardcount = (Integer) request.getAttribute("boardcount");
	int paging = 3;
	int totalpage=0;
	int index=0 ;
	if(boardcount%paging ==0){
		totalpage= boardcount / paging;
	}else{
		totalpage= boardcount / paging +1;
	}
	for(int i=0; i < totalpage ;i++){
		index = i+1;
		%>
		<a href="boardlist?page=<%=i+1%>"><%=i+1 %></a>
		<%
	}
%> 
</body>
</html>