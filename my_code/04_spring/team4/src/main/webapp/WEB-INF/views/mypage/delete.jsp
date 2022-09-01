<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(document).ready(function(){
})
</script>
<style>
body{
		background-color: rgb(240,240,240);
		margin : 0 auto ;
	}
	#pwcheck{
		margin: 0 auto;
		justify-content: center;
		align-items:center;
	}
	#delete_container{
		position:relative;
		display: flex;
		flex-flow: column; 
		height: 500px;
		width:100%;
		margin: 0 auto;
		justify-content: center;
		align-items:center;		
		
	}
	#delete_item{		
		margin-top: 50px;
		width:400px;
		height:400px;
		border-radius:10px;
		background-color:white;
	}
	#delete_header{
		text-align: center;
		position:relative;
		padding:30px 0 10px 0;
		font-weight: 700;
		font-size: 19px;
	}

</style>
</head>
<body>
<jsp:include page="../nav.jsp"> <jsp:param value="false" name="login"/></jsp:include>
   <form action="deletemember" method="post" id="deleteForm" name="deleteForm">
   <input type="hidden" id="id" name="id" value="${sessionid}">
    <div id="delete_container">
        <div id="delete_item">
                <p id="delete_header">회원탈퇴를 하려면 비밀번호를 입력해주세요.</p>
                <hr>
                <div id="pwcheck">
                <table>
                <tr>
                	<td>
                   	 	<input type="password" id = "pw" name="pw" placeholder="비밀번호" />                 	 	  
               	 	</td>
               	</tr>
               	<tr> 	
               	 	<td> 
                    	<input type="password" id="memberPw2" name="memberPw2"  placeholder="비밀번호 확인" />
                	</td>    
                </tr>
                <tr>
                	<td>
               			<input type="button" id="delete" name="delete"  value="회원탈퇴" onclick="deletebtn()"/>
                		<input type="button" onclick="back()" value="취소"/>
                	</td>
                </tr>
               </table> 
               </div>
        	</div>
    	</div>
    </form>    
<script>
	function back(){
		history.back();
	}
	function deletebtn(){		
		if($("#pw").val()==""){
			alert("비밀번호를 입력해주세요");
			$("#pw").focus();
			return false
		}
		
		if($("#memberPw2").val()==""){
			alert("비밀번호 확인을 입력해주세요");
			$("#memberPw2").focus();
			return false
		}
		
		if ($("#pw").val() != $("#memberPw2").val()) {
			alert("비밀번호가 일치하지 않습니다.");
			$("#pw").focus();			 
			return false;			
		}
		$("#deleteForm").submit();
		alert("탈퇴되셨습니다.")
	}
</script>


    
</body>
</html>