<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.OrderDetail"%>
<html>
<head>
	<title>修改订单详细信息</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<%
     OrderDetail orderDetail =(OrderDetail)request.getAttribute("orderDetail");

%>
<body>
         修改订单信息信息
<form action="<%=request.getContextPath()%>/UpdateorderdetailServlet"
method="post">
<table align="center">
	<tr>
		<td>订单主键编号 :</td>
		<td><input type="num" name="detailId" readonly value="<%=orderDetail.getDetailId()%>" > </td>
	</tr>
	<tr>
		<td>订单编号:</td>
		<td><input type="text" name="orderNum" value="<%=orderDetail.getOrderNum()%>"> </td>
	</tr>
	<tr>
		<td>图书编号:</td>
		<td><input type="num" name="bookId" value="<%=orderDetail.getBookId()%>" > </td>
	</tr>
	<tr>
		<td>订单数量:</td>
		<td><input type="num" name="num"  value="<%=orderDetail.getNum()%>"> </td>
	</tr>
		<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</html>


