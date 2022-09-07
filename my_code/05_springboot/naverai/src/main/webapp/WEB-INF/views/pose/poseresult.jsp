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
	var json = JSON.parse('${poseresult}');
	var output = "코확률 : "+json.predictions[0][0].score *100+"%<br>";
	output+="코의 x좌표 : "+json.predictions[0][0].x +"<br>";
	output+="코의 y좌표 : "+json.predictions[0][0].y +"<br>";
	$('#result').html(output);
	
	//canvas 작업
	var mycanvas = document.getElementById("mycanvas");
	var mycontext = mycanvas.getContext("2d");
	
	var colors=["red","blue","green","purple","pink","yellow","navy","lime"];
	var bodyinforms=["코","목","오어깨","오팔꿈치","오손목","왼어깨","왼팔꿈치","왼손목"];
	var myimage= new Image();
	myimage.src = "http://localhost:8082/naverai/${param.image}";
		if(myimage.width>mycanvas.width){
			mycanvas.width = myimage.width;
		}
		if(myimage.height>mycanvas.height){
			mycanvas.height = myimage.height;
		}
		mycontext.drawImage(myimage,0,0,myimage.width,myimage.height);
				
		 mycontext.fillText("코("+Object.keys(json).length+')',10,10); 
		//for(let i=0;i<Object.keys(json);i++){
			for(let j=0;j<bodyinforms.length;j++){
				var x = json.predictions[0][j].x * myimage.width;
				var y = json.predictions[0][j].y * myimage.height;
				mycontext.fillStyle=colors[j];
				mycontext.fillText(bodyinforms[j]+"("+json.predictions[0][j].score+')',x,y);
				mycontext.fillRect(x,y,5,5); 
			//양손목 연결선그리기
				if(bodyinforms[j].indexOf("왼손목")>=0){
					var leftx = json.predictions[0][j].x * myimage.width;
					var lefty = json.predictions[0][j].y * myimage.height;
				}
				if(bodyinforms[j].indexOf("오손목")>=0){
					var rightx = json.predictions[0][j].x * myimage.width;
					var righty = json.predictions[0][j].y * myimage.height;
				}
				mycontext.beginPath();
				mycontext.moveTo(leftx,lefty); //시작
				mycontext.lineTo(rightx,righty); //선
				mycontext.closePath();
				mycontext.strokeStyle = "red";
				mycontext.lineWidth = 5;
				mycontext.stroke();
			}
	myimage.onload= function(){ //이미지그릴 준비 대기
		//} 
		/* var x = json.predictions[0][0].x * myimage.width;
		var y = json.predictions[0][0].y * myimage.height;
		mycontext.fillStyle="blue";
		mycontext.fillText("코("+json.predictions[0][0].score+')',x,y);
		
		mycontext.fillRect(x,y,5,5); */
		
	}
	
});//ready end
</script>
</head>
<body>
<div id="result"></div>
<%-- <img src="/naverai/${param.image }"> --%>
<canvas id="mycanvas" style="border:2px solid orange;"></canvas>

</body>
</html>