<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="enetiy.CustomerInfo"%>
<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<html>
  <head><title>用户信息管理</title>
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
		location = "<%=request.getContextPath()%>/FindAllCustomerInfoServlet?nowPage=" + nowPage;
		  }
        </script>
        </head>
        <body>
         <table border="1">
         <caption align="center">用户基本信息</caption> 
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
		    <a href="background/savecustomerInfo.jsp" >新增</a>
                      共<%=pageCount%>页
                        上一页<%=pageCount++%>
                        下一页<%=pageCount--%>
        	<%if(nowPage == 1) {%>
					第一页 上一页
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllCustomerInfoServlet?nowPage=1">第一页</a>
					<a href="<%=request.getContextPath()%>/FindAllCustomerInfoServlet?nowPage=<%=(nowPage - 1)%>">上一页</a>	
				<%}%>
				
				<%if(nowPage == pageCount) {%>
					下一页 最后页
				<%} else {%>
					<a href="<%=request.getContextPath()%>/FindAllCustomerInfoServlet?nowPage=<%=(nowPage + 1)%>">下一页</a>
					<a href="<%=request.getContextPath()%>/FindAllCustomerInfoServlet?nowPage=<%=pageCount%>">最后页</a>
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
