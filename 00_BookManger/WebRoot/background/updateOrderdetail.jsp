<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.OrderDetail"%>
<html>
<head>
	<title>�޸Ķ�����ϸ��Ϣ</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<%
     OrderDetail orderDetail =(OrderDetail)request.getAttribute("orderDetail");

%>
<body>
         �޸Ķ�����Ϣ��Ϣ
<form action="<%=request.getContextPath()%>/UpdateorderdetailServlet"
method="post">
<table align="center">
	<tr>
		<td>����������� :</td>
		<td><input type="num" name="detailId" readonly value="<%=orderDetail.getDetailId()%>" > </td>
	</tr>
	<tr>
		<td>�������:</td>
		<td><input type="text" name="orderNum" value="<%=orderDetail.getOrderNum()%>"> </td>
	</tr>
	<tr>
		<td>ͼ����:</td>
		<td><input type="num" name="bookId" value="<%=orderDetail.getBookId()%>" > </td>
	</tr>
	<tr>
		<td>��������:</td>
		<td><input type="num" name="num"  value="<%=orderDetail.getNum()%>"> </td>
	</tr>
		<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</html>


