<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.BookType"%>
<%@page import="enetiy.CustomerInfo"%>
<html>
<head>
	<title>�޸��û���Ϣ</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
<%
      CustomerInfo customerInfo =(CustomerInfo)request.getAttribute("customerInfo");
%>
        
<form action="<%=request.getContextPath()%>/UpdateCustomerInfoServlet"
method="post">
<table align="center">
	<tr>
		<td>�û����:</td>
		<td><input type="num" name="custId" readonly value="<%=customerInfo.getCustId()%>"> </td>
	</tr>
	
	<tr>
		<td>�û�����:</td>
		<td><input type="text" name="custName" value="<%=customerInfo.getCustName()%>"> </td>
	</tr>
	<tr>
		<td>�û�����:</td>
		<td><input type="text" name="pwd"  value="<%=customerInfo.getPwd()%>" ></td>
	</tr>
	<tr>
		<td>�û�email:</td>
		<td><input type="text" name="email"  value="<%=customerInfo.getEmail()%>" > </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>


