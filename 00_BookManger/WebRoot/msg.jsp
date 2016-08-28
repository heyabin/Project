<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
	<head><title>пео╒╢МнС</title>
	</head>
<body>
	<%=request.getAttribute("msg")%>
	<a href =" <%=request.getContextPath()%><%=request.getAttribute("returnPath")%>"></a>
</body>
</html>
