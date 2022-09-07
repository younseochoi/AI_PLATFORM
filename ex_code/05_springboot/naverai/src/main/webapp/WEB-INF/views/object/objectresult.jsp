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
	var json = JSON.parse('${objectresult }');
	$("#result").html("<h3> 발견된 사물의 수 = "+json.predictions[0].num_detections+"</h3>");
	for(var i = 0; i < json.predictions[0].num_detections; i++){
		$("#result").append
		(json.predictions[0].detection_names[i] + " : " + 
		parseInt(json.predictions[0].detection_scores[i] * 100) + "%<br>"); 
	}//for end
	
	var mycanvas = document.getElementById("mycanvas");
	var mycontext = mycanvas.getContext("2d");

	var myimage = new Image();
	myimage.src = "/naverai/${param.image}";
	
	myimage.onload = function(){
		mycontext.drawImage(myimage, 0, 0, myimage.width, myimage.height);
		for(var i = 0; i < json.predictions[0].num_detections; i++ ){//사물수 반복
			var y1 = json.predictions[0].detection_boxes[i][0] * myimage.height;
			var x1 = json.predictions[0].detection_boxes[i][1] * myimage.width;
			var y2 = json.predictions[0].detection_boxes[i][2] * myimage.height;
			var x2 = json.predictions[0].detection_boxes[i][3] * myimage.width;		
			// 사물 박스 그리기
			var x = x1;
			var y = y1;
			var width = x2 - x1;
			var height = y2 - y1;
			mycontext.strokeStyle = "green";
			mycontext.lineWidth = 3;
			mycontext.strokeRect(x, y, width, height);
			//사물이름 출력
			mycontext.fillStyle="red";
			mycontext.font="12px batang";
			mycontext.fillText(json.predictions[0].detection_names[i], x, y);
			
		}//for
	}//onload
	
	if(myimage.width > mycanvas.width){
		mycanvas.width = myimage.width;
	}	
	if(myimage.height > mycanvas.height){
		mycanvas.height = myimage.height;
	}
	

});//ready end
</script>
</head>
<body>
<div id="result"></div>
<canvas id="mycanvas" width=500 height=500 style="border:2px solid green">
</body>
</html>