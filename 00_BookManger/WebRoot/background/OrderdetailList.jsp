<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="enetiy.OrderDetail"%>
<html>
		<head>
			<title>������ϸ��Ϣ�б�</title>
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
			location = "<%=request.getContextPath()%>/FindAllorderdetailServlet?nowPage=" + nowPage;
		}
		</script>	       
		       
		</head>
    <body>

  <table border="1">
			<caption align="center">������Ϣ����</caption> 
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
		    <a href="background/saveorderdetail.jsp" >����</a>
                      ��<%=pageCount%>ҳ
                        ��һҳ<%=pageCount++%>
                        ��һҳ<%=pageCount--%>
        	<%if(nowPage == 1) {%>
					��һҳ ��һҳ
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllorderdetailServlet?nowPage=1">��һҳ</a>
					<a href="<%=request.getContextPath()%>/FindAllorderdetailServlet?nowPage=<%=(nowPage - 1)%>">��һҳ</a>	
				<%}%>
				
				<%if(nowPage == pageCount) {%>
					��һҳ ���ҳ
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllorderdetailServlet?nowPage=<%=(nowPage + 1)%>">��һҳ</a>
					<a href="<%=request.getContextPath()%>/FindAllorderdetailServlet?nowPage=<%=pageCount%>">���ҳ</a>
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

