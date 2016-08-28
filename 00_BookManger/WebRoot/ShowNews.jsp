<%@ page language="java"  contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="enetiy.BookDiscuss"%>
<%@page import="enetiy.News"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云起点</title>
<meta name="keywords" content="关键字" />
<meta name="description" content="页面描述" />
<link rel="stylesheet" href="style/public.css" type="text/css" />
<link rel="stylesheet" href="style/index.css" type="text/css" />
<script src="js/banner.js" type="text/javascript"></script>
<SCRIPT src="js/jquery-1.2.6.pack.js" type=text/javascript></SCRIPT>
<SCRIPT src="js/base.js" type=text/javascript></SCRIPT>

</head>
<body>
<!-- top1 -->
<div class="top1">
	<div class="top1_1">
   	欢迎您登云起点网上商城！用户名：<input type="text" name="name" class="inputsty"> 密码：<input type="text" name="password" class="inputsty"> 
   	<a href="#">忘记密码?</a> 
   	<input type="button" value="登录" class="btn1"> 
   	 <input type="button" value="注册" class="btn1"> 
    </div>
	<div class="top1_2">
		<div class="top1_2_l">
            <ul class="yudingCon">
                <li>书名:<input type="text" name="" class="kuang" />  </li>
            	<li>作者:<input type="text" name="" class="kuang" />  </li>
		</ul>
        </div>
		<div class="top1_2_r">
        	<ul class="other">
            	<li><a href="#"><img src="images/car.gif"><br />购物车</a></li>
				<li><a href="#"><img src="images/car.gif"><br />订单查询  </a></li>
				<li><a href="#"><img src="images/car.gif"><br />我的空间</a></li>
				<li><a href="#"><img src="images/car.gif"><br />购书服务 </a></li>
            </ul>
            <ul class="menu">
            	<li><a href="index.html">首页</a></li>
                <li><a href="prolist.html">畅销</a></li>
                <li><a href="pro_show.html">文学</a></li>
                <li><a href="#">旺旺书系</a></li>
                <li><a href="#">文化</a></li>
                <li><a href="#">经营</a></li>
            </ul>
        </div>
	</div>
</div>
<!-- middle -->
<div class="middle">
	
	<%@ include file="leftInclude.jsp" %>
	
    <div class="middle_right">
    	<div class="middle_right6tit">
        	您当前的位置：新闻首页 > 新闻类别 > 
        </div>
        <div class="middle_right6con">
        <%
		News news =(News)request.getAttribute("news");        
		List<BookDiscuss> bookDiscusses = (List<BookDiscuss>)request.getAttribute("bookDiscusses");
        %>
            <SCRIPT type=text/javascript>
            $(function(){			
               $(".jqzoom").jqueryzoom({
                    xzoom:400,
                    yzoom:400,
                    offset:10,
                    position:"right",
                    preload:1,
                    lens:1
                });
                $("#spec-list").jdMarquee({
                    deriction:"left",
                    width:350,
                    height:56,
                    step:2,
                    speed:4,
                    delay:10,
                    control:true,
                    _front:"#spec-right",
                    _back:"#spec-left"
                });
                $("#spec-list img").bind("mouseover",function(){
                    var src=$(this).attr("src");
                    $("#spec-n1 img").eq(0).attr({
                        src:src.replace("\/n5\/","\/n1\/"),
                        jqimg:src.replace("\/n5\/","\/n0\/")
                    });
                    $(this).css({
                        "border":"2px solid #ff6600",
                        "padding":"1px"
                    });
                }).bind("mouseout",function(){
                    $(this).css({
                        "border":"1px solid #ccc",
                        "padding":"2px"
                    });
                });				
            })
            </SCRIPT>
        
        <SCRIPT src="js/lib.js" type=text/javascript></SCRIPT>
        <SCRIPT src="js/163css.js" type=text/javascript></SCRIPT>

         <div class="middle_rightR">
        <table width="100%" border="0">
          <tr>
           <td>新闻编号：<%=news.getNewsId()%></td>
           
            <td>新闻作者:<%=news.getAdminId()%></td>
          </tr>
          <tr>
            <td>新闻标题：<%=news.getTitle()%></td>
            <td>新闻内容：<%=news.getContext()%></td>
          </tr>
         
        </table>
       
        </div> 	
        <div class="middle8">
        	<div class="middle8tit">
            	<a href="#"><span>新闻信息</span></a>
            </div>
            <div class="middle8con" >             
<%=news.getContext() %> 

<p>新闻编号： 35</p> 
<p>ISBN： 9787543924857 </p> 
<p>ASIN： B00116U33Q</p> 
<p>   
新闻： 发布者  </p>
<p>发布单位： 上海新闻社 </p>
<p>出版日期： <%=news.getFbTime()%></p> 

<p>相关新闻：新闻 链接</p>

        </div>
        <div class="middle9">
        	<div class="middle9tit">书评:</div>
        		<ul>
        			<%
        			for(BookDiscuss bookDiscuss: bookDiscusses) {%>
        				&nbsp;&nbsp;&nbsp;&nbsp;<%=bookDiscuss.getCustId()%>说:<%=bookDiscuss.getContext()%><br><br>
        			<%}
        			%>
        		
        		</ul>
        	</div>
        </div>
        <div class="middle9">
        	<div class="middle9tit">用户评论</div>
            <div class="middle_right9con">
            	<div>用户名：匿名用户</div>
                <div>E-mail:<input type="text" name="text" size="25" ></div>
            	<div>评论等级：<input name="" type="radio" value="" /><img src="images/pl1.gif"> <input name="" type="radio" value="" /><img src="images/pl1.gif"> <input name="" type="radio" value="" /><img src="images/pl1.gif"> <input name="" type="radio" value="" />
            	<img src="images/pl1.gif"> <input name="" type="radio" value="" /><img src="images/pl1.gif"></div>
            	<div>评论内容：<textarea name="" cols="" rows=""></textarea></div>
                <div>验证码：<input type="text"  size="15"><img src="images/yz.gif"></div>
                <div><input type="button"  class="btn4" value=" " ></div>
            </div>
            </div>        
        </div> 		   
        	   
	</div>

</div>
<!-- footer2 -->
<div class="footer3">
	<div class="footer3_in">
	<a href="#">公司简介</a><span>|</span><a href="#">免责条款</a><span>|</span><a href="#">隐私保护</a><span>|</span><a href="#">咨询热点</a><span>|</span><a href="#">合作招募</a><span>|</span><a href="#">配送方式</a><span>|</span><a href="#">联系我们</a>
    </div>
    <div class="footer2">
    @ 2011-2012 旭邦医疗商城 版权所有，并保留所有权利。<br />
    电话:029-62966051 87811277 传真：029-62966051 陕ICP备1109231号 技术支持：<a href="#">徽韵网络</a>

    </div>
</div>
</body>
</html>

