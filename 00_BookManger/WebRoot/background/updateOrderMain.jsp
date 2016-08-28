<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.OrderMain"%>
<html>
<head>
	<title>修改订单信息信息</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<%
      OrderMain orderMain = (OrderMain)request.getAttribute("orderMain");

%>
<body>
         修改订单信息信息
<form action="<%=request.getContextPath()%>/SaveOrderMainServlet"
method="post">
<table align="center">
	<tr>
		<td>订单编号 :</td>
		<td><input type="text" name="orderNum" readonly value="<%=orderMain.getOrderNum()%>" > </td>
	</tr>
	<tr>
		<td>客户编号:</td>
		<td><input type="num" name="customerId" value="<%=orderMain.getCustomerId()%>"> </td>
	</tr>
	<tr>
		<td>收货人姓名:</td>
		<td><input type="num" name="customerName" value="<%=orderMain.getCustomerId()%>" > </td>
	</tr>
	<tr>
		<td>收货人电话	:</td>
		<td><input type="text" name="tel"  value="<%=orderMain.getTel()%>"> </td>
	</tr>
	<tr>
		<td>收货地址:</td>
		<td><input type="text" name="address"value="<%=orderMain.getAddress()%>"> </td>
	</tr>
	<tr>
		<td>销售单状态:</td>
		<td><input type="text" name="status" value="<%=orderMain.getStatus()%>" > </td>
	</tr>
	<tr>
		<td>处理人编号 :</td>
		<td><input type="num" name="adminId" value="<%=orderMain.getAdminId()%>"> </td>
	</tr>
	<tr>
		<td>备注:</td>
		<td><input type="text" name="context" value="<%=orderMain.getContext()%>"> </td>
	</tr>
	<tr>
		<td>总价:</td>
		<td><input type="double" name="sumprice" value="<%=orderMain.getSumprice()%>"> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</html>


