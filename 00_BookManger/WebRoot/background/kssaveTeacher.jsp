<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>新增信息</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body background="<%=request.getContextPath()%>/background/images/savahe.jpg">
         新增老师信息
<form action="<%=request.getContextPath()%>/SaveTeacherServlet"
method="post">
<table align="center">
	<tr>
		<td>老师姓名:</td>
		<td><input type  ="text" name="teaName" placeholder="请输入姓名"  autofocus required> </td>
	</tr>
	<tr>
		<td>老师年龄:</td>
		<td><input type="number" name="teaAge" placeholder="请输入年龄"  autofocus required
		min="22" max="55"> </td>
	</tr>
	<tr>
		<td>老师生日:</td>
		<td><input type="date" name="teaBtd" autofocus required	> </td>
	</tr>
	<tr>
		<td>性别:</td>
		<td>
			<input type="radio" name="teaSex" value="0">女
			<input type="radio" name="teaSex" value="1" checked="checked">男 
		</td>
	</tr>
	<tr>
		<td>老师电话:</td>
		<td><input type="text" name="teaTel" autofocus required> </td>
	</tr>
	<tr>
		<td>家庭住址:</td>
		<td><input type="text" name="teaaddress" autofocus required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


