<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>�޸�ѧ����Ϣ</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
        
<form action="<%=request.getContextPath()%>/UpdateStudentServlet"
method="post">
<table align="center">
	<tr>
		<td>ѧ�����:</td>
		<td><input type="text" name="stuId" readonly value="${requestScope.stu.stuId}"> </td>
	</tr>
	<tr>
		<td>ѧ������:</td>
		<td><input type="text" name="stuName" value="${requestScope.stu.stuName}" > </td>
	</tr>
	<tr>
		<td>ѧ������:</td>
		<td><input type="number" name="stuAge" value="${requestScope.stu.stuAge}"> </td>	
	</tr>
	<tr>
		<td>ѧ���绰:</td>
		<td><input type="text" name="stuTel" value="${requestScope.stu.stuTel}"> </td>	
	</tr>
	<tr>
		<td>ѧ������:</td>
		<td><input type="date" name="stuBtd" value="${requestScope.stu.stuBtd}"> </td>	
	</tr>
	<tr>
		<td>�Ա�:</td>
		<td>
			<input type="radio" name="stuSex" value="0">Ů
			<input type="radio" name="stuSex" value="1" checked="checked">�� 
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>


