<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>修改客户类别</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
     
<form action="<%=request.getContextPath()%>/update_CustomerDetailInfo.action"
method="post">
<table align="center">
    <tr>
		<td>客户电话:</td>
		<td><input type="text" name="customerDetailInfo.tel" value="${oldCustomerDetailInfo.tel}" /> </td>
		<td><input type="hidden" name="customerDetailInfo.custId"  value="${oldCustomerDetailInfo.custId}"  readonly="readonly"/> </td>
	</tr>
	<tr>
		<td>客户地址:</td>
		<td><input type="text" name="customerDetailInfo.address"  value="${oldCustomerDetailInfo.address}"> </td>
	</tr>
	<tr>
		<td>客户性别:</td>
		<td><input type="num" name="customerDetailInfo.sex"  value="${oldCustomerDetailInfo.sex}"> </td>
	</tr>
	<tr>
		<td>客户年龄:</td>
		<td><input type="num" name="customerDetailInfo.age"  value="${oldCustomerDetailInfo.age}"> </td>
	</tr>
	<tr>
		<td>消费金额:</td>
		<td><input type="num" name="customerDetailInfo.countMoney"  value="${oldCustomerDetailInfo.countMoney}"> </td>
	</tr>
	<tr>
		<td>客户QQ:</td>
		<td><input type="num" name="customerDetailInfo.qq"  value="${oldCustomerDetailInfo.qq}"> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>



