<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.CustomerDetailInfo"%>
<html>
<head>
	<title>修改客户类别</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
<%
CustomerDetailInfo stu = (CustomerDetailInfo)request.getAttribute("stu");
%>
        
<form action="<%=request.getContextPath()%>/UpdateCustomerDetailInfoServlet"
method="post">
<table align="center">
    <tr>
		<td>客户编号:</td>
		<td><input type="num" name="custId" readonly value="<%=stu.getCustId()%>"> </td>
	</tr>
	<tr>
		<td>客户电话:</td>
		<td><input type="text" name="tel"  value="<%=stu.getTel()%>"> </td>
	</tr>
	<tr>
		<td>客户地址:</td>
		<td><input type="text" name="address"  value="<%=stu.getAddress()%>"> </td>
	</tr>
	<tr>
		<td>客户性别:</td>
		<td><input type="num" name="sex"  value="<%=stu.getSex()%>"> </td>
	</tr>
	<tr>
		<td>客户年龄:</td>
		<td><input type="num" name="age"  value="<%=stu.getAge()%>"> </td>
	</tr>
	<tr>
		<td>消费金额:</td>
		<td><input type="num" name="countMoney"  value="<%=stu.getCountMoney()%>"> </td>
	</tr>
	<tr>
		<td>客户QQ:</td>
		<td><input type="num" name="qq"  value="<%=stu.getQq()%>"> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>



