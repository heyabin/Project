<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.News"%>
<%@page import="java.util.List"%>
<html>
<head>
	<title>修改新闻信息</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
	<%
	 	News news =(News)request.getAttribute("news");
	%>
	
</head>
<body>
         修改新闻信息
<form action="<%=request.getContextPath()%>/UpdateNewsServlet"
method="post">
<table align="center">
	<tr>
		<td>新闻编号:</td>
		<td><input type ="number" name="newsId"  readonly value="<%=news.getNewsId()%>"> </td>
	</tr>
	<tr>
		<td>管理员编号:</td>
		<td><input type="number" name="adminId"  value="<%=news.getAdminId()%>"  autofocus required > </td>
	</tr>
	<tr>
		<td>新闻标题:</td>
		<td><input type="text" name="title" value="<%=news.getContext()%>" autofocus required> </td>
	</tr>
	<tr>
		<td>新闻内容:</td>
		<td><input type="text" name="context" value="<%=news.getContext()%>" autofocus required> </td>
	</tr>
	
	<tr>
		<td>新闻发布时间:</td>
		<td><input type="date" name="fbTime" value="<%=news.getFbTime()%>" autofocus required	> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>





