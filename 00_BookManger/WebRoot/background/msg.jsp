<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
	<head><title>ÐÅÏ¢´íÎó</title>
	</head>
<body>
	<%=request.getAttribute("msg")%>
	<a href =" <%=request.getContextPath()%><%=request.getAttribute("returnPath")%>">·µ»Ø</a>
</body>
</html>
