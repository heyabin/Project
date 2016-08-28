<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@ include file="check.jsp"%>
<html>
<head>
<title>作业批改与提交系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<frameset rows="93,*" cols="*" frameborder="NO" border="0" framespacing="0" >
     <frame name="topFrame" scrolling="NO" noresize src="<%=request.getContextPath()%>/background/kstop.jsp" >
  <frameset cols="180,*" frameborder="NO" border="0" framespacing="0" rows="*"> 
     <frame name="leftFrame" noresize scrolling="AUTO" src="<%=request.getContextPath()%>/background/ksleft.jsp" >
    <frame name="mainFrame" src="<%=request.getContextPath()%>/background/ksmain.jsp">
  </frameset>
</frameset>
<noframes >
<body  bgcolor="#33FFFF" text="#000000"  >
</noframes>
</body>
</html>

