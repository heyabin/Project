<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>�����ղ���Ϣ</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
         �����ղ���Ϣ
<form action="<%=request.getContextPath()%>/SavefavoriteServlet"
method="post">
<table align="center">
	<tr>
	      <td>ͼ����:</td>
		<td><input type="num" name="bookId" placeholder="������ͼ����"  autofocus required> </td>
	</tr>
	 <tr>
		<td>�˿ͱ��:</td>
		<td><input type="num" name="custId" placeholder="������˿ͱ��"  autofocus required> </td>
	</tr>
	
	<tr>
		<td>�ղ�����:</td>
		<td><input type="date" name="date" autofocus required > </td>
	</tr>
	<tr>
		<td>�ղ�����:</td>
		<td><input type="text" name="context" autofocus required > </td>
	</tr>
	
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>


