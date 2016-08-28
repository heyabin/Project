<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
<head>
<style>
<!--
.wr{font-size: 12pt; line-height: 22px}
.wr1 {	FONT-SIZE: 12px; LINE-HEIGHT: 200%}
.wr2 {	FONT-SIZE: 14px; LINE-HEIGHT: 200%}
.wr3 {	FONT-SIZE: 12px}
.wr4 {	FONT-SIZE: 16px; LINE-HEIGHT: 150%}
.wr4 a:hover{color:#f00;}
a {
    color: #364B7E; 
	text-decoration: none;
}
// -->
</style>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#FFFFDB" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table>
	 <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">&nbsp;</td>
  </tr>
</table>
<table>
	 <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">&nbsp;</td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td background="${pageContext.request.contextPath}/background/images/ht08.jpg" class="wr4"> 
      <div align="center"><a href="<%=request.getContextPath()%>/myshop.jsp" target="mainFrame">个人信息</a></div>
    </td>
    <td width="12"><img src="${pageContext.request.contextPath}/background/images/ht07.jpg" width="12" height="20"></td>
  </tr>
</table>
<table>
	 <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">&nbsp;</td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td background="${pageContext.request.contextPath}/background/images/ht08.jpg" class="wr4"> 
      <div align="center"><a href="qtupdatecustomerInfo.jsp" target="mainFrame">密码修改</a></div>
    </td>
    <td width="12"><img src="${pageContext.request.contextPath}/background/images/ht07.jpg" width="12" height="20"></td>
  </tr>
</table>
<table>
	 <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">&nbsp;</td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td background="${pageContext.request.contextPath}/background/images/ht08.jpg" class="wr4"> 
      <div align="center"><a href="<%=request.getContextPath()%>/MakeOrderServlet" target="mainFrame">我的订单</a></div>
    </td>
    <td width="12"><img src="${pageContext.request.contextPath}/background/images/ht07.jpg" width="12" height="20"></td>
  </tr>
</table>
<table>
	 <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">&nbsp;</td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td background="${pageContext.request.contextPath}/background/images/ht08.jpg" class="wr4"> 
      <div align="center"><a href="qtsavefavorite.jsp" target="mainFrame">我的收藏夹</a></div>
    </td>
    <td width="12"><img src="${pageContext.request.contextPath}/background/images/ht07.jpg" width="12" height="20"></td>
  </tr>
</table>
&nbsp;
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td background="${pageContext.request.contextPath}/background/images/ht08.jpg" class="wr4"> 
      <div align="center"><a href="InitSevert" target="_blank">退出</a></div>
    </td>
    <td width="12"><img src="${pageContext.request.contextPath}/background/images/ht07.jpg" width="12" height="20"></td>
  </tr>
</table>
</body>
</html>
