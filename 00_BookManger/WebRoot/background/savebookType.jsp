<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>新增图书类别</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
         新增图书类别
<form action="<%=request.getContextPath()%>/SaveBookTypeServlet"
method="post">
<table align="center">
	<tr>
		<td>图书父编号:</td>
		<td><input type="num" name="parentId" placeholder="请输入编号"  autofocus required> </td>
	</tr>
	<tr>
		<td>图书类别名称:</td>
		<td><input type="text" name="bookTypeName" placeholder="请输入图书类别名称"  autofocus required> </td>
	</tr>
	<tr>
		<td>图书类别描述:</td>
		<td><input type="text" name="context" autofocus required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>



