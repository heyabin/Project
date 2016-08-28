<%@ page language="java"  contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.Collection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<script type="text/javaScript">
	function changeNum(id,num) {
		if(isNaN(num)) {
			alert("数量必须是数字!");
			return;
		}
		if(num < 1) {
			alert("数量必须大于一!");
			return;
		}
		location = "${pageContext.request.contextPath}/update_AddGwcItem.action?bookId=" + id + "&num=" + num;
	}
</script>
<title>我的购物袋</title>
<link rel="stylesheet" type="text/css" href="style/style.css"/>
<link rel="stylesheet" href="style/public.css" type="text/css"/>
</head>
<body>
<!-- top1 -->
<div class="top1">
	<div class="top1_1">
   	欢迎您登云起点网上商城！用户名：<input type="text" name="name" class="inputsty"> 
   	密码：<input type="text" name="password" class="inputsty"/> 
   	<a href="#">忘记密码?</a> 
   	<input type="button" value="登录" class="btn1">  <input type="button" value="注册" class="btn1"> 
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
<div class="content">
    	  <div class="title1"></div>
        <!-- 购物袋 -->
        <dl id="myCartTitle">
        	<dt>我挑选的商品</dt>
        	<dd>现在 <a href="#">登录</a>，商品将永久保存到“我的购物袋”</dd></dl>
			<div class="clear"><img src="#" width="1" height="1"></div>
			<div id="myCartTable">
		<table >
		  <tr>
			<th>商品名称</th>
			<th>单价（元）</th>
			<th>数量</th>
			<th>优惠</th>
			<th>小计（元）</th>
			<th>操作</th>
		  </tr>
		  
	 <s:if test="#session.gwc==null">
		  		 <tr>
			  	<td colspan="6" align="center">
			  		您的购物车中还没有商品，点击<a href="${pageContext.request.contextPath}/show_InitIndex.action">这里</a>购买
			  	</td>
			  </tr>
		  
		  </s:if>
		  <s:else>
			<c:forEach items="${gwc.itemNum}" var="item">
		  <tr>
			<td align="left" width="400">
			<div class="shpic">
				<a href="<%=request.getContextPath()%>/ShowBookInfoServlet?bookId=${item.bookId}"><img src="<%=request.getContextPath()%>/background/imgsd/${item.smallImg}"/></a>
			</div>
			<span class="shname">
			<a href="<%=request.getContextPath()%>/ShowBookInfoServlet?bookId=${item.bookId}">${item.bookName}</a>
			<br />
			   </span></td>
			<td align="center" width="100">
			售 价 ：${item.hyprice}
			<span class="fccc"><del> <br />
		        市场价：${item.price}</del></span></td>
			<td align="center" width="70">
			<a title="减-" 
			onclick="changeNum('${item.bookId}','${item.num-1}');" style="cursor:pointer" class="btn_minus_s">-</a>  
				<!-- 数量 -->
				<input value="${item.num}" onchange="changeNum('${item.bookId}', this.value);" name="text" type="text" class="text_num"id="num_2073165120748"  size="2" maxlength="2" autocomplete="off" now_data2073165120748="1"/>
			<a title="加+" onclick="changeNum('${item.bookId}','${item.num+1}');" style="cursor:pointer" class="btn_plus_s">+</a></td>
			<!-- 优惠 -->
			<td align="center" width="50">${((item.price - item.hyprice) * item.num)}</td>
			<!-- 小计 -->
			<td align="center" width="60">${(item.num)*(item.price)}</td>
			
			<td align="center" width="100"><span class="cols col-7"><a onclick="add_favorites('2073165120748','20731651148');" style="cursor:pointer">加入收藏</a> | 
			<a onclick="return confirm('您确定要删除${item.bookName}吗?');" href="<%=request.getContextPath()%>/show_ClearGwc?bookId= ${item.bookId}" style="cursor:pointer">删除</a></span></td>
		  </tr>
			</c:forEach>
		  </s:else>
		  <tr><td colspan="6"><div class="left">
		  			<!-- 继续购物 -->
					 <a class="btn_clear_cart" href="<%=request.getContextPath()%>/show_InitSevert.action"><img src="images/jxgw.png"></a>
					 <!-- 清空购物车 -->
                     <a  class="btn_clear_cart" href="<%=request.getContextPath()%>/show_ClearGwc?bookId=${bookInfo.bookId}"><img src="images/qkgw.png"></a>
                    </div>
                    <!-- 去结算 -->
					 <div class="right" >
					<a href="<%=request.getContextPath()%>/init_OrderSevert?bookId=${bookInfo.bookId}" class="bg_cart btn_check_order" ><img src="images/jies.png"></a>
					</div>
         </td></tr>
		</table>
		</div>
		<div id="interested">
			<h3>您可能感兴趣的宝贝&hellip;</h3>
				<a href="#" class="J_ClearBrowse clear" style="display: none;">清空</a>
			<div class="con">
				<ul class="tabs" id="menu3">
					<li onmouseOver="settab(3,0)"  class="current "><a href="#"><span>最近收藏的</span></a></li>
					<li onmouseOver="settab(3,1)"><a href="#"><span>最近浏览过的</span></a></li>
					<li onmouseOver="settab(3,2)"><a href="#"><span>猜你喜欢的</span></a></li>
				</ul>
						<div id="main3">
							<ul class="pannel">
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">琅琅上口的百年老课本曾经</span> <span  class="fred">￥299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">琅琅上口的百年老课本曾经滋琅</span> <span  class="fred">￥299</span></a> </li>
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">琅琅上口的百年老课本曾经滋养</span> <span  class="fred">￥299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">琅琅上口的百年老课本曾经滋养</span> <span  class="fred">￥299</span></a></li>
							</ul>
						
						<ul class="pannel" style="display:none; ">
								<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">琅琅上口的百年老课本曾经</span> <span  class="fred">￥299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">琅琅上口的百年老课本曾经滋养</span> <span  class="fred">￥299</span></a> </li>
								<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">琅琅上口的百年老课本曾经滋养恤</span> <span  class="fred">￥299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">琅琅上口的百年老课本曾经滋养 </span> <span  class="fred">￥299</span></a></li></ul>
						<ul class="pannel"  style="display:none; ">
									<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">琅琅上口的百年老课本曾经滋养</span> <span  class="fred">￥299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">琅琅上口的百年老课本曾经滋养 </span> <span  class="fred">￥299</span></a> </li>
								<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">M琅琅上口的百年老课本曾经滋养</span> <span  class="fred">￥299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">琅琅上口的百年老课本曾经滋养</span> <span  class="fred">￥299</span></a></li>
						</ul>         
			  </div></div>
		</div>
		
		<div class="clear"><img src="#" width="1" height="1"></div>  	
</div>
	<!-- footer -->
<div class="footer">
	<ul class="lbox">
    	<li><a href="#">顾客必读</a></li>
        <li><a href="#">订单的几种状态</a></li>
        <li><a href="#">会员等级折扣</a></li>
        <li><a href="#">积分奖励计划</a></li>
        <li><a href="#">顾客必读</a></li>
        <li><a href="#">商品退货保证</a></li>
    </ul>
    <ul class="lbox">
    	<li><a href="#">顾客必读</a></li>
        <li><a href="#">订单的几种状态</a></li>
        <li><a href="#">会员等级折扣</a></li>
        <li><a href="#">积分奖励计划</a></li>
        <li><a href="#">顾客必读</a></li>
        <li><a href="#">商品退货保证</a></li>
    </ul>
   	<ul class="lbox">
    	<li><a href="#">顾客必读</a></li>
        <li><a href="#">订单的几种状态</a></li>
        <li><a href="#">会员等级折扣</a></li>
        <li><a href="#">积分奖励计划</a></li>
        <li><a href="#">顾客必读</a></li>
        <li><a href="#">商品退货保证</a></li>
    </ul>
   	<ul class="lbox nolbox">
    	<li><a href="#">顾客必读</a></li>
        <li><a href="#">订单的几种状态</a></li>
        <li><a href="#">会员等级折扣</a></li>
        <li><a href="#">积分奖励计划</a></li>
        <li><a href="#">顾客必读</a></li>
        <li><a href="#">商品退货保证</a></li>
    </ul>




</div>
<div class="footer1">
	<img src="images/footer1img.jpg" />
	<img src="images/footer2img.jpg" /> 
	<img src="images/footer3img.jpg" />
	<img src="images/footer4img.jpg" />
  	<img src="images/footer5img.jpg" />
	<img src="images/footer6img.jpg" />           
</div>
<!-- footer2 -->
<div class="footer2">
版权所有：www.xubangyiliao.com<br />
电话:029-62966051 87811277 传真：029-62966051 陕ICP备1109231号
</div>

</body>
<script language="javascript"><!-- 
function settab(m,n){ 
var tli=document.getElementById("menu"+m).getElementsByTagName("li"); 
var mli=document.getElementById("main"+m).getElementsByTagName("ul"); 
for(i= 0;i<tli.length;i++){ 
tli[i].className=i==n?"current":""; 
mli[i].style.display=i==n?"block":"none"; 
} 
} 
</script>

</html>

