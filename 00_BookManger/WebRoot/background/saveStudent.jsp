<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>新增学生信息</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
         新增学生信息
<form action="<%=request.getContextPath()%>/SaveStudentServlet"
method="post">
<table align="center">
	<tr>
		<td>学生姓名:</td>
		<td><input type    ="text" name="stuName" placeholder="请输入姓名"  autofocus required> </td>
	</tr>
	<tr>
		<td>学生年龄:</td>
		<td><input type="number" name="stuAge" placeholder="请输入年龄"  autofocus required
		min="18" max="36"> </td>
	</tr>
	<tr>
		<td>学生生日:</td>
		<td><input type="date" name="stuBtd" autofocus required	
		value="2000-10-10"> </td>
	</tr>
	<tr>
		<td>性别:</td>
		<td>
			<input type="radio" name="stuSex" value="0">女
			<input type="radio" name="stuSex" value="1" checked="checked">男 
		</td>
	</tr>
	<tr>
		<td>学生电话:</td>
		<td><input type="text" name="stuTel" autofocus required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


