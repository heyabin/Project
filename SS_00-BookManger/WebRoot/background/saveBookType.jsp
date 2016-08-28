<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>s
<html>
<head>
<title>新增图书类别</title>
<style type="text/css" >
	@import'<%= request.getContextPath()%>/background/css/addUpdate.css'
</style>
</head>
<body>
<form action="<%=request.getContextPath() %>/save_BookType.action" method="get">
<table align="center">
	
	<tr>
	<td>父类书的代号：</td>
	<td><input type="text" name="bookType.parentId" required placeholder="请输入父类书的代号" autofocus /></td>
	</tr>
	<tr>
	<td>类型名称：</td>
	<td><input type="text" name="bookType.bookTypeName" required placeholder="请输入书的类型" autofocus /></td>
	</tr>
	<tr>
	<td>书型描述：</td>
	<td><input type="text" name="bookType.context" required placeholder="请输入书的类型描述" autofocus /></td>
	</tr>
	<tr>
	<td>书型描述：</td>
	<td><input type="text" name="bookType.isDelete" required placeholder="请输入书的类型描述" autofocus /></td>
	</tr>
	<tr>
	
	<td>
	<input type="submit" name="submit" value="提交"/>
	<input type="reset" name="reset" value="重置"/></td>
	</tr>
</table>

</form>

</body>
</html>