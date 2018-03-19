
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
<!DOCTYPE html>
<%
//일반적인 자바소스코드가 작성되는 영역 
Member loginUser = (Member)session.getAttribute("loginUser");
%>


<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>first jsp</title>

<link rel="stylesheet" type="text/css" href="/FWP/resources/css/newcss.css">

</head>

<body>

<%
if(loginUser !=null && loginUser.getUserid().equals("admin")){
%>
	<%@ include file ="Header.jsp"%>
<% }else{%>
	<%@ include file="Header1.jsp" %>
<% }%>



<nav>
<hr style="clear:both">
<img src="images/11.jpg" width="295" height="171" border="0" alt="" style="float:left;">

<%
if(loginUser==null) {
%>

<form method="post" action="login"><!--서블릿의 매핑이름이 액션이름이다.  -->
<table width="220" height="85">
		<tr height="25">
		<td width="170"> 		<input type="text" name="userid"> 		</td> 
		<td rowspan="2" >		<input type="submit" value="로그인">		</td>
		</tr>
		<tr height="25">
		<td width="170"> <input type="password" name="password"> </td><td></td></tr>
		<tr height="25">
		<td width="170"> <a href="/FWP/view/member/enroll.html">회원가입</a>
		</td><td>아디비번찾기</td></tr>
	</table>
</form>
</nav>
<%}else{ %>
<table width="220" height="85">

<tr>

<td><%= loginUser.getUserName() %> 새킈</td>
<td><a href="/FWP/logout">로그아웃</a></td>

</tr>
<tr height="25">

<!--  쿼리 스트링, a 태그에서 사용함. 컨트롤러에게 전송할 값을 지정함. 


href="대상이름 ?이름 이름=값"
a태그는 전송방식이 get임.


-->
<td><a href="/FWP/MD?userid=<%=loginUser.getUserid()%>">내정보보기</a></td>
<td>&nbsp;</td>

</tr>
</table>
<%} %>
<hr style="clear:both">
<%@ include file="footer.html" %>

</body>
</html>