<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.OrderMain"%>
<html>
<head>
	<title>�޸Ķ�����Ϣ��Ϣ</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<%
      OrderMain orderMain = (OrderMain)request.getAttribute("orderMain");

%>
<body>
         �޸Ķ�����Ϣ��Ϣ
<form action="<%=request.getContextPath()%>/SaveOrderMainServlet"
method="post">
<table align="center">
	<tr>
		<td>������� :</td>
		<td><input type="text" name="orderNum" readonly value="<%=orderMain.getOrderNum()%>" > </td>
	</tr>
	<tr>
		<td>�ͻ����:</td>
		<td><input type="num" name="customerId" value="<%=orderMain.getCustomerId()%>"> </td>
	</tr>
	<tr>
		<td>�ջ�������:</td>
		<td><input type="num" name="customerName" value="<%=orderMain.getCustomerId()%>" > </td>
	</tr>
	<tr>
		<td>�ջ��˵绰	:</td>
		<td><input type="text" name="tel"  value="<%=orderMain.getTel()%>"> </td>
	</tr>
	<tr>
		<td>�ջ���ַ:</td>
		<td><input type="text" name="address"value="<%=orderMain.getAddress()%>"> </td>
	</tr>
	<tr>
		<td>���۵�״̬:</td>
		<td><input type="text" name="status" value="<%=orderMain.getStatus()%>" > </td>
	</tr>
	<tr>
		<td>�����˱�� :</td>
		<td><input type="num" name="adminId" value="<%=orderMain.getAdminId()%>"> </td>
	</tr>
	<tr>
		<td>��ע:</td>
		<td><input type="text" name="context" value="<%=orderMain.getContext()%>"> </td>
	</tr>
	<tr>
		<td>�ܼ�:</td>
		<td><input type="double" name="sumprice" value="<%=orderMain.getSumprice()%>"> </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</html>


