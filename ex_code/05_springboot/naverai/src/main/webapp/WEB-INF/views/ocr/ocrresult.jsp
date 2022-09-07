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
	var json = JSON.parse('${ocrresult }');
	var fieldlist = json.images[0].fields; //[]
	
	for(var i = 0; i < fieldlist.length; i++){
		if(fieldlist[i].lineBreak == true){
			$("#text").append(fieldlist[i].inferText + "<br>");
		}else{
			$("#text").append(fieldlist[i].inferText + "&nbsp;&nbsp;");
		}
	}
	
	var mycanvas = document.getElementById("mycanvas");
	var mycontext = mycanvas.getContext("2d");
	
	var myimage = new Image();
	myimage.src = "/naverai/${param.textimage }";
	myimage.onload = function(){
		mycontext.drawImage(myimage, 0, 0, myimage.width, myimage.height);
		//발견 텍스트 빨강색박스
		mycontext.strokeStyle='red';
		for(var i = 0; i < fieldlist.length; i++){
			var x = fieldlist[i].boundingPoly.vertices[0].x;
			var y = fieldlist[i].boundingPoly.vertices[0].y;
			var x2 = fieldlist[i].boundingPoly.vertices[1].x;
			var width = x2 - x;
			var y3 = fieldlist[i].boundingPoly.vertices[3].y;
			var height = y3 - y;
			mycontext.strokeRect(x, y, width, height);
		}
		
	}//onload 
});//ready end
</script>
</head>
<body>
<h3>${param.textimage } 파일에서 ${ocrresult } 결과를 추출했습니다.</h3>
<h3 id="text" style="border:2px solid navy"> </h3>
<canvas id="mycanvas" width=600 height=600 style="border:2px solid aqua"></canvas>
</body>
</html>



