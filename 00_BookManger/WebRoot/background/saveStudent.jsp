<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>����ѧ����Ϣ</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
         ����ѧ����Ϣ
<form action="<%=request.getContextPath()%>/SaveStudentServlet"
method="post">
<table align="center">
	<tr>
		<td>ѧ������:</td>
		<td><input type    ="text" name="stuName" placeholder="����������"  autofocus required> </td>
	</tr>
	<tr>
		<td>ѧ������:</td>
		<td><input type="number" name="stuAge" placeholder="����������"  autofocus required
		min="18" max="36"> </td>
	</tr>
	<tr>
		<td>ѧ������:</td>
		<td><input type="date" name="stuBtd" autofocus required	
		value="2000-10-10"> </td>
	</tr>
	<tr>
		<td>�Ա�:</td>
		<td>
			<input type="radio" name="stuSex" value="0">Ů
			<input type="radio" name="stuSex" value="1" checked="checked">�� 
		</td>
	</tr>
	<tr>
		<td>ѧ���绰:</td>
		<td><input type="text" name="stuTel" autofocus required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>


