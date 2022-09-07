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
	var json = JSON.parse('${objectresult}');
	var output = "감지된 객체수 : "+json.predictions[0].num_detections+"개<br>";
	output+="감지된 물체 이름 : "+json.predictions[0].detection_names +"<br>";
	output+="감지된 물체 클래스번호 : "+json.predictions[0].detection_classes +"<br>";
	output+="감지된 물체 스코어 : "+json.predictions[0].detection_scores+"<br>";
	output+="감지된 물체 좌표 : "+json.predictions[0].detection_boxes+"<br>";
	/* output+="코의 y좌표 : "+json.predictions[0][0].y +"<br>"; */
	$('#result').html(output);
	for(let i=0;i<json.predictions[0].num_detections;i++){
		$('#result').append(json.predictions[0].detection_names[i]+" : "+
				parseInt(json.predictions[0].detection_scores[i]*100)+"%<br>");
	}
	//canvas 작업
	var mycanvas = document.getElementById("mycanvas");
	var mycontext = mycanvas.getContext("2d");
	
	var myimage= new Image();
	myimage.src = "http://localhost:8082/naverai/${param.image}";
	myimage.onload= function(){ //이미지그릴 준비 대기		
			if(myimage.width>mycanvas.width){
				mycanvas.width = myimage.width;
			}
			if(myimage.height>mycanvas.height){
				mycanvas.height = myimage.height;
			}
			mycontext.drawImage(myimage,0,0,myimage.width,myimage.height);
			
			for(let i=0;i<json.predictions[0].num_detections;i++){
				var y1 = json.predictions[0].detection_boxes[i][0] * myimage.height;
				var x1 =  json.predictions[0].detection_boxes[i][1] * myimage.width;
				var y2 = json.predictions[0].detection_boxes[i][2] * myimage.height;
				var x2 =  json.predictions[0].detection_boxes[i][3] * myimage.width;
				//사물 박스그리기
				var x= x1;
				var y= y1;
				var width = x2-x1;
				var height = y2-y1;
				mycontext.strokeStyle = "lime";
				mycontext.lineWidth=3;
				mycontext.strokeRect(x,y,width,height);
				//사물 이름 출력
				mycontext.fillStyle="red";
				mycontext.font="12px"
				mycontext.fillText(json.predictions[0].detection_names[i] , x,y);
			}
		
	}//image onload end
});//ready end
</script>
</head>
<body>
<div id="result"></div>
<img src="/naverai/${param.image }">
<canvas id="mycanvas" width="500px" height="500px" style="border:2px solid orange;"></canvas>

</body>
</html>