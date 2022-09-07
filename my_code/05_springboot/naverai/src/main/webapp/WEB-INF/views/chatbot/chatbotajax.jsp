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
	$("input:button").on('click', function(){
		$.ajax({
			url:'chatbotresultajax',
			data: {'request' : $("#request").val() , 'event': $(this).val() },
			type:"get",
			dataType:'json',
			success:function(server){
				//alert(server.bubbles[0].data.description);
				$("#chat").append("<p><span style='background-color:aqua' > 나 : " + $("#request").val() +"</span></p>");
				
				var bubbles = server.bubbles;
				for(var i = 0; i < bubbles.length; i++){
					if(bubbles[i].type == 'text'){
						//텍스트답변
					$("#chat").append
					("<p><span style='background-color:pink' >답변 : " + server.bubbles[0].data.description +"</p>");
					$("#mp3").css("display", "inline");
					
					
					// ajax 로 voiceservice 호출
					$.ajax({
						url : 'chatbotvoice',
						data : {'text' : server.bubbles[0].data.description},
						type : 'get',
						dataType : 'json',
						success : function (mp3){ //ai_images폴더 mp3파일 저장하고 리턴값 파일명
							var audio = document.getElementById("mp3");
							audio.src="/naverai/" + mp3.mp3;
							audio.play();//즉각재생
						}
					});
					}//text답변 if
					else if(bubbles[i].type == 'template'){
						//멀티링크답변이나 이미지답변 
						if(bubbles[i].data.cover.data.imageUrl != null ){
							$("#chat").append
							("<img src=" + bubbles[i].data.cover.data.imageUrl + " width=200 height=200><br>");
						}//이미지답변
						else if(bubbles[i].data.cover.type == "text"){
							$("#chat").append
							("<p><span style='background-color:pink' >답변 : " 
									+ server.bubbles[0].data.cover.data.description +"</p>");
							//contentTable변수 배열
							for(var j = 0; j < bubbles[i].data.contentTable.length; j++){
								for(var k = 0; k < bubbles[i].data.contentTable[j].length; k++ ){
									var linkname = bubbles[i].data.contentTable[j][k].data.title;
									var url = bubbles[i].data.contentTable[j][k].data.data.action.data.url;
									$("#chat").append("<a href=" + url + " >" + linkname + "</a><br>");
									//<a href=url변수>linkname변수</a>
								}
							}
						}//멀티링크답변

					
				}
				
			}
			}
		});//ajax
	});//on
});//ready end
</script>
</head>
<body>
<div id="chat" width=500 height=500 style="border : 2px solid blue"> 
여기에 대화 내용을 표시합니다 </div>
질문 : <input type=text id="request" name="request">
<input type=button value="답변" name="replyevent">
<input type=button value="채팅시작" name="welcomeevent">
<audio style="display:none;" id="mp3" src="" controls ></audio>
</body>
</html>