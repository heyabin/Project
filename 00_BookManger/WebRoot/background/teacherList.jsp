<%@ page language="java"  contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="enetiy.Teacher"%>
<html>
		<head>
			<title>老师信息列表</title>
			<style type="text/css">
				@import '<%=request.getContextPath()%>/background/css/body.css'
			</style>
  <% 
  
    int pageCount =Integer.parseInt(request.getAttribute("pageCount").toString());
    int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
  	List <Teacher> tea =(List<Teacher>)request.getAttribute("tea");
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
               location ="<%=request.getContextPath()%>/FindAllTeacherServlet?nowPage="+nowPage;  
		       }
		</script>
		</head>
    <body background="<%=request.getContextPath()%>/background/images/homeworklist.jpg">
 
  <table border="1">
			<caption>老师基本信息</caption> 
		<tr>
			<th>teaId</th>
			<th>teaName</th>
			<th>teaAge</th>
			<th>teaBtd</th>
			<th>teaSex</th>
			<th>teaTel</th>
			<th>teaaddress</th>
			<th>delete</th>
			<th>update</th>
		</tr>
		<%
  	    for (Teacher teacher : tea) {%>
  	  	<tr onmouseover="this.bgColor='red'" onmouseout="this.bgColor='white'" >
  	  	    <td><%=teacher.getTeaId()%></td> 
  	  	    <td><%=teacher.getTeaName()%></td>
		    <td><%=teacher.getTeaAge() %></td>
			<td><%=teacher.getTeaBtd() %></td>
			<td><%=teacher.isTeaSex() %></td>
			<td><%=teacher.getTeaTel()%></td>
			<td><%=teacher.getTeaaddress()%></td> 
			<td><a href="<%=request.getContextPath()%>/FindByTeacherIdServlet?teaId=<%=teacher.getTeaId()%>">update</a></td>
			<td><a href="<%=request.getContextPath()%>/DeleteTeacherServlet?id=<%=teacher.getTeaId()%>" onclick="return isDelete('<%=teacher.getTeaName()%>')">delete</a></td>
  	  	</tr>
  	   <% 
	  }%>
	  <tr>
			<td colspan="8">
				<a href="background/saveTeacher.jsp">save</a>
			共<%= pageCount%>页
			第<%= nowPage%>页
			<%if(nowPage==1){%>
				 第一页  上一页
				<%}else{%>
				<a href =" <%=request.getContextPath()%>/FindAllTeacherServlet?nowPage=1" >第一页</a> 
				<a href =" <%=request.getContextPath()%>/FindAllTeacherServlet?nowPage=<%=(nowPage - 1)%>" >上一页</a>	
			 <%}%>
			
			<%if(nowPage == pageCount){%>
				下一页  最后页  
			 <%}else{%>
			<a href="<%=request.getContextPath()%>/FindAllTeacherServlet?nowPage=<%= pageCount%>">最后页</a>	 
         	 <a href="<%=request.getContextPath()%>/FindAllTeacherServlet?nowPage=<%=(nowPage+1)%>">下一页</a>
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
