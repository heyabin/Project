<%@ page language="java"  contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="enetiy.Teacher"%>
<html>
		<head>
			<title>��ʦ��Ϣ�б�</title>
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
               location ="<%=request.getContextPath()%>/FindAllTeacherServlet?nowPage="+nowPage;  
		       }
		</script>
		</head>
    <body background="<%=request.getContextPath()%>/background/images/homeworklist.jpg">
 
  <table border="1">
			<caption>��ʦ������Ϣ</caption> 
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
			��<%= pageCount%>ҳ
			��<%= nowPage%>ҳ
			<%if(nowPage==1){%>
				 ��һҳ  ��һҳ
				<%}else{%>
				<a href =" <%=request.getContextPath()%>/FindAllTeacherServlet?nowPage=1" >��һҳ</a> 
				<a href =" <%=request.getContextPath()%>/FindAllTeacherServlet?nowPage=<%=(nowPage - 1)%>" >��һҳ</a>	
			 <%}%>
			
			<%if(nowPage == pageCount){%>
				��һҳ  ���ҳ  
			 <%}else{%>
			<a href="<%=request.getContextPath()%>/FindAllTeacherServlet?nowPage=<%= pageCount%>">���ҳ</a>	 
         	 <a href="<%=request.getContextPath()%>/FindAllTeacherServlet?nowPage=<%=(nowPage+1)%>">��һҳ</a>
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
