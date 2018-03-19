<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.Notice,member.model.vo.Member" %>    
<%

	Notice notice = (Notice)request.getAttribute("notice");
	Member loginUser=(Member)session.getAttribute("loginUser");
	
%>    
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function movePage(){
	location.href="/FWP/nupview?no=<%=notice.getNoticeNO()%>";
	return false;	
	
}
function deleteNotice(){
	location.href="/FWP/ndel?no=<%=notice.getNoticeNO()%>";
	return false;
	
}
</script>
<meta charset="UTF-8">
<title>noticeDetailView</title>
</head>
<body>
<%@ include file="/Header.jsp" %>
<hr style="clear:both;">
<br>
<h2 align="center"><%= notice.getNoticeNO()%>번 공지글 상세보기</h2>
<br>
<form action="/FWP/nwrite" method="post" enctype="multipart/form-data" name="form">
<table align="center" width="600">
<tr><th bgcolor="orange" >제 목</th>
<td><input type="text" name="title" size="80" value="<%=notice.getNoticeTitle()%>"  readonly></td></tr>
<tr><th bgcolor="orange">작성자</th>
<td><input type="text" name="writer" value="<%= notice.getNoticeWriter()%>" readonly></td>
</tr>
<tr><th bgcolor="orange">첨부파일</th>
<td>
<% if(notice.getOriginalFilePath() != null){ %>
	<a href="/FWP/fdown?ofile=<%= notice.getOriginalFilePath() %>&rfile=<%= notice.getRenameFilePath() %>">
	<%= notice.getOriginalFilePath() %></a>
<% }else{ %>
	첨부파일없음
<% } %>

<input type="file" name="upfile"></td></tr>
<tr><th bgcolor="orange">내 용</th>
<td><%=notice.getNoticeContent()%></td>
</tr>
<tr><th colspan="2" bgcolor="orange">
<%if(loginUser.getUserid().equals(notice.getNoticeWriter())){ %>
<input type="button" value="수정페이지로 이동" onclick="movePage()"> &nbsp;
<input type="button" value="글삭제" onclick="deleteNotice()">

<%}%>

<input type="button" value="이전 페이지로 이동" onclick="history.go(-1); return false;"></th></tr>
</table>
</form>
<br>
<hr>
<%@ include file="/footer.html" %>
</body>
</html>