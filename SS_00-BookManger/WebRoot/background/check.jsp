<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<c:if test="${empty sessionScope.sysAdmin}">
	<c:redirect url="login.jsp">
	</c:redirect>
</c:if>
