<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="enetiy.CustomerInfo"%>
<%@page import="enetiy.CustomerDetailInfo"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>我的空间</title>
    
    <style type="text/css">
    	body {
    		 margin: 0px,200px,0px,0px;
    		  padding: 30px,340px;
    		background-color: #E6EBEF;
    	}
   
  	
  	<%--<style type="text/css">
  		@IMPORT url("<%=request.getContextPath()%>/background/css/addUpdate.css");--%>
  	</style>
 </head>
  <%
  CustomerInfo customerInfo = (CustomerInfo)session.getAttribute("customerInfo");
  CustomerDetailInfo customerDetailInfo = (CustomerDetailInfo)session.getAttribute("customerDetailInfo");
  if(customerInfo == null) {
	  response.sendRedirect("qtlogin.jsp");
  }
  %>
  <body>
  
  		<form action="${pageContext.request.contextPath}/UpdateMyInfoServlet" method="post">
  			<table >
			<caption><h3 align="center">个人详细信息修改</h3></caption>
			<tr>
			  <td>用户名称：</td>
			  <td>
			  <input type="hidden" name="custId" id="custId"  value="<%=customerInfo.getCustId()%>" readonly>
			  <input type="text" name="custName" id="custName" value="<%=customerInfo.getCustName()%>"></td>
			</tr>
			<tr>
			  <td>性别：</td>
			<td><input type="text" name="sex"  value="<%=customerDetailInfo.getSex()%>"> </td>
			</tr>
			<tr>
			  <td>年龄：</td>
			  <td><input type="text" name="age" id="age" value="<%=customerDetailInfo.getAge()%>"></td>
			</tr>
			<tr>
			  <td>地址：</td>
			  <td><input type="text" name="address" id="address" value="<%=customerDetailInfo.getAddress()%>"></td>
			</tr>
			<tr>
			  <td>email：</td>
			  <td><input type="text" name="email" id="email" value="<%=customerInfo.getEmail()%>"></td>
			</tr>
			<tr>
			  <td>手机号码：</td>
			  <td><input type="text" name="tel" id="tel" value="<%=customerDetailInfo.getTel()%>"></td>
			</tr>
			<tr>
			  <td>qq：</td>
			  <td><input type="text" name="qq" id="qq" value="<%=customerDetailInfo.getQq()%>"></td>
			</tr>
			<tr>
			  <td><input type="submit" name="submit" value="修改" id="submit" onclick="return valid()"></td>
			  <td><input type="reset" name="reset" value="重置" id="reset"></td>
			</tr>
		</table>
  	</form>
  </body>
  	<script type="text/javascript">
			function valid() {
				alert("12");
				var custName = document.getElementById("custName").value;
				var age = document.getElementById("age").value;
				var tel = document.getElementById("tel").value;
				var qq = document.getElementById("qq").value;
		  		var email = document.getElementById("email").value;
		  		var pwdReg = /\w{3,10}/;
		  		var emailReg = /^\w+@{1}\w{1,6}\.\w{2,3}$/;
		  		var nameReg =/^[A-Za-z0-9\u4e00-\u9fa5_-]{3,12}$/;
		  		var telReg =/^1[0-9]{10}$/;
		  		var qqReg = /[1-9][0-9]{7,10}/;
				if(!nameReg.test(custName)) {
					alert("用户名须3-12个字符(包括字母、数字、中文、下划线)");
					return false;
				} else if(!emailReg.test(email)) {
					alert("email格式不正确！");
					return false;
				} else if(Number(age) > 100 || Number(age) <= 0) {
					alert("年龄必须在0到100！");
					return false;
				}else if((telReg ！= "null" ||telReg ！= "")&& !(telReg.test(tel))) {
					alert("填写的手机号格式不正确！");
					return false;
				}  else if((Number(qq) ！= 0 )&&!(qqReg.test(qq))) {
					alert("填写的qq号码格式不正确！");
					return false;
				}else {
					return true;
				}
			} 	
  	</script>
</html>
