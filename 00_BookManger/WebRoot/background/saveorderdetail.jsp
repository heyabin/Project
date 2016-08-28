<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>新增订单详细信息管理</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
         新增订单详细信息管理
<form action="<%=request.getContextPath()%>/SaveorderdetailServlet"
method="post">
<table align="center">
	<tr>
		<td>下订单编号:</td>
		<td><input type="text" name="orderNum" placeholder="请输入订单编号"  autofocus required> </td>
	</tr>
	<tr>
		<td>图书编号:</td>
		<td><input type="num" name="bookId" placeholder="请输入图书编号"  autofocus required> </td>
	</tr>
	<tr>
		<td>图书数量:</td>
		<td><input type="num" name="num" autofocus required > </td>
	</tr>
	
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


