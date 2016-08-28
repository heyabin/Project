<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>新增书评信息管理</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
         新增书评信息管理
<form action="<%=request.getContextPath()%>/SavebookDiscussServlet"
method="post">
<table align="center">
   
	<tr>
		<td>图书编号:</td>
		<td><input type="num" name="bookId" placeholder="请输入图书编号"  autofocus required> </td>
	</tr>
	<tr>
		<td>客户编号:</td>
		<td><input type="num" name="custId" autofocus required > </td>
	</tr>
	<tr>
		<td>书评内容:</td>
		<td><input type="text" name="context" autofocus required  > </td>
	</tr>
	<tr>
		<td>状态:</td>
		<td><input type="text" name="states" autofocus required > </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


