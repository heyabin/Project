<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="enetiy.BookDiscuss"%>
<html>
		<head>
			<title>������Ϣ�б�</title>
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
		    	   return confirm("��ȷ��Ҫɾ��["+name+"]��");
		       }
		       function gotoNowPage(nowPage){
			if(isNaN(nowPage)) {
				alert("ҳ�����������!");
				return;
			}
			var numNowPage = parseInt(nowPage);
			if(numNowPage < 1 || numNowPage > <%=pageCount%>) {
				alert("ҳ�������1��<%=pageCount%>֮��!");
				return;
			}
			location = "<%=request.getContextPath()%>/FindAllbookDiscussServlet?nowPage=" + nowPage;
		}
		</script>	       
		       
		</head>
    <body>

  <table border="1">
			<caption align="center">������Ϣ</caption> 
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
				<a href="background/saveBookdiscuss.jsp" >����</a>
				��<%=pageCount%>ҳ
				��<%=nowPage%>ҳ
				<%if(nowPage == 1) {%>
					��һҳ ��һҳ
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllbookDiscussServlet?nowPage=1">��һҳ</a>
					<a href="<%=request.getContextPath()%>/FindAllbookDiscussServlet?nowPage=<%=(nowPage - 1)%>">��һҳ</a>	
				<%}%>
				
				<%if(nowPage == pageCount) {%>
					��һҳ ���ҳ
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllbookDiscussServlet?nowPage=<%=(nowPage + 1)%>">��һҳ</a>
					<a href="<%=request.getContextPath()%>/FindAllbookDiscussServlet?nowPage=<%=pageCount%>">���ҳ</a>
				<%}%>
				��<input value="<%=nowPage%>" size="2" onblur="gotoNowPage(this.value)">ҳ
				
				<select onchange="gotoNowPage(this.value)">
					<%
					for(int i = 1; i <= pageCount; i++) {%>
						<option value="<%=i%>"
						<%if(i == nowPage){out.write("selected");} %> 
						>��<%=i%>ҳ</option>
					<%}
					%>
				</select>	
			</td>
		</tr>
   </table>
   </body>
</html>

