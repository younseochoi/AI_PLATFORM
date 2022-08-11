<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%=pageContext.getAttribute("a")%><br>
<%=request.getAttribute("a")%><br>
<%=session.getAttribute("a")%><br>
<%=application.getAttribute("a")%><br>
<hr>
1.pageScope에서 찾는다 2.RequestScope 에서 찾는다 3. sessionsCOPE 4. applicationScope
5.공백

현재페이지에서전달=${a }<br>
이동전의 페이지에서전달=${requestScope.a }<br>
세션에서전달=${sessionScope.a }<br>
applcaition에서전달=${applicationScope.a }<br>



</body>
</html>