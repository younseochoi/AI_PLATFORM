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
String [] laguages = {"Kor", "Jpn", "Eng", "Chn"};
String [] lang_names = {"한국어", "일본어","영어","중국어" };
%>

<form action="csrresult" >

언어선택 : <br>
<% for(int i = 0; i < laguages.length; i++){
%>
<input type=radio name="lang" value="<%=laguages[i]%>"> <%=lang_names[i] %>
<%} %>
mp파일 선택 : <br>
<select name="image">
<% 
String [] filelist = (String[])request.getAttribute("filelist");
for(int i = 0; i < filelist.length; i++ ){
	String file_split[] = filelist[i].split("\\.");
	String ext = file_split[file_split.length-1]; 
	if(ext.equals("mp3") || ext.equals("m4a")){
%>
		<option value="<%=filelist[i] %>"><%=filelist[i] %></option>
<%	}//if
}//for
%>
</select>
<input type=submit value="텍스트로변환" >
</form>
</body>
</html>




















