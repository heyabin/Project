<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.BookDiscuss"%>
<html>
<head>
	<title>�޸�������Ϣ</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<%
        BookDiscuss bookDiscuss =(BookDiscuss)request.getAttribute("bookDiscuss");

%>
<body>
         �޸�������Ϣ
<form action="<%=request.getContextPath()%>/UpdatebookDiscussServlet"
method="post">
<table align="center">
   <tr>
		<td>�������:</td>
		<td><input type="num" name="disId" readonly value="<%=bookDiscuss.getDisId()%>"> </td>
	</tr>
	<tr>
		<td>ͼ����:</td>
		<td><input type="num" name="bookId" value="<%=bookDiscuss.getBookId()%>" > </td>
	</tr>
	<tr>
		<td>�ͻ����:</td>
		<td><input type="num" name="custId" value="<%=bookDiscuss.getCustId()%>" > </td>
	</tr>
	<tr>
		<td>��������:</td>
		<td><input type="text" name="context" value = "<%=bookDiscuss.getContext()%>" > </td>
	</tr>
	<tr>
		<td>״̬:</td>
		<td><input type="text" name="states"  value = "<%=bookDiscuss.getStates() %>"> </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>


