<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@page import="com.po.BookInfo"%>
<%@page import="java.util.List"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:if test="#session.pb==null">
	<c:redirect url="findAll_BookInfo.action"></c:redirect>
</s:if>

<html>
<head>
<title>图书信息列表</title>
<style type="text/css">
@import
'<%=request.getContextPath()%>/background/css/body.css'
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
		window.location="findAll_BookInfo.action?rows="+rows;
		
	}
	//改变页数（跳页）
	function doChangePage(){
		var page=document.form1.page.value;
		if(isNaN(page)){
			alert("请输入正确的数字！");
			document.form1.page.value=${pb.page};
			return;
		}
		window.location="findAll_BookInfo.action?page="+page;
		
	}
	//删除提示
	function doel(name){
		 return confirm("你确定要删除["+name+"]吗？");
	}
</script>
</head>
<body>
	<table>
		<caption>图书基本信息</caption>
		<tr>
			<th>bookId</th>
			<th>bookName</th>
			<th>bookInfoId</th>
			<th>author</th>
			<th>pbName</th>
			<th>context</th>
			<th>smallImg</th>
			<th>bigImg</th>
			<th>price</th>
			<th>pbdate</th>
			<th>hyprice</th>
			<th>bookStates</th>
			<th>datetime</th>
			<th>num</th>
			<th>saleCount</th>
			<th>update</th>
			<th>delete</th>
		</tr>
		<s:iterator value="#session.pb.pagelist" var="bookInfo">
			<tr>
				<td>${bookInfo.bookId}</td>
				<td>${bookInfo.bookName}</td>
				<td>${bookInfo.bookType.bookTypeId}</td>
				<td>${bookInfo.author}</td>
				<td>${bookInfo.pbName}</td>
				<td>${bookInfo.context}</td>
				<td>${bookInfo.smallImg}</td>
				<td>${bookInfo.bigImg}</td>
				<td>${bookInfo.price}</td>
				<td>${bookInfo.pbdate}</td>
				<td>${bookInfo.hyprice}</td>
				<td>${bookInfo.bookStates}</td>
				<td>${bookInfo.sjdate}></td>
				<td>${bookInfo.num}</td>
				<td>${bookInfo.saleCount}</td>
				<td><a
					href="<%=request.getContextPath()%>/findById_BookInfo?bookId=${bookInfo.bookId}">update</a>
				</td>
				<td><a
					href="<%=request.getContextPath()%>/delById_BookInfo?bookId=${bookInfo.bookId}"
					onclick="return doel('${bookInfo.bookId}')">delete</a></td>
			</tr>
		</s:iterator>

		<tr bgcolor="#CCCCCC" align="center">
			<td colspan="17"><c:if test="${pb.page == 1}" var="result">
				第一页 上一页
			</c:if> <c:if test="${!result}">
					<a
						href="<%=request.getContextPath()%>/findAll_BookInfo.action?page=1">第一页</a>
					<a
						href="<%=request.getContextPath()%>/findAll_BookInfo.action?page=${pb.page-1}">上一页</a>
				</c:if> <c:if test="${pb.page==pb.maxpage}" var="result">
      			     下一页  最后页
      			</c:if> <c:if test="${!result}">
					<a
						href="<%=request.getContextPath()%>/findAll_BookInfo.action?page=${pb.page+1}">下一页</a>
					<a
						href="<%=request.getContextPath()%>/findAll_BookInfo.action?page=${pb.maxpage}">最后页</a>
				</c:if> 每页 <label for="rows"></label> 
				<input name="rows" value="${pb.rows }" type="text" id="rows" size="2" /> 条记录
				
				<input type="button" name="button" id="button" value="确定"
				onclick="doChangeRows()"/> 跳转到第 <label for="page"></label> 
				<input name="page" value="${pb.page}" type="text" id="page" size="2" /> 页
				<input type="button" name="button2" id="button2" value="确定"
				onclick="doChangePage()" /> ${pb.page}/${pb.maxpage}页
				</td>
		</tr>
	</table>
	<p align="center">
		<strong> <a href="saveBookInfo.jsp">返回添加</a> </strong>
	</p>
</body>
</htm>