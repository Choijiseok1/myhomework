<%@ page language="java" 
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" 
isErrorPage="true"%>
    <%
    String message=(String)request.getAttribute("message");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="../../Header1.jsp"  %>
<hr style="clear:both;">
<section style="height:400px; background:gray;">
<% if(message!=null){ %>
에러 발생 : <%= message %><br>
<%}else{%>
에러 발생 : <%= exception.getMessage() %>
<%} %>

</section>
<hr>
<%@ include file="/footer.html" %>


</body>
</html>