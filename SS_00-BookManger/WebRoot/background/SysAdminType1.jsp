<%@ page language="java" contentType="text/html; charset=gbk"%>
 <table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center">��ӭ��:${sessionScope.sysAdmin.adminName}</td>
    <td width="12">&nbsp;</td>
  </tr>
  <tr> 
    <td background="images/ht04.jpg" class="wr4"> 
      <div align="center">�� �� �� ��</div>
    </td>
    <td width="12"><img src="images/ht03.jpg" width="12" height="20"></td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="2">
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/findAll_CustomerInfo?page=1" target="mainFrame">�û���Ϣ����</a>
    </td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/background/saveCustomerInfo.jsp" target="mainFrame">�����û���Ϣ</a>
    </td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/findAll_CustomerDetailInfo.action?page=1" target="mainFrame">�û���ϸ����</a>
    </td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/background/saveCustomerDetailInfo.jsp" target="mainFrame">������ϸ��Ϣ</a>
    </td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="${pageContext.request.contextPath}/findAll_Student.action" target="mainFrame">ѧ����Ϣ����</a>
    </td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/background/saveStudent.jsp" target="mainFrame">����ѧ����Ϣ</a>
    </td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="CustomerInformationList.htm" target="mainFrame">�ͻ�����</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">������Ϣ</td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">&nbsp;</td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td background="images/ht06.jpg" class="wr4"> 
      <div align="center">ͼ �� �� Ϣ</div>
    </td>
    <td width="12"><img src="images/ht05.jpg" width="12" height="20"></td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="2">
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/findAll_BookInfo.action" target="mainFrame">ͼ����Ϣ����</a>
    </td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/background/saveBookinfor.jsp" target="mainFrame">����ͼ����Ϣ</a>
    </td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="${pageContext.request.contextPath}/findAll_BookType.action" target="mainFrame">ͼ��������</a>
    </td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/background/savebookType.jsp" target="mainFrame">����ͼ�����</a>
    </td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="OrderFormList.htm" target="mainFrame">���۹���</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="storageBrow.htm" target="mainFrame">��Ʒ�����Ϣ</a></td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/FindAllNewsServlet?nowPage=1" target="mainFrame">������Ϣ����</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/background/saveNews.jsp" target="mainFrame">����������Ϣ</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">&nbsp;</td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td background="images/ht08.jpg" class="wr4"> 
      <div align="center">�� �� �� ��</div>
    </td>
    <td width="12"><img src="images/ht07.jpg" width="12" height="20"></td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="2">
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/findAll_OrderMain.action?page=1" target="mainFrame">��������</a>
    </td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/background/saveOrderMain.jsp" target="mainFrame">��������</a>
    </td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/FindAllorderdetailServlet?nowPage=1" target="mainFrame">������ϸ����</a>
    </td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/background/saveorderdetail.jsp" target="mainFrame">������ϸ����</a>
    </td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="saloonTypeModify.htm" target="mainFrame">��Ŀ����</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="bookSloon.htm" target="mainFrame">ͼ���ϼ�</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="OOSMangae.htm" target="mainFrame">ȱ������</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">�ʼ��б���</td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/findAll_BookDiscuss?page=1" target="mainFrame">���۹���</a></td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/background/saveBookdiscuss.jsp" target="mainFrame">��������</a></td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/FindAllfavoriteServlet?nowPage=1" target="mainFrame">�ղؼй���</a></td>
  </tr>
   <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/background/savefavorite.jsp" target="mainFrame">�����ղؼ�</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">&nbsp;</td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td background="images/ht04.jpg" class="wr4"> 
      <div align="center"><a href="systemSet.htm" target="mainFrame">ϵ ͳ �� ��</a></div>
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
      target="_parent">�� �� ϵ ͳ</a></div>
    </td>
    <td width="12"><img src="images/ht07.jpg" width="12" height="20"></td>
  </tr>
</table>