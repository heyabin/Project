<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.BookInfo"%>
<html>
<head>
	<title>�޸�ͼ��������Ϣ</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<%
        BookInfo info =(BookInfo)request.getAttribute("info");

%>
<body>
         �޸�ͼ��������Ϣ
<form action="<%=request.getContextPath()%>/UpdateBookinforServlet"
method="post">
<table align="center">
   <tr>
		<td>ͼ����:</td>
		<td><input type="text" name="bookId" readonly value="<%=info.getBookId()%>"> </td>
	</tr>
	<tr>
		<td>ͼ������:</td>
		<td><input type="text" name="bookName" value="<%=info.getBookName()%>" > </td>
	</tr>
	<tr>
		<td>ͼ�����ͱ��:</td>
		<td><input type="num" name="bookTypeId" value="<%=info.getBookTypeId()%>" > </td>
	</tr>
	<tr>
		<td>����:</td>
		<td><input type="text" name="author" value = "<%=info.getAuthor()%>" > </td>
	</tr>
	<tr>
		<td>������:</td>
		<td><input type="text" name="pbName"  value = "<%=info.getPbName() %>"> </td>
	</tr>
	<tr>
		<td>����:</td>
		<td><input type="text" name="context"  value="<%=info.getContext() %>"> </td>
	</tr>
	<tr>
		<td>ͼƬ:</td>
		<td><input type="text" name="bigImg" value="<%=info.getBigImg()%>" > </td>
	</tr>
	<tr>
		<td>ͼƬ:</td>
		<td><input type="text" name="smallImg"  value="<%=info.getSmallImg()%>"> </td>
	</tr>
	<tr>
		<td>�۸�:</td>
		<td><input type="num" name="price" value="<%=info.getPrice()%>"> </td>
	</tr>
	<tr>
		<td>��������:</td>
		<td><input type="date" name="pbdate" value="<%=info.getPbdate()%>" > </td>
	</tr>
	<tr>
		<td>��Ա��:</td>
		<td><input type="num" name="hyprice" value="<%=info.getHyprice()%>" > </td>
	</tr>
	<tr>
		<td>ͼ��״̬:</td>
		<td><input type="num" name="bookStates" value="<%=info.getBookStates()%>" > </td>
	</tr>
	<tr>
		<td>�ϼ�����:</td>
		<td><input type="Date" name="datetime" value="<%=info.getDatetime()%>"> </td>
	</tr>
	<tr>
		<td>���:</td>
		<td><input type="num" name="num" value="<%=info.getNum()%>" > </td>
	</tr>
	<tr>
		<td>������:</td>
		<td><input type="num" name="saleCount" value="<%=info.getSaleCount()%>" > </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>


