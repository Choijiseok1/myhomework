<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="noticeError.jsp"%>
    
    <%@ page import ="notice.model.vo.Notice,java.util.*" %>
    <% List<Notice> list=(List<Notice>)request.getAttribute("nlist"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/Header1.jsp" %>
<hr style="clear: both;">
<br>
<h2 align="center">공지글 전체 목록</h2>
<br>
<table align="center" width="650" cellspacing="0" border="1">
<tr>
<th>번호</th>
<th>제목</th>
<th>작성자</th>
<th>날짜</th>
<th>첨부파일</th>
<%for(Notice n: list){ %>
<tr>
<td align="center"><%= n.getNoticeNO() %></td>
<td align="center"><%= n.getNoticeTitle() %></td>
<td align="center"><%= n.getNoticeWriter() %></td>
<td align="center"><%= n.getNoticeDate() %></td>
<td align="center"><% if(n.getOriginalFilePath()!=null) {%>
		◎
		<%}else{ %>
		x
		<%} %>
</td>
</tr>


<%} %>
</table>
<hr>
<%@ include file="/footer.html" %>
</body>
</html>