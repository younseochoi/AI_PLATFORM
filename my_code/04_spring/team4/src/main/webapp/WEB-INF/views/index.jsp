<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>team4-bookstore</title>
<script src="resources/js/jquery-3.6.0.min.js"></script>
<link href="resources/css/index.css" rel="stylesheet">
<script src="resources/js/index.js"></script>
<script>
/* function category_btn_click(btn_id){ 
	if(btn_id=='novel_btn_l'){
		var count = ${category_btn_count1-1};
		alert(count);
		if(category_btn_count1==0){
			category_btn_count1=3;
		}
	}else if(btn_id=='novel_btn_r'){
		 category_btn_count1+=1;
		if(category_btn_count1==4){
			category_btn_count1=1;
		}
	}
	
	
} */
		
</script>
 <style>
 
    </style>
</head>
<body>
<!-- 상단바  -->
<jsp:include page="nav.jsp"> <jsp:param value="false" name="login"/></jsp:include>
<main class="main">
       <section class="section2"> 
            <div class ="title">
            <span>역대 베스트 셀러</span>
            <div class="btn"><input id="total_btn_l" type="button" value='<'>&nbsp;<input type="button"  id="total_btn_r" value='>'></div>
            </div>
            <div class="category">
                <div class="product_box">
                   <!--  <div class ="product1">
         				<img src="resources/images/novel/아라의소설.jpeg">
         				<div class="description">
		         			<div class="book_name">아라의 소설</div>
		         			<div class="writer">지은이</div>
         				</div>
                    </div> -->
                </div>
            </div>
       </section>
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
         	<div class="right">
         		<div class="menu1">
         			<div class="top">
         				<div class="title">이달의 베스트셀러</div>
         				<div class="btn"><input type="button" id ="month_btn_l" value='<'>&nbsp;<input type="button" id ="month_btn_r" value='>'></div>
         			</div>
         			<div class="bottom1" id="month_box">
         				<!-- <div class="item">
         					<img src="resources/images/novel/아라의소설.jpeg">
         					<div class="description">
	         					<div class="book_name">아라의 소설</div>
	         					<div class="writer">지은이</div>
         					</div>
         				</div> -->
         			</div>
         		</div>
         		<div class="menu1" >
         			<div class="top">
         				<div class="title">소설 베스트셀러</div>
         				<div class="btn"><input type="button" id ="novel_btn_l" value='<'>&nbsp;<input type="button"  id ="novel_btn_r" value='>'></div>
         			</div>
         			<div class="bottom1" id="novel">
         				<!-- <div class="item">
         					<img src="resources/images/novel/아라의소설.jpeg">
         					<div class="description">
	         					<div class="book_name">아라의 소설</div>
	         					<div class="writer">지은이</div>
         					</div>
         				</div> -->
         			</div>
         		</div> 
         		<div class="menu1" >
         			<div class="top">
         				<div class="title">시 베스트셀러</div>
         				<div class="btn"><input type="button" id ="poetry_btn_l" value='<'>&nbsp;<input type="button"  id ="poetry_btn_r" value='>'></div>
         			</div>
         			<div class="bottom1" id="poetry">
         				<!-- <div class="item">
         					<img src="resources/images/novel/아라의소설.jpeg">
         					<div class="description">
	         					<div class="book_name">아라의 소설</div>
	         					<div class="writer">지은이</div>
         					</div>
         				</div> -->
         			</div>
         		</div> 
         		<div class="menu1" >
         			<div class="top">
         				<div class="title">인문학 베스트셀러</div>
         				<div class="btn"><input type="button" id ="human_btn_l" value='<'>&nbsp;<input type="button"  id ="human_btn_r" value='>'></div>
         			</div>
         			<div class="bottom1" id="human">
         				<!-- <div class="item">
         					<img src="resources/images/novel/아라의소설.jpeg">
         					<div class="description">
	         					<div class="book_name">아라의 소설</div>
	         					<div class="writer">지은이</div>
         					</div>
         				</div> -->
         			</div>
         		</div> 
         		<div class="menu1" >
         			<div class="top">
         				<div class="title">과학 베스트셀러</div>
         				<div class="btn"><input type="button" id ="science_btn_l" value='<'>&nbsp;<input type="button"  id ="science_btn_r" value='>'></div>
         			</div>
         			<div class="bottom1" id="science">
         				<!-- <div class="item">
         					<img src="resources/images/novel/아라의소설.jpeg">
         					<div class="description">
	         					<div class="book_name">아라의 소설</div>
	         					<div class="writer">지은이</div>
         					</div>
         				</div> -->
         			</div>
         		</div> 
         		<div class="menu1" >
         			<div class="top">
         				<div class="title">IT 베스트셀러</div>
         				<div class="btn"><input type="button" id ="it_btn_l" value='<'>&nbsp;<input type="button"  id ="it_btn_r" value='>'></div>
         			</div>
         			<div class="bottom1" id="it">
         				<!-- <div class="item">
         					<img src="resources/images/novel/아라의소설.jpeg">
         					<div class="description">
	         					<div class="book_name">아라의 소설</div>
	         					<div class="writer">지은이</div>
         					</div>
         				</div> -->
         			</div>
         		</div> 
         	</div>
        </section>
    </main>
    
    <footer class="footer">
    </footer>

</body>
</html>