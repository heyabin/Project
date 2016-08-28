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
<title>清韵网上书店后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body>
<%
    CustomerInfo customerInfo = (CustomerInfo)session.getAttribute("customerInfo");
    CustomerDetailInfo customerDetailInfo = (CustomerDetailInfo)session.getAttribute("customerDetailInfo"); 
%>

<% if(customerInfo == null||customerDetailInfo==null){%>
	 <a href ="qtsavecustomerDetailInfo.jsp">你还没有完善详细信息请点击这里完善</a>
 <%}else{%>
 	<h3 align="center">个人详细基本信息</h3>
  	账户名称：<br><br>
  	性        别：<br><%=customerDetailInfo.getSex()%><br>
  	年        龄：<br><%=customerDetailInfo.getAge()%><br>
  	地        址：<br><%=customerDetailInfo.getAddress()%><br>
  	Email：   <br><%=customerDetailInfo.getSex()%><br>
  	手机号码：<br><%=customerDetailInfo.getTel()%><br>
  	qq号码：	<br><%=customerDetailInfo.getQq()%><br>
 
<% }%>
 
</body>
</html>

