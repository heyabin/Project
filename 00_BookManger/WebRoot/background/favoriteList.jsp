<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="enetiy.Favorite"%>
<html>
		<head>
			<title>�ղ���Ϣ�б�</title>
			<style type="text/css">
				@import '<%=request.getContextPath()%>/background/css/body.css'
			</style>
		 <%
		 int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
		 int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
		 List<Favorite> list =(List<Favorite>)request.getAttribute("list");
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
			location = "<%=request.getContextPath()%>/FindAllfavoriteServlet?nowPage=" + nowPage;
		}
		</script>	       
		       
		</head>
    <body>

  <table border="1">
			<caption align="center">ͼ�������Ϣ</caption> 
		<tr> 
	
			<th>favoriteId</th>
			<th>bookId</th>
			<th>custId</th>
			<th>date</th>
			<th>context</th>
			<th>update</th>
			<th>delete</th>
		</tr>
		
		<%
		for (Favorite favorite : list)  {%>
		  <tr>
  	  	    <td><%=favorite.getFavoriteId()%></td> 
  	  	    <td><%=favorite.getBookId()%></td>
  	  	    <td><%=favorite.getCustId()%></td>
		    <td><%=favorite.getDate()%></td>
		    <td><%=favorite.getContext()%></td>
			<td><a href="<%=request.getContextPath()%>/FindByfavoriteIdServlet?id=<%=favorite.getFavoriteId()%>">update</a></td>
			<td><a href="<%=request.getContextPath()%>/DeletefavoriteServlet?id=<%=favorite.getFavoriteId()%>"onclick="return isDelete('<%=favorite.getContext()%>');">delete</a></td>
  	  	</tr>
  	   <% 
	  }%>
	 	 <tr>
			<td colspan="6">
				<a href="background/savefavorite.jsp" >����</a>
				��<%=pageCount%>ҳ
				��<%=nowPage%>ҳ
				<%if(nowPage == 1) {%>
					��һҳ ��һҳ
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllfavoriteServlet?nowPage=1">��һҳ</a>
					<a href="<%=request.getContextPath()%>/FindAllfavoriteServlet?nowPage=<%=(nowPage - 1)%>">��һҳ</a>	
				<%}%>
				
				<%if(nowPage == pageCount) {%>
					��һҳ ���ҳ
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllfavoriteServlet?nowPage=<%=(nowPage + 1)%>">��һҳ</a>
					<a href="<%=request.getContextPath()%>/FindAllfavoriteServlet?nowPage=<%=pageCount%>">���ҳ</a>
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

