<%@ page language="java" contentType="text/html; charset=gbk"%>

<html>
<head>
	<title>修改用户信息</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>

        
<form action="<%=request.getContextPath()%>/update_CustomerInfo.action"
method="post">
<table align="center">
	<tr>
		<td>用户编号:</td>
		<td><input type="number" name="customerInfo.custId" readonly value="${oldCustomerInfo.custId}"> </td>
	</tr>
	
	<tr>
		<td>用户姓名:</td>
		<td><input type="text" name="customerInfo.custName" value="${oldCustomerInfo.custName}"> </td>
	</tr>
	<tr>
		<td>用户密码:</td>
		<td><input type="text" name="customerInfo.pwd"  value="${oldCustomerInfo.pwd}" ></td>
	</tr>
	<tr>
		<td>用户email:</td>
		<td><input type="text" name="customerInfo.email"  value="${oldCustomerInfo.email}" > </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


