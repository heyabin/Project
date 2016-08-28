<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
	<title>新增图书类型信息</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
         新增图书类型信息
<form action="<%=request.getContextPath()%>/save_BookInfo.action" method="post">
<table align="center">
	<tr>
		<td>图书名称:</td>
		<td><input type="text" name="bookInfo.bookName" placeholder="请输入书名"  autofocus required> </td>
	</tr>
	<tr>
		<td>图书类型编号:</td>
		<td><input type="num" name="bookInfo.bookType.bookTypeId" placeholder="请输入图书编号"  autofocus required
		min="0" max="10"> </td>
	</tr>
	<tr>
		<td>作者:</td>
		<td><input type="text" name="bookInfo.author" autofocus required > </td>
	</tr>
	<tr>
		<td>出版社:</td>
		<td><input type="text" name="bookInfo.pbName" autofocus required > </td>
	</tr>
	<tr>
		<td>描述:</td>
		<td><input type="text" name="bookInfo.context" autofocus required > </td>
	</tr>
	<tr>
		<td>图片:</td>
		<td><input type="text" name="bookInfo.bigImg" autofocus required > </td>
	</tr>
	<tr>
		<td>图片:</td>
		<td><input type="text" name="bookInfo.smallImg" autofocus required > </td>
	</tr>
	<tr>
		<td>价格:</td>
		<td><input type="number" name="bookInfo.price" autofocus required > </td>
	</tr>
	<tr>
		<td>出版日期:</td>
		<td><input type="date" name="bookInfo.pbdate" autofocus required > </td>
	</tr>
	<tr>
		<td>会员价:</td>
		<td><input type="num" name="bookInfo.hyprice" autofocus required > </td>
	</tr>
	<tr>
		<td>图书状态:</td>
		<td><input type="num" name="bookInfo.bookStates" autofocus required > </td>
	</tr>
	<tr>
		<td>上架日期:</td>
		<td><input type="Date" name="bookInfo.datetime" autofocus required > </td>
	</tr>
	<tr>
		<td>库存:</td>
		<td><input type="num" name="bookInfo.num" autofocus required > </td>
	</tr>
	<tr>
		<td>销售量:</td>
		<td><input type="num" name="bookInfo.saleCount" autofocus required > </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


