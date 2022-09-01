<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
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
${dto.name }님이 ${dto.file1.originalFilename } 파일과
${dto.file2.originalFilename } 파일을 업로드하였습니다. <br>
설명 : ${dto.description }

</body>
</html>