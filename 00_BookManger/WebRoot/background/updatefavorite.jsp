<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.Favorite"%>
<html>
<head>
	<title>修改收藏信息</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<%
      Favorite favorite =(Favorite)request.getAttribute("favorite");

%>
<body>
         修改收藏信息
<form action="<%=request.getContextPath()%>/UpdatefavoriteServlet"
method="post">
<table align="center">
   <tr> 
		<td>收藏编号:</td>
		<td><input type="num" name="favoriteId" readonly value="<%=favorite.getFavoriteId()%>"> </td>
	</tr>
	<tr>
		<td>图书编号:</td>
		<td><input type="num" name="bookId" value="<%=favorite.getBookId()%>" > </td>
	</tr>
	<tr>
		<td>顾客编号:</td>
		<td><input type="num" name="custId" value="<%=favorite.getCustId()%>" > </td>
	</tr>
	<tr>
		<td>收藏日期:</td>
		<td><input type="date" name="date" value = "<%=favorite.getDate()%>" > </td>
	</tr>
	<tr>
		<td>收藏内容:</td>
		<td><input type="text" name="context"  value="<%=favorite.getContext()%>"> </td>
	</tr>
	
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


