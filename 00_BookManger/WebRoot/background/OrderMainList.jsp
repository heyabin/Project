<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="enetiy.OrderMain"%>
<html>
		<head>
			<title>������Ϣ�б�</title>
			<style type="text/css">
				@import '<%=request.getContextPath()%>/background/css/body.css'
			</style>
		 <%
		 int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
		 int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
		 List<OrderMain> list =(List<OrderMain>)request.getAttribute("list");
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
			location = "<%=request.getContextPath()%>/FindAllOrderMainServlet?nowPage=" + nowPage;
		}
		</script>	       
		       
		</head>
    <body>

  <table border="1">
			<caption align="center">������Ϣ����</caption> 
		<tr>
			<th>orderNum</th>
			<th>customerId</th>
			<th>customerName</th>
			<th>tel</th>
			<th>address </th>
			<th>status</th>
			<th>adminId</th>
			<th>context</th>
			<th>sumprice</th>
			<th>update</th>
			<th>delete</th>
		</tr>
		<%
		 for (OrderMain  orderMain : list) {
		%>
		  <tr>
  	  	    <td><%=orderMain.getOrderNum()%></td> 
  	  	    <td><%=orderMain.getCustomerId()%></td>
  	  	    <td><%=orderMain.getCustomerName()%></td>
		    <td><%=orderMain.getTel()%></td>
		    <td><%=orderMain.getAddress()%></td>
		    <td><%=orderMain.getStatus()%></td>
		    <td><%=orderMain.getAdminId()%></td>
		    <td><%=orderMain.getContext()%></td>
		    <td><%=orderMain.getSumprice()%></td>
			<td><a href="<%=request.getContextPath()%>/FindByOrderMainIdServlet?id=<%=orderMain.getOrderNum()%>">update</a></td>
			<td><a href="<%=request.getContextPath()%>/DeleteOrdermainServlet?id=<%=orderMain.getCustomerName()%>"onclick="return isDelete('<%=orderMain.getCustomerName()%>');">delete</a></td>
  	  	</tr>
  	  <% 
	  }%>
	  <tr>
		    <td colspan="11">
		    <a href="background/saveOrderMain.jsp" >����</a>
                      ��<%=pageCount%>ҳ
                        ��һҳ<%=pageCount++%>
                        ��һҳ<%=pageCount--%>
        	<%if(nowPage == 1) {%>
					��һҳ ��һҳ
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllOrderMainServlet?nowPage=1">��һҳ</a>
					<a href="<%=request.getContextPath()%>/FindAllOrderMainServlet?nowPage=<%=(nowPage - 1)%>">��һҳ</a>	
				<%}%>
				
				<%if(nowPage == pageCount) {%>
					��һҳ ���ҳ
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllOrderMainServlet?nowPage=<%=(nowPage + 1)%>">��һҳ</a>
					<a href="<%=request.getContextPath()%>/FindAllOrderMainServlet?nowPage=<%=pageCount%>">���ҳ</a>
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

