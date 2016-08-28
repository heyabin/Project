<%@ page language="java"  contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="enetiy.Homework"%>
<html>
		<head>
			<title>作业信息列表</title>
			<style type="text/css">
				@import '<%=request.getContextPath()%>/background/css/body.css'
			</style>
   <% 
  
    int pageCount =Integer.parseInt(request.getAttribute("pageCount").toString());
    int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
  	List<Homework> home =(List<Homework>)request.getAttribute("home");
  %>
		<script type="text/javascript">
		       function isDelete(name){
		    	   return confirm("你确定要删除["+name+"]吗？");
		       }
		       function gotoNowPage(nowPage){
                 if(isNaN(nowPage)){
                 alter("必须是数字");
                   return;
                   }
              	var numNowPage = parseInt(nowPage);   
                  if(numNowPage<1 ||numNowPage><%=pageCount%>){
                	alert("页码必须在1到<%=pageCount%>之间!"); 
                	 return;
                   }
                  alert(nowPage);
               location ="<%=request.getContextPath()%>/FindAllHomeworkServlet?nowPage="+nowPage;  
		       }
		</script>
		</head>
    <body background="<%=request.getContextPath()%>/background/images/homeworklist.jpg">
 
  <table border="1" >
			<caption>作业基本信息</caption> 
		<tr>
			<th>homeId</th>
			<th>homeName</th>
			<th>homecontext</th>
			<th>homesumbmit</th>
			<th>homegrade</th>
			<th>author</th>
			<th>delete</th>
			<th>update</th>
		</tr>
		<%
  	    for (Homework  homework: home) {%>
  	  	<tr onmouseover="this.bgColor='red'" onmouseout="this.bgColor='white'" >
  	  	    <td><%=homework.getHomeId()%></td> 
  	  	    <td><%=homework.getHomeName()%></td>
		    <td><%=homework.getHomecontext()%></td>
		    <td><%=homework.getHomesumbmit()%></td> 
			<td><%=homework.getHomegrade()%></td>
			<td><%=homework.getAuthor()%></td>
			<td><a href="<%=request.getContextPath()%>/FindByHomeworkServlet?id=<%=homework.getHomeId()%>">update</a></td>
			<td><a href="<%=request.getContextPath()%>/DeleteHomeworkServlet?id=<%=homework.getHomeId()%>" onclick="return isDelete('<%=homework.getHomeName()%>')">delete</a></td>
  	  	</tr>
  	   <% 
	  }%>
	  <tr>
			<td colspan="8">
				<a href="background/kssaveHomework.jsp">save</a>
			共<%= pageCount%>页
			第<%= nowPage%>页
			<%if(nowPage==1){%>
				 第一页  上一页
				<%}else{%>
				<a href =" <%=request.getContextPath()%>/FindAllHomeworkServlet?nowPage=1" >第一页</a> 
				<a href =" <%=request.getContextPath()%>/FindAllHomeworkServlet?nowPage=<%=(nowPage - 1)%>" >上一页</a>	
			 <%}%>
			
			<%if(nowPage == pageCount){%>
				下一页  最后页  
			 <%}else{%>
			<a href="<%=request.getContextPath()%>/FindAllHomeworkServlet?nowPage=<%= pageCount%>">最后页</a>	 
         	 <a href="<%=request.getContextPath()%>/FindAllHomeworkServlet?nowPage=<%=(nowPage+1)%>">下一页</a>
			 <%}%>  
         <input type="text" value="<%=nowPage%>" size="1" onblur="gotoNowPage(this.value)"></input>
			<select onchange="gotoNowPage(this.value)">
					<% for(int i = 1;i<=pageCount;i++){%>
					<option value="<%=i%>" <% if(i == nowPage){%>selected<%}%>
					>第"<%=i%>"页 
					</option>
					<%}%>
				</select>
			
			
			</td>
		</tr>
  </table>
    </body>
</html>
