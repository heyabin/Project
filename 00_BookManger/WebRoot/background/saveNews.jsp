<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>����������Ϣ</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
         ����������Ϣ
<form action="<%=request.getContextPath()%>/SaveNewsServlet"
method="post">
<table align="center">
	<tr>
		<td>���ű��:</td>
		<td><input type   ="number" name="newsId" placeholder="���������ű��"  autofocus required> </td>
	</tr>
	<tr>
		<td>����Ա���:</td>
		<td><input type="number" name="adminId" placeholder="���������Ա���"  autofocus required> </td>
	</tr>
	<tr>
		<td>���ű���:</td>
		<td><input type="text" name="title" autofocus required> </td>
	</tr>
	<tr>
		<td>��������:</td>
		<td><input type="text" name="context" autofocus required> </td>
	</tr>
	
	<tr>
		<td>���ŷ���ʱ��:</td>
		<td><input type="date" name="fbTime" autofocus required	> </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>





