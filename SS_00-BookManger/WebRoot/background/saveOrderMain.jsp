<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
	<title>新增订单信息管理</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
         新增订单信息管理
<form action="<%=request.getContextPath()%>/save_OrderMain.action" method="post">
<table >
	<tr>
		<td>订单编号:</td>
		<td><input type="text" name="orderMain.orderNum"> </td>
	</tr>
	<tr>
		<td>客户编号:</td>
		<td><input type="text" name="orderMain.customerInfo.custId" > </td>
	</tr>
	<tr>
		<td>收货人姓名:</td>
		<td><input type="text" name="orderMain.customerName"> </td>
	</tr>
	<tr>
		<td>收货人电话	:</td>
		<td><input type="text" name="orderMain.tel"> </td>
	</tr>
	<tr>
		<td>收货地址:</td>
		<td><input type="text" name="orderMain.address" > </td>
	</tr>
	<tr>
		<td>销售单状态:</td>
		<td><input type="text" name="orderMain.status" > </td>
	</tr>
	<tr>
		<td>处理人编号 :</td>
		<td><input type="number" name="orderMain.sysAdmin.adminId"> </td>
	</tr>
	<tr>
		<td>备注:</td>
		<td><input type="text" name="orderMain.context" > </td>
	</tr>
	<tr>
		<td>总价:</td>
		<td><input type="number" name="orderMain.sumprice" > </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


