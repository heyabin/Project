<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="enetiy.BookInfo"%>
<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>

<html>
		<head>
			<title>图书信息列表</title>
			<style type="text/css">
				@import '<%=request.getContextPath()%>/background/css/body.css'
			</style>
		 <%
		 int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
		 int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
		 List<BookInfo> list =(List<BookInfo>)request.getAttribute("list");
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
			location = "<%=request.getContextPath()%>/FindAllBookinforServlet?nowPage=" + nowPage;
		}
		</script>	       
		       
		</head>
    <body>

  <table border="1">
			<caption align="center">图书基本信息</caption> 
		<tr>
			<th>bookId</th>
			<th>bookName</th>
			<th>bookTypeId</th>
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
		
		<%
		 for (BookInfo bookType : list) {%>
		  <tr>
  	  	    <td><%=bookType.getBookId()%></td> 
  	  	    <td><%=bookType.getBookName()%></td>
		    <td><%=bookType.getBookTypeId()%></td>
			<td><%=bookType.getAuthor()%></td>
			<td><%=bookType.getPbName()%></td>
			<td><%=bookType.getContext()%></td>
			<td><%=bookType.getSmallImg() %></td>
			<td><%=bookType.getBigImg()%></td>
			<td><%=bookType.getPrice()%></td> 
			<td><%=bookType.getPbdate() %></td>
			<td><%=bookType.getHyprice()%></td>
			<td><%=bookType.getBookStates()%></td>
			<td><%=bookType.getDatetime()%></td> 
			<td><%=bookType.getNum() %></td>
			<td><%=bookType.getSaleCount()%></td>
			<td><a href="<%=request.getContextPath()%>/FindByBookinforIdServlet?id=<%=bookType.getBookId()%>">update</a></td>
			<td><a href="<%=request.getContextPath()%>/DeleteBookinforServlet?id=<%=bookType.getBookId()%>"onclick="return isDelete('<%=bookType.getBookName()%>');">delete</a></td>
  	  	</tr>
  	   <% 
	  }%>
	 	 <tr>
			<td colspan="14">
				<a href="background/saveBookinfor.jsp" >新增</a>
				共<%=pageCount%>页
				第<%=nowPage%>页
				<%if(nowPage == 1) {%>
					第一页 上一页
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllBookinforServlet?nowPage=1">第一页</a>
					<a href="	<%=request.getContextPath()%>/FindAllBookinforServlet?nowPage=<%=(nowPage - 1)%>">上一页</a>	
				<%}%>
				
				<%if(nowPage == pageCount) {%>
					下一页 最后页
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllBookinforServlet?nowPage=<%=(nowPage + 1)%>">下一页</a>
					<a href="<%=request.getContextPath()%>/FindAllBookinforServlet?nowPage=<%=pageCount%>">最后页</a>
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

