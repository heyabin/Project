<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<s:if test="#session.pb.pagelist==null">
	<c:redirect url="findAll_CustomerInfo.action"></c:redirect>
</s:if>
<html>
  <head><title>用户信息管理</title>
     <style type="text/css">
     	@import '<%=request.getContextPath()%>/background/css/body.css'
     </style>
 
        	<script>
       //改变每页记录数
	function doChangeRows(){
		var rows=document.form1.rows.value;
		if(isNaN(rows)){
			alert("请输入正确的数字！");
			document.form1.rows.value=${pb.rows};
			return;
		}
		window.location="findAll_CustomerInfo.action?rows="+rows;
		
	}
	//改变页数（跳页）
	function doChangePage(){
		var page=document.form1.page.value;
		if(isNaN(page)){
			alert("请输入正确的数字！");
			document.form1.page.value=${pb.page};
			return;
		}
		window.location="findAll_CustomerInfo.action?page="+page;
		
	}
	//删除提示
	function doel(name){
		 return confirm("你确定要删除["+name+"]吗？");
	}
</script>
        </head>
        <body>
         <table border="1">
         <caption align="center">用户基本信息</caption> 
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
				第一页 上一页
			</c:if> <c:if test="${!result}">
					<a
						href="<%=request.getContextPath()%>/findAll_CustomerInfo.action?page=1">第一页</a>
					<a
						href="<%=request.getContextPath()%>/findAll_CustomerInfo.action?page=${pb.page-1}">上一页</a>
				</c:if> <c:if test="${pb.page==pb.maxpage}" var="result">
      			     下一页  最后页
      			</c:if> <c:if test="${!result}">
					<a
						href="<%=request.getContextPath()%>/findAll_CustomerInfo.action?page=${pb.page+1}">下一页</a>
					<a
						href="<%=request.getContextPath()%>/findAll_CustomerInfo.action?page=${pb.maxpage}">最后页</a>
				</c:if> 每页 <label for="rows"></label> 
				<input name="rows" value="${pb.rows }" type="text" id="rows" size="2" /> 条记录
				
				<input type="button" name="button" id="button" value="确定"
				onclick="doChangeRows()"/> 跳转到第 <label for="page"></label> 
				<input name="page" value="${pb.page}" type="text" id="page" size="2" /> 页
				<input type="button" name="button2" id="button2" value="确定"
				onclick="doChangePage()"/> ${pb.page}/${pb.maxpage}页
				</td>
		</tr>
	</table>
	<p align="center">
		<strong> <a href="saveCustomerInfo.jsp">返回添加</a> </strong>
	</p>
</body>
</htm>