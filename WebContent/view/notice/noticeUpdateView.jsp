<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.Notice,member.model.vo.Member" %>    
<%
	Notice notice = (Notice)request.getAttribute("notice");	
%>    
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">

function deleteNotice(){
	location.href="/FWP/ndel?no=<%=notice.getNoticeNO()%>";
	return false;
}
</script>
<meta charset="UTF-8">
<title>noticeUpdate</title>
</head>
<body>
<%@ include file="/Header.jsp" %>
<hr style="clear:both;">
<br>
<h2 align="center"><%= notice.getNoticeNO()%>번 공지글 수정하기</h2>
<br> 

<form action="/FWP/nupdate" method="post" enctype="multipart/form-data">
<input type="hidden" name="no" value="<%=notice.getNoticeNO()%>">
<input type="hidden" name="ofile" value="<%=notice.getOriginalFilePath()%>">
<input type="hidden" name="rfile" value="<%=notice.getRenameFilePath()%>">

<table align="center" width="600">
<tr><th bgcolor="orange">제 목</th>
<td><input type="text" name="title" size="80" value="<%=notice.getNoticeTitle()%>"></td></tr>
<tr><th bgcolor="orange">작성자</th>
<td><input type="text" name="writer" value="<%=notice.getNoticeWriter()%>" readonly></td>
</tr>
<tr>

<th bgcolor="orange">첨부파일</th>

<td id="fileTD">
<%=notice.getOriginalFilePath()%>&nbsp;
<input type="button" onclick="return addFile();" value="첨부파일 변경하기">
<script>
function addFile(){
	var fileTD = document.getElementById("fileTD");
		var addHtml = "<input type='file' name='upfile'>";
		fileTD.innerHTML = fileTD.innerHTML + 
				"<BR>" + addHtml;
		return false;
}
</script>
</td>



</tr>
<tr>
<th bgcolor="orange">내 용</th><td>
<textarea rows="5" cols="80" name="content"><%=notice.getNoticeContent()%></textarea>

</td>
</tr>
<tr><th colspan="2" bgcolor="orange">
<input type="submit" value="수정"> &nbsp;
<input type="button" value="글삭제" onclick="deleteNotice()">
<input type="button" value="이전 페이지로 이동" onclick="history.go(-1); return false;"></th></tr>
</table>
</form>
<br>
<hr>
<%@ include file="/footer.html" %>
</body>
</html>