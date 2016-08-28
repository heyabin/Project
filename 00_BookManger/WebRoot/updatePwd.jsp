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
  	</style>
  
 </head>
 
  <body>
  
  		<form action="<%=request.getContextPath()%>/UpdateMyPwdServlet" method="post">
  			<table>
			<caption><h3 align="center">密码修改</h3></caption>
			<tr>
			  <td>新 密 码:</td>
			  <td><input type="text" name="pwd" id="pwd" ></td>
			</tr>
			<tr>
			  <td>确认密码:</td>
			  <td><input type="password" name="repwd" id="repwd" ></td>
			</tr>
			<tr>
			  <td><input type="submit" name="submit" value="修改" id="submit" onclick="return valid();"></td>
			  <td><input type="reset" name="reset" value="重置" id="reset"></td>
			</tr>
		</table>
  	</form>
  </body>
  	<script type="text/javascript">
			function valid() {
				var pwd = document.getElementById("pwd").value;
				var repwd = document.getElementById("repwd").value;
				var filter=/^[A-Za-z0-9]{6,16}$/;
				if(!filter.test(pwd)) {
					alert("密码须6-16个字符(包括字母、数字)，推荐使用英文字母加数字或符号的组合密码！");
					return false;
				} else if (pwd != repwd) {
					alert("两次输入的密码不一致！");
					document.getElementById("repwd").value = "";
					return false;
				} else {
					return true;
				}
			} 	
  	</script>
</html>
