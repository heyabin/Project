<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<s:if test="#session.oldStudent == null">
	<c:redirect url="findById_Student.action"></c:redirect>
</s:if>
<html>
<head>
	<title>修改学生信息</title>
</head>
<body>
        
<form action="<%=request.getContextPath()%>/update_Student.action" method="post">
<table align="center">
	<tr>
		<td>学生姓名:</td>
		<td><input type="text" name="student.stuName" value="${oldStudent.stuName}" > </td>
		<td><input hidden name="student.stuId" value="${oldStudent.stuId}"/></td>
	</tr>
	<tr>
		<td>学生年龄:</td>
		<td><input type="number" name="student.stuAge" value="${oldStudent.stuAge}"> </td>	
	</tr>
	<tr>
		<td>学生电话:</td>
		<td><input type="text" name="student.stuTel" value="${oldStudent.stuTel}"> </td>	
	</tr>
	<tr>
		<td>学生生日:</td>
		<td><input type="date" name="student.stuBtd" value="<s:date name='#session.oldStudent.stuBtd' format='yyyy-MM-dd'/>"/></td>	
	</tr>
	
	<tr>
		<td>性别:</td>
		<td>
			<input type="radio" name="student.stuSex" value="0">女
			<input type="radio" name="student.stuSex" value="1" checked="checked">男 
		</td>
	</tr>
	<tr>
		<td>是否可用 :</td>
		<td><input type="text" name="student.isDelete" value="${oldStudent.isDelete}"> </td>	
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


