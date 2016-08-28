<%@ page language="java" contentType="text/html; charset=gbk"%>
<html>
	<head><title>信息错误</title>
	</head>
<body>
	修改学生信息失败!
	<a href =" <%=request.getContextPath()%>/FindByStudentIdServlet?id=<%=request.getAttribute("id")%>" >返回</a>
</body>
</html>
