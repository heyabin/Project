<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="enetiy.News"%>

<html>
		<head>
			<title>新闻信息列表</title>
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
		    	   return confirm("你确定要删除["+name+"]吗？");
		       }
		       function gotonowPage(nowPage){
			if(isNaN(nowPage)) {
				alert("页码必须是数字!");
				return;
			}
			var numNowPage = parseInt(nowPage);
			if(numNowPage < 1 || numNowPage > <%=pageCount%>) {
				alert("页码必须在1到<%=pageCount%>之间!");
				return;
			}
			location = "<%=request.getContextPath()%>/FindAllNewsServlet?nowPage=" + nowPage;	
			}
			
			 
			
			</script>
		</head>
    <body>
    <table border="1">
      <caption align="center">新闻基本信息</caption>
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
				<a href="background/saveNews.jsp" >新增</a>    
	  共<%=pageCount%>页 
	  第<%=nowPage%>页 
	 <%
	     if(nowPage == 1){%>
	    	第一页 上一页
	    	 
	   <% }else{ %> 
	   <a href="<%=request.getContextPath()%>/FindAllNewsServlet?nowPage=1">第一页 </a>            	 
	   <a href="<%=request.getContextPath()%>/FindAllNewsServlet?nowPage=<%=nowPage-1%>">上一页</a>
	   <% }
	   %>
	    <%
	     if(nowPage == pageCount){%>
	    	下一页 最后页
	    	 
	   <% }else{ %> 
	   <a href="<%=request.getContextPath()%>/FindAllNewsServlet?nowPage=<%=nowPage+1%>">下一页 </a>            	 
	   <a href="<%=request.getContextPath()%>/FindAllNewsServlet?nowPage=<%=pageCount%>">最后页</a>
	   <% }
	   %>
	  第<input value="<%=nowPage%>" size="1" onblur="gotonowPage(this.value)">页
	   
	  <select onchange="gotonowPage(this.value)">
					<%
					for(int i = 1; i <= pageCount; i++) {%>
						<option value="<%=i%>"
						<%if(i == nowPage){out.write("selected");} %> 
						>第<%=i%>页</option>
					<%}
					%>
				</select>
	 
	 
	 
    
	 </tr>
	  
    </table>
       
    
    
    
   </body>
</html>

