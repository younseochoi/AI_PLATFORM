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
	//$("tr:even").css("background-color", "pink");
	//$("tr:odd").css("background-color", "silver");
});
</script>
<style>
table, td{border : 2px solid blue; border-collapse: collapse;}
td{width : 100px; height:100px; text-align:center; line-height: 100px;} 
tr:nth-child(2n+1){background-color:pink;}
tr:nth-child(2n){background-color:silver;}
</style>
</head>
<body>
<table>
	<% for(int i = 1; i <=9; i++){ %>
		<tr>
		<%for(int j = 3; j <= 7 ; j++){ %>
			<td><%=j*i %></td>
		<%}%>
		</tr>
	<%} %>
</table>
</body>
</html>







