<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta name="viewport" content="width=1024" />
<title>我的购物袋</title>
<link rel="stylesheet" type="text/css" href="style/style.css" />
<link rel="stylesheet" type="text/css" href="style/orderInfo.css" />
<link rel="stylesheet" href="style/public.css" type="text/css" />

</head>
<body>

<!-- top1 -->
<div class="top1">
	<div class="top1_1">
   	欢迎您登云起点网上商城！用户名：<input type="text" name="name" class="inputsty">
   	 密码：<input type="text" name="password" class="inputsty"> <a href="#">忘记密码?</a> 
   	<input type="button" value="登录" class="btn1">  
   	<input type="button" value="注册" class="btn1"> 
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
<form action="<%=request.getContextPath()%>/commit_MakeOrder.action" method="post">
		<div class="content">
    	  <div class="title2"></div>
        <!-- 购物袋 -->
		<dl id="myCartTitle">
        	<dt>确认订单信息</dt>
        	<dd><a href="#">管理收货地址</a></dd> 
		 </dl>
			<div class="clear"><img src="#" width="1" height="1"></div>
		 
		 
		 <div class="address"><!--收货人地址开始--> 
				<div id=part_consignee>
				<div class=o_write>
				<h1>收货人信息&nbsp;
                  <span style="DISPLAY: none"><a style="COLOR: #ff6600" onclick=addNewAddress(this); href="javascript:void(0)">[创建一个新地址]</a></span> 
                </h1>
				<div class=middle>
				<div id=addressListPanel></div>
				<div id=consignee_addr>
				<table >
				  <TBODY>
				  <tr>
					<td   align=right><FONT color=red>*</FONT>收货人姓名：</TD>
					<td  align=left>
					<input value="${customerInfo.custName}" name="orderMain.customerName" class=txt maxLength=20 type=text>&nbsp; 
					</td>
			     </tr>
				  <tr>
					<td  width=85 align=right><FONT color=red>*</FONT>客户编号：</td>
					<td  align=left>
					<input value="${customerInfo.custId}" name="orderMain.customerInfo.custId" class=txt maxLength=20 >&nbsp; </td>
			     </tr>
				  <tr>
					<td  align=right><FONT color=red>*</FONT>地　　址：</TD>
					<td align=left><span id=consigneeShow_addressName></span>
					  <input value="${customerDetailInfo.address}" style="WIDTh: 327px; MARGIN-LEFT: 2px" id=consignee_address class=txt name="orderMain.address" maxLength=50 type=text>&nbsp; </td></tr>
				  <tr>
					<td align=right><FONT color=red>*</FONT>手机号码：</td>
					<TD  align=left>
					<input value="${customerDetailInfo.tel}" id=consignee_message class=txt name="orderMain.tel"/>
					<font color=#000000>用于接收发货通知短信及送货前确认</font> </td>
				 </tr>
				 <tr>
					<td align=right>备注：</td>
					<td align=left>
					<input value="" name="orderMain.context" id=consignee_message class=txt/>
					 </td>
				 </tr>
				  <tr>
					<td align=right>电子邮件：</TD>
					<TD align=left>
					<input value="${customerInfo.email}" id=consignee_email class=txt type=text name="orderMain.customerInfo.email "/> &nbsp;
					<font  color=#000000>用来接收订单提醒邮件，便于您及时了解订单状态</font> </td>
				  </tr>
				  </TBODY>
				  </table>
				  </div>
				  </div>
				</div>
				</div><!--收货人地址结束--> 
				<!--支付方式及配送方式开始-->
			<div id=part_payTypeAndShipType>
			<div class=o_show>
			<h1>支付及配送方式&nbsp;<A id=linkPayTypeShipType 
			onclick=showForm_payTypeAndShipType(this); href="javascript:void(0)" 
			clstag="checkout|keycount|jiesuan|linkpayshiptype">[修改]</A></h1>
			<div id=updateInfo_payType></div>
			<div class=middle>
			<TABLE style="WIDTh: 100%">
			  <TBODY>
			  <TR>
				<TD style="TEXT-ALIGN: right; WIDTh: 80px">支付方式：</TD>
				<TD>在线支付</TD></TR>
			  <TR>
				<TD style="TEXT-ALIGN: right">配送方式：</TD>
				<TD>快递运输</TD></TR>
			  <TR>
				<TD style="TEXT-ALIGN: right">运　　费：</TD>
				<TD>0.00元<SPAN style="COLOR: red">(免运费)</SPAN></TD></TR>
			  <TR style="DISPLAY: none">
				<TD style="TEXT-ALIGN: right">送货日期：</TD>
				<TD style="COLOR: red">{CodTime}</TD></TR>
			  <TR style="DISPLAY: none">
				<TD style="TEXT-ALIGN: right">自提时间：</TD>
				<TD style="COLOR: red">{PickTime}</TD></TR></TBODY></TABLE></div>
			<div class=footsty></div></div></div><!--支付方式及配送方式结束-->
			<!--发票信息开始-->
<div id=part_invoice>
<div class=o_show>
<h1>发票信息&nbsp;<A onclick=showForm_invoice(this) href="javascript:void(0)" 
clstag="checkout|keycount|jiesuan|xiugaifapiao">[修改]</A></h1>
<div class=middle>
<TABLE style="WIDTh: 100%; DISPLAY: none">
  <TBODY>
  <TR>
    <TD 
  style="TEXT-ALIGN: left; PADDING-LEFT: 22px">开取类型：&nbsp;默认开取</TD></TR></TBODY></TABLE>
<TABLE style="WIDTh: 100%">
  <TBODY>
  <TR>
    <TD style="TEXT-ALIGN: right; WIDTh: 82px">发票类型：</TD>
    <TD>普通发票</TD></TR>
  <TR>
    <TD style="TEXT-ALIGN: right">发票抬头：</TD>
    <TD>个人 </TD></TR>
  <TR>
    <TD style="TEXT-ALIGN: right">发票内容：</TD>
    <TD>
      <div><SPAN style="DISPLAY: none">非图书商品：</SPAN><SPAN>明细</SPAN></div>
      <div><SPAN style="DISPLAY: none">图书商品：</SPAN><SPAN 
      style="DISPLAY: none">不开发票</SPAN></div></TD></TR></TBODY></TABLE>
<TABLE style="WIDTh: 100%; DISPLAY: none">
  <TBODY>
  <TR>
    <TD 
style="TEXT-ALIGN: left; PADDING-LEFT: 22px">不开发票</TD></TR></TBODY></TABLE></div>
<div class=footsty></div></div></div><!--发票信息结束--><!--Cart信息开始-->
<div id=part_cart></div><!--Cart信息开始--><!--有货先发开始-->
<div 
style="PADDING-BOTTOM: 8px; PADDING-LEFT: 30px; PADDING-RIGhT: 0px; COLOR: red; PADDING-TOP: 8px" 
id=part_FirstInstockShip><INPUT id=chk_FirstInstockShip 
onclick=SetTag_FirstInstockShip() type=checkbox>&nbsp;<LABEL 
for=chk_FirstInstockShip>先发有货商品（如果订单部分商品缺货，优先配送有货商品）</LABEL> </div><!--有货先发结束-->
					 
		 </div>
	    <dl id="myCartTitle">
        	<dt>确认挑选的商品</dt>
        	<dd>”</dd>        
	    </dl>
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
			<td align="center" width="50">${item.price-item.hyprice}*${item.num} </td>
			<!-- 小计 -->
			<td align="center" width="60">${item.num} * ${item.price}</td>
			
			<td align="center" width="100"><span class="cols col-7"><a onclick="add_favorites('2073165120748','20731651148');" style="cursor:pointer">加入收藏</a> | 
			<a onclick="return confirm('您确定要删除${item.bookName}吗?');" href="<%=request.getContextPath()%>/DeleteGwcItemServlet?bookId= ${item.bookId}" style="cursor:pointer">删除</a></span></td>
		  </tr>
			</c:forEach>
		  </s:else>
		  <tr><td colspan="6"><div class="left">
		  			<!-- 继续购物 -->
					 <a class="btn_clear_cart" href="<%=request.getContextPath()%>/show_ShowBookInfo?bookId=${bookInfo.bookId}"><img src="images/jxgw.png"></a>
					 <!-- 清空购物车 -->
                     <a  class="btn_clear_cart" href="<%=request.getContextPath()%>/show_ClearGwc?bookId=${bookInfo.bookId}"><img src="images/qkgw.png"></a>
                    </div>
					 <div class="right" >
						<input type="image" src="images/tjdd.png"> 
					</div>
         </td>
         </tr>
		</table>
		</div>		  	
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
</form>
</body>
</html>
