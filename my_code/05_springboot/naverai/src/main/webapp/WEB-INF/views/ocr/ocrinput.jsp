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

});//ready end
</script>
</head>
<body>
<%// 언어 코드 ( Kor, Jpn, Eng, Chn )
String imgext[] =  {"jpg", "png", "gif", "jfif"};
String [] filelist = (String [])request.getAttribute("filelist");
for(int i =0;i<filelist.length;i++){
	String [] file_split = filelist[i].split("\\.");
	String ext = file_split[file_split.length-1];
	for(int j=0;j<imgext.length;j++){
		if(ext.equals(imgext[j])){ //원하는 확장자만 보여주기
%>
	<a href="ocrresult?textimage=<%=filelist[i]%>"><%=filelist[i] %></a>
	<img alt="" src="/naverai/<%=filelist[i]%>" width="100px" height="100px"><br>
<%			
		} //if end
	} //inner for
} //outer for
%>

</body>
</html>