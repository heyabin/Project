<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.CustomerInfo"%>
<%@page import="enetiy.CustomerDetailInfo"%>



<html>
<head>
    <title>�ҵĿռ�</title>
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
  	<h3 align="center">���˻�����Ϣ</h3>
  	��        �� ��<br><%=customerInfo.getCustId()%><br>
  	��        ����<br><%=customerInfo.getCustName()%><br>
  	��        �룺<br><%=customerInfo.getPwd()%><br>
  	Email��<br><%=customerInfo.getEmail()%><br>
  	<input type="button" value="�޸�" id="bt"><br><br>
  </body>
  <script type="text/javascript">
  	document.getElementById("bt").onclick = function() {
  		window.location = "updateMyInfo.jsp";
  	}
  </script>
</html>
