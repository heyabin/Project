<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>����ͼ�����</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
         ����ͼ�����
<form action="<%=request.getContextPath()%>/SaveBookTypeServlet"
method="post">
<table align="center">
	<tr>
		<td>ͼ�鸸���:</td>
		<td><input type="num" name="parentId" placeholder="��������"  autofocus required> </td>
	</tr>
	<tr>
		<td>ͼ���������:</td>
		<td><input type="text" name="bookTypeName" placeholder="������ͼ���������"  autofocus required> </td>
	</tr>
	<tr>
		<td>ͼ���������:</td>
		<td><input type="text" name="context" autofocus required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>



