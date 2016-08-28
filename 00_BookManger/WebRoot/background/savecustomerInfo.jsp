<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>新增用户信息</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
          新增用户信息
<form action="<%=request.getContextPath()%>/SaveCustomerInfoServlet"
method="post">
<table align="center">
	<tr>
		<td>用户姓名:</td>
		<td><input type="text" name="custName" placeholder="请输入姓名"  autofocus required> </td>
	</tr>
		<td>用户密码:</td>
		<td><input type="password" name="pwd" autofocus required> </td>
	</tr>
	<tr>
		<td>用户email:</td>
		<td><input type="text" name="email" autofocus required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>



