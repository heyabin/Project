<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.BookInfo"%>
<html>
<head>
	<title>修改图书类型信息</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<%
        BookInfo info =(BookInfo)request.getAttribute("info");

%>
<body>
         修改图书类型信息
<form action="<%=request.getContextPath()%>/UpdateBookinforServlet"
method="post">
<table align="center">
   <tr>
		<td>图书编号:</td>
		<td><input type="text" name="bookId" readonly value="<%=info.getBookId()%>"> </td>
	</tr>
	<tr>
		<td>图书名称:</td>
		<td><input type="text" name="bookName" value="<%=info.getBookName()%>" > </td>
	</tr>
	<tr>
		<td>图书类型编号:</td>
		<td><input type="num" name="bookTypeId" value="<%=info.getBookTypeId()%>" > </td>
	</tr>
	<tr>
		<td>作者:</td>
		<td><input type="text" name="author" value = "<%=info.getAuthor()%>" > </td>
	</tr>
	<tr>
		<td>出版社:</td>
		<td><input type="text" name="pbName"  value = "<%=info.getPbName() %>"> </td>
	</tr>
	<tr>
		<td>描述:</td>
		<td><input type="text" name="context"  value="<%=info.getContext() %>"> </td>
	</tr>
	<tr>
		<td>图片:</td>
		<td><input type="text" name="bigImg" value="<%=info.getBigImg()%>" > </td>
	</tr>
	<tr>
		<td>图片:</td>
		<td><input type="text" name="smallImg"  value="<%=info.getSmallImg()%>"> </td>
	</tr>
	<tr>
		<td>价格:</td>
		<td><input type="num" name="price" value="<%=info.getPrice()%>"> </td>
	</tr>
	<tr>
		<td>出版日期:</td>
		<td><input type="date" name="pbdate" value="<%=info.getPbdate()%>" > </td>
	</tr>
	<tr>
		<td>会员价:</td>
		<td><input type="num" name="hyprice" value="<%=info.getHyprice()%>" > </td>
	</tr>
	<tr>
		<td>图书状态:</td>
		<td><input type="num" name="bookStates" value="<%=info.getBookStates()%>" > </td>
	</tr>
	<tr>
		<td>上架日期:</td>
		<td><input type="Date" name="datetime" value="<%=info.getDatetime()%>"> </td>
	</tr>
	<tr>
		<td>库存:</td>
		<td><input type="num" name="num" value="<%=info.getNum()%>" > </td>
	</tr>
	<tr>
		<td>销售量:</td>
		<td><input type="num" name="saleCount" value="<%=info.getSaleCount()%>" > </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


