<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>�����û���Ϣ</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
          �����û���Ϣ
<form action="<%=request.getContextPath()%>/save_CustomerInfo.action"
method="post">
<table >
	<tr>
		<td>�û�����:</td>
		<td><input type="text" name="customerInfo.custName" placeholder="����������"  autofocus required> </td>
	</tr>
	<tr>
		<td>�û�����:</td>
		<td><input type="password" name="customerInfo.pwd" /> </td>
	</tr>
	<tr>
		<td>�û�email:</td>
		<td><input type="text" name="customerInfo.email" /> </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>



