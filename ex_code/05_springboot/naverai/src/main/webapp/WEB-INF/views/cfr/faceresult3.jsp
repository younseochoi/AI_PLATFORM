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
	var obj = '${result}'; //obj 변수 타입 String(내부데이터 json규격)
	//js 내부 객체<--String 함수 존재
	var json = JSON.parse(obj);
	$("h1").html("사람수 = " + json.info.faceCount +"<br>");
	//사람수만큼  출력
	for(var i = 0; i < json.info.faceCount; i++){
		$("h1").append("얼굴위치 = " + json.faces[i].roi.x + " : " + json.faces[i].roi.y + ":"
				+ json.faces[i].roi.width + ":" + json.faces[i].roi.height + "<br>");
		if(json.faces[i].landmark != null){
			$("h1").append("왼쪽눈위치 = " + json.faces[i].landmark.leftEye.x + " : " 
					+ json.faces[i].landmark.leftEye.y+ "<br>");
			$("h1").append("오른쪽눈위치 = " + json.faces[i].landmark.rightEye.x + " : " 
					+ json.faces[i].landmark.rightEye.y+ "<br>");
			$("h1").append("코위치 = " + json.faces[i].landmark.nose.x + " : " 
					+ json.faces[i].landmark.nose.y+ "<br>");
			$("h1").append("왼쪽입끝 = " + json.faces[i].landmark.leftMouth.x + " : " 
					+ json.faces[i].landmark.leftMouth.y + "<br>");
			$("h1").append("오른쪽입끝 = " + json.faces[i].landmark.rightMouth.x + " : " 
					+ json.faces[i].landmark.rightMouth.y + "<br>");
		}
	}//for
	
	var mycanvas = document.getElementById("mycanvas");
	var mycontext = mycanvas.getContext("2d");
	var myimage = new Image();// 이미지객체 비어있다
	myimage.src = "/naverai/${param.image}";// 이미지객체 비어있지 ㅇ않다
	myimage.onload = function(){
		mycontext.drawImage(myimage, 0, 0, myimage.width, myimage.height);
		mycontext.lineWidth = 4;
		mycontext.strokeStyle="blue";
		mycontext.fillStyle="blue";
		//var colors = ["red", "blue", "yellow", "green"];
		//var faces = ["왼쪽눈", "오른쪽눈", "코", "입술"];
		//반복
		for(var i = 0; i < json.info.faceCount; i++){
			//mycontext.fillRect(json.faces[i].roi.x,  json.faces[i].roi.y, 
			//		json.faces[i].roi.width, json.faces[i].roi.height);
			//landmark 있으면 왼눈, 오른눈, 코, 양입술끝 빨강색 선택
			if(json.faces[i].landmark != null){
mycontext.fillText("왼쪽눈" ,json.faces[i].landmark.leftEye.x, json.faces[i].landmark.leftEye.y);
mycontext.strokeRect(json.faces[i].landmark.leftEye.x, json.faces[i].landmark.leftEye.y, 5, 5);
mycontext.fillText("오른쪽눈" ,json.faces[i].landmark.rightEye.x, json.faces[i].landmark.rightEye.y);
mycontext.strokeRect(json.faces[i].landmark.rightEye.x, json.faces[i].landmark.rightEye.y, 5, 5);
mycontext.fillText("코" ,json.faces[i].landmark.nose.x, json.faces[i].landmark.nose.y);
mycontext.strokeRect(json.faces[i].landmark.nose.x, json.faces[i].landmark.nose.y, 5, 5);
mycontext.fillText("입술" ,json.faces[i].landmark.leftMouth.x, json.faces[i].landmark.leftMouth.y);
mycontext.strokeRect(json.faces[i].landmark.leftMouth.x , json.faces[i].landmark.leftMouth.y,  
		json.faces[i].landmark.rightMouth.x - json.faces[i].landmark.leftMouth.x,
		json.faces[i].landmark.rightMouth.y - json.faces[i].landmark.leftMouth.y+ 10);
			}
		}//for
	}//myimage onload

	
});//ready end
</script>
</head>
<body>
<h3>${result }</h3>
<h1></h1>
<canvas id="mycanvas" width=1000 height=600 style="border:2px solid pink">
</canvas>
</body>
</html>








