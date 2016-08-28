<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.BookDiscuss"%>
<html>
<head>
	<title>修改书评信息</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<%
        BookDiscuss bookDiscuss =(BookDiscuss)request.getAttribute("bookDiscuss");

%>
<body>
         修改书评信息
<form action="<%=request.getContextPath()%>/UpdatebookDiscussServlet"
method="post">
<table align="center">
   <tr>
		<td>书评编号:</td>
		<td><input type="num" name="disId" readonly value="<%=bookDiscuss.getDisId()%>"> </td>
	</tr>
	<tr>
		<td>图书编号:</td>
		<td><input type="num" name="bookId" value="<%=bookDiscuss.getBookId()%>" > </td>
	</tr>
	<tr>
		<td>客户编号:</td>
		<td><input type="num" name="custId" value="<%=bookDiscuss.getCustId()%>" > </td>
	</tr>
	<tr>
		<td>书评内容:</td>
		<td><input type="text" name="context" value = "<%=bookDiscuss.getContext()%>" > </td>
	</tr>
	<tr>
		<td>状态:</td>
		<td><input type="text" name="states"  value = "<%=bookDiscuss.getStates() %>"> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


