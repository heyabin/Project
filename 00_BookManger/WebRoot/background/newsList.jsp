<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="enetiy.News"%>

<html>
		<head>
			<title>������Ϣ�б�</title>
			<style type="text/css">
			
			@import '<%=request.getContextPath()%>/background/css/body.css';
			</style>
			<%
			int nowPage =Integer.parseInt(request.getAttribute("nowPage").toString());
			int  pageCount =Integer.parseInt(request.getAttribute("pageCount").toString());
			List<News> news =(List<News>)request.getAttribute("news");
			
			%>
			<script type="text/javascript">
			
			 function isDelete(name){
		    	   return confirm("��ȷ��Ҫɾ��["+name+"]��");
		       }
		       function gotonowPage(nowPage){
			if(isNaN(nowPage)) {
				alert("ҳ�����������!");
				return;
			}
			var numNowPage = parseInt(nowPage);
			if(numNowPage < 1 || numNowPage > <%=pageCount%>) {
				alert("ҳ�������1��<%=pageCount%>֮��!");
				return;
			}
			location = "<%=request.getContextPath()%>/FindAllNewsServlet?nowPage=" + nowPage;	
			}
			
			 
			
			</script>
		</head>
    <body>
    <table border="1">
      <caption align="center">���Ż�����Ϣ</caption>
      <tr>
			<th>newsId</th>
			<th>adminId</th>
			<th>title</th>
			<th>context</th>
			<th>fbTime</th>
			<th>update</th>
			<th>delete</th>
	 </tr>
	 
	 <% for (News new2 : news){%>
	   <tr>
  	  	    <td><%=new2.getNewsId()%></td> 
  	  	    <td><%=new2.getAdminId()%></td>
		    <td><%=new2.getTitle()%></td>
			<td><%=new2.getContext()%></td>
			<td><%=new2.getFbTime()%></td>
			<td><a href="<%=request.getContextPath()%>/FindByNewsIdServlet?id=<%=new2.getNewsId()%>">update</a></td>
			<td><a href="<%=request.getContextPath()%>/DeleteNewsServlet?id=<%=new2.getNewsId()%>"onclick="return isDelete('<%=new2.getContext()%>');">delete</a></td>
  	  	</tr>
	 
	  <%}%>
	  
	  <tr>
	    <td colspan="7">
				<a href="background/saveNews.jsp" >����</a>    
	  ��<%=pageCount%>ҳ 
	  ��<%=nowPage%>ҳ 
	 <%
	     if(nowPage == 1){%>
	    	��һҳ ��һҳ
	    	 
	   <% }else{ %> 
	   <a href="<%=request.getContextPath()%>/FindAllNewsServlet?nowPage=1">��һҳ </a>            	 
	   <a href="<%=request.getContextPath()%>/FindAllNewsServlet?nowPage=<%=nowPage-1%>">��һҳ</a>
	   <% }
	   %>
	    <%
	     if(nowPage == pageCount){%>
	    	��һҳ ���ҳ
	    	 
	   <% }else{ %> 
	   <a href="<%=request.getContextPath()%>/FindAllNewsServlet?nowPage=<%=nowPage+1%>">��һҳ </a>            	 
	   <a href="<%=request.getContextPath()%>/FindAllNewsServlet?nowPage=<%=pageCount%>">���ҳ</a>
	   <% }
	   %>
	  ��<input value="<%=nowPage%>" size="1" onblur="gotonowPage(this.value)">ҳ
	   
	  <select onchange="gotonowPage(this.value)">
					<%
					for(int i = 1; i <= pageCount; i++) {%>
						<option value="<%=i%>"
						<%if(i == nowPage){out.write("selected");} %> 
						>��<%=i%>ҳ</option>
					<%}
					%>
				</select>
	 
	 
	 
    
	 </tr>
	  
    </table>
       
    
    
    
   </body>
</html>

