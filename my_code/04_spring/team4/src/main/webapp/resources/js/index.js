/**
 * 
 */
 $(document).ready(function(){
	var total_btn_count=1;
	var month_btn_count=1;
	var category_btn_count1=1; //소설
	var category_btn_count2=1;//시
	var category_btn_count3=1;//인문학
	var category_btn_count4=1;//과학
	var category_btn_count5=1;//it
	var category_name;
	var categories = ['novel','poetry','human','science','it'];
	
	function setCategories(){
		for(let j =0;j<categories.length;j++){
		
			$.ajax({
				url :'categorybestseller',
				data : {'page': '1', 'category': categories[j] }, 
				/* type :'get', */
				datatype :'json', /* 서버로 부터 받아오는거 json이야*/
				success: function(server){
					for(let i = 0 ; i < server.length; i++){
						var imgpath = "resources/images/novel/"+server[i].image;
						var description = "<div class='description'>"+"<div class='book_name'><a href='productdetail/"+server[i].book_id+"'>"+server[i].title+"</a></div>"
									+"<div class='writer'>"+server[i].writer+"</div></div>";
						var init_tag = "#"+categories[j]	;		
						$(init_tag).append("<div class='item' id='item1'><img src = "+imgpath+">"+description+'</div>');
					}  //for
				}
		}); //ajax
		}
	}
	function total_bestseller() { 
			$.ajax({
				url :'totalbestseller',
				data : {'page': total_btn_count}, 
				/* type :'get', */
				datatype :'json', /* 서버로 부터 받아오는거 json이야*/
				success: function(server){
					for(let i = 0 ; i< server.length; i++){
						var imgpath = "resources/images/novel/"+server[i].image;
						var description = "<div class='description'>"+"<div class='book_name'><a href='productdetail/"+server[i].book_id+"'>"+server[i].title+"</a></div>"
									+"<div class='writer'>"+server[i].writer+"</div></div>";
						$(".product_box").append("<div class='product1'><img src = "+imgpath+">"+description+'</div>');
					}  //for
				}
		}); //ajax
	}; //total_bestseller
	function month_bestseller() { 
		$.ajax({
			url :'monthbestseller',
			data : {'page': month_btn_count}, 
			/* type :'get', */
			datatype :'json', /* 서버로 부터 받아오는거 json이야*/
			success: function(server){
				for(let i = 0 ; i< server.length; i++){
					var imgpath = "resources/images/novel/"+server[i].image;
					var description = "<div class='description'>"+"<div class='book_name'><a href='productdetail/"+server[i].book_id+"'>"+server[i].title+"</a></div>"
								+"<div class='writer'>"+server[i].writer+"</div></div>";
					$("#month_box").append("<div class='item' id='item1'><img src = "+imgpath+">"+description+'</div>');
				}  //for
			}
	}); //ajax
}; //month_bestseller
function category_bestseller(page) { 
	$.ajax({
		url :'categorybestseller',
		data : {'page': page, 'category': category_name }, 
		/* type :'get', */
		datatype :'json', /* 서버로 부터 받아오는거 json이야*/
		success: function(server){
			for(let i = 0 ; i< server.length; i++){
				var imgpath = "resources/images/novel/"+server[i].image;
				var description = "<div class='description'>"+"<div class='book_name'><a href='productdetail/"+server[i].book_id+"'>"+server[i].title+"</a></div>"
							+"<div class='writer'>"+server[i].writer+"</div></div>";
				$("#"+category_name).append("<div class='item' id='item1'><img src = "+imgpath+">"+description+'</div>');
			}  //for
		}
}); //ajax
}; //category_bestseller
	
	total_bestseller(); //메인페이지 처음 로딩시 page = 1로 세팅
	month_bestseller();
	setCategories();
	
	$('#total_btn_r').on('click',function(){
		total_btn_count+=1;
		if(total_btn_count==4){
			total_btn_count=1;
		}
		
		$('.product_box').html("");
		/* $(".product1 img").remove();
		$('.product1 .description').remove();
		$('.product1').remove(); */
		
		total_bestseller();
		
	});//total_btn_r
	
	$('#total_btn_l').on('click',function(){
		total_btn_count-=1;
		if(total_btn_count==0){
			total_btn_count=3;
		}
		
		$('.product_box').html("");
		/* $(".product1 img").remove();
		$('.product1 .description').remove();
		$('.product1').remove(); */
		
		total_bestseller();
		
	});//total_btn_l
	
	$('#month_btn_l').on('click',function(){
		month_btn_count-=1;
		if(month_btn_count==0){
			month_btn_count=3;
		}
		
		$('#month_box').html("");
		/* $(".item1 img").remove();
		$('.item1 .description').remove();
		$('.item1').remove(); */
		
		month_bestseller();
		
	});//month_btn_l
	
	$('#month_btn_r').on('click',function(){
		month_btn_count+=1;
		if(month_btn_count==4){
			month_btn_count=1;
		}
		
		$('#month_box').html("");
		/* $(".item1 img").remove();
		$('.item1 .description').remove();
		$('.item1').remove(); */
		
		month_bestseller();
		
	});//month_btn_l
	
	$('#novel_btn_l, #poetry_btn_l #human_btn_l, #science_btn_l, #it_btn_l').on('click',function(){
		//alert($(this).attr("id"));
		var btn_id = $(this).attr("id");
		/* for(let i =0; i< categories.length;i++){
			if(btn_id.indexOf(categories[i])!=-1){
				category_name = categories[i];
				var tmp = category_name+i;
				tmp +=1; 
				alert(tmp);
				$("#"+category_name).html("");
				break;
			}
		} */
			var count=1;
		if(btn_id.indexOf(categories[0])!=-1){
			category_name = categories[0];
			category_btn_count1-=1; //소설
			$("#novel").html("");
			if(category_btn_count1==0){
				category_btn_count1=3;
			}
			count = category_btn_count1;
		}
		else if(btn_id.indexOf(categories[1])!=-1){
			category_name = categories[1];
			category_btn_count2-=1; //시
			$("#poetry").html("");
			if(category_btn_count2==0){
				category_btn_count2=3;
			}
			count = category_btn_count2;
		}
		else if(btn_id.indexOf(categories[2])!=-1){
			category_name = categories[2];
			category_btn_count3-=1; //인문학
			$("#human").html("");
			if(category_btn_count3==0){
				category_btn_count3=3;
			}
			count = category_btn_count3;
		}
		else if(btn_id.indexOf(categories[3])!=-1){
			category_name = categories[3];
			category_btn_count4-=1; //과학
			$("#science").html("");
			if(category_btn_count4==0){
				category_btn_count4=3;
			}
			count = category_btn_count4;
		}
		else if(btn_id.indexOf(categories[4])!=-1){
			category_name = categories[4];
			category_btn_count5-=1; //인문학
			$("#it").html("");
			if(category_btn_count5==0){
				category_btn_count5=3;
			}
			count = category_btn_count5;
		}
		category_bestseller(count);
		/* month_btn_count+=1;
		if(month_btn_count==4){
			month_btn_count=1;
		}
		
		$('#month_box').html(""); */
		/* $(".item1 img").remove();
		$('.item1 .description').remove();
		$('.item1').remove(); */
		
		//month_bestseller();
		
	});//category_btn_l
	
	$('#novel_btn_r, #poetry_btn_r, #human_btn_r, #science_btn_r, #it_btn_r').on('click',function(){
		//alert($(this).attr("id"));
		var btn_id = $(this).attr("id");
			var count=1;
		if(btn_id.indexOf(categories[0])!=-1){
			category_name = categories[0];
			category_btn_count1+=1; //소설
			$("#novel").html("");
			if(category_btn_count1==4){
				category_btn_count1=1;
			}
			count = category_btn_count1;
		}
		else if(btn_id.indexOf(categories[1])!=-1){
			category_name = categories[1];
			category_btn_count2+=1; //시
			$("#poetry").html("");
			if(category_btn_count2==4){
				category_btn_count2=1;
			}
			count = category_btn_count2;
		}
		else if(btn_id.indexOf(categories[2])!=-1){
			category_name = categories[2];
			category_btn_count3+=1; //인문학
			$("#human").html("");
			if(category_btn_count3==4){
				category_btn_count3=1;
			}
			count = category_btn_count3;
		}
		else if(btn_id.indexOf(categories[3])!=-1){
			category_name = categories[3];
			category_btn_count4+=1; //과학
			$("#science").html("");
			if(category_btn_count4==4){
				category_btn_count4=1;
			}
			count = category_btn_count4;
		}
		else if(btn_id.indexOf(categories[4])!=-1){
			category_name = categories[4];
			category_btn_count5+=1; //인문학
			$("#it").html("");
			if(category_btn_count5==4){
				category_btn_count5=1;
			}
			count = category_btn_count5;
		}
		category_bestseller(count);
	
		
	});//category_btn_r
	/*<div bottom> 
	<div class="item">
		<img src="resources/images/novel/아라의소설.jpeg">
		<div class="description">
			<div class="book_name">아라의 소설</div>
			<div class="writer">지은이</div>
		</div>
	</div> */
});