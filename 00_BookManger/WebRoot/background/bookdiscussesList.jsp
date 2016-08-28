<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="enetiy.BookDiscuss"%>
<html>
		<head>
			<title>书评信息列表</title>
			<style type="text/css">
				@import '<%=request.getContextPath()%>/background/css/body.css'
			</style>
		 <%
		    int pageCount =Integer.parseInt(request.getAttribute("pageCount").toString());
		    int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
		 	List<BookDiscuss> bookDiscusses =(List<BookDiscuss>)request.getAttribute("bookDiscusses");
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
			location = "<%=request.getContextPath()%>/FindAllbookDiscussServlet?nowPage=" + nowPage;
		}
		</script>	       
		       
		</head>
    <body>

  <table border="1">
			<caption align="center">书评信息</caption> 
		<tr>
	
			<th>disId</th>
			<th>bookId</th>
			<th>custId</th>
			<th>context</th>
			<th>states</th>
			<th>update</th>
			<th>delete</th>
		</tr>
	
    
		<%
		for (BookDiscuss bookDiscuss : bookDiscusses) {%>
		  <tr>
		    <td><%=bookDiscuss.getDisId()%></td>
  	  	    <td><%=bookDiscuss.getBookId()%></td> 
  	  	    <td><%=bookDiscuss.getCustId()%></td>
		    <td><%=bookDiscuss.getContext()%></td>
		     <td><%=bookDiscuss.getStates()%></td>
			<td><a href="<%=request.getContextPath()%>/FindBybookDiscussIdServlet?id=<%=bookDiscuss.getDisId()%>">update</a></td>
			<td><a href="<%=request.getContextPath()%>/DeletebookDiscussServlet?id=<%=bookDiscuss.getDisId()%>"onclick="return isDelete('<%=bookDiscuss.getContext()%>');">delete</a></td>
  	  	</tr>
  	   <% 
	  }%>
	 	 <tr>
			<td colspan="6">
				<a href="background/saveBookdiscuss.jsp" >新增</a>
				共<%=pageCount%>页
				第<%=nowPage%>页
				<%if(nowPage == 1) {%>
					第一页 上一页
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllbookDiscussServlet?nowPage=1">第一页</a>
					<a href="<%=request.getContextPath()%>/FindAllbookDiscussServlet?nowPage=<%=(nowPage - 1)%>">上一页</a>	
				<%}%>
				
				<%if(nowPage == pageCount) {%>
					下一页 最后页
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllbookDiscussServlet?nowPage=<%=(nowPage + 1)%>">下一页</a>
					<a href="<%=request.getContextPath()%>/FindAllbookDiscussServlet?nowPage=<%=pageCount%>">最后页</a>
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

