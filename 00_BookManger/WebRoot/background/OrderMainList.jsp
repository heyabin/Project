<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="enetiy.OrderMain"%>
<html>
		<head>
			<title>订单信息列表</title>
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
		    	   return confirm("你确定要删除["+name+"]吗？");
		       }
		       function gotoNowPage(nowPage){
			if(isNaN(nowPage)) {
				alert("页码必须是数字!");
				return;
			}
			var numNowPage = parseInt(nowPage);
			if(numNowPage < 1 || numNowPage > <%=pageCount%>) {
				alert("页码必须在1到<%=pageCount%>之间!");
				return;
			}
			location = "<%=request.getContextPath()%>/FindAllOrderMainServlet?nowPage=" + nowPage;
		}
		</script>	       
		       
		</head>
    <body>

  <table border="1">
			<caption align="center">订单信息管理</caption> 
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
		    <a href="background/saveOrderMain.jsp" >新增</a>
                      共<%=pageCount%>页
                        上一页<%=pageCount++%>
                        下一页<%=pageCount--%>
        	<%if(nowPage == 1) {%>
					第一页 上一页
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllOrderMainServlet?nowPage=1">第一页</a>
					<a href="<%=request.getContextPath()%>/FindAllOrderMainServlet?nowPage=<%=(nowPage - 1)%>">上一页</a>	
				<%}%>
				
				<%if(nowPage == pageCount) {%>
					下一页 最后页
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllOrderMainServlet?nowPage=<%=(nowPage + 1)%>">下一页</a>
					<a href="<%=request.getContextPath()%>/FindAllOrderMainServlet?nowPage=<%=pageCount%>">最后页</a>
				<%}%>
				第<input value="<%=nowPage%>" size="2" onblur="gotoNowPage(this.value)">页
				
				<select onchange="gotoNowPage(this.value)">
					<%
					for(int i = 1; i <= pageCount; i++) {%>
						<option value="<%=i%>"
						<%if(i == nowPage){out.write("selected");} %> 
						>第<%=i%>页</option>
					<%}
					%>
				</select>	                            	
         	</td>
        </tr>       
	  
	  
   </table>
   </body>
</html>

