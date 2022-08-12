<%@page import="java.util.HashMap"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<% String array[] = {"red", "black","white","green","blue"};  
pageContext.setAttribute("colors", array);
%>
${pageScope.colors[0] }:${colors[0].toUpperCase() }<br>
${pageScope.colors[1] }:${colors[1] }<br>
${pageScope.colors[2] }:${colors[2] }<br>
${pageScope.colors[3] }:${colors[3] }<br>
${pageScope.colors[4] }:${colors[4] }<br>
${Integer.parseInt("100") }

<hr>
<jsp:useBean id="memberlist" class="java.util.ArrayList" />
<jsp:useBean id="dto6" class='dto.MemberDTO'  />
<jsp:setProperty property="id" name="dto6" value="mem6"/>
<% 
memberlist.add(new MemberDTO("MEM1",1,"회원1","폰1","이메일1","2022-07-12"));
memberlist.add(new MemberDTO("MEM2",2,"회원2","폰1","이메일1","2022-09-12"));
memberlist.add(new MemberDTO("MEM3",3,"회원3","폰1","이메일1","2012-08-12"));
memberlist.add(new MemberDTO("MEM4",4,"회원4","폰1","이메일1","2022-08-12"));
memberlist.add(new MemberDTO("MEM5",5,"회원5","폰1","이메일1","2022-08-12"));
memberlist.add(dto6);
%>
${memberlist[0]} - ${memberlist.get(0)}<br>
${memberlist[1]} - ${memberlist.get(0)}<br>
${memberlist[2]} - ${memberlist.get(0)}<br>
${memberlist[3]} - ${memberlist.get(0)}<br>
${memberlist[4]} - ${memberlist.get(0)}<br>
${memberlist[5].id} - ${memberlist[5].name}<br>
<hr>
<%  
HashMap<String, String> map = new HashMap();
map.put("빨강", "red");//저장
map.put("주황", "orange");
map.put("노랑", "yellow");
map.put("초록", "green");
map.put("파랑", "blue");
map.put("남색", "navy");
map.put("빨강", "purple");//수정
map.put("colors", "black");
pageContext.setAttribute("colormap", map);
%>
${colormap["빨강"]}<br>
${empty colormap["빨강색"]?"해당색없음":colormap["빨강색"]}<br>
${colormap.colors }<br>
</body>
</html>








