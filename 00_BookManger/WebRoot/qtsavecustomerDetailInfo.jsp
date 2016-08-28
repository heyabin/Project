<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.CustomerDetailInfo"%>
<%@page import="enetiy.CustomerInfo"%>
<html>
<head>
	<title>新增客户类别</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>      
<form action="<%=request.getContextPath()%>/AddCustomerDetailInfoServlet"
method="post">
<% CustomerInfo customerInfo = (CustomerInfo)session.getAttribute("customerInfo");  %>
<table align="center">
    <tr>
		<td>客户编号:</td>
		<td><input type="num" name="custId" value="<%=customerInfo.getCustId() %>" readonly autofocus required> </td>
	</tr> 
	<tr>
		<td>客户电话:</td>
		<td><input type="text" name="tel" placeholder="请输入客户电话"  autofocus required> </td>
	</tr>
	<tr>
		<td>客户地址:</td>
		<td><input type="text" name="address"  placeholder="请输入客户地址"  autofocus required> </td>
	</tr>
	<tr>
		<td>客户性别:</td>
		<td><input type="num" name="sex"  placeholder="请输入客户性别"  autofocus required> </td>
	</tr>
	<tr>
		<td>客户年龄:</td>
		<td><input type="num" name="age"  placeholder="请输入客户年龄"  autofocus required> </td>
	</tr>
	<tr>
		<td>消费金额:</td>
		<td><input type="num" name="countMoney"  placeholder="请输入消费金额"  autofocus required> </td>
	</tr>
	<tr>
		<td>客户QQ:</td>
		<td><input type="num" name="qq"   placeholder="请输入客户QQ"  autofocus required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>



