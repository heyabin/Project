<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>����ʯ�ʹ�ѧ</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body background="<%=request.getContextPath()%>/background/images/savahe.jpg">
         ������ҵ��Ϣ
<form action="<%=request.getContextPath()%>/SaveHomeworkServlet"
method="post">
<table align="center">
    <tr>
		<td width="74">ѧ��ѧ��:</td>
		<td width="223"><input type    ="text" name="homeId" placeholder="������ѧ��"  autofocus required> </td>
	</tr>
	<tr>
		<td>��ҵ����:</td>
		<td><input type  ="text" name="homeName" placeholder="��������ҵ����"  autofocus required></td>
	</tr>
	<td>��ҵ����:</td>
	<td>
	<textarea name="homecontext" rows="8"cols="25">1.�����������ߴ������ڰ����ļ����׶Σ����Ҫ����ÿ���׶εĹ���&nbsp; 
    2.����ѧ��ϵͳ����д��ҵ���ݿ� &nbsp;
   </textarea>
   </td>
	<tr>
		<td>�ύʱ��:</td>
		<td><input type="date" name="homesumbmit" autofocus required	
		value="2000-10-10"> </td>
	</tr>
	<tr>
		<td>ѧ���� ��::</td>
		<td><input type="number" name="homegrade" placeholder="������ɼ�"  autofocus required
		min="0" max="100"> </td>
	</tr>
	<tr>
		<td>ѧ������:</td>
		<td><input type="text" name="author"  placeholder="����������" autofocus required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>
