<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>新增订单信息管理</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
         新增订单信息管理
<form action="<%=request.getContextPath()%>/SaveOrderMainServlet"
method="post">
<table align="center">
	<tr>
		<td>客户编号:</td>
		<td><input type="num" name="customerId" placeholder="请输入客户编号"  autofocus required> </td>
	</tr>
	<tr>
		<td>收货人姓名:</td>
		<td><input type="num" name="customerName" placeholder="请输入收货人姓名"  autofocus required> </td>
	</tr>
	<tr>
		<td>收货人电话	:</td>
		<td><input type="text" name="tel" autofocus required > </td>
	</tr>
	<tr>
		<td>收货地址:</td>
		<td><input type="text" name="address" autofocus required > </td>
	</tr>
	<tr>
		<td>销售单状态:</td>
		<td><input type="text" name="status" autofocus required > </td>
	</tr>
	<tr>
		<td>处理人编号 :</td>
		<td><input type="num" name="adminId" autofocus required > </td>
	</tr>
	<tr>
		<td>备注:</td>
		<td><input type="text" name="context" autofocus required > </td>
	</tr>
	<tr>
		<td>总价:</td>
		<td><input type="double" name="sumprice" autofocus required > </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


