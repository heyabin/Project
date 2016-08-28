<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<s:if test="#session.pb.pagelist==null">
	<c:redirect url="findAll_CustomerInfo.action"></c:redirect>
</s:if>
<html>
  <head><title>�û���Ϣ����</title>
     <style type="text/css">
     	@import '<%=request.getContextPath()%>/background/css/body.css'
     </style>
 
        	<script>
       //�ı�ÿҳ��¼��
	function doChangeRows(){
		var rows=document.form1.rows.value;
		if(isNaN(rows)){
			alert("��������ȷ�����֣�");
			document.form1.rows.value=${pb.rows};
			return;
		}
		window.location="findAll_CustomerInfo.action?rows="+rows;
		
	}
	//�ı�ҳ������ҳ��
	function doChangePage(){
		var page=document.form1.page.value;
		if(isNaN(page)){
			alert("��������ȷ�����֣�");
			document.form1.page.value=${pb.page};
			return;
		}
		window.location="findAll_CustomerInfo.action?page="+page;
		
	}
	//ɾ����ʾ
	function doel(name){
		 return confirm("��ȷ��Ҫɾ��["+name+"]��");
	}
</script>
        </head>
        <body>
         <table border="1">
         <caption align="center">�û�������Ϣ</caption> 
         	<tr>
         	   <th>custId</th>
         	   <th>custName</th>
         	   <th>pwd</th>
         	   <th>email</th>
         	   <th>delete</th>
         	   <th>update</th>
         	</tr>
 			<s:iterator value="#session.pb.pagelist" var="customerInfo">
		  	<tr>
		  	<td>${customerInfo.custId}</td>
		    <td>${customerInfo.custName}</td>
		  	<td>${customerInfo.pwd}</td>
		    <td>${customerInfo.email}</td>
         	<td><a href="<%=request.getContextPath()%>/findById_CustomerInfo?custId=${customerInfo.custId}">update</a></td>
			<td><a href="<%=request.getContextPath()%>/delById_CustomerInfo?custId=${customerInfo.custId}"onclick="return isDelete('${customerInfo.custName}')">delete</a></td>
         	</tr>
		</s:iterator>
	  	<tr>
		  <tr bgcolor="#CCCCCC" align="center">
			<td colspan="6"><c:if test="${pb.page == 1}" var="result">
				��һҳ ��һҳ
			</c:if> <c:if test="${!result}">
					<a
						href="<%=request.getContextPath()%>/findAll_CustomerInfo.action?page=1">��һҳ</a>
					<a
						href="<%=request.getContextPath()%>/findAll_CustomerInfo.action?page=${pb.page-1}">��һҳ</a>
				</c:if> <c:if test="${pb.page==pb.maxpage}" var="result">
      			     ��һҳ  ���ҳ
      			</c:if> <c:if test="${!result}">
					<a
						href="<%=request.getContextPath()%>/findAll_CustomerInfo.action?page=${pb.page+1}">��һҳ</a>
					<a
						href="<%=request.getContextPath()%>/findAll_CustomerInfo.action?page=${pb.maxpage}">���ҳ</a>
				</c:if> ÿҳ <label for="rows"></label> 
				<input name="rows" value="${pb.rows }" type="text" id="rows" size="2" /> ����¼
				
				<input type="button" name="button" id="button" value="ȷ��"
				onclick="doChangeRows()"/> ��ת���� <label for="page"></label> 
				<input name="page" value="${pb.page}" type="text" id="page" size="2" /> ҳ
				<input type="button" name="button2" id="button2" value="ȷ��"
				onclick="doChangePage()"/> ${pb.page}/${pb.maxpage}ҳ
				</td>
		</tr>
	</table>
	<p align="center">
		<strong> <a href="saveCustomerInfo.jsp">�������</a> </strong>
	</p>
</body>
</htm>