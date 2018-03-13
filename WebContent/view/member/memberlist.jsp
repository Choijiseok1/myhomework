<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,member.model.vo.*" %>
   <%
   ArrayList<Member> list =(ArrayList<Member>)request.getAttribute("list");
   %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원조회</title>
</head>
<body>
<h2 align="center">회원조회 </h2>
<table border="1" width="1800">
<tr>
<th>순번</th>
<th>아이디</th>
<th>이름</th>
<th>나이</th>
<th>성별</th>
<th>전화번호</th>
<th>이메일</th>
<th>취미</th>
<th>특이사항</th>
<th>가입날짜</th>
<th>마지막정보갱신날</th>
<th>로그인권한제한</th>
<th>로그인권한풀기</th>
<th>강퇴</th></tr>
<%for(int i=0;i<list.size();i++){ %>
<tr><td><%=i+1 %></td>
	<td><%= list.get(i).getUserid()%></td>
	<td><%= list.get(i).getUserName()%></td>
	<td><%= list.get(i).getAge()%></td>
	<td><%= list.get(i).getGender()%></td>
	<td><%= list.get(i).getPhone()%></td>
	<td><%= list.get(i).getEmail()%></td>
	<td><%= list.get(i).getHobby()%></td>
	<td><%= list.get(i).getEtc()%></td>
	<td><%= list.get(i).getEnrollDate()%></td>
	<td><%= list.get(i).getLastModified()%></td>
	<td><button>로그인제한</button></td>
	<td><button>로그인허용</button></td>&nbsp;
	<td><button>강퇴</button></td>
	

<%} %>





</table>

</body>
</html>