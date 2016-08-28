<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.po.BookType"%>

<html>
<head>
<title>修改图书类别</title>
<style type="text/css" >
	@import'<%= request.getContextPath()%>/background/css/addUpdate.css'
</style>
</head>
<body>
<%
	BookType bookType = (BookType)request.getAttribute("books");
%>
<form action="<%=request.getContextPath() %>/update_BookType.action" method="post">
<table align="center">
	<tr>
	<td>父类书的代号：</td>
	<td><input  type="text" name="bookType.parentId" required  autofocus value="${oldBookType.parentId}" /></td>
	<td><input  type="hidden" name="bookType.bookTypeId" value="${oldBookType.bookTypeId}" readonly/></td>
	</tr>
	<tr>
	<td>类型名称：</td>
	<td><input type="text" name="bookType.bookTypeName" required value="${oldBookType.bookTypeName}"  autofocus /></td>
	</tr>
	<tr>
	<td>书型描述：</td>
	<td><input type="text" name="bookType.context" required value="${oldBookType.context}"  autofocus /></td>
	</tr>
	<tr>
	<td>是否可用：</td>
	<td><input type="number" name="bookType.isDelete" required value="${oldBookType.isDelete}"  autofocus /></td>
	</tr>
	<tr>
	<td>
	<input type="submit" name="submit" value="提交"/>
	<input type="reset" name="reset" value="重置"/></td>
	</tr>
</table>

</form>

</body>
</html>