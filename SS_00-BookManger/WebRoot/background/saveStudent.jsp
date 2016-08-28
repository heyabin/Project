<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@page import="java.util.List"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>新增学生信息列表</title>
</head>
<body >
	<form action="<%=request.getContextPath()%>/save_Student.action">
		<table align="center">
			<tr>
				<td>学生姓名:</td>
				<td><input name="student.stuName"/></td>
			</tr>
			<tr>
				<td>学生年龄:</td>
			     <td><input  name="student.stuAge"/></td>
			</tr>
			<tr>
				<td>学生生日:</td>
				<td><input type = "date" name="student.stuBtd"/></td>	
			</tr>
    	<tr>
		<td>学生性别:</td>
       <td>
       <s:radio name="student.stuSex" list="#{'男':'男','女':'女'}" listKey="key" listValue="value" value="'男'"/>
       </td>
	   <tr>
		<td>学生电话:</td>
		<td><input type = "text" name="student.stuTel"/></td>
	    </tr>
	    <tr>
		<td>是否可用:</td>
        <td><input type ="text" name="student.isDelete"/></td>
			</tr>
	 	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
		</tr>
		</table>
	</form>
</body>
</html>


