<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.CustomerDetailInfo"%>
<html>
<head>
	<title>�޸Ŀͻ����</title>
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
		<td>�ͻ����:</td>
		<td><input type="num" name="custId" readonly value="<%=stu.getCustId()%>"> </td>
	</tr>
	<tr>
		<td>�ͻ��绰:</td>
		<td><input type="text" name="tel"  value="<%=stu.getTel()%>"> </td>
	</tr>
	<tr>
		<td>�ͻ���ַ:</td>
		<td><input type="text" name="address"  value="<%=stu.getAddress()%>"> </td>
	</tr>
	<tr>
		<td>�ͻ��Ա�:</td>
		<td><input type="num" name="sex"  value="<%=stu.getSex()%>"> </td>
	</tr>
	<tr>
		<td>�ͻ�����:</td>
		<td><input type="num" name="age"  value="<%=stu.getAge()%>"> </td>
	</tr>
	<tr>
		<td>���ѽ��:</td>
		<td><input type="num" name="countMoney"  value="<%=stu.getCountMoney()%>"> </td>
	</tr>
	<tr>
		<td>�ͻ�QQ:</td>
		<td><input type="num" name="qq"  value="<%=stu.getQq()%>"> </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>



