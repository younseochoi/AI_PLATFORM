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
		//if(json.faces[i].gender.confidence >= 0.5){
		$("h1").append("성별 = " + json.faces[i].gender.value + " : " );
		$("h1").append(parseInt(json.faces[i].gender.confidence  * 100 ) + "%<br>");
		$("h1").append("나이 = " + json.faces[i].age.value + " : " );
		$("h1").append(parseInt(json.faces[i].age.confidence  * 100 ) + "%<br>");
		$("h1").append("감정 = " + json.faces[i].emotion.value + " : " );
		$("h1").append(parseInt(json.faces[i].emotion.confidence  * 100 ) + "%<br>");
		$("h1").append("방향 = " + json.faces[i].pose.value + " : " );
		$("h1").append(parseInt(json.faces[i].pose.confidence  * 100 ) + "%<br>");
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
		//}
	}
	
	//참고 객체--> String 변환 함수
	/*var str = JSON.stringify({"a":"aa"});
	str.a 접근 불가*/
	
});//ready end
</script>
</head>
<body>
<h3>${result }</h3>
<h1></h1>
<img src="naverai/${param.image }" >
</body>
</html>








