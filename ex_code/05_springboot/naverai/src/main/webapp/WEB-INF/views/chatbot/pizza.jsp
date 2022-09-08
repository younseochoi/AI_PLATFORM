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
	$("input:button").on('click', function(){
		
		$.ajax({
			url:'chatbotresultajax',
			data: {'request' : $("#request").val() , 'event': $(this).val() },
			type:"get",
			dataType:'json',
			success:function(server){
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
						url : 'pizzavoice',
						data : {'text' : server.bubbles[0].data.description},
						type : 'get',
						dataType : 'json',
						success : function (mp3){ //ai_images폴더 mp3파일 저장하고 리턴값 파일명
							var audio = document.getElementById("mp3");
							audio.src="/naverai/" + mp3.mp3;
							audio.play();//즉각재생
						}
					});
					if(server.bubbles[0].data.description.indexOf("주문을 완료하셨습니다") >= 0){
					//주문을 완료하셨습니다. 하와이안피자, 대를 주문하셨습니다. 101111111 번호로 연락드립니다.
						var ordermessage = server.bubbles[0].data.description;
						var order_split = ordermessage.split(" ");
						var kind = order_split[2].split(",")[0];//하와이안피자
						var size = order_split[4].split("를")[0];//대
						var telnum = '0'+order_split[6];
					// ajax로 /pizzaprice 요청 결과 채팅창 출력
					// xxxx 시각에 주문하신 피자는 xxxx 원을 지불하셔야 합니다
					alert(kind+":"+size);
					$.ajax({
						url:"pizzaprice",
						data:{'kind': kind, 'size':size, 'telnum':telnum},
						type :"get",
						dataType:"json",
						success:function(pizzadto){
							$("#chat").append('<p>' + pizzadto.ordertime + ' 시각에 주문하신 피자는 '
									+ pizzadto.price + ' 원을 지불하셔야 합니다</p>');
						}
					});// ajax
					}//주문완료답변if end
					
					}//text답변 if

				}//for 	
			}//success
		});//ajax
	});//on
});//ready end
</script>
</head>
<body>
<div id="chat" width=500 height=500 style="border : 2px solid blue"> 
여기에서 주문을 시작하세요<br> </div>
주문 : <input type=text id="request" name="request">
<input type=button value="답변" >
<input type=button value="채팅시작" >
<audio style="display:none;" id="mp3" src="" controls ></audio>
</body>
</html>





