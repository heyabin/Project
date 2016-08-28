<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>修改学生信息</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
        
<form action="<%=request.getContextPath()%>/UpdateStudentServlet"
method="post">
<table align="center">
	<tr>
		<td>学生编号:</td>
		<td><input type="text" name="stuId" readonly value="${requestScope.stu.stuId}"> </td>
	</tr>
	<tr>
		<td>学生姓名:</td>
		<td><input type="text" name="stuName" value="${requestScope.stu.stuName}" > </td>
	</tr>
	<tr>
		<td>学生年龄:</td>
		<td><input type="number" name="stuAge" value="${requestScope.stu.stuAge}"> </td>	
	</tr>
	<tr>
		<td>学生电话:</td>
		<td><input type="text" name="stuTel" value="${requestScope.stu.stuTel}"> </td>	
	</tr>
	<tr>
		<td>学生生日:</td>
		<td><input type="date" name="stuBtd" value="${requestScope.stu.stuBtd}"> </td>	
	</tr>
	<tr>
		<td>性别:</td>
		<td>
			<input type="radio" name="stuSex" value="0">女
			<input type="radio" name="stuSex" value="1" checked="checked">男 
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


