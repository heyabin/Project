<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.BookType"%>
<html>
<head>
	<title>�޸�ͼ�����</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
<%
      BookType stu = (BookType)request.getAttribute("stu");
		out.print(stu);
%>
        
<form action="<%=request.getContextPath()%>/UpdateBookTypeServlet"
method="post">
<table align="center">
    <tr>
		<td>ͼ����:</td>
		<td><input type="num" name="bookTypeId" readonly value="<%=stu.getBookTypeId()%>"> </td>
	</tr>
	<tr>
		<td>ͼ�鸸���:</td>
		<td><input type="num" name="parentId"  value="<%=stu.getParentId()%>"> </td>
	</tr>
	<tr>
		<td>ͼ���������:</td>
		<td><input type="text" name="bookTypeName"  value="<%=stu.getBookTypeName()%>"> </td>
	</tr>
	<tr>
		<td>ͼ���������:</td>
		<td><input type="text" name="context" value="<%=stu.getContext()%>"> </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>


