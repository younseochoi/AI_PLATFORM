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
	$("tr:even").css("background-color", "pink");
	$("tr:odd").css("background-color", "silver");
});
</script>
<style type="text/css">
table, td  {border : 2px solid blue; border-collapse: collapse;}
td {width:100px; height:50px; text-align: center; line-height: 50px; }
/* tr:nth-child(2n+1){background-color: pink;}
tr:nth-child(2n) {background-color: silver;} */
</style>
</head>
<body>

<% 
if(request.getMethod().equals("POST")){
	request.setCharacterEncoding("utf-8");
}
String start = request.getParameter("start"); 
  if(start == null){ start = "2"; }
  int startInt = Integer.parseInt(start);
  String end = request.getParameter("end"); 
  if(end == null){ end = "9"; }
  int endInt = Integer.parseInt(end);
 %>
<h1> 구구단 출력 </h1>
<table>
	<%for(int i = 1; i <=9; i++){ %>
		<tr>
		<%for(int j = startInt; j <=endInt; j++){ %>
			<td> <%=j%> * <%=i%> = <%=j*i%>  </td>
		<%} %>
		</tr> 
	<%}%>
</table>
<h3><a href="input.jsp"> 구구단 입력하기 </a></h3>
</body>
</html>







