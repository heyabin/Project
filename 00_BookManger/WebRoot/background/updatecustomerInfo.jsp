<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.BookType"%>
<%@page import="enetiy.CustomerInfo"%>
<html>
<head>
	<title>修改用户信息</title>
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
		<td>用户编号:</td>
		<td><input type="num" name="custId" readonly value="<%=customerInfo.getCustId()%>"> </td>
	</tr>
	
	<tr>
		<td>用户姓名:</td>
		<td><input type="text" name="custName" value="<%=customerInfo.getCustName()%>"> </td>
	</tr>
	<tr>
		<td>用户密码:</td>
		<td><input type="text" name="pwd"  value="<%=customerInfo.getPwd()%>" ></td>
	</tr>
	<tr>
		<td>用户email:</td>
		<td><input type="text" name="email"  value="<%=customerInfo.getEmail()%>" > </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


