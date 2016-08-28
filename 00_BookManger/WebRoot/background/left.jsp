<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="com.sun.org.apache.xml.internal.security.transforms.params.InclusiveNamespaces"%>
<%@page import="enetiy.SysAdmin"%>
<%@page import="com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ContentType"%>
<%@ include file="check.jsp"%>

<html>
<head>

<style>
<!--
.wr{font-size: 12pt; line-height: 22px}
.wr1 {	FONT-SIZE: 12px; LINE-HEIGHT: 200%}
.wr2 {	FONT-SIZE: 14px; LINE-HEIGHT: 200%}
.wr3 {	FONT-SIZE: 12px}
.wr4 {	FONT-SIZE: 12px; LINE-HEIGHT: 150%}
 -->
</style>
<title>云工厂网上书店后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<%
	SysAdmin sysAdmin =(SysAdmin)session.getAttribute("sysAdmin");
%>
<body bgcolor="#FFFFDB" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="right">欢迎您:${sessionScope.sysAdmin.adminName }</td>
    <td width="12">&nbsp;</td>
  </tr>
  <%
       if(sysAdmin.getAdminType()==1){%>
    	  <%@include file="SysAdminType3.jsp"%>
     <%  }else if(sysAdmin.getAdminType()==2){%>
    	   <%@include file="SysAdminType2.jsp"%>
      <%  }else if(sysAdmin.getAdminType()==3){%>
       <%@include file="SysAdminType1.jsp"%>
    	   
       <% }
    %>
</body>
</html>