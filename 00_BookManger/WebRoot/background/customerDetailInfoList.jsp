<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="enetiy.CustomerDetailInfo"%>

<html>
		<head>
			<title>�û���ϸ��Ϣ�б�</title>
			<style type="text/css">
				@import '<%=request.getContextPath()%>/background/css/body.css'
			</style>
		 <%
		 int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
		 int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
		 List<CustomerDetailInfo> list =(List<CustomerDetailInfo>)request.getAttribute("list");
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
			location = "<%=request.getContextPath()%>/FindAllCustomerDetailInfoServlet?nowPage=" + nowPage;
		}
		</script>	       
		       
		</head>
    <body>
  <table border="1">
			<caption align="center">�û���ϸ��Ϣ</caption> 
		<tr>
			<th>custId</th>
			<th>tel</th>
			<th>address</th>
			<th>sex</th>
			<th>age</th>
			<th>countMoney</th>
			<th>qq</th>
			<th>update</th>
			<th>delete</th>
		</tr>
		<%
		 for (CustomerDetailInfo bookType : list) {%>
		  <tr>
  	  	    <td><%=bookType.getCustId()%></td> 
  	  	    <td><%=bookType.getTel()%></td>
		    <td><%=bookType.getAddress()%></td>
		    <td><%=bookType.getSex()%></td>
			<td><%=bookType.getAge()%></td>
			<td><%=bookType.getCountMoney()%></td>
			<td><%=bookType.getQq()%></td>
			<td><a href="<%=request.getContextPath()%>/FindByCustomerDetailInfoIdServlet?id=<%=bookType.getCustId()%>">update</a></td>
			<td><a href="<%=request.getContextPath()%>/DeleteCustomerDetailInfoServlet?id=<%=bookType.getCustId()%>"onclick="return isDelete('<%=bookType.getAddress()%>');">delete</a></td>
  	  	</tr>
  	   <% 
	  }%>
	 	 <tr>
			<td colspan="14">
				<a href="background/savecustomerDetailInfo.jsp" >����</a>
				��<%=pageCount%>ҳ
				��<%=nowPage%>ҳ
				<%if(nowPage == 1) {%>
					��һҳ ��һҳ
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllCustomerDetailInfoServlet?nowPage=1">��һҳ</a>
					<a href="<%=request.getContextPath()%>/FindAllCustomerDetailInfoServlet?nowPage=<%=(nowPage - 1)%>">��һҳ</a>	
				<%}%>
				
				<%if(nowPage == pageCount) {%>
					��һҳ ���ҳ
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllCustomerDetailInfoServlet?nowPage=<%=(nowPage + 1)%>">��һҳ</a>
					<a href="<%=request.getContextPath()%>/FindAllCustomerDetailInfoServlet?nowPage=<%=pageCount%>">���ҳ</a>
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

