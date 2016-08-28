<%@ page language="java" contentType="text/html; charset=gbk"%>

<html>
<head>
	<title>新增客户类别</title>
	<style type="text/css">
		@import '<%=request.getContextPath()%>/background/css/addUpdate.css'
	</style>
</head>
<body>
   
<form action="<%=request.getContextPath()%>/save_CustomerDetailInfo.action" method="post">
<table>
	<tr>
		<td>客户编号:</td>
		<td><input type="number" name="customerDetailInfo.custId"/> </td>
	</tr>
	<tr>
		<td>客户电话:</td>
		<td><input type="text" name="customerDetailInfo.tel"/> </td>
	</tr>
	<tr>
		<td>客户地址:</td>
		<td><input type="text" name="customerDetailInfo.address"/> </td>
	</tr>
		<tr>
		 <td>客户性别:</td>
		 <td>
      		 <input type="radio" name="customerDetailInfo.sex" value="0"/>女
			<input type="radio" name="customerDetailInfo.sex" value="1" checked="checked"/>男
       </td>
	<tr>
		<td>客户年龄:</td>
		<td><input type="number" name="customerDetailInfo.age" /> </td>
	</tr>
	<tr>
		<td>消费金额:</td>
		<td><input type="number" name="customerDetailInfo.countMoney"/> </td>
	</tr>
	<tr>
		<td>客户QQ:</td>
		<td><input type="number" name="customerDetailInfo.qq" /> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>



