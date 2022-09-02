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
	var obj = '${result}'; //내부규격 json 규격
	//js 내부 객체 <---String 함수 존재 
	var json = JSON.parse(obj);
	$("div").html("사람수는"+json.info.faceCount);
	
	//참고객체 -->String
		/* var str-JSON.stringify({"a":"aas"}); */
		
		for(var i =0;i<json.info.faceCount;i++){
			//얼굴
			$('h1').append("얼굴위치 = "+json.faces[i].roi.x +"  ::::  "+json.faces[i].roi.y+
					"  ::::  "+json.faces[i].roi.width+"  ::::  "+json.faces[i].roi.height+"<br>");
			
			if(json.faces[i].landmark != null){
			$('h1').append("왼쪽눈위치 = "+json.faces[i].landmark.leftEye.x +","+json.faces[i].landmark.leftEye.y +"  :::: <br>");
			$('h1').append("오른쪽눈위치 = "+json.faces[i].landmark.rightEye.x +","+json.faces[i].landmark.rightEye.y +"  :::: <br>");
			$('h1').append("코위치 = "+json.faces[i].landmark.nose.x +","+json.faces[i].landmark.nose.y +"  :::: <br>");
			$('h1').append("왼쪽입끝위치 = "+json.faces[i].landmark.leftMouth.x+","+json.faces[i].landmark.leftMouth.y +"  :::: <br>");
			$('h1').append("오른쪽입끝위치 = "+json.faces[i].landmark.rightMouth.x+","+json.faces[i].landmark.rightMouth.y +"  :::: <br>");
			}
			
		}//for
	var mycanvas = document.getElementById("mycanvas");	
	var mycontext = mycanvas.getContext("2d");
	var myimage= new Image(); //이미지객체 비어있다.
	myimage.src="/naverai/${param.image}";//이미지객체 비어있지 않다.
	
	myimage.onload = function(){
		mycontext.drawImage(myimage,0,0,myimage.width,myimage.height);
		mycontext.lineWidth=4;
		mycontext.strokeStyle="blue";
		mycontext.fillStyle="blue";
		//반복
		for(var i =0;i<json.info.faceCount;i++){
			//얼굴
			//얼굴좌표에 파랑색 사각형으로 표시
			//mycontext.fillRect(json.faces[i].roi.x ,json.faces[i].roi.y,json.faces[i].roi.width,json.faces[i].roi.height);
			
			//랜드마크있으면 표시하기
			if(json.faces[i].landmark != null){
				mycontext.strokeStyle="red";
				mycontext.fillText("왼쪽눈",json.faces[i].landmark.leftEye.x,json.faces[i].landmark.leftEye.y);
				mycontext.strokeRect(json.faces[i].landmark.leftEye.x,json.faces[i].landmark.leftEye.y,2,2);
				mycontext.fillText("오른쪽눈",json.faces[i].landmark.rightEye.x,json.faces[i].landmark.rightEye.y);
				mycontext.strokeRect(json.faces[i].landmark.rightEye.x,json.faces[i].landmark.rightEye.y,2,2);
				mycontext.fillText("코",json.faces[i].landmark.nose.x ,json.faces[i].landmark.nose.y);
				mycontext.strokeRect(json.faces[i].landmark.nose.x ,json.faces[i].landmark.nose.y,2,2 );
				mycontext.fillText("입술",json.faces[i].landmark.leftMouth.x ,json.faces[i].landmark.leftMouth.y);
				mycontext.strokeRect(json.faces[i].landmark.leftMouth.x,json.faces[i].landmark.leftMouth.y,(json.faces[i].landmark.rightMouth.x-json.faces[i].landmark.leftMouth.x),
						(json.faces[i].landmark.rightMouth.y-json.faces[i].landmark.leftMouth.y+10));
			/* 	$('h1').append("왼쪽눈위치 = "+json.faces[i].landmark.leftEye.x +","+json.faces[i].landmark.leftEye.y +"  :::: <br>");
				$('h1').append("오른쪽눈위치 = "+json.faces[i].landmark.rightEye.x +","+json.faces[i].landmark.rightEye.y +"  :::: <br>");
				$('h1').append("코위치 = "+json.faces[i].landmark.nose.x +","+json.faces[i].landmark.nose.y +"  :::: <br>");
				$('h1').append("왼쪽입끝위치 = "+json.faces[i].landmark.leftMouth.x+","+json.faces[i].landmark.leftMouth.y +"  :::: <br>");
				$('h1').append("오른쪽입끝위치 = "+json.faces[i].landmark.rightMouth.x+","+json.faces[i].landmark.rightMouth.y +"  :::: <br>");
			 */	}
		}//for
		
	}//myimage onload end
	
});//ready end
</script>
</head>
<body>
<%-- <h1>${result }</h1> --%>
<h1></h1>
<div></div>
<canvas id="mycanvas" width="500" height="500" style="border:2px solid orange;">
</canvas>
<%-- <img src="/naverai/${param.image }" width="200px" height="200px"> --%>
</body>
</html>