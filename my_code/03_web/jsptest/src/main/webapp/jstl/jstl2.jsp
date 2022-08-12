<%@page import="java.util.HashMap"%>
<%@page import="dto.MemberDTO"%>
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
	
});
</script>
</head>
<body>
<% 
String array[] ={"red", "black","white","green","blue"}; 
%>
<c:set var="colors" value="<%=array %>"/>
<c:forEach items="${colors }" var="onecolor">
	<h1>${onecolor }</h1>
</c:forEach>
<c:forEach items="<%=array %>" varStatus="vs">
	<h1>${vs.count}번째 색상 =%{ondeclolor}</h1> <!--count = vs.index+1  -->
</c:forEach>
<c:forEach items="${colors }" var="onecolor" varStatus="vs">
	<c:if test="${ vs.first}">	
	<h1>첫번째 ${onecolor }</h1>
	</c:if>
	<c:if test="${ vs.last}">	
	<h1>마지막 ${onecolor }</h1>
	</c:if>
	
</c:forEach>
<hr>
<hr>
<c:forEach items="${colors }" varStatus="vs">
	<h1>${vs.count}번째 색상 = ${vs.current}</h1> <!--count = vs.index+1  -->
</c:forEach>

<c:forEach begin="2" end="10" step="2" var="num">
	<h1>${num*num}</h1>
</c:forEach>

${pageScope.colors[0] } : ${ colors[0].toUpperCase()} <br>
${pageScope.colors[1] } : ${ colors[1]} <br>
${pageScope.colors[2] } : ${ colors[2]} <br>
${pageScope.colors[3] } : ${ colors[3]} <br>
${pageScope.colors[4] } : ${ colors[4]} <br>
${Integer.parseInt("100")+100 }<br>

<hr>
<jsp:useBean id="memberlist" class="java.util.ArrayList"/>
<jsp:useBean id="dto6" class="dto.MemberDTO"/>
<jsp:setProperty property="id" name="dto6" value="MEM6"/>

<%
memberlist.add(new MemberDTO("MEM1",1,"회원1","폰1","이메일1","2022-08-12"));
memberlist.add(new MemberDTO("MEM2",1,"회원2","폰1","이메일1","2022-04-11"));
memberlist.add(new MemberDTO("MEM3",1,"회원3","폰1","이메일1","2022-01-17"));
memberlist.add(new MemberDTO("MEM4",1,"회원4","폰1","이메일1","2022-12-02"));
memberlist.add(new MemberDTO("MEM5",1,"회원5","폰1","이메일1","2020-10-01"));
memberlist.add(dto6);
%>

<table border=1>
<c:forEach items="${memberlist}" var="dto">
	<tr><td>${dto.id }</td><td>${dto.name}</td></tr>
</c:forEach>
</table>


<hr>
<% 
HashMap <String, String> map = new HashMap();
map.put("빨강","red");
map.put("주황","orange");
map.put("노랑","yellow");
map.put("초록","green");
map.put("파랑","blue");
map.put("남색","navy");
map.put("보라","purple");

pageContext.setAttribute("colormap", map);
%>
<c:forEach items="${colormap }" var="onecolor" varStatus="s">
	<h1 style="color:orange">${onecolor }</h1>
	<h1 style="color:green">${s.count}. 한국어 색상명으로 ${s.current.key}은 영문색상명 ${onecolor.value } 입니다.</h1>
</c:forEach>

<%
HashMap<String, MemberDTO> dtomap = new HashMap<String, MemberDTO>();
dtomap.put("mem1",new MemberDTO("MEM1",1,"회원1","폰1","이메일1","2022-08-12"));
dtomap.put("mem2",new MemberDTO("MEM2",1,"회원2","폰1","이메일1","2022-04-11"));
dtomap.put("mem3",new MemberDTO("MEM3",1,"회원3","폰1","이메일1","2022-01-17"));
dtomap.put("mem4",new MemberDTO("MEM4",1,"회원4","폰1","이메일1","2022-12-02"));
dtomap.put("mem5",new MemberDTO("MEM5",1,"회원5","폰1","이메일1","2020-10-01"));

%>
<c:set var="dtoMap" value ="<%=dtomap %>"/>
<c:forEach items="${dtoMap }" varStatus="st">
	<h1 style="color:pink"> 순서가 없는 해시맵 ${st.current.key } - ${st.current.value.name }</h1>
</c:forEach>

<hr>
<c:url var="mypage" value="http://localhost:8080/jsptest/jstl/loginage.jsp" />

<%--<jsp:include 태그 --%>
<c:import url="${mypage }">
	<c:param name="name" value="김원회"/>
	<c:param name="age" value="11"/>
</c:import>

<%--<jsp:forward 태그 --%>
<c:redirect url="${mypage }">
	<c:param name="name" value="김원회"/>
	<c:param name="age" value="11"/>
</c:redirect>

</body>
</html>