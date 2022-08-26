<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 div#ajaxresult {width : 300px; border : solid 3px green;}
 div#ajaxresult2 {width : 600px; border : solid 3px blue;}
 div#ajaxresult3 {width : 100px; border : solid 3px red;}
 div#upload , div#ajaxresult4 {width : 500px; border : solid 3px pink;}
</style>
<script src="resources/js/jquery-3.6.0.min.js" ></script>
<script>
$(document).ready(function(){
$("#ajaxbtn").on("click", function(){
	$.ajax({
		url : 'loginajax2', 
		data : {id:$("#id").val(),'password':$("#password").val()},
		type : 'post',
		///////////////////////////////////////
		dataType: 'json', 
		success : function(server){ 
		//id, password 입력한 정보 MemberDTO 객체 응답
		$("#ajaxresult").html("<h3>로그인 아이디=" + server.id + "</h3>");
		$("#ajaxresult").append("<h3>회원이름=" + server.name + "</h3>");
		$("#ajaxresult").append("<h3>폰번호=" + server.phone + "</h3>");
		$("#ajaxresult").append("<h3>이메일=" + server.email + "</h3>");
		$("#ajaxresult").append("<h3>가입일=" + server.regdate + "</h3>");
		}//success 

	});//ajax
})//on

$("#listbtn").on("click", function(){
	$.ajax({
		url : 'memberlistajax', 
		//////////////////서버로 요청 /////////////////////
		dataType: 'json', 
		success : function(server){ //[{"id":"xxx",...}, {}, {} ]
			for(var i = 0; i < server.length; i++){
				var onemember = "<h3><a id='" + server[i].id + "' href=''>" + server[i].id + "</a> : "
				                + server[i].name + " : "
				                + server[i].phone + " : "
				                + server[i].email + " : "
				                + server[i].regdate + " </h3> ";
				$("#ajaxresult2").append(onemember);               
			}
		}//success 
	});//ajax
})//on

//클릭한 아이디의 암호 요청 ajax 처리
//$("이벤트 처리 동적 생성 태그 부모 태그").on('click', "이벤트 처리 동적 생성 태그선택자",function(){});
$("#ajaxresult2").on("click", "a", function(event){
	event.preventDefault();
	$.ajax({
	 /*url :'memberpasswordajax',
	 data : { 'id' : $(this).attr("id")} , */
	 url : "memberpasswordajax2/" + $(this).attr("id"), 
	 type : 'get',
	 /////////////////////////////////////////////
	 dataType : 'json',
	 success : function(fromserver){ //id + 암호
		$("#ajaxresult3").html(fromserver.id + " 회원님의 암호= " + fromserver.password);
	 }
	});//ajax
})//on

$("#uploadbtn").on('click', function(event){
	event.preventDefault(); 
	var form = $("#uploadForm")[0]  ;//jquery객체를 자바스크립트 변수로 변환
	var data = new FormData(form);//FormData객체형태로 
	
	$.ajax({
		type:'post' , 
		data : data,
		url : 'uploadajax',
		encType : 'multipart/form-data',//여러 형태 폼데이터들이 뒤섞여있다
		processData : false,// name=값&namr2=값2 형태로 전송하지 않겠다(request.getParameter()x)
		contentType : false,// request.setContentType("text/html;charset-utf-8") 요청 기본 설정 사용하지 않겠다ㅓ
		dataType : 'json',
		success : function(response){ //{"result":"..."}
 			alert(response);
 			$("#ajaxresult4").html("<h3>" + response.result + "</h3>");
		}
		
	});//ajax
})//on

});//ready
</script>
</head>
<body>
<img src="http://localhost:8080/test/upload/google(372ee13b-a30d-4a3c-9178-cdb11446924a).png"  >

<h1>로그인 폼</h1>
<form action="loginajax2" method=post >
	아이디<input type=text name="id" id="id"><br>
	암호<input type=password name="password" id="password"><br>
	<input id="ajaxbtn" type="button" value="ajax로그인"><br>
</form>

<input id="listbtn" type=button value="회원리스트주세요" >

<div id=upload>
 <form  id="uploadForm">
 파일선택 : <input type=file name="uploadfile">
 <input id="uploadbtn" type=button value="파일업로드">
 </form>
</div> 
 
<div id="ajaxresult">  로그인 회원 정보 출력 </div>
<div id="ajaxresult2"> 회원리스트정보 출력 </div>
<div id="ajaxresult3"> 클릭한 회원 암호 2자리만.**** 출력 </div>
<div id="ajaxresult4"> 파일 업로드 결과 출력 </div>



</body>
</html>








