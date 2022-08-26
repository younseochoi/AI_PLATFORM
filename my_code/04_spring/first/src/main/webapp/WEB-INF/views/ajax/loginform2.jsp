<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div#ajaxresult{
	width:300px;
	border: 3px solid green;
}
div#ajaxresult2{
	width:600px;
	border: 3px solid blue;
}
div#ajaxresult3{
	width:600px;
	border: 3px solid red;
}
div#upload , div#ajaxresult4{
	width:500px;
	border: 3px solid pink;
}
</style>
<script src="resources/js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	$('#ajaxbtn').on("click",function(){
		/* alert(this.value); */
		//ajax 요청
		$.ajax({
			url :'loginajax2',
			data : {'id':$("#id").val(), 'password':$("#password").val()},
			type :'post',
			datatype :'json', /* 서버로 부터 받아오는거 json이야 */
			success: function(server){
				alert(server.id);
				$("#ajaxresult").html("로그인한 아이디는? "+server.id);
				if(server.id !=null){
					$("#ajaxresult").append("사용자이름은? "+server.name);
					$("#ajaxresult").append("사용자phone은? "+server.phone);
					$("#ajaxresult").append("사용자email은? "+server.email);
					$("#ajaxresult").append("사용자regdate은? "+server.regdate);
					
				}
				
			}
		}); //ajax
	});
	
	$('#ajaxbtn2').on("click",function(){
		/* alert(this.value); */
		//ajax 요청
		$.ajax({
			url :'memberlistajax',
			/* data : {'id':$("#id").val(), 'password':$("#password").val()}, */
			/* type :'get', */
			datatype :'json', /* 서버로 부터 받아오는거 json이야 */
			success: function(server){

				for(let i = 0 ; i< server.length-1; i++){
					$("#ajaxresult2").append("<p>"+(i+1)+" . <a id='"+server[i].id+"' href=''>"+server[i].id+"</a></p>");
					$("#ajaxresult2").append("<p>"+server[i].name+"</p>");
					$("#ajaxresult2").append("<p>"+server[i].phone+"</p>");
					$("#ajaxresult2").append("<p>"+server[i].email+"</p>");
					$("#ajaxresult2").append("<p>"+server[i].regdate+"</p>");
					$("#ajaxresult2").append("<hr>");
					
				} 
				
			}
		}); //ajax
	 });
		$('#ajaxresult2').on("click", "a",function(event){
			event.preventDefault();
			$.ajax({
				/* url : "memberpasswordajax",
				data : { 'id' : $(this).attr("id")}, */
				url : "memberpasswordajax2/"+$(this).attr("id"),
				type : "get",
				dataType : 'json',
				success : function(fromserver){  
					$("#ajaxresult3").html(fromserver.id+" 회원님의 암호는 "+fromserver.password);
				
				}
				
				
			}); //ajax	
	 });//on
	 
	 $('#uploadbtn').on("click", function(event){
		 event.preventDefault(); // form 안에 버튼 들어가있으면 submit동작을 하기때문에 취소해라.
		 var form = $("#uploadForm")[0]; // jquery 객체를 자바스크립트 변수로 저장
		 var data = new FormData(form); //FormData 생성(form에 들어가있는 정보를 서버로 전달) , name = uploadfile
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
			}); //ajax	
	 });//on
});
</script>
</head>
<body>
<img src="http://localhost:8080/test/upload/불편한편의점.jpeg">
<form action="loginajax2" method="post">
아이디 : <input type=text name="id" id="id"> <br>
pw : <input type=password name="password" id="password"> <br>
<input type=submit value="로그인">
</form>
<input id="ajaxbtn" type=button value="ajax로그인">
<div id="upload">
<!-- action="uploadajax" enctype="multipart/form-data" method="post">
name속성값 = 컨트롤러 전달받을 변수명 (MultipartFile upload)
id속성값 =jquery , js 전달받을 변수명
 -->
<form id="uploadForm">
<input type=file name="uploadfile">
<input id="uploadbtn" type =button value="파일업로드">
</form>
</div>

<div id="ajaxresult"> 로그인 결과 출력</div>

<div><input id="ajaxbtn2" type=button value="멤버리스트 출력"></div>
<input id="ajaxbtn3" type=button value="멤버리스트 1개씩 출력">
<div id="ajaxresult2">멤버정보</div>
<div id ="ajaxresult3">클릭한 회원 일부 암호보여주기</div>
<div id ="ajaxresult4">파일 업로드 결과 보여주기</div>
</body>
</html>