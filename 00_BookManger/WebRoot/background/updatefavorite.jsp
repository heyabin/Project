<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.Favorite"%>
<html>
<head>
	<title>�޸��ղ���Ϣ</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<%
      Favorite favorite =(Favorite)request.getAttribute("favorite");

%>
<body>
         �޸��ղ���Ϣ
<form action="<%=request.getContextPath()%>/UpdatefavoriteServlet"
method="post">
<table align="center">
   <tr> 
		<td>�ղر��:</td>
		<td><input type="num" name="favoriteId" readonly value="<%=favorite.getFavoriteId()%>"> </td>
	</tr>
	<tr>
		<td>ͼ����:</td>
		<td><input type="num" name="bookId" value="<%=favorite.getBookId()%>" > </td>
	</tr>
	<tr>
		<td>�˿ͱ��:</td>
		<td><input type="num" name="custId" value="<%=favorite.getCustId()%>" > </td>
	</tr>
	<tr>
		<td>�ղ�����:</td>
		<td><input type="date" name="date" value = "<%=favorite.getDate()%>" > </td>
	</tr>
	<tr>
		<td>�ղ�����:</td>
		<td><input type="text" name="context"  value="<%=favorite.getContext()%>"> </td>
	</tr>
	
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>


