<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>����������ϸ��Ϣ����</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
         ����������ϸ��Ϣ����
<form action="<%=request.getContextPath()%>/SaveorderdetailServlet"
method="post">
<table align="center">
	<tr>
		<td>�¶������:</td>
		<td><input type="text" name="orderNum" placeholder="�����붩�����"  autofocus required> </td>
	</tr>
	<tr>
		<td>ͼ����:</td>
		<td><input type="num" name="bookId" placeholder="������ͼ����"  autofocus required> </td>
	</tr>
	<tr>
		<td>ͼ������:</td>
		<td><input type="num" name="num" autofocus required > </td>
	</tr>
	
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>


