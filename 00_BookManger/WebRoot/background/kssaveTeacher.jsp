<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>������Ϣ</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body background="<%=request.getContextPath()%>/background/images/savahe.jpg">
         ������ʦ��Ϣ
<form action="<%=request.getContextPath()%>/SaveTeacherServlet"
method="post">
<table align="center">
	<tr>
		<td>��ʦ����:</td>
		<td><input type  ="text" name="teaName" placeholder="����������"  autofocus required> </td>
	</tr>
	<tr>
		<td>��ʦ����:</td>
		<td><input type="number" name="teaAge" placeholder="����������"  autofocus required
		min="22" max="55"> </td>
	</tr>
	<tr>
		<td>��ʦ����:</td>
		<td><input type="date" name="teaBtd" autofocus required	> </td>
	</tr>
	<tr>
		<td>�Ա�:</td>
		<td>
			<input type="radio" name="teaSex" value="0">Ů
			<input type="radio" name="teaSex" value="1" checked="checked">�� 
		</td>
	</tr>
	<tr>
		<td>��ʦ�绰:</td>
		<td><input type="text" name="teaTel" autofocus required> </td>
	</tr>
	<tr>
		<td>��ͥסַ:</td>
		<td><input type="text" name="teaaddress" autofocus required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>


