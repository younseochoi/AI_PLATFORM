<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>team4-bookstore</title>
<script src="resources/js/jquery-3.6.0.min.js"></script>

<script>
$(document).ready(function(){
	
});
</script>
<style>
@charset "UTF-8";
 @import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@800&display=swap');
  body {
            margin: 0;
            /*font-family : 'gulim', 'gothic';*/
            position: relative;
        }
        .header {
            position: relative;
            top: 0px;
            width: 100%;
            height: 6vh;
            background-color: white;
            /*border: 1px solid black;*/
        }
        .header2 {
            position: relative;
            display: flex;
         
            flex-wrap: nowrap;
            top: 0px;
            width: 100%;
            height: 12vh;
            background-color: white;
            border-bottom : 2px solid #405b7c; 
            /* border: 1px solid black; */
        }
        .header .nav {
            position: relative;
            display: flex;
            align-items: center;
            justify-content: space-between;
            top: 0px;
            margin: 0px auto;
            width: 70%;
            background-color:white;
            height: 100%;
            /*border: 1px solid black;*/
        }
        .header2 .nav2 {
            position: relative;
            display: flex;
            flex-wrap: nowrap;
            align-items: center;
           	justify-content: center; 
           	
            top: 0px;
            margin: 0px auto;
            width: 750px;
            padding-bottom: 10px;
           /*  background-color:white; */
         	height: 100%;
           /*  border: 1px solid black; */
        }
        .header .nav .logo {
            position: relative;
            align-items: center;
            float: left;
            font-weight: 500;
            background-color: white;
            width: 180px;
            justify-content: space-between;
            /*height: 100%;*/
            /*border: 1px solid black;*/
            cursor: pointer;
        }
        .header .nav .logo a {
            text-decoration: none;
            color: black;
            font-size: 14pt;
        }
        .header .nav .logo a:hover {
            /*text-decoration: none;*/
            color: royalblue;
            /*font-size: 14pt;*/
        }
        .header .nav .menu {
            position: relative;
            align-items: center;
            text-align: right;
            display: flex;
            justify-content: right;
            background-color: white;
            width: 50%;
            /*height: 100%;*/
            /*border: 1px solid black;*/
            cursor: pointer;
        }
        .header .nav .menu .menu1 {
            position: relative;
            align-items: center;
            float: left;
            background-color: white;
            width: 200px;
            /*height: 100%;*/
            /*border: 1px solid black;*/
            cursor: pointer;
        }
        .a1 {
            text-decoration: none;
            color: black;
        }
        .a1:hover {
            color: royalblue;
        }
        .header2 .nav2  .logo{
       
        	width: 30%;
        }
        .header2 .nav2  .logo img{
        	width: 200px;
        	height: 60px;
        }
        .header2 .nav2 .menu{
        	width:600px;
        	/* height:100%; */
        	height: 40px;
        	position:relative;
        	display:flex;
        	flex-wrap: nowrap;
       		/* border : 1px solid red; */
        	 margin:0;
        	 padding:0 0 0 40px;
        	align-items: stretch;
        	text-align: center;
        }
       
         .header2 .nav2 .menu input[type=text]{
         	position : relative;
         	flex-wrap: nowrap;
         	width:250px;
         	height: 36px;
         	border: 2px solid #405b7c;
         	padding: 0 3px 0 3px;
         	margin: 0 0 0 0;
         	
         }
          .header2 .nav2 .menu #search_select{
          flex-wrap: nowrap;
          	position : relative;
          	border: 2px solid #405b7c;
          	border-right-style:none;
          	border-radius: 5px 0 0 5px;
          	width: 55px;
           	height: 40px;
			left:4px;
			top: 0.3px;
          	cursor: pointer;
          }
         .header2 .nav2 .menu button[type=submit] {
         flex-wrap: nowrap;
            position: relative;
            width: 55px;
            height: 40px;
   			border: 2px solid #405b7c;
         	margin: 0;
         	border-radius:  0 5px 5px 0;
         	right:5px;
         	bottom:0.3px;
      		/*  align-items: center;
            justify-content: center;  */
         	background: #405b7c;
            color:white;
            cursor: pointer;
        }
        .header2 .nav2 .menu #search_detail_btn {
         	flex-wrap: nowrap;
            position: relative;
            width: 65px;
            height: 40px;
   			border: 2px solid #405b7c;
         	margin-left: 25px;
         	border-radius:  5px;
         	/* right:5px; */
         	bottom:0.3px;
      		/*  align-items: center;
            justify-content: center;  */
         	background: #405b7c;
            color:white;
            cursor: pointer;
        }
        .header2 .nav2 .menu button[type=submit]:hover{
        	border-color : #667b96;
        	background: #667b96;
        }
        .header2 .nav2 .menu #search_detail_btn:hover{
        	border-color : #667b96;
        	background: #667b96;
        }
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
#detail_menu2{
	position:relative;
	display:flex;
	flex-flow:column;
	justify-content: flex-start;
	min-height: 600px;
	/* border: 1px solid black; */
	
}
#detail_menu2 #detail_view{
	position:relative;
	display:flex;
	flex-flow:row;
	justify-content:space-around;
	width:100%;
	min-height: 400px;
	 border: 1px solid black; 
	/* margin-top: 30px;  */

}
#detail_menu2  #detail_view #detail_left{
	position:relative;
	display:flex;
	flex-flow:column;
	margin-left:50px;
	justify-content:flex-start;
	text-align:center;
	width: 30%;
}
#detail_menu2  #detail_view #detail_left #detail_book_image{
	padding-top:50px;
	height: 50%;
	/* border: 1px solid black; */
}
#detail_menu2  #detail_view #detail_left #detail_book_image img{
	width: 200px;
	height: 300px;
}
#detail_menu2  #detail_view #detail_left #detail_book_title{
	/* height: 40px; */
	font-size : 20px;
/* 	margin-top:10px; */
	font-weight:700;
	
}
#detail_menu2 #detail_right{
	position:relative;
	display:flex;
	width: 60%;
	min-height: 300px;
	/* border: 1px solid black; */
	align-items:center;
	justify-content:center;
	text-align: center;
}
#detail_menu2 #detail_right #product_detail_table{
	margin-top:30px;
	width: 300px; 
	min-height: 300px;
	text-align: left;
	/* border: 1px solid black; */
}
/* #detail_menu2 #detail_right #product_detail_table .product_detail_header{
	text-align: left;
} */
#detail_buy, #detail_cart{
	width:100px;
	height: 40px;
	} 
#reviewform{
	position:relative;
	display:flex;
	flex-flow:column;
	min-height: 150px;
	/* border: 1px solid black; */
	padding: 0 20px 20px 40px;
}	
#reviewform_bigtitle{
	font-size: 25px;
	color:#405b7c;
	font-weight: 700;
	margin:20px;
}
#reviewform #reviewform_header{
	/* margin-top:px; */
	position:relative;
	display:flex;
	flex-flow:row;
	height: 30px;
	align-items: center;
	/* padding-left:20px; */
	/* border: 1px solid black; */
}
#reviewform #reviewform_header #reviewform_rating{
	width: 200px;
}
#reviewform #reviewform_header #reviewform_title{
	width: 300px;
	
	
}
#reviewform #reviewform_contents{
	/* width: 300px; */
	min-height: 100px;
	margin-top:10px;
/* 	border: 1px solid black; */
}
#reviewform #reviewform_footer{
	margin-top:5px;
	color: rgb(150,150,150);
	font-size: 14px;
	margin-bottom: 0;
	border-bottom: 2px solid rgb(221,221,221);
}
</style>
</head>
<body>
<!-- 상단바  -->
      <header class="header">
        <nav class="nav">
            <div class="logo"><a href="/bookstore">T E A M 4</a></div>
            <div class="menu">
                <%
                String login2 = (String) session.getAttribute("sessionid");
               System.out.print(login2);
                if(login2 != null){%>
                    <div class="menu1"><a class="a1" href="memberDetail">마이페이지</a></div>
                    <div class="menu1"><a class="a1" href="cart2">장바구니</a></div>
                    <div class="menu1"><a class="a1" href="logout">로그아웃</a></div>
                    <%}else{%>
                        <div class="menu1"><a class="a1" href="registerform">회원가입</a></div>
                        <div class="menu1"><a class="a1" href="loginform">로그인</a></div>
                 <%} %>
            </div>
        </nav>
    </header>
 <header class="header2">
        <nav class="nav2">
          <div class="logo"><img src="resources/images/logo.png" ></div>
            <div class="menu">
           
                <form action="search" method="get">
                <select id="search_select"  name="search_select">
                	<option value="title">제목</option>
                	<option value="writer">지은이</option>
                	<option value="publisher">출판사</option>
                </select>
                    <input type="text" placeholder="검색어 입력" name="keyword">
                    <button type="submit">검색</button>
                </form>
           			<button type="submit" id="search_detail_btn">상세검색</button>
            </div>
        </nav>
    </header>
<main class="main">
         <section class="section1">
         	<div class="left">
         		<div class="category_list">
         		
         			<div class="list1 text1">국내도서</div>
         			<div class="list1"><a href="booklist?category_id=1">소설</a></div>	
         			<div class="list1"><a href="booklist?category_id=2">시</a></div>
         			<div class="list1"><a href="booklist?category_id=3">인문학</a></div>
         			<div class="list1"><a href="booklist?category_id=4">과학</a></div>
         			<div class="list1"><a href="booklist?category_id=5">IT</a></div>
         		</div>
         		<hr>
         		<div class="category_list">
         			<div class="list1 text1">해외도서</div>
         			<div class="list1"><a href="booklist?category_id=6">소설</a></div>	
         			<div class="list1"><a href="booklist?category_id=7">시</a></div>
         			<div class="list1"><a href="booklist?category_id=8">인문학</a></div>
         			<div class="list1"><a href="booklist?category_id=9">과학</a></div>
         			<div class="list1"><a href="booklist?category_id=10">IT</a></div>
         		</div>
         	</div>
         	<div class="right">
         		<div id="detail_menu2">
         			<div id="detail_view">
	         			<div id="detail_left">
	         			<!-- 제목, 이미지, 지은이, 옮긴이, 출판사, 간단줄거리, 가격, 재고, 배송료, 구매하기 버튼, 장바구니 버튼, 구매후기 -->
	         				<div id="detail_book_image"><img src="resources/images/novel/${product_list.image }"></div>
	         				<!-- <div id="detail_book_title"> 책제목</div> -->
	         			</div>
	         			<div id="detail_right">
	         			
	         				<table id="product_detail_table">
	         					<tr><td>책이름 : </td><td> ${product_list.title } </td></tr>
	         					<tr><td>지은이 : </td><td>${product_list.writer }</td></tr>
	         					<tr><td>출판사 : </td><td>${product_list.publisher }</td></tr>
	         					<tr><td>간단 줄거리 : </td><td>${product_list.summary }</td></tr>
	         					<tr><td>구매후기쓰기 : </td><td><button onclick="location.href='reviewwrite'">구매후기</button></td></tr>
	         					<tr><td><button id="detail_buy" onclick="location.href='구매주소';">구매하기</button></td><td><button id="detail_cart" onclick="location.href='cart2/${book_id}';">장바구니</button></td></tr>
	         		
	         				</table>
	         			</div>
         			</div>
	         			<div id="reviewform_bigtitle">구매평</div>
	         		<div id="reviewform">
	         			<div id="reviewform_header">
	         				<div id="reviewform_rating">평점(별모양..넣고싶닼~~)</div>
	         				<div id="reviewform_title">타이틀</div>
	         			</div>
	         			<div id="reviewform_contents">내용</div>
	         			<div id="reviewform_footer">2022-08-19</div>
	         		</div> --%>
	         		<!-- <div id="reviewform">
	         			<div id="reviewform_header">
	         				<div id="reviewform_rating">평점(별모양..넣고싶닼~~)</div>
	         				<div id="reviewform_title">타이틀</div>
	         			</div>
	         			<div id="reviewform_contents">내용</div>
	         			<div id="reviewform_footer">2022-08-19</div>
	         		</div> -->
         			
         		</div>
         	</div>
        </section>
    </main>
    
    <footer class="footer">
    </footer>

</body>
</html>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>team4-bookstore</title>
<script src="resources/js/jquery-3.6.0.min.js"></script>
<link href="resources/css/product/simplesearchresult.css" rel="stylesheet">
<script>
/* $(document).ready(function(){
	var qtt=1;
	$("#detail_prduct_btnl").on("click",function(){
		if($('#qtt').val() >1){
			qtt-=1;
		}else{
			qtt=1;
		}
		$('#qtt').val(qtt);
	});
		qtt -=1; 
	$("#detail_prduct_btnr").on("click",function(){
		if($('#qtt').val() <100){
			qtt+=1;
		}else{
			qtt=100;
		}
		$('#qtt').val(qtt);
	});
	$("#detail_cart").on("click",function(){
		location.href = 'cart2/${book_id}&qtt='+$('#qtt').val();
		
	})
}); */
</script>
<style>
#detail_menu2{
	position:relative;
	display:flex;
	flex-flow:column;
	justify-content: flex-start;
	min-height: 600px;
	/* border: 1px solid black; */
	
}
#detail_menu2 #detail_view{
	position:relative;
	display:flex;
	flex-flow:row;
	justify-content:space-around;
	width:100%;
	height: 400px;
	/*  border: 1px solid black;  */
	/* margin-top: 30px;  */

}
#detail_menu2  #detail_view #detail_left{
	position:relative;
	display:flex;
	flex-flow:column;
	margin-left:50px;
	justify-content:flex-start;
	text-align:center;
	width: 30%;
}
#detail_menu2  #detail_view #detail_left #detail_book_image{
	padding-top:50px;
	height: 50%;
	/* border: 1px solid black; */
}
#detail_menu2  #detail_view #detail_left #detail_book_image img{
	width: 200px;
	height: 300px;
}
#detail_menu2  #detail_view #detail_left #detail_book_title{
	/* height: 40px; */
	font-size : 20px;
/* 	margin-top:10px; */
	font-weight:700;
	
}
#detail_menu2 #detail_right{
	position:relative;
	display:flex;
	width: 60%;
	/* border: 1px solid black; */
	align-items:center;
	justify-content:center;
	text-align: center;
}
#detail_menu2 #detail_right #product_detail_table{
	margin-top:30px;
	width: 300px; 
	height: 300px;
	text-align: left;
	/* border: 1px solid black; */
}
/* #detail_menu2 #detail_right #product_detail_table .product_detail_header{
	text-align: left;
} */
#detail_buy, #detail_cart{
	width:100px;
	height: 40px;
	} 
#reviewform{
	position:relative;
	display:flex;
	flex-flow:column;
	min-height: 150px;
	/* border: 1px solid black; */
	padding: 0 20px 20px 40px;
}	
#reviewform_bigtitle{
	font-size: 25px;
	color:#405b7c;
	font-weight: 700;
	margin:20px;
	border-bottom: 2px solid rgb(200,200,200);
}
#reviewform #reviewform_header{
	/* margin-top:px; */
	position:relative;
	display:flex;
	flex-flow:row;
	height: 30px;
	align-items: center;
	/* padding-left:20px; */
	/* border: 1px solid black; */
}
#reviewform #reviewform_header #reviewform_rating{
	width: 200px;
}
#reviewform #reviewform_header #reviewform_title{
	width: 300px;
	
	
}
#reviewform #reviewform_contents{
	/* width: 300px; */
	min-height: 100px;
	margin-top:10px;
/* 	border: 1px solid black; */
}
#reviewform #reviewform_footer{
	margin-top:5px;
	color: rgb(150,150,150);
	font-size: 14px;
	margin-bottom: 0;
	border-bottom: 2px solid rgb(221,221,221);
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
         			<div class="list1"><a href="booklist?category_id=3">소설</a></div>	
         			<div class="list1"><a href="booklist?category_id=4">시</a></div>
         			<div class="list1"><a href="booklist?category_id=5">인문학</a></div>
         			<div class="list1"><a href="booklist?category_id=2">과학</a></div>
         			<div class="list1"><a href="booklist?category_id=1">IT</a></div>
         		</div>
         		<hr>
         		<div class="category_list">
         			<div class="list1 text1">해외도서</div>
         			<div class="list1"><a href="booklist?category_id=8">소설</a></div>	
         			<div class="list1"><a href="booklist?category_id=9">시</a></div>
         			<div class="list1"><a href="booklist?category_id=10">인문학</a></div>
         			<div class="list1"><a href="booklist?category_id=7">과학</a></div>
         			<div class="list1"><a href="booklist?category_id=6">IT</a></div>
         		</div>
         	</div>
         	<div class="right">
         		<div id="detail_menu2">
         			<div id="detail_view">
	         			<div id="detail_left">
	         			<!-- 제목, 이미지, 지은이, 옮긴이, 출판사, 간단줄거리, 가격, 재고, 배송료, 구매하기 버튼, 장바구니 버튼, 구매후기 -->
	         				<div id="detail_book_image"><img src="resources/images/novel/1984.jpeg"></div>
	         				<!-- <div id="detail_book_title"> 책제목</div> -->
	         			</div>
	         			<div id="detail_right">
	         				<table id="product_detail_table">
	         					<tr><td>책이름 : </td><td>책이름</td></tr>
	         					<tr><td>지은이 : </td><td>지은이</td></tr>
	         					<tr><td>출판사 : </td><td>출판사</td></tr>
	         					<tr><td>간단 줄거리 : </td><td>간줄</td></tr>
	         					<tr><td>수량 : </td><td><button id="detail_prduct_btnl"><</button><input style="width:20px;" type=text  name="quantity" id="qtt" value="1"><button id="detail_prduct_btnr">></button></td></tr>
	         					<tr><td><button id="detail_buy" onclick="location.href='구매주소';">구매하기</button></td><td><button id="detail_cart">장바구니</button></td></tr>
	         					
	         				</table>
	         			</div>
         			</div>
	         			<div id="reviewform_bigtitle">구매평</div>
	         		<div id="reviewform">
	         			<div id="reviewform_header">
	         				<div id="reviewform_rating">평점</div>
	         				<div id="reviewform_title">타이틀</div>
	         			</div>
	         			<div id="reviewform_contents">내용</div>
	         			<div id="reviewform_footer">2022-08-19</div>
	         		</div>
	         		<!-- <div id="reviewform">
	         			<div id="reviewform_header">
	         				<div id="reviewform_rating">평점(별모양..넣고싶닼~~)</div>
	         				<div id="reviewform_title">타이틀</div>
	         			</div>
	         			<div id="reviewform_contents">내용</div>
	         			<div id="reviewform_footer">2022-08-19</div>
	         		</div> -->
         			
         		</div>
         	</div>
        </section>
    </main>
    
    <footer class="footer">
    </footer>

</body>
</html> --%>