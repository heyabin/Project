<%@ page language="java" contentType="text/html; charset=gbk"%>
 <table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center">欢迎您:${sessionScope.sysAdmin.adminName}</td>
    <td width="12">&nbsp;</td>
  </tr>
  <tr> 
    <td background="images/ht04.jpg" class="wr4"> 
      <div align="center">用 户 管 理</div>
    </td>
    <td width="12"><img src="images/ht03.jpg" width="12" height="20"></td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="2">
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/findAll_CustomerInfo?page=1" target="mainFrame">用户信息管理</a>
    </td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/background/saveCustomerInfo.jsp" target="mainFrame">新增用户信息</a>
    </td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/findAll_CustomerDetailInfo.action?page=1" target="mainFrame">用户详细管理</a>
    </td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/background/saveCustomerDetailInfo.jsp" target="mainFrame">新增详细信息</a>
    </td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="${pageContext.request.contextPath}/findAll_Student.action" target="mainFrame">学生信息管理</a>
    </td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/background/saveStudent.jsp" target="mainFrame">新增学生信息</a>
    </td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="CustomerInformationList.htm" target="mainFrame">客户管理</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">个人信息</td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">&nbsp;</td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td background="images/ht06.jpg" class="wr4"> 
      <div align="center">图 书 信 息</div>
    </td>
    <td width="12"><img src="images/ht05.jpg" width="12" height="20"></td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="2">
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/findAll_BookInfo.action" target="mainFrame">图书信息管理</a>
    </td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/background/saveBookinfor.jsp" target="mainFrame">新增图书信息</a>
    </td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="${pageContext.request.contextPath}/findAll_BookType.action" target="mainFrame">图书类别管理</a>
    </td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/background/savebookType.jsp" target="mainFrame">新增图书类别</a>
    </td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="OrderFormList.htm" target="mainFrame">销售管理</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="storageBrow.htm" target="mainFrame">商品库存信息</a></td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/FindAllNewsServlet?nowPage=1" target="mainFrame">新闻信息管理</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/background/saveNews.jsp" target="mainFrame">新增新闻信息</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">&nbsp;</td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td background="images/ht08.jpg" class="wr4"> 
      <div align="center">交 互 管 理</div>
    </td>
    <td width="12"><img src="images/ht07.jpg" width="12" height="20"></td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="2">
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/findAll_OrderMain.action?page=1" target="mainFrame">订单管理</a>
    </td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/background/saveOrderMain.jsp" target="mainFrame">新增订单</a>
    </td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/FindAllorderdetailServlet?nowPage=1" target="mainFrame">订单明细管理</a>
    </td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/background/saveorderdetail.jsp" target="mainFrame">新增明细订单</a>
    </td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="saloonTypeModify.htm" target="mainFrame">栏目管理</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="bookSloon.htm" target="mainFrame">图书上架</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="OOSMangae.htm" target="mainFrame">缺货管理</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">邮件列表发送</td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/findAll_BookDiscuss?page=1" target="mainFrame">评论管理</a></td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/background/saveBookdiscuss.jsp" target="mainFrame">新增评论</a></td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/FindAllfavoriteServlet?nowPage=1" target="mainFrame">收藏夹管理</a></td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/background/savefavorite.jsp" target="mainFrame">新增收藏夹</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">&nbsp;</td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td background="images/ht04.jpg" class="wr4"> 
      <div align="center"><a href="systemSet.htm" target="mainFrame">系 统 设 置</a></div>
    </td>
    <td width="12"><img src="images/ht03.jpg" width="12" height="20"></td>
  </tr>
  <tr>
    <td class="wr4">&nbsp;</td>
    <td width="12">&nbsp;</td>
  </tr>
  <tr>
    <td background="images/ht08.jpg" class="wr4"> 
      <div align="center">
     <a href="<%=request.getContextPath()%>/SysAdminLoginServlet"
      target="_parent">退 出 系 统</a></div>
    </td>
    <td width="12"><img src="images/ht07.jpg" width="12" height="20"></td>
  </tr>
</table>