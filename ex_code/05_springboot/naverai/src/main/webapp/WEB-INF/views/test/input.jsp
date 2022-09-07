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
	$("#ajaxbtn").on('click', function(){
		$.ajax({
			url : "myoutput", 
			data :  {'request': $("#request").val()},
			type :"get",
			dataType : 'json',
			success : function(fromserver){
			//fromserver={"response":"넌 할 수 있어", "mp3":"20220906161852.mp3"}
			$("#response").html(fromserver.response);
			$("#mp3").attr("src", "naverai/"+fromserver.mp3);
			document.getElementById("mp3").play();
			}//success
				
		});//ajax
	});//on
});//ready end
</script>
</head>
<body>
<!-- <form action="myoutput" >
질문 : <input type=text name="request">
<input type=submit value="대화">
</form> -->

질문 : <input type=text id="request" name="request">
<input id="ajaxbtn" type=button value="대화">

<h3 id=response ></h3>
<audio id="mp3" src="" controls="controls"></audio>
</body>
</html>



