<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="enetiy.CustomerInfo"%>
<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<html>
  <head><title>�û���Ϣ����</title>
     <style type="text/css">
     	@import '<%=request.getContextPath()%>/background/css/body.css'
     </style>
   <%
            int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
            int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
            List<CustomerInfo>  list =(List<CustomerInfo>)request.getAttribute("list");
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
		location = "<%=request.getContextPath()%>/FindAllCustomerInfoServlet?nowPage=" + nowPage;
		  }
        </script>
        </head>
        <body>
         <table border="1">
         <caption align="center">�û�������Ϣ</caption> 
         	<tr>
         	   <th>custId</th>
         	   <th>custName</th>
         	   <th>pwd</th>
         	   <th>email</th>
         	   <th>delete</th>
         	   <th>update</th>
         	</tr>
 		<%
		for (CustomerInfo customerInfo : list){%>
		  	<tr>
		  	<td><%=customerInfo.getCustId()%></td>
		    <td><%=customerInfo.getCustName()%></td>
		  	<td><%=customerInfo.getPwd()%></td>
		    <td><%=customerInfo.getEmail()%></td>
         	<td><a href="<%=request.getContextPath()%>/FindByCustomerInfoIdServlet?id=<%=customerInfo.getCustId()%>">update</a></td>
			<td><a href="<%=request.getContextPath()%>/DeleteCustomerInfoServlet?id=<%=customerInfo.getCustId()%>"onclick="return isDelete('<%=customerInfo.getCustName()%>');">delete</a></td>
         	</tr>
		<%
		}%> 
	  	<tr>
		    <td colspan="6">
		    <a href="background/savecustomerInfo.jsp" >����</a>
                      ��<%=pageCount%>ҳ
                        ��һҳ<%=pageCount++%>
                        ��һҳ<%=pageCount--%>
        	<%if(nowPage == 1) {%>
					��һҳ ��һҳ
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllCustomerInfoServlet?nowPage=1">��һҳ</a>
					<a href="<%=request.getContextPath()%>/FindAllCustomerInfoServlet?nowPage=<%=(nowPage - 1)%>">��һҳ</a>	
				<%}%>
				
				<%if(nowPage == pageCount) {%>
					��һҳ ���ҳ
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllCustomerInfoServlet?nowPage=<%=(nowPage + 1)%>">��һҳ</a>
					<a href="<%=request.getContextPath()%>/FindAllCustomerInfoServlet?nowPage=<%=pageCount%>">���ҳ</a>
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
