<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
	<title>����ͼ��������Ϣ</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
         ����ͼ��������Ϣ
<form action="<%=request.getContextPath()%>/SaveBookinforServlet"
method="post">
<table align="center">
	<tr>
		<td>ͼ������:</td>
		<td><input type="text" name="bookName" placeholder="����������"  autofocus required> </td>
	</tr>
	<tr>
		<td>ͼ�����ͱ��:</td>
		<td><input type="num" name="bookTypeId" placeholder="������ͼ����"  autofocus required
		min="0" max="10"> </td>
	</tr>
	<tr>
		<td>����:</td>
		<td><input type="text" name="author" autofocus required > </td>
	</tr>
	<tr>
		<td>������:</td>
		<td><input type="text" name="pbName" autofocus required > </td>
	</tr>
	<tr>
		<td>����:</td>
		<td><input type="text" name="context" autofocus required > </td>
	</tr>
	<tr>
		<td>ͼƬ:</td>
		<td><input type="text" name="bigImg" autofocus required > </td>
	</tr>
	<tr>
		<td>ͼƬ:</td>
		<td><input type="text" name="smallImg" autofocus required > </td>
	</tr>
	<tr>
		<td>�۸�:</td>
		<td><input type="num" name="price" autofocus required > </td>
	</tr>
	<tr>
		<td>��������:</td>
		<td><input type="date" name="pbdate" autofocus required > </td>
	</tr>
	<tr>
		<td>��Ա��:</td>
		<td><input type="num" name="hyprice" autofocus required > </td>
	</tr>
	<tr>
		<td>ͼ��״̬:</td>
		<td><input type="num" name="bookStates" autofocus required > </td>
	</tr>
	<tr>
		<td>�ϼ�����:</td>
		<td><input type="Date" name="datetime" autofocus required > </td>
	</tr>
	<tr>
		<td>���:</td>
		<td><input type="num" name="num" autofocus required > </td>
	</tr>
	<tr>
		<td>������:</td>
		<td><input type="num" name="saleCount" autofocus required > </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>


