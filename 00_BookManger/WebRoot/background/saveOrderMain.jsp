<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>����������Ϣ����</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
         ����������Ϣ����
<form action="<%=request.getContextPath()%>/SaveOrderMainServlet"
method="post">
<table align="center">
	<tr>
		<td>�ͻ����:</td>
		<td><input type="num" name="customerId" placeholder="������ͻ����"  autofocus required> </td>
	</tr>
	<tr>
		<td>�ջ�������:</td>
		<td><input type="num" name="customerName" placeholder="�������ջ�������"  autofocus required> </td>
	</tr>
	<tr>
		<td>�ջ��˵绰	:</td>
		<td><input type="text" name="tel" autofocus required > </td>
	</tr>
	<tr>
		<td>�ջ���ַ:</td>
		<td><input type="text" name="address" autofocus required > </td>
	</tr>
	<tr>
		<td>���۵�״̬:</td>
		<td><input type="text" name="status" autofocus required > </td>
	</tr>
	<tr>
		<td>�����˱�� :</td>
		<td><input type="num" name="adminId" autofocus required > </td>
	</tr>
	<tr>
		<td>��ע:</td>
		<td><input type="text" name="context" autofocus required > </td>
	</tr>
	<tr>
		<td>�ܼ�:</td>
		<td><input type="double" name="sumprice" autofocus required > </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>


