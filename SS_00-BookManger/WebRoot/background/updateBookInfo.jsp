<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@page import="com.po.BookInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

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
<form action="<%=request.getContextPath()%>/update_BookInfo.action"
method="post">
<table align="center">
	<tr>
		<td>图书名称:</td>
		<td><input type="text" name="bookInfo.bookName" value="${oldBookInfo.bookName}" > </td>
		<td><input type="hidden" name="bookInfo.bookId"  value="${oldBookInfo.bookId}"> </td>
	</tr>
	<tr>
		<td>图书类型编号:</td>
		<td><input type="num" name="bookInfo.bookType.bookTypeId" value="${oldBookInfo.bookType.bookTypeId}" > </td>
	</tr>
	<tr>
		<td>作者:</td>
		<td><input type="text" name="bookInfo.author" value = "${oldBookInfo.author}" > </td>
	</tr>
	<tr>
		<td>出版社:</td>
		<td><input type="text" name="bookInfo.pbName"  value = "${oldBookInfo.pbName}"> </td>
	</tr>
	<tr>
		<td>描述:</td>
		<td><input type="text" name="bookInfo.context"  value="${oldBookInfo.context}"> </td>
	</tr>
	<tr>
		<td>图片:</td>
		<td><input type="text" name="bookInfo.bigImg" value="${oldBookInfo.bigImg}" > </td>
	</tr>
	<tr>
		<td>图片:</td>
		<td><input type="text" name="bookInfo.smallImg"  value="${oldBookInfo.smallImg}"> </td>
	</tr>
	<tr>
		<td>价格:</td>
		<td><input type="num" name="bookInfo.price" value="${oldBookInfo.price}"> </td>
	</tr>
	<tr>
		<td>出版日期:</td>
		<td><input type="date" name="bookInfo.pbdate" value="<s:date name="#session.oldBookInfo.pbdate" format="yyyy-MM-dd"/>" > </td>
	</tr>
	<tr>
		<td>会员价:</td>
		<td><input type="num" name="bookInfo.hyprice" value="${oldBookInfo.hyprice}" > </td>
	</tr>
	<tr>
		<td>图书状态:</td>
		<td><input type="num" name="bookInfo.bookStates" value="${oldBookInfo.bookStates}" > </td>
	</tr>
	<tr>
		<td>上架日期:</td>
		<td><input type="date" name="bookInfo.sjdate" value="<s:date name="#session.oldBookInfo.sjdate" format="yyyy-MM-dd"/>"> </td>
	</tr>
	<tr>
		<td>库存:</td>
		<td><input type="num" name="bookInfo.num" value="${oldBookInfo.num}" > </td>
	</tr>
	<tr>
		<td>销售量:</td>
		<td><input type="num" name="bookInfo.saleCount" value="${oldBookInfo.saleCount}"> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


