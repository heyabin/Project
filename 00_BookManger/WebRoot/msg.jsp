<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
	<head><title>��Ϣ����</title>
	</head>
<body>
	<%=request.getAttribute("msg")%>
	<a href =" <%=request.getContextPath()%><%=request.getAttribute("returnPath")%>"></a>
</body>
</html>
