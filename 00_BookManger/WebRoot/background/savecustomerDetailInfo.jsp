<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.CustomerDetailInfo"%>
<html>
<head>
	<title>�����ͻ����</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
<%
CustomerDetailInfo stu = (CustomerDetailInfo)request.getAttribute("stu");
%>
        
<form action="<%=request.getContextPath()%>/SaveCustomerDetailInfoServlet"
method="post">
<table align="center">
    <tr>
		<td>�ͻ����:</td>
		<td><input type="num" name="custId" placeholder="������ͻ����"  autofocus required> </td>
	</tr>
	<tr>
		<td>�ͻ��绰:</td>
		<td><input type="text" name="tel" placeholder="������ͻ��绰"  autofocus required> </td>
	</tr>
	<tr>
		<td>�ͻ���ַ:</td>
		<td><input type="text" name="address"  placeholder="������ͻ���ַ"  autofocus required> </td>
	</tr>
	<tr>
		<td>�ͻ��Ա�:</td>
		<td><input type="num" name="sex"  placeholder="������ͻ��Ա�"  autofocus required> </td>
	</tr>
	<tr>
		<td>�ͻ�����:</td>
		<td><input type="num" name="age"  placeholder="������ͻ�����"  autofocus required> </td>
	</tr>
	<tr>
		<td>���ѽ��:</td>
		<td><input type="num" name="countMoney"  placeholder="���������ѽ��"  autofocus required> </td>
	</tr>
	<tr>
		<td>�ͻ�QQ:</td>
		<td><input type="num" name="qq"   placeholder="������ͻ�QQ"  autofocus required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>



