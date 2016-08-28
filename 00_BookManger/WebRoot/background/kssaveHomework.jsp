<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>西安石油大学</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body background="<%=request.getContextPath()%>/background/images/savahe.jpg">
         新增作业信息
<form action="<%=request.getContextPath()%>/SaveHomeworkServlet"
method="post">
<table align="center">
    <tr>
		<td width="74">学生学号:</td>
		<td width="223"><input type    ="text" name="homeId" placeholder="请输入学号"  autofocus required> </td>
	</tr>
	<tr>
		<td>作业名称:</td>
		<td><input type  ="text" name="homeName" placeholder="请输入作业名称"  autofocus required></td>
	</tr>
	<td>作业内容:</td>
	<td>
	<textarea name="homecontext" rows="8"cols="25">1.求完整的总线传输周期包括哪几个阶段？请简要叙述每个阶段的工作&nbsp; 
    2.根据学生系统，编写作业数据库 &nbsp;
   </textarea>
   </td>
	<tr>
		<td>提交时间:</td>
		<td><input type="date" name="homesumbmit" autofocus required	
		value="2000-10-10"> </td>
	</tr>
	<tr>
		<td>学生成 绩::</td>
		<td><input type="number" name="homegrade" placeholder="请输入成绩"  autofocus required
		min="0" max="100"> </td>
	</tr>
	<tr>
		<td>学生姓名:</td>
		<td><input type="text" name="author"  placeholder="请输入姓名" autofocus required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>
