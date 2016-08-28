	<%@ page language="java" contentType="text/html; charset=gbk"%>
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td background="images/ht04.jpg" class="wr4"> 
      <div  align="center"> 教师管理</div>
    </td>
    <td width="12"><img src="images/ht03.jpg" width="12" height="20"></td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="2">
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/FindAllTeacherServlet?nowPage=1" target="mainFrame">教师信息管理</a>
    </td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/background/kssaveTeacher.jsp" target="mainFrame">新增教师信息</a>
    </td>
  </tr>
 
</table>
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td background="images/ht04.jpg" class="wr4"> 
      <div  align="center"> 学生管理</div>
    </td>
    <td width="12"><img src="images/ht03.jpg" width="12" height="20"></td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="2">
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/FindAllStudentServlet?nowPage=1" target="mainFrame">学生信息管理</a>
    </td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/background/kssaveStudent.jsp" target="mainFrame">新增学生信息</a>
    </td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td background="images/ht06.jpg" class="wr4"> 
      <div align="center">作业管理</div>
    </td>
    <td width="12"><img src="images/ht05.jpg" width="12" height="20"></td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="2">
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/FindAllHomeworkServlet?nowPage=1" target="mainFrame">作业信息管理</a>
    </td>
  </tr>
 <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">
    	<a href="<%=request.getContextPath()%>/background/kssaveHomework.jsp" target="mainFrame">新增作业信息</a>
    </td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">&nbsp;</td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td background="images/ht04.jpg" class="wr4"> 
      <div align="center"><a href="computer.html" target="mainFrame">系 统 设 置</a></div>
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
     <a href="<%=request.getContextPath()%>/SysAdminksLoginOutSevlet"
      target="_parent">退 出 系 统</a></div>
    </td>
    <td width="12"><img src="images/ht07.jpg" width="12" height="20"></td>
  </tr>
</table>