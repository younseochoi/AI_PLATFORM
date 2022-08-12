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
<% String array[] = {"red", "black","white","green","blue"};  
%>
<c:set var="colors" value="<%=array %>" />

<c:forEach items="${colors }" var="onecolor"  varStatus="vs">
	<h1>${vs.count } 번째 색상 = ${onecolor } </h1>
</c:forEach>

<c:forEach items="${colors }" var="onecolor"  varStatus="vs">
	<c:if test="${vs.first }">
	   <h1>첫번째 색상 = ${onecolor }</h1>
	</c:if>
	<c:if test="${vs.last }">
	   <h1>마지막 색상 = ${onecolor }</h1>
	</c:if>
</c:forEach>

<c:forEach items="${colors }" varStatus="vs">
	<h1>${vs.count } 번째 색상 = ${vs.current} </h1>
</c:forEach>

<c:forEach begin="2" end="10" step="2" var="num" >
  <h1>${num*num }</h1>
</c:forEach>

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
//System.out.println(memberlist.size());
%>

<table border=3>
<c:forEach items="${memberlist}" var="dto" varStatus="vs">
 <tr><td> ${dto.id} 회원님 </td><td>이름 ${dto.name} 입니다. </td></tr>
</c:forEach> 
</table>

<%-- <%
for(int i = 0; i < memberlist.size(); i++){
	out.println(((MemberDTO)memberlist.get(i)).getId()+"<br>");
}

%> --%>
<hr>

<%  
HashMap<String, String> map = new HashMap();
map.put("빨강", "red");//저장(key=value)
map.put("주황", "orange");
map.put("노랑", "yellow");
map.put("초록", "green");
map.put("파랑", "blue");
map.put("남색", "navy");
map.put("빨강", "purple");//수정
pageContext.setAttribute("colormap", map);
%>

<c:forEach items="${colormap }" var="onecolor" varStatus="s" > 
  <h1>${s.count } 번 한국어색상명 ${s.current.key} 는 영문색상명 ${onecolor.value }입니다</h1>
</c:forEach>

<%
HashMap<String, MemberDTO> dtoMap  = new HashMap<String, MemberDTO>();
dtoMap.put("mem1", new MemberDTO("MEM1",1,"회원1","폰1","이메일1","2022-07-12"));
dtoMap.put("mem2", new MemberDTO("MEM2",2,"회원2","폰1","이메일1","2022-09-12"));
dtoMap.put("mem3", new MemberDTO("MEM3",3,"회원3","폰1","이메일1","2012-08-12"));
dtoMap.put("mem4", new MemberDTO("MEM4",4,"회원4","폰1","이메일1","2022-08-12"));
dtoMap.put("mem5", new MemberDTO("MEM5",5,"회원5","폰1","이메일1","2022-08-12"));

%>
<c:set var="dtoMap" value="<%=dtoMap %>"  />
<c:forEach items="${dtoMap }" varStatus="st">
<h1> ${st.current.key } - ${st.current.value.name  } </h1>
</c:forEach>

<c:url var="mypage" value="http://localhost:8080/jsptest/jstl/loginage.jsp" />

<%--<jsp:include 동작태그 --%>
<c:import url="${mypage }" >
	<c:param name="name" value="김대한" />
	<c:param name="age" value="10" />
</c:import>

<%--<jsp:forward 동작태그(유사) --%>
<c:redirect url="${mypage }" >
	<c:param name="name" value="김대한" />
	<c:param name="age" value="10" />
</c:redirect>
	
</body>
</html>











