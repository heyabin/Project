<%@ page language="java" contentType="text/html; charset=gbk"%>
<%
   if(session.getAttribute("sysAdmin") == null){
	   //request.getRequestDispatcher("login.jsp").forward(request,response);
	  response.sendRedirect("kslogin.jsp");
	  return;
	  
   }
%>
