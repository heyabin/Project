<%@ page language="java" contentType="text/html; charset=gbk"%>

<html>
<head>
	<title>�����ͻ����</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
   
<form action="<%=request.getContextPath()%>/save_CustomerDetailInfo.action" method="post">
<table>
	<tr>
		<td>�ͻ����:</td>
		<td><input type="number" name="customerDetailInfo.custId"/> </td>
	</tr>
	<tr>
		<td>�ͻ��绰:</td>
		<td><input type="text" name="customerDetailInfo.tel"/> </td>
	</tr>
	<tr>
		<td>�ͻ���ַ:</td>
		<td><input type="text" name="customerDetailInfo.address"/> </td>
	</tr>
		<tr>
		 <td>�ͻ��Ա�:</td>
		 <td>
      		 <input type="radio" name="customerDetailInfo.sex" value="0"/>Ů
			<input type="radio" name="customerDetailInfo.sex" value="1" checked="checked"/>��
       </td>
	<tr>
		<td>�ͻ�����:</td>
		<td><input type="number" name="customerDetailInfo.age" /> </td>
	</tr>
	<tr>
		<td>���ѽ��:</td>
		<td><input type="number" name="customerDetailInfo.countMoney"/> </td>
	</tr>
	<tr>
		<td>�ͻ�QQ:</td>
		<td><input type="number" name="customerDetailInfo.qq" /> </td>
	</tr>
	<tr>
		<td><input type="submit" value="����"> </td>
		<td><input type="reset" value="����"> </td>
	</tr>
</table>
</form>
</body>
</html>



