<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@ include file="kscheck.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>作业提交与批阅系统</title>
<link href="/css/mianstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="background/js/jquery.js"></script>
</head>
<body background="<%=request.getContextPath()%>/background/images/ksmain.jpg"
>
	
    <div class="welinfo">
    <span><img src="<%=request.getContextPath()%>/background/images/sun.png" alt="天气" /></span>
    <b>Admin早上好，欢迎使用作业提交与批阅系统</b>
    <a href="#">帐号设置</a>
    </div>
    <div class="xline"></div>
    
    <ul class="iconlist">
    <li><img src="<%=request.getContextPath()%>/background/images/ico01.png" /><a href="#">教师管理</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<img src="<%=request.getContextPath()%>/background/images/ico02.png" /><a href="#">学生管理</a></li>
    <li><img src="<%=request.getContextPath()%>/background/images/ico03.png" /><a href="#">作业管理</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<img src="<%=request.getContextPath()%>/background/images/ico04.png" /><a href="#">系统设置</a></li>
    </ul>
   
    <div class="welinfo">
    <span><img src="<%=request.getContextPath()%>/background/images/dp.png" alt="提醒" /></span>
    <b>作业批阅提交系统使用指南</b>
    </div>
    <ul class="infolist">
    <li><span>您可以快速进行作业提交操作</span><a class="ibtn">提交或查阅作业</a></li>
    <li><span>您可以快速作业修改</span><a class="ibtn">修改或管理作业</a></li>
    <li><span>您可以进行密码修改账户设置等操作</span><a class="ibtn">账户管理</a></li>
    </ul>
    <div class="xline"></div>
   <div class="uimakerinfo">
    <span><img src="<%=request.getContextPath()%>/background/images/dp.png" alt="提醒" /></span>
   <b>查看西安石油大学作业提交与批改系统，你可以查阅授课教师及学生，作业内容成绩等相关信息</b>(<a href="http://www.mycodes.net" target="_blank">西安石油大学</a>)</div>
   <table width="540" border="0" cellspacing="0" cellpadding="20" align="left"> 
    <td class="wr2"> 
      <blockquote  > 
   <p>系统教师管理：系统教师列表，权限分配，系统设置<br>
          教师列表：教师列表<br>
          教师信息：个人信息</p>
      </blockquote>
      <blockquote> 
        <p>学生信息管理：学生信息维护<br>
          学生列表：学生列表<br>
          学生管理：查询学生，新增学生，系统设置</p>
      </blockquote>
      <blockquote> 
        <p>作业管理：作业类别   作业专栏 <br>
          作业提交：作业上架，作业专栏维护<br>
          作业查看：作业管理<br>
          新增作业：未查到作业，缺少作业信息<br>
      </blockquote>
    </td>
</table>
</body>
</html>

