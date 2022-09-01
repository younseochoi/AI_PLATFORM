<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>team4-bookstore</title>
<script src="resources/js/jquery-3.6.0.min.js"></script>
<link href="resources/css/product/searchresult.css?ver=1" rel="stylesheet" type="text/css">
<script>
$(document).ready(function(){
	
});
</script>
<style>
body{
        margin: 0;
        /*font-family : 'gulim', 'gothic';*/
        position: relative;
     }
   .main{
        position: relative;
        top: 0px;
        align-items: center;
        width: 100%;
        min-width: 1280px;
        min-height: 180vh;
        /*height: 180%;*/
        background-color: rgb(240, 240, 240);
    }
    .main .section1{
        position: relative;
        display :flex;
        flex-direction : row;
       /*  align-items: center; */
        justify-content:center;
        top: 20px;
        width: 72%;
        min-height: 140vh;
        padding: 20px 10px 20px 10px;
        margin: 0 auto;
        border: 1px solid black;
        /* border-top:none; */
        background-color: white;
    }
     .main .section2{
        position: relative;
        align-items: center;
        top: 50px;
        width: 72%;
        min-height: 440px;
        padding: 20px 10px 20px 10px;
        margin: 0px auto;
        border: 1px solid black;
        border-bottom:none;
        border-radius : 5px;
        background-color: white;
    }
     .main .section2 .title{
        position: relative;
        width: 100%;
       
        font-size: xx-large;
        font-weight: 700;
        padding: 0 0 0 20px;
        margin: 0px auto;
        /*border: 1px solid black; */
        margin-bottom: 20px;
        color:#405b7c;
    }
 
    .main .section2 .category{
         position:relative;
         /*display: block;*/
         width: 95%;
         flex-direction: column;
         flex-wrap: wrap;
         justify-content: space-evenly;
         margin: 0px auto;
         min-height: 300px;
         align-items: center;
         align-content: center;
         border-radius :5px;
         padding: 20px 0px 20px 0px;
          background-color: rgba(204,220,215,0.3); 
        /*  border: 1px solid black; */
    }
    
    .main .section1 .left{
    	/* position :absolute; */
    	border: 1px solid black;
    	border-radius : 5px 0 0 5px;
    	border-right:none;
    	width: 20%;
    	height: 100%;
    }
    .main .section1 .right{
    	border: 1px solid black;
    	/* border-left:none; */
    	border-radius : 0 5px 5px 0;;
    	width: 75%;
    	height: 100%;
    }
    .main .section1 .left .category_list{
    	/* position:relative; */
    	/* border:1px solid black;  */
    	width: 100%;
    	height: 40%
    	padding : 20px 20px 20px 20px;
    }
    .main .section1 .left .category_list a{
    	text-decoration : none;
    	color: black; 
    }
    .main .section1 .left .category_list a:hover{
    	color: royalblue;
    }
    .main .section1 .left .category_list .list1{
    	height: 30px;
    	padding:3px 10px 0px 10px;
    }
    .main .section1 .left .category_list hr{
    	margin :0;
    }
     .main .section1 .left .category_list .text1{
     	margin-top:5px;
        color: #405b7c;
        font-size: large;
        font-weight: 700;
        /* background-color: #405b7c; */
    }
    /* .main .section1 .category .text1:hover{
        color: green;
    } */
    .main .section1 .right .menu1{
    	/* position:relative;
    	display:flex; */
    	flex-wrap:wrap;
    	border: 1px solid black;
    	/* min-height:900px; */
    	border-radius :5px;
    	margin: 20px 25px 20px 25px;
    	padding:  20px 25px 20px 25px;
    }
    .main .section1 .right .menu1 .top{
    	position:relative;
    	display : flex;
    	flex-flow:row;
    	font-size: 20px;
    	font-weight: 700;
    	align-items:center;
    	justify-content:space-between;
    	color :  #405b7c;
    	/* border: 1px solid black; */
    }
    .main .section1 .right .menu1 .top .btn{
    	/* border: 1px solid black; */
    	text-align:center;
    	width: 60px;
    }
    /* bottom1 bottom2 영역은똑같음 */
    .main .section1 .right .menu1 .bottom1, .bottom2{
    	position :relative;
    	display:flex;
    	flex-flow:row;
    	flex-wrap:wrap;
    	justify-content:flex-start;
    	/* border: 1px solid black; */
    	margin-top: 10px;
    }
    .main .section1 .right .menu1 .item{
    	width: 165px;
    	min-height:220px;
    	flex-flow : wrap;
		text-align:center;
    	/* border: 1px solid black; */
    	
    }
    .main .section1 .right .menu1 .item img{
    	width : 100px;
    	height: 150px;
    	margin:12px 0 5px 0; 
    }
    .main .section1 .right .menu1 .item .description{
    	width: 100%;
    /* 	border: 1px solid black; */
    }
    .main .section1 .right .menu1 .item .description .book_name{
   		margin-top:3px;
    	font-weight: 600;
    }
    .main .section1 .right .menu1 .item .description .writer{
    	margin-top:3px;
    	font-size: 14px;
    }
  
	.description a{
		text-decoration: none;
		color: black;
	}   
   .description a:hover{
   		color:royalblue;
   }
    .footer {
            position: relative;
            top: 0px;
            width: 100%;
            min-width: 1280px;
            height: 5vh;
            background-color: #405b7c;
        }
</style>
</head>
<body>
<!-- 상단바  -->
<jsp:include page="../nav.jsp"> <jsp:param value="false" name="login"/></jsp:include>
<main class="main">
      
         <section class="section1">
         	<div class="left">
         		<div class="category_list">
         		
         			<div class="list1 text1">국내도서</div>
         			<div class="list1"><a href="">소설</a></div>	
         			<div class="list1"><a href="">시</a></div>
         			<div class="list1"><a href="">인문학</a></div>
         			<div class="list1"><a href="">과학</a></div>
         			<div class="list1"><a href="">IT</a></div>
         		</div>
         		<hr>
         		<div class="category_list">
         			<div class="list1 text1">해외도서</div>
         			<div class="list1"><a href="">소설</a></div>	
         			<div class="list1"><a href="">시</a></div>
         			<div class="list1"><a href="">인문학</a></div>
         			<div class="list1"><a href="">과학</a></div>
         			<div class="list1"><a href="">IT</a></div>
         		</div>
         	</div>
         	
         	<div>
         	<h1> 리뷰 쓰기 폼 </h1>
			<form action="reviewwrite" method=post>
			제목:<input type=text name="title" ><br>
			점수:<select name="rating" id="rating">
			<option value="1">1점</option>
			<option value="2">2점</option>
			<option value="3">3점</option>
			<option value="4">4점</option>
			<option value="5">5점</option>
			</select><br>
			내용:<textarea rows=10 cols=100 name="contents" > test </textarea><br>
			
			작성자:<input type=text name="member_id"><br> 
			책정보:<input type=text name="book_id"><br>
			<!-- 작성자:<input type=text name="member_id" value="${sessionid }" readonly ><br>  -->
			<!-- 책정보:<input type=text name="book_id" value="${session_bookid }" readonly ><br>  -->
			<input type=submit value="글쓰기">
			</form>
         	</div>
         	
        </section>
    </main>
    
    <footer class="footer">
    </footer>

</body>
</html>





