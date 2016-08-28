<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>新增收藏信息</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
         新增收藏信息
<form action="<%=request.getContextPath()%>/SavefavoriteServlet"
method="post">
<table align="center">
	<tr>
	      <td>图书编号:</td>
		<td><input type="num" name="bookId" placeholder="请输入图书编号"  autofocus required> </td>
	</tr>
	 <tr>
		<td>顾客编号:</td>
		<td><input type="num" name="custId" placeholder="请输入顾客编号"  autofocus required> </td>
	</tr>
	
	<tr>
		<td>收藏日期:</td>
		<td><input type="date" name="date" autofocus required > </td>
	</tr>
	<tr>
		<td>收藏内容:</td>
		<td><input type="text" name="context" autofocus required > </td>
	</tr>
	
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


