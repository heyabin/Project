<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.Teacher"%>
<html>
<head>
	<title>�޸���ʦ��Ϣ</title>
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
		<td>��ʦ���:</td>
		<td><input type="text" name="teaId" readonly value="<%=teacher.getTeaId()%>"> </td>
	</tr>
	<tr>
		<td>��ʦ����:</td>
		<td><input type  ="text" name="teaName"  value="<%=teacher.getTeaName()%>"> </td>
	</tr>
	<tr>
		<td>��ʦ����:</td>
		<td><input type="number" name="teaAge" value="<%=teacher.getTeaAge()%>"> </td>
	</tr>
	<tr>
		<td>��ʦ����:</td>
		<td><input type="date" name="teaBtd" value="<%=teacher.getTeaBtd()%>"> </td>
	</tr>
	<tr>
		<td>�Ա�:</td>
		<td>
			<input type="radio" name="teaSex" value="0"
				<% if(teacher.isTeaSex()== false){ out.println("checked");}%>>Ů
			<input type="radio" name="teaSex" value="1" checked="checked"
			<% if(teacher.isTeaSex()== true){ out.println("checked");}%>>�� 
		</td>
	</tr>
	<tr>
		<td>��ʦ�绰:</td>
		<td><input type="text" name="teaTel" value="<%=teacher.getTeaTel()%>" > </td>
	</tr>
	<tr>
		<td>��ͥסַ:</td>
		<td><input type="text" name="teaaddress" value="<%=teacher.getTeaaddress()%>"> </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>


