<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.News"%>
<%@page import="java.util.List"%>
<html>
<head>
	<title>�޸�������Ϣ</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
	<%
	 	News news =(News)request.getAttribute("news");
	%>
	
</head>
<body>
         �޸�������Ϣ
<form action="<%=request.getContextPath()%>/UpdateNewsServlet"
method="post">
<table align="center">
	<tr>
		<td>���ű��:</td>
		<td><input type ="number" name="newsId"  readonly value="<%=news.getNewsId()%>"> </td>
	</tr>
	<tr>
		<td>����Ա���:</td>
		<td><input type="number" name="adminId"  value="<%=news.getAdminId()%>"  autofocus required > </td>
	</tr>
	<tr>
		<td>���ű���:</td>
		<td><input type="text" name="title" value="<%=news.getContext()%>" autofocus required> </td>
	</tr>
	<tr>
		<td>��������:</td>
		<td><input type="text" name="context" value="<%=news.getContext()%>" autofocus required> </td>
	</tr>
	
	<tr>
		<td>���ŷ���ʱ��:</td>
		<td><input type="date" name="fbTime" value="<%=news.getFbTime()%>" autofocus required	> </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>





