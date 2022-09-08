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
					
					if(server.bubbles[0].data.description.includes('주문 완료하셨습니다.')){
						alert("주문완");
						var ordermessage = server.bubbles[0].data.description;
						var order_split = ordermessage.split(" ");
						var kind= order_split[2];
						kind = kind.slice(0,-1);
						var size = order_split[4];
						size = size.slice(0,-1);
						alert(size);
						var telnum = order_split[6];
						telnum = telnum.slice(0,-1);
						// ajax 로 pizzaprice 호출 후 가격 보여줌
						$.ajax({
							url : 'pizzaprice',
							data : {'kind' :kind, 'size' : size , 'telnum': telnum },
							type : 'get',
							dataType : 'json',
							success : function (pizzadto){ //ai_images폴더 mp3파일 저장하고 리턴값 파일명
								$("#chat").append("<p><span style='background-color:yellow' >"+pizzadto.ordertime+"시각에 주문하신 피자는 "+pizzadto.price+"원을 지불하셔야 합니다.</span></p>")
								/* var audio = document.getElementById("mp3");
								audio.src="/naverai/" + mp3.mp3;
								audio.play();//즉각재생 */
							}
						});
					}
					
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
여기에 주문을 시작합니다. </div>
질문 : <input type=text id="request" name="request">
<input type=button value="답변" name="replyevent">
<input type=button value="채팅시작" name="welcomeevent">
<audio style="display:none;" id="mp3" src="" controls ></audio>
</body>
</html>