<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="#session.oldBookDiscuss == null">
	<c:redirect url="findById_BookDiscuss.action"></c:redirect>
</s:if>
<html>
<head>
	<title>修改书评信息</title>
	<style type="text/css">
		@import '${pageContext.request.contextPath}/background/css/addUpdate.css'
	</style>
</head>
<body>
         修改书评信息
<form action="<%=request.getContextPath()%>/update_BookDiscuss.action"
method="post">
<table align="center">
 
	<tr>
		<td>图书编号:</td>
		<td><input type="num" name="bookDiscuss.bookInfo.bookId" value="${oldBookDiscuss.bookInfo.bookId}" > </td>
		<td><input hidden name="bookDiscuss.disId"  value="${oldBookDiscuss.disId}"/></td> 
	</tr>
	<tr> 
		<td>客户编号:</td>
		<td><input type="num" name="bookDiscuss.customerInfo.custId" value="${oldBookDiscuss.customerInfo.custId }" > </td>
	</tr>
	<tr>
		<td>书评内容:</td>
		<td><input type="text" name="bookDiscuss.context" value ="${oldBookDiscuss.context}" > </td>
	</tr>
	<tr>
		<td>状态:</td>
		<td><input type="text" name="bookDiscuss.states"  value = "${oldBookDiscuss.states}"> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


