<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>�޸Ŀͻ����</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
     
<form action="<%=request.getContextPath()%>/update_CustomerDetailInfo.action"
method="post">
<table align="center">
    <tr>
		<td>�ͻ��绰:</td>
		<td><input type="text" name="customerDetailInfo.tel" value="${oldCustomerDetailInfo.tel}" /> </td>
		<td><input type="hidden" name="customerDetailInfo.custId"  value="${oldCustomerDetailInfo.custId}"  readonly="readonly"/> </td>
	</tr>
	<tr>
		<td>�ͻ���ַ:</td>
		<td><input type="text" name="customerDetailInfo.address"  value="${oldCustomerDetailInfo.address}"> </td>
	</tr>
	<tr>
		<td>�ͻ��Ա�:</td>
		<td><input type="num" name="customerDetailInfo.sex"  value="${oldCustomerDetailInfo.sex}"> </td>
	</tr>
	<tr>
		<td>�ͻ�����:</td>
		<td><input type="num" name="customerDetailInfo.age"  value="${oldCustomerDetailInfo.age}"> </td>
	</tr>
	<tr>
		<td>���ѽ��:</td>
		<td><input type="num" name="customerDetailInfo.countMoney"  value="${oldCustomerDetailInfo.countMoney}"> </td>
	</tr>
	<tr>
		<td>�ͻ�QQ:</td>
		<td><input type="num" name="customerDetailInfo.qq"  value="${oldCustomerDetailInfo.qq}"> </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>



