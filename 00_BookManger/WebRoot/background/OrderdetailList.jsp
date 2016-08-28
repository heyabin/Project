<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="enetiy.OrderDetail"%>
<html>
		<head>
			<title>订单详细信息列表</title>
			<style type="text/css">
				@import '<%=request.getContextPath()%>/background/css/body.css'
			</style>
		 <%
		 int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
		 int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
		 List<OrderDetail> list =(List<OrderDetail>)request.getAttribute("list");
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
			location = "<%=request.getContextPath()%>/FindAllorderdetailServlet?nowPage=" + nowPage;
		}
		</script>	       
		       
		</head>
    <body>

  <table border="1">
			<caption align="center">订单信息管理</caption> 
		<tr> 
			<th>detailId</th>
			<th>orderNum</th>
			<th>bookId</th>
			<th>num</th>
			<th>update</th>
			<th>delete</th>
		</tr>
		<%
		 for (OrderDetail  orderDetail : list) {
		%>
		  <tr>
  	  	    <td><%=orderDetail.getDetailId()%></td>
  	  	      <td><%=orderDetail.getOrderNum()%></td> 
  	  	    <td><%=orderDetail.getBookId()%></td>
		    <td><%=orderDetail.getNum()%></td>
			<td><a href="<%=request.getContextPath()%>/FindByorderdetailIdServlet?id=<%=orderDetail.getDetailId()%>">update</a></td>
			<td><a href="<%=request.getContextPath()%>/DeleteorderdetailServlet?id=<%=orderDetail.getDetailId()%>"onclick="return isDelete('<%=orderDetail.getOrderNum()%>');">delete</a></td>
  	  	</tr>
  	  <% 
	  }%>
	  <tr>
		    <td colspan="11">
		    <a href="background/saveorderdetail.jsp" >新增</a>
                      共<%=pageCount%>页
                        上一页<%=pageCount++%>
                        下一页<%=pageCount--%>
        	<%if(nowPage == 1) {%>
					第一页 上一页
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllorderdetailServlet?nowPage=1">第一页</a>
					<a href="<%=request.getContextPath()%>/FindAllorderdetailServlet?nowPage=<%=(nowPage - 1)%>">上一页</a>	
				<%}%>
				
				<%if(nowPage == pageCount) {%>
					下一页 最后页
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllorderdetailServlet?nowPage=<%=(nowPage + 1)%>">下一页</a>
					<a href="<%=request.getContextPath()%>/FindAllorderdetailServlet?nowPage=<%=pageCount%>">最后页</a>
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

