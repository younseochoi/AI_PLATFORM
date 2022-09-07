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
	var json = JSON.parse('${poseresult}');
	//canvas 작업
	var mycanvas = document.getElementById("mycanvas");
	var mycontext = mycanvas.getContext("2d");
	
	var colors = ['red','blue','green','purple','pink','yellow','navy','lime'];
	var bodyinforms = ['코','목','오어깨', '오팔꿈치', '오손목', '왼어깨', '왼팔꿈치', '왼손목'];
	var myimage = new Image();
	myimage.src = "http://localhost:8082/naverai/${param.image }";
	if(myimage.width > mycanvas.width){
		mycanvas.width = myimage.width;
	}	
	if(myimage.height > mycanvas.height){
		mycanvas.height = myimage.height;
	}	
	myimage.onload = function(){//이미지 그릴 준비 대기
		mycontext.drawImage(myimage, 0, 0, myimage.width, myimage.height);
	//	bodyinforms 신체부위이름, 위치점 표시. colors 색상으로 각 신체부위별 다르게 표시

	for(var j = 0; j <json.predictions.length; j++ ){//사람수만큼 반복
		for(var i = 0; i < bodyinforms.length; i++){//8개신체부위만큼 반복
			//i-신체부위명인덱스번호-사진에 신체 안보이면 json.predictions[j][i]--> null
			if(json.predictions[j][i] != null){
			var x = json.predictions[j][i].x * myimage.width ;
			var y = json.predictions[j][i].y * myimage.height;
			mycontext.fillStyle=colors[i];
			mycontext.fillText(bodyinforms[i], x, y);
			mycontext.fillRect(x, y, 10, 10 );
			}//if 


		}//inner for
	}//outer for	
	}//inload
});//ready end
</script>
</head>
<body>
<div id="result"></div>
<img src="http://localhost:8082/naverai/${param.image }">
<canvas id="mycanvas" width=500 height=500 style="border:2px solid green">
</body>
</html>


