<%@ page language="java"  contentType="text/html; charset=utf-8"%>
<html>
  <head>
    
    <title>My JSP 'makeOrderOK.jsp' starting page</title>

  </head>
  
  <body>
	<h1>提示</h1>
	下订单成功,您的订单编号是:<%=session.getAttribute("orderNum") %>!<a href="index.jsp">返回</a>
  </body>
</html>


