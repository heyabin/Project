<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title >新增书评信息管理</title>
</head>
<body>
       <p align="center"> 新增书评信息管理</p>  
<form action="<%=request.getContextPath()%>/save_BookDiscuss.action"method="post">
<table align="center">
   
	<tr>
		<td>图书编号:</td>
		<td><input name="bookDiscuss.bookInfo.bookId"/></td>
	</tr>
	<tr>
		<td>客户编号:</td>
		<td><input  name="bookDiscuss.customerInfo.custId"/></td>
	</tr>
	<tr>
		<td>书评内容:</td>
		<td><input type="text" name="bookDiscuss.context"></input></td>
	</tr>
	<tr>
		<td>状态:</td>
		<td><input type="text" name="bookDiscuss.states"></td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


