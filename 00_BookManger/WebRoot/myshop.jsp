<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.CustomerInfo"%>
<%@page import="enetiy.CustomerDetailInfo"%>



<html>
<head>
    <title>我的空间</title>
    <style type="text/css">
    	body {
    		 margin: 0px,260px,0px,0px;
    		  padding: 30px,340px;
    		background-color: #E6EBEF;
    	}
    </style>
    <%
			CustomerInfo  customerInfo = (CustomerInfo)session.getAttribute("customerInfo");
	  %>
    
 </head>
  <body>
  	<h3 align="center">个人基本信息</h3>
  	编        号 ：<br><%=customerInfo.getCustId()%><br>
  	姓        名：<br><%=customerInfo.getCustName()%><br>
  	密        码：<br><%=customerInfo.getPwd()%><br>
  	Email：<br><%=customerInfo.getEmail()%><br>
  	<input type="button" value="修改" id="bt"><br><br>
  </body>
  <script type="text/javascript">
  	document.getElementById("bt").onclick = function() {
  		window.location = "updateMyInfo.jsp";
  	}
  </script>
</html>
