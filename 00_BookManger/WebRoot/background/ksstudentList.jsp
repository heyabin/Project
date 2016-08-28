<%@ page language="java"  contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="enetiy.Student"%>
<html>
		<head>
			<title>学生信息列表</title>
			<style type="text/css">
				@import '<%=request.getContextPath()%>/background/css/body.css'
			</style>
		 <% 
  
		    int pageCount =Integer.parseInt(request.getAttribute("pageCount").toString());
		    int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
		  	List<Student> stus =(List<Student>)request.getAttribute("stus");
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
               location ="<%=request.getContextPath()%>/FindAllStudentServlet?nowPage="+nowPage;  
		       }
		</script>
		</head>
    <body background="<%=request.getContextPath()%>/background/images/homeworklist.jpg">
 
  <table border="1">
			<caption>学生基本信息</caption> 
		<tr>
			<th>stuId</th>
			<th>stuName</th>
			<th>stuAge</th>
			<th>stuBtd</th>
			<th>stuSex</th>
			<th>stuTel</th>
			<th>delete</th>
			<th>update</th>
		</tr>
		<%
  	    for (Student stu : stus) {%>
  	  	<tr onmouseover="this.bgColor='red'" onmouseout="this.bgColor='white'" >
  	  	    <td><%=stu.getStuId()%></td> 
  	  	    <td><%=stu.getStuName() %></td>
		    <td><%=stu.getStuAge() %></td>
			<td><%=stu.getStuBtd() %></td>
			<td><%=stu.isStuSex() %></td>
			<td><%=stu.getStuTel() %></td> 
			<td><a href="<%=request.getContextPath()%>/FindByStudentIdServlet?id=<%=stu.getStuId()%>">update</a></td>
			<td><a href="<%=request.getContextPath()%>/DeleteStudentServlet?id=<%=stu.getStuId()%>" onclick="return isDelete('<%= stu.getStuName()%>')">delete</a></td>
  	  	</tr>
  	   <% 
	  }%>
	  <tr>
			<td colspan="8">
				<a href="background/saveStudent.jsp">save</a>
			共<%= pageCount%>页
			第<%= nowPage%>页
			<%if(nowPage==1){%>
				 第一页  上一页
				<%}else{%>
				<a href =" <%=request.getContextPath()%>/FindAllStudentServlet?nowPage=1" >第一页</a> 
				<a href =" <%=request.getContextPath()%>/FindAllStudentServlet?nowPage=<%=(nowPage - 1)%>" >上一页</a>	
			 <%}%>
			
			<%if(nowPage == pageCount){%>
				下一页  最后页  
			 <%}else{%>
			<a href="<%=request.getContextPath()%>/FindAllStudentServlet?nowPage=<%= pageCount%>">最后页</a>	 
         	 <a href="<%=request.getContextPath()%>/FindAllStudentServlet?nowPage=<%=(nowPage+1)%>">下一页</a>
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
