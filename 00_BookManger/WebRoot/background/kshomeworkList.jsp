<%@ page language="java"  contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="enetiy.Homework"%>
<html>
		<head>
			<title>��ҵ��Ϣ�б�</title>
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
		    	   return confirm("��ȷ��Ҫɾ��["+name+"]��");
		       }
		       function gotoNowPage(nowPage){
                 if(isNaN(nowPage)){
                 alter("����������");
                   return;
                   }
              	var numNowPage = parseInt(nowPage);   
                  if(numNowPage<1 ||numNowPage><%=pageCount%>){
                	alert("ҳ�������1��<%=pageCount%>֮��!"); 
                	 return;
                   }
                  alert(nowPage);
               location ="<%=request.getContextPath()%>/FindAllHomeworkServlet?nowPage="+nowPage;  
		       }
		</script>
		</head>
    <body background="<%=request.getContextPath()%>/background/images/homeworklist.jpg">
 
  <table border="1" >
			<caption>��ҵ������Ϣ</caption> 
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
			��<%= pageCount%>ҳ
			��<%= nowPage%>ҳ
			<%if(nowPage==1){%>
				 ��һҳ  ��һҳ
				<%}else{%>
				<a href =" <%=request.getContextPath()%>/FindAllHomeworkServlet?nowPage=1" >��һҳ</a> 
				<a href =" <%=request.getContextPath()%>/FindAllHomeworkServlet?nowPage=<%=(nowPage - 1)%>" >��һҳ</a>	
			 <%}%>
			
			<%if(nowPage == pageCount){%>
				��һҳ  ���ҳ  
			 <%}else{%>
			<a href="<%=request.getContextPath()%>/FindAllHomeworkServlet?nowPage=<%= pageCount%>">���ҳ</a>	 
         	 <a href="<%=request.getContextPath()%>/FindAllHomeworkServlet?nowPage=<%=(nowPage+1)%>">��һҳ</a>
			 <%}%>  
         <input type="text" value="<%=nowPage%>" size="1" onblur="gotoNowPage(this.value)"></input>
			<select onchange="gotoNowPage(this.value)">
					<% for(int i = 1;i<=pageCount;i++){%>
					<option value="<%=i%>" <% if(i == nowPage){%>selected<%}%>
					>��"<%=i%>"ҳ 
					</option>
					<%}%>
				</select>
			
			
			</td>
		</tr>
  </table>
    </body>
</html>
