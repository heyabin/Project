<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="enetiy.BookType"%>
<html>
		<head>
			<title>图书信息列表</title>
			<style type="text/css">
				@import '<%=request.getContextPath()%>/background/css/body.css'
			</style>
		 <%
		 int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
		 int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
		 List<BookType> list =(List<BookType>)request.getAttribute("list");
		 %>
		 <script type="text/javascript">
		       function isDelete(name){
		    	   return confirm("你确定要删除["+name+"]吗？");
		       }
		       function gotoNowPage(nowPage){
			if(isNaN(nowPage)) {
				alert("页码必须是数字!");
				return;
			}
			var numNowPage = parseInt(nowPage);
			if(numNowPage < 1 || numNowPage > <%=pageCount%>) {
				alert("页码必须在1到<%=pageCount%>之间!");
				return;
			}
			location = "<%=request.getContextPath()%>/FindAllBookTypeServlet?nowPage=" + nowPage;
		}
		</script>	       
		       
		</head>
    <body>

  <table border="1">
			<caption align="center">图书类别信息</caption> 
		<tr>
	
			<th>bookTypeId</th>
			<th>parentId</th>
			<th>bookTypeName</th>
			<th>context</th>
			<th>update</th>
			<th>delete</th>
		</tr>
		
		<%
		for (BookType bookType : list) {%>
		  <tr>
  	  	    <td><%=bookType.getBookTypeId()%></td> 
  	  	    <td><%=bookType.getParentId()%></td>
  	  	    <td><%=bookType.getBookTypeName()%></td>
		    <td><%=bookType.getContext()%></td>
			<td><a href="<%=request.getContextPath()%>/FindByBookTypeIdServlet?id=<%=bookType.getBookTypeId()%>">update</a></td>
			<td><a href="<%=request.getContextPath()%>/DeleteBookTypeServlet?id=<%=bookType.getBookTypeId()%>"onclick="return isDelete('<%=bookType.getBookTypeName()%>');">delete</a></td>
  	  	</tr>
  	   <% 
	  }%>
	 	 <tr>
			<td colspan="6">
				<a href="background/savebookType.jsp" >新增</a>
				共<%=pageCount%>页
				第<%=nowPage%>页
				<%if(nowPage == 1) {%>
					第一页 上一页
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllBookTypeServlet?nowPage=1">第一页</a>
					<a href="<%=request.getContextPath()%>/FindAllBookTypeServlet?nowPage=<%=(nowPage - 1)%>">上一页</a>	
				<%}%>
				
				<%if(nowPage == pageCount) {%>
					下一页 最后页
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllBookTypeServlet?nowPage=<%=(nowPage + 1)%>">下一页</a>
					<a href="<%=request.getContextPath()%>/FindAllBookTypeServlet?nowPage=<%=pageCount%>">最后页</a>
				<%}%>
				第<input value="<%=nowPage%>" size="2" onblur="gotoNowPage(this.value)">页
				
				<select onchange="gotoNowPage(this.value)">
					<%
					for(int i = 1; i <= pageCount; i++) {%>
						<option value="<%=i%>"
						<%if(i == nowPage){out.write("selected");} %> 
						>第<%=i%>页</option>
					<%}
					%>
				</select>	
			</td>
		</tr>
   </table>
   </body>
</html>

