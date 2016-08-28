<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="#session.rxBooks == null || #session.boofoInfo == null || #session.bookDiscusses == null">
	<c:redirect url="show_ShowBookInfo.action"></c:redirect>
</s:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>云起点</title>
<meta name="keywords" content="关键字" />
<meta name="description" content="页面描述" />
<link rel="stylesheet" href="style/public.css" type="text/css" />
<link rel="stylesheet" href="style/index.css" type="text/css" />
<script src="js/banner.js" type="text/javascript"></script>
<script src="js/jquery-1.2.6.pack.js" type=text/javascript></script>
<script src="js/base.js" type=text/javascript></script>

</head>
<body>
<!-- top1 -->
<div class="top1">
	<div class="top1_1">
   	欢迎您登云起点网上商城！用户名：<input type="text" name="customerInfo.custName" class="inputsty"/> 密码：<input type="text" name="customerInfo.pwd" class="inputsty"/> <a href="#">忘记密码?</a> 
   	<input type="button" value="登录" class="btn1"/>  <input type="button" value="注册" class="btn1"/> 
    </div>
	<div class="top1_2">
		<div class="top1_2_l">
            <ul class="yudingCon">
                <li>书名:<input type="text" name="" class="kuang" />  </li>
            	<li>作者:<input type="text" name="" class="kuang" />  </li>
            	<li class="ribtn"><input type="image" src="images/btn.gif" class="btn"/></li>
		</ul>
        </div>
		<div class="top1_2_r">
        	<ul class="other">
            	<li><a href="#"><img src="images/car.gif"/><br />购物车</a></li>
				<li><a href="#"><img src="images/car.gif"/><br />订单查询  </a></li>
				<li><a href="#"><img src="images/car.gif"/><br />我的空间</a></li>
				<li><a href="#"><img src="images/car.gif"/><br />购书服务 </a></li>
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
        	您当前的位置：网站首页 > 产品类别 > 
        </div>
        <div class="middle_right6con">
    <div id=preview>
            <div class=jqzoom id=spec-n1 onClick="window.open('http://www.lanrentuku.com/')"><img height=350
            src="${pageContext.request.contextPath}/background/imgsd/${boofoInfo.bigImg}" jqimg="${pageContext.request.contextPath}/background/imgsd/${boofoInfo.bigImg}" width=350/>
            </div>
            <div id=spec-n5>
                <div class=control id=spec-left>
                    <img src="images/left.gif" />
                </div>
                <div id=spec-list>
                    <ul class=list-h>
                        <li><img src="${pageContext.request.contextPath}/background/imgsd/${boofoInfo.bigImg}"/> </li>
                    </ul>
                </div>
                <div class=control id=spec-right>
                    <img src="images/right.gif" />
                </div>
                
            </div>
        </div>
        <script type=text/javascript>
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
            </script>
        
        <script src="js/lib.js" type=text/javascript></script>
        <script src="js/163css.js" type=text/javascript></script>

         <div class="middle_rightR">
        <table width="100%" border="0">
          <tr>
            <td>市场价：${boofoInfo.price}元</td>
            <td>商品货:${boofoInfo.bookName}</td>
          </tr>
          <tr>
            <td>会员价：${boofoInfo.hyprice}</td>
            <td>库存情况：${boofoInfo.num}</td>
          </tr>
          <tr>
            <td colspan="2">商品评论： <img src="images/icon3.jpg" /> (已有${num}人评论)</td>
          </tr>
        </table>
        <div class="middle_rightRC"> 
        <a href="${pageContext.request.contextPath}/show_AddGwcItem.action?bookId=${boofoInfo.bookId}"><img src="images/jr.jpg"/></a> 
         </div>
      </div>        
        </div> 	
        <div class="middle8">
        	<div class="middle8tit">
            	<a href="#"><span>产品信息</span></a>
                <a href="#">书 评</a>
            </div>
            <div class="middle8con" >             
			${boofoInfo.context}
	
<p>商品编号： ${boofoInfo.bookId}</p> 
<p>   
作者：${boofoInfo.author}</p>
<p>出版社：${boofoInfo.pbName}</p>
<p>出版日期： ${boofoInfo.pbdate}</p> 
<p>相关书籍： 所有版本  相近的书 </p>
        </div>
        <div class="middle9">
        	<div class="middle9tit"><a>书 评:</a></div>
            	<ul>
            		<s:iterator value="#session.bookDiscusses" var="bookDiscuss">
            			&nbsp;&nbsp;&nbsp;&nbsp;${bookDiscuss.customerInfo.custId}说:${bookDiscuss.context}<br/>
            		</s:iterator>        		
        		</ul>
            </div>        
        </div> 		   
        <div class="middle9">
        	<div class="middle9tit">用户评论</div>
            <div class="middle_right9con">
            	<div>用户名：匿名用户</div>
                <div>E-mail:<input type="text" name="text" size="25" /></div>
            	<div>评论等级：<input name="" type="radio" value="" /><img src="images/pl1.gif"/> <input name="" type="radio" value="" /><img src="images/pl1.gif"/> <input name="" type="radio" value="" /><img src="images/pl1.gif"/> <input name="" type="radio" value="" /><img src="images/pl1.gif"/> <input name="" type="radio" value="" /><img src="images/pl1.gif"/></div>
            	<div>评论内容：<textarea name="" cols="" rows=""></textarea></div>
                <div>验证码：<input type="text"  size="15"/><img src="images/yz.gif"/></div>
                <div><input type="button"  class="btn4" value=" " /></div>
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

