<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.Teacher"%>
<html>
<head>
	<title>修改老师信息</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
<%
     Teacher teacher =(Teacher)request.getAttribute("teacher");
%>
        
<form action="<%=request.getContextPath()%>/UpdateTeacherServlet"
method="post">
<table align="center">
	<tr>
		<td>老师编号:</td>
		<td><input type="text" name="teaId" readonly value="<%=teacher.getTeaId()%>"> </td>
	</tr>
	<tr>
		<td>老师姓名:</td>
		<td><input type  ="text" name="teaName"  value="<%=teacher.getTeaName()%>"> </td>
	</tr>
	<tr>
		<td>老师年龄:</td>
		<td><input type="number" name="teaAge" value="<%=teacher.getTeaAge()%>"> </td>
	</tr>
	<tr>
		<td>老师生日:</td>
		<td><input type="date" name="teaBtd" value="<%=teacher.getTeaBtd()%>"> </td>
	</tr>
	<tr>
		<td>性别:</td>
		<td>
			<input type="radio" name="teaSex" value="0"
				<% if(teacher.isTeaSex()== false){ out.println("checked");}%>>女
			<input type="radio" name="teaSex" value="1" checked="checked"
			<% if(teacher.isTeaSex()== true){ out.println("checked");}%>>男 
		</td>
	</tr>
	<tr>
		<td>老师电话:</td>
		<td><input type="text" name="teaTel" value="<%=teacher.getTeaTel()%>" > </td>
	</tr>
	<tr>
		<td>家庭住址:</td>
		<td><input type="text" name="teaaddress" value="<%=teacher.getTeaaddress()%>"> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


