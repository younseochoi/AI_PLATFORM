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
	var json = JSON.parse('${ocrresult}');
	var fieldlist = json.images[0].fields; //[]
	for(var i=0;i<fieldlist.length;i++){		
		$('#text').append(fieldlist[i].inferText);
		if(fieldlist[i].lineBreak == true){
			$('#text').append('<br>');
		}else{
			$('#text').append('&nbsp;&nbsp;');
		}
	}
	
	var mycanvas = document.getElementById("mycanvas");
	var mycontext = mycanvas.getContext("2d");
	
	var myimage = new Image();
	myimage.src = "/naverai/${param.textimage}";
	myimage.onload= function(){
		mycontext.drawImage(myimage,0,0,myimage.width,myimage.height);
		//fieldlist[0].boundingPoly.vertices[0].x
		for(let j = 0;j<fieldlist.length;j++){
			var x1 = fieldlist[j].boundingPoly.vertices[0].x;
			var y1 = fieldlist[j].boundingPoly.vertices[0].y;
			
			var x2 = fieldlist[j].boundingPoly.vertices[1].x;
			//var y2 = fieldlist[j].boundingPoly.vertices[1].y;
			
			//var x3 = fieldlist[j].boundingPoly.vertices[2].x;
			var y3 = fieldlist[j].boundingPoly.vertices[2].y;
			
			//var x4 = fieldlist[j].boundingPoly.vertices[3].x;
			//var y4 = fieldlist[j].boundingPoly.vertices[3].y;
			
			var width = x2-x1;
			var height = y3-y1;
			mycontext.strokeStyle = "red";
			mycontext.lineWidth=2;
			mycontext.strokeRect(x1,y1,width,height);
		}
		
	}
	
});//ready end
</script>
</head>
<body>
<h3>${param.textimage}란 파일에서 ${ocrresult} 결과를 추출했습니다.</h3>
<div id="text" style="border:2px solid navy;"></div>
<canvas id="mycanvas" width="600" height="600" style="border: 2px solid orange;"></canvas>
</body>
</html>