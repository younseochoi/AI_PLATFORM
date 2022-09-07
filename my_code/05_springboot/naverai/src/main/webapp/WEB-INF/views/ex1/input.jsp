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
	$("#ajaxbtn").on("click",function(){
		var question = $('#questionform').val();
		var audio = document.getElementById("myaudio");
	
		//alert(question);
		$.ajax({
			url : "myoutput",
			data : {'question':question },
			datatype :'json',
			success : function(server){
				//alert(server);
				var output = "Q. "+question+"<br>";
				output+="A. "+server.textresult+"<br>";
				output+="<audio id='myaudio' src='/naverai/"+server.voiceresult+"'autoplay controls></audio><br>";
				$('#response').append(output);
				
			}
		});//ajax end 
	});//ajaxbtn end
});//ready end
</script>
</head>
<body>
<!-- <form action="myoutput">
<input type="text" placeholder="질문을 입력해보세요." name="question">
<input type="submit" value="질문하기">
</form> -->
<input id ="questionform" type="text" placeholder="질문을 입력해보세요." name="question">
<input id="ajaxbtn" type="button" value="질문하기">
<div id="response"></div>
</body>
</html>