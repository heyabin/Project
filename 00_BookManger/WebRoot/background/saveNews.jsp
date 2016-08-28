<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>新增新闻信息</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
         新增新闻信息
<form action="<%=request.getContextPath()%>/SaveNewsServlet"
method="post">
<table align="center">
	<tr>
		<td>新闻编号:</td>
		<td><input type   ="number" name="newsId" placeholder="请输入新闻编号"  autofocus required> </td>
	</tr>
	<tr>
		<td>管理员编号:</td>
		<td><input type="number" name="adminId" placeholder="请输入管理员编号"  autofocus required> </td>
	</tr>
	<tr>
		<td>新闻标题:</td>
		<td><input type="text" name="title" autofocus required> </td>
	</tr>
	<tr>
		<td>新闻内容:</td>
		<td><input type="text" name="context" autofocus required> </td>
	</tr>
	
	<tr>
		<td>新闻发布时间:</td>
		<td><input type="date" name="fbTime" autofocus required	> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>





