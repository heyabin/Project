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
<form action="<%=request.getContextPath()%>/SavebookDiscussServlet"
method="post">
<table align="center">
   
	<tr>
		<td>ͼ����:</td>
		<td><input type="num" name="bookId" placeholder="������ͼ����"  autofocus required> </td>
	</tr>
	<tr>
		<td>�ͻ����:</td>
		<td><input type="num" name="custId" autofocus required > </td>
	</tr>
	<tr>
		<td>��������:</td>
		<td><input type="text" name="context" autofocus required  > </td>
	</tr>
	<tr>
		<td>״̬:</td>
		<td><input type="text" name="states" autofocus required > </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>


