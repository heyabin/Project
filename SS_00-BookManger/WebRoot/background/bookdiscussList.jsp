<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@page import="com.po.BookDiscuss"%>

<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<s:if test="#session.pb==null">
	<c:redirect url="findAll_BookDiscuss.action"></c:redirect>
</s:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
			<title>书评信息列表</title>
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
		window.location="findAll_BookDiscuss.action?rows="+rows;
		
	}
	//改变页数（跳页）
	function doChangePage(){
		var page=document.form1.page.value;
		if(isNaN(page)){
			alert("请输入正确的数字！");
			document.form1.page.value=${pb.page};
			return;
		}
		window.location="findAll_BookDiscuss.action?page="+page;
		
	}
	//删除提示
	function doel(name){
		 return confirm("你确定要删除["+name+"]吗？");
	}
</script>

</head>

<body>
<p align="center"><strong>评论管理</strong></p>
<table width="700" border="1" align="center" cellpadding="1" cellspacing="0">
  <tr align="center" bgcolor="#CCCCCC">

	<th>bookId</th>
	<th>custId</th>
	<th>context</th>
	<th>states</th>
	<th>操作</th>
</tr>
  <s:iterator value="#session.pb.pagelist" var="bookDiscuss">
  <tr align="center" onmouseover="this.bgColor='red'" onmouseout="this.bgColor='white'" >
    <td>${bookDiscuss.bookInfo.bookId}</td>
    <td>${bookDiscuss.customerInfo.custId}</td>
    <td>${bookDiscuss.context}</td>
    <td>${bookDiscuss.states}</td>
    <td>
    <a href="<%=request.getContextPath()%>/delById_BookDiscuss.action?disId=${bookDiscuss.disId}" onclick="return doel('${bookDiscuss.bookInfo.bookId}')">删除</a>
     <a href="<%=request.getContextPath()%>/findById_BookDiscuss.action?disId=${bookDiscuss.disId}">修改</a></td>
  </tr>
  </s:iterator>
  <!-- 每页记录数不够rows条，按空行补齐 -->
  <s:if test="#session.num<#session.pb.rows">
  <s:iterator begin="#session.num+1" end="#session.pb.rows">
  	<tr align="center">
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  </s:iterator>
  </s:if>
</table>
<form id="form1" name="form1" method="post" action="">
  <table width="700" border="1" align="center" cellpadding="1" cellspacing="0">
    <tr align="center" bgcolor="#CCCCCC">
      <td width="44">
      		<c:if test="${pb.page>1}">
      			<a href="<%=request.getContextPath()%>/findAll_BookDiscuss.action?page=1">
      		</c:if>
      		首页</a></td>
      <td width="44">
      		<c:if test="${pb.page>1}">
      			<a href="<%=request.getContextPath()%>/findAll_BookDiscuss.action?page=${pb.page-1}">
      		</c:if>	
      			上页</a></td>
      <td width="44">
      		<c:if test="${pb.page<pb.maxpage}">
      			<a href="<%=request.getContextPath()%>/findAll_BookDiscuss.action?page=${pb.page+1}">
      		</c:if>	
      			下页</a></td>
      <td width="44">
      		<c:if test="${pb.page<pb.maxpage}">	
      			<a href="<%=request.getContextPath()%>/findAll_BookDiscuss.action?page=${pb.maxpage}">
      		</c:if>		
      			末页</a></td>
      <td width="220">每页
        <label for="rows"></label>
      <input name="rows" value="${pb.rows }" type="text" id="rows" size="2" />
      条记录
      <input type="button" name="button" id="button" value="确定" onclick="doChangeRows()" /></td>
      <td width="213">跳转到第
        <label for="page"></label>
        <input name="page"  value="${pb.page}" type="text" id="page" size="2" />
        页
      <input type="button" name="button2" id="button2" value="确定" onclick="doChangePage()" /></td>
      <td width="61">${pb.page}/${pb.maxpage}页</td>
    </tr>
  </table>
</form>
<p>&nbsp;</p>
<p align="center"><strong><a href="saveBookdiscuss.jsp">返回添加</a></strong></p>
</body>
</html>