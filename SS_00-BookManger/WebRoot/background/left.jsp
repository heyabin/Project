<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@ include file="check.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.po.SysAdmin"%>
		

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
<body bgcolor="#FFFFDB" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <s:if test="#session.sysAdmin.adminType==1">
  			<c:redirect url="SysAdminType3.jsp"></c:redirect>
  		</s:if>
  		<s:if test="#session.sysAdmin.adminType==2">
  			<c:redirect url="SysAdminType2.jsp"></c:redirect>
  		</s:if>
  		<s:if test="#session.sysAdmin.adminType==3">
  			<c:redirect url="SysAdminType1.jsp"></c:redirect>
  		</s:if>
  		
  </table>
</body>
</html>