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
	/* $('tr:nth-child(2n)').css("background-color","pink");
	$('tr:nth-child(2n+1)').css("background-color","silver");
	 */
	$('tr:even').css("background-color","pink");
	$('tr:odd').css("background-color","silver");
});
</script>
<style>
table {
	margin : 0 auto;
	padding : 0;
	border : 2px solid blue;
	border-collapse :collapse ;
	text-align: center;
	align-self: center;
}
td{
	border : 2px solid blue;
	padding : 8px 8px 8px 8px;
}
</style>
</head>
<body>
<% 
	String startstr =  request.getParameter("start") ;

	if(startstr == ""||startstr==null){
		startstr = "2";
	}
	int start = Integer.parseInt(startstr);
	String endstr =  request.getParameter("end");
	if(endstr == ""||endstr==null){
		endstr = "9";
	}
	int end = Integer.parseInt(endstr);
	%>
	<table>
	<%
	for(int i=1 ; i<=9 ; i++){
		%>
		<tr>
		<% 
		for(int j=start;j<=end;j++){
			int result = i*j;
			%>
			<td><%=j %> x <%=i %> = <%=result %></td>
			<%
		}
		%>
		</tr>
		<%
	}
	%>
	</table>
	<a href="input.jsp">구구단 입력하기</a>
</body>
</html>