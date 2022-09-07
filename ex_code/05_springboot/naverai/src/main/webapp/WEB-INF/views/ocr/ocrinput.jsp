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
$(document).ready(function() {
	
});//ready end
</script>
</head>
<body>
<%
String imgext [] = {"jpg", "png", "gif", "jfif"};
String[] filelist = (String[])request.getAttribute("filelist");
for(int i = 0; i < filelist.length; i++){
	String[] file_split = filelist[i].split("\\.");
	String ext = file_split[file_split.length-1];
	for(int j = 0; j < imgext.length; j++ ){
		if(ext.equals(imgext[j])){
%>			
			<a href="ocrresult?textimage=<%=filelist[i] %>" ><%=filelist[i] %></a>
			<img src="/naverai/<%=filelist[i] %>" width=100 height=100 ><br>
<%		}//if end
	}//inner for 
}//outer for
%>

</body>
</html>




















