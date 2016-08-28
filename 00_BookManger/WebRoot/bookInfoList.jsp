<%@ page language="java" contentType="text/html; charset=gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

   <% 
  
    int pageCount =Integer.parseInt(request.getAttribute("pageCount").toString());
    int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
    int booktypeId =Integer.parseInt(request.getParameter("booktypeId").toString());
    List<BookInfo> bookInfos =(List<BookInfo>)request.getAttribute("bookInfos");
  %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云起点</title>
<meta name="keywords" content="关键字" />
<meta name="description" content="页面描述" />
<link rel="stylesheet" href="style/public.css" type="text/css" />
<link rel="stylesheet" href="style/index.css" type="text/css" />
<script src="js/banner.js" type="text/javascript"></script>
</head>
<body>
<!-- top1 -->
<div class="top1">
	<div class="top1_1">
   	欢迎您登云起点网上商城！用户名：<input type="text" name="name" class="inputsty"> 密码：<input type="text" name="password" class="inputsty"> <a href="#">忘记密码?</a> 
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
<!-- middle -->
<div class="middle">

<%@include file="leftInclude.jsp" %>

    <div class="middle_right">
    	<div class="middle_right6tit">
        	您当前的位置：网站首页 > 产品列表页</div>
      <div class="middle_right6con">
      	<%

      	for(BookInfo bookInfo : bookInfos) {%>
             <div class="warpbor">
                <div class="leftshop">
                <a href="<%=request.getContextPath()%>/ShowBookInfoServlet?id=<%=bookInfo.getBookId()%>"><img src="<%=request.getContextPath()%>/background/imgsx/<%=bookInfo.getSmallImg()%>"/></a>
                </div>
                <div class="righttext"><h3><a href="<%=request.getContextPath()%>/ShowBookInfoServlet?id=<%=bookInfo.getBookId()%>"><%=bookInfo.getBookName() %></a></h3><p> 
       				 <span class="fontcc">(10条评论)</span><br />
         				<%=bookInfo.getAuthor() %>著/
         				<%=bookInfo.getPbdate() %><br />
        				<%=bookInfo.getContext() %>
     			   <span class="xiangx">人民币:<%=bookInfo.getHyprice() %> 
     			   <span class="textde">人民币:<%=bookInfo.getPrice() %></span> 
     			   <a href="<%=request.getContextPath()%>/AddGwcItemServlet?bookId=<%=bookInfo.getBookId()%>"><img src="images/btn_buy.gif"></a><a href="<%=request.getContextPath()%>/AddkeepServert?id=<%=bookInfo.getBookId()%>">
     			   <img src="images/btn_keep.gif"></a></span>
     			</div>
            </div>	
      		
      	<%}
      	%>  
          <tr>
			共<%= pageCount%>页
			第<%= nowPage%>页
			<%if(nowPage==1){%>
				 第一页  上一页
				<%}else{%>
				<a href =" <%=request.getContextPath()%>/ShowBookListByTypeIdServlet?nowPage=1&booktypeId=<%=request.getParameter("booktypeId")%>" >第一页</a> 
				<a href =" <%=request.getContextPath()%>/ShowBookListByTypeIdServlet?nowPage=<%=(nowPage - 1)%>&booktypeId=<%=request.getParameter("booktypeId")%>" >上一页</a>	
			 <%}%>
			
			<%if(nowPage == pageCount){%>
				下一页  最后页  
			 <%}else{%>
			<a href="<%=request.getContextPath()%>/ShowBookListByTypeIdServlet?nowPage=<%= pageCount%>&booktypeId=<%=request.getParameter("booktypeId")%>">最后页</a>	 
         	 <a href="<%=request.getContextPath()%>/ShowBookListByTypeIdServlet?nowPage=<%=(nowPage+1)%>&booktypeId=<%=request.getParameter("booktypeId")%>">下一页</a>
			 <%}%>  
         <input type="text" value="<%=nowPage%>" size="1" onblur="gotoNowPage(this.value)"></input>
			<select onchange="gotoNowPage(this.value)">
					<% for(int i = 1;i<=pageCount;i++){%>
					<option value="<%=i%>" <% if(i == nowPage){%>selected<%}%>
					>第"<%=i%>"页 
					</option>
					<%}%>
				</select>
			</td>
		</tr>   
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
