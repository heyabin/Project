<%@ page language="java"  contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="enetiy.Student"%>
<html>
		<head>
			<title>ѧ����Ϣ�б�</title>
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
               location ="<%=request.getContextPath()%>/FindAllStudentServlet?nowPage="+nowPage;  
		       }
		</script>
		</head>
    <body background="<%=request.getContextPath()%>/background/images/homeworklist.jpg">
 
  <table border="1">
			<caption>ѧ��������Ϣ</caption> 
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
			��<%= pageCount%>ҳ
			��<%= nowPage%>ҳ
			<%if(nowPage==1){%>
				 ��һҳ  ��һҳ
				<%}else{%>
				<a href =" <%=request.getContextPath()%>/FindAllStudentServlet?nowPage=1" >��һҳ</a> 
				<a href =" <%=request.getContextPath()%>/FindAllStudentServlet?nowPage=<%=(nowPage - 1)%>" >��һҳ</a>	
			 <%}%>
			
			<%if(nowPage == pageCount){%>
				��һҳ  ���ҳ  
			 <%}else{%>
			<a href="<%=request.getContextPath()%>/FindAllStudentServlet?nowPage=<%= pageCount%>">���ҳ</a>	 
         	 <a href="<%=request.getContextPath()%>/FindAllStudentServlet?nowPage=<%=(nowPage+1)%>">��һҳ</a>
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
