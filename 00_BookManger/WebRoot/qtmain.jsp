<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.CustomerInfo"%>
<%@page import="enetiy.CustomerDetailInfo"%>

<html>
<head>
<style>
<!--
.wr{font-size: 12pt; line-height: 22px}
.wr1 {	FONT-SIZE: 12px; LINE-HEIGHT: 200%}
.wr2 {	FONT-SIZE: 14px; LINE-HEIGHT: 200%}
.wr3 {	FONT-SIZE: 12px}
.wr4 {	FONT-SIZE: 12px; LINE-HEIGHT: 150%}
// -->
</style>
<title>������������̨����ϵͳ</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body>
<%
    CustomerInfo customerInfo = (CustomerInfo)session.getAttribute("customerInfo");
    CustomerDetailInfo customerDetailInfo = (CustomerDetailInfo)session.getAttribute("customerDetailInfo"); 
%>

<% if(customerInfo == null||customerDetailInfo==null){%>
	 <a href ="qtsavecustomerDetailInfo.jsp">�㻹û��������ϸ��Ϣ������������</a>
 <%}else{%>
 	<h3 align="center">������ϸ������Ϣ</h3>
  	�˻����ƣ�<br><br>
  	��        ��<br><%=customerDetailInfo.getSex()%><br>
  	��        �䣺<br><%=customerDetailInfo.getAge()%><br>
  	��        ַ��<br><%=customerDetailInfo.getAddress()%><br>
  	Email��   <br><%=customerDetailInfo.getSex()%><br>
  	�ֻ����룺<br><%=customerDetailInfo.getTel()%><br>
  	qq���룺	<br><%=customerDetailInfo.getQq()%><br>
 
<% }%>
 
</body>
</html>

