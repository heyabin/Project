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
<form action="<%=request.getContextPath()%>/SaveCustomerInfoServlet"
method="post">
<table align="center">
	<tr>
		<td>�û�����:</td>
		<td><input type="text" name="custName" placeholder="����������"  autofocus required> </td>
	</tr>
		<td>�û�����:</td>
		<td><input type="password" name="pwd" autofocus required> </td>
	</tr>
	<tr>
		<td>�û�email:</td>
		<td><input type="text" name="email" autofocus required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>



