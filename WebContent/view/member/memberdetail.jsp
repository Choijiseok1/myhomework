<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
    <% 
    Member member=(Member)request.getAttribute("member");
    //체크박스 처리..
    String[] hobbies=member.getHobby().split(",");
    String[] checked=new String[9];
    for(String s: hobbies){
    	
    	switch(s){
    	case "game": checked[0]="checked"; break;
    	case "reading":checked[1]="checked"; break;
    	case "music":checked[2]="checked"; break;
    	case "climb":checked[3]="checked"; break;
    	case "sport":checked[4]="checked"; break;
    	case "movie":checked[5]="checked"; break;

    	
    	}
    }
    
    
    %>
    
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>맴버디테일</title>
</head>
<body>
<h2 align="center">회원 정보</h2>
<br>

<form action="MDUP" method="post">

<table width="650" align="center">
<tr height="40">

<th width="150">아이디</th>
<th width="150"><input type="text" name="userid" value="<%=member.getUserid() %>" readonly="readonly"></th>
</tr>
<tr height="40">
<th width="150">이 름</th>
<th width="150"><input type="text" name="name" value="<%=member.getUserName() %>" readonly="readonly"></th>
</tr>
<tr height="40">
<th width="150">암 호</th>
<th width="150"><input type="password" name="pw" value="<%=member.getUserPwd() %>"></th>
</tr>
<tr height="40">
<th width="150">성 별</th>

<th width="150">
<% 
	if(member.getGender().equals("M")){%>
			
<input type="radio" name="gender" readonly="readonly" checked="checked"> 남
<input type="radio" name="gender" readonly="readonly" >여
		<%}else {%>
		
					
<input type="radio" name="gender" readonly="readonly" > 남
<input type="radio" name="gender" readonly="readonly" checked="checked">여

<% }%>


</th>



</tr>
<tr height="40">
<th width="150">나이</th>
<th width="150"><input type="text" name="age" value="<%=member.getAge() %>" readonly="readonly"></th>
</tr>
<tr height="40">
<th width="150">폰번호</th>
<th width="150">
<input type="text" name="phone" value="<%=member.getPhone() %>" readonly="readonly">
</th>
</tr>

<tr height="40">
<th width="150">이메일</th>

<th width="150">

<input type="email" name="email" value="<%= member.getEmail() %>" >
</th>

</tr>
<tr height="40">


<th width="150">취미</th>

<th width="200">

<td width="150"><input type="checkbox" name="hobby" value="game" <%= checked[0] %> >게임</td>
<td width="150"><input type="checkbox" name="hobby" value="reading" <%= checked[1] %>>독서</td>
<td width="150"><input type="checkbox" name="hobby" value="music" <%= checked[2] %>>음악감상</td>

<td width="150"><input type="checkbox" name="hobby" value="climb" <%= checked[3] %>>등신</td>
<td width="150"><input type="checkbox" name="hobby" value="sport" <%= checked[4] %>>웅동</td>
<td width="150"><input type="checkbox" name="hobby" value="movie" <%= checked[5] %>>영화감상</td>

</th>

</tr>

<tr height="40">
<th width="150">기타</th>
<th width="150"><input type="text" name="etc" value="<%=member.getEtc() %>" readonly="readonly"></th>
</tr>

<th width="150">등록일</th>
<th width="150"><input type="text" name="edate" value="<%=member.getEnrollDate() %>" readonly="readonly"></th>
</tr>

<th width="150">마지막 등록일</th>
<th width="150"><input type="text" name="ldate" value="<%=member.getLastModified() %>" readonly="readonly"></th>
</tr>


<th> 
<a href="#">등록하기</a>
</th>
<th>
<input type="submit" value="수정하기">
</th>
<th><a href="/FWP/MDD?userid=<%=member.getUserid()%>">탈퇴하기</a>
</th>

</table>


</form>
<%@ include file="../../footer.html" %>

</body>
</html>