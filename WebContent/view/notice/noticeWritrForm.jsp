<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="notice.model.vo.Notice,java.util.*,member.model.vo.*" %>
    
    <%
    Member loginUser=(Member)session.getAttribute("loginUser");
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/Header.jsp" %>
<h2 align="center">공지 글쓰기 페이지</h2>
<br>
<form action="/FWP/nwrite" method="post" enctype="multipart/form-data">
<!-- enctype="multipart/form-data"은 파일업로드때 쓰인다. -->
<table align="center" width="600">
<tr>
<th>제목:</th><td><input type="text" name="title"></td>
</tr>
<tr>
<th>작성자</th><td><input type="text" name="writer" value="<%= loginUser.getUserid()%>" readonly="readonly"></td>
</tr>
<tr>
<th>내용</th><td><textarea rows="5" cols="50" name="content"></textarea></td>
</tr>
<tr>
<th colspan="2"><input type="submit" value="등록">&nbsp;
<input type="file" name="upfile" value="첨부파일">&nbsp;
<input type="reset" value="작성취소">&nbsp;
<input type="button" value="이전 페이지로" onclick="history.go(-1)">&nbsp;

</table>
</form>










<%@ include file="/footer.html" %>
</body>
</html>