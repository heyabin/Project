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
<title>�����</title>
<meta name="keywords" content="�ؼ���" />
<meta name="description" content="ҳ������" />
<link rel="stylesheet" href="style/public.css" type="text/css" />
<link rel="stylesheet" href="style/index.css" type="text/css" />
<script src="js/banner.js" type="text/javascript"></script>
</head>
<body>
<!-- top1 -->
<div class="top1">
	<div class="top1_1">
   	��ӭ��������������̳ǣ��û�����<input type="text" name="name" class="inputsty"> ���룺<input type="text" name="password" class="inputsty"> <a href="#">��������?</a> 
   	<input type="button" value="��¼" class="btn1">  <input type="button" value="ע��" class="btn1"> 
    </div>
	<div class="top1_2">
		<div class="top1_2_l">
            <ul class="yudingCon">
                <li>����:<input type="text" name="" class="kuang" />  </li>
            	<li>����:<input type="text" name="" class="kuang" />  </li>
            	<li class="ribtn"><input type="image" src="images/btn.gif" class="btn"/></li>
		</ul>
        </div>
		<div class="top1_2_r">
        	<ul class="other">
            	<li><a href="#"><img src="images/car.gif"><br />���ﳵ</a></li>
				<li><a href="#"><img src="images/car.gif"><br />������ѯ  </a></li>
				<li><a href="#"><img src="images/car.gif"><br />�ҵĿռ�</a></li>
				<li><a href="#"><img src="images/car.gif"><br />������� </a></li>
            </ul>
            <ul class="menu">
            	<li><a href="index.html">��ҳ</a></li>
                <li><a href="prolist.html">����</a></li>
                <li><a href="pro_show.html">��ѧ</a></li>
                <li><a href="#">������ϵ</a></li>
                <li><a href="#">�Ļ�</a></li>
                <li><a href="#">��Ӫ</a></li>
            </ul>
        </div>
	</div>
</div>
<!-- middle -->
<div class="middle">

<%@include file="leftInclude.jsp" %>

    <div class="middle_right">
    	<div class="middle_right6tit">
        	����ǰ��λ�ã���վ��ҳ > ��Ʒ�б�ҳ</div>
      <div class="middle_right6con">
      	<%

      	for(BookInfo bookInfo : bookInfos) {%>
             <div class="warpbor">
                <div class="leftshop">
                <a href="<%=request.getContextPath()%>/ShowBookInfoServlet?id=<%=bookInfo.getBookId()%>"><img src="<%=request.getContextPath()%>/background/imgsx/<%=bookInfo.getSmallImg()%>"/></a>
                </div>
                <div class="righttext"><h3><a href="<%=request.getContextPath()%>/ShowBookInfoServlet?id=<%=bookInfo.getBookId()%>"><%=bookInfo.getBookName() %></a></h3><p> 
       				 <span class="fontcc">(10������)</span><br />
         				<%=bookInfo.getAuthor() %>��/
         				<%=bookInfo.getPbdate() %><br />
        				<%=bookInfo.getContext() %>
     			   <span class="xiangx">�����:<%=bookInfo.getHyprice() %> 
     			   <span class="textde">�����:<%=bookInfo.getPrice() %></span> 
     			   <a href="<%=request.getContextPath()%>/AddGwcItemServlet?bookId=<%=bookInfo.getBookId()%>"><img src="images/btn_buy.gif"></a><a href="<%=request.getContextPath()%>/AddkeepServert?id=<%=bookInfo.getBookId()%>">
     			   <img src="images/btn_keep.gif"></a></span>
     			</div>
            </div>	
      		
      	<%}
      	%>  
          <tr>
			��<%= pageCount%>ҳ
			��<%= nowPage%>ҳ
			<%if(nowPage==1){%>
				 ��һҳ  ��һҳ
				<%}else{%>
				<a href =" <%=request.getContextPath()%>/ShowBookListByTypeIdServlet?nowPage=1&booktypeId=<%=request.getParameter("booktypeId")%>" >��һҳ</a> 
				<a href =" <%=request.getContextPath()%>/ShowBookListByTypeIdServlet?nowPage=<%=(nowPage - 1)%>&booktypeId=<%=request.getParameter("booktypeId")%>" >��һҳ</a>	
			 <%}%>
			
			<%if(nowPage == pageCount){%>
				��һҳ  ���ҳ  
			 <%}else{%>
			<a href="<%=request.getContextPath()%>/ShowBookListByTypeIdServlet?nowPage=<%= pageCount%>&booktypeId=<%=request.getParameter("booktypeId")%>">���ҳ</a>	 
         	 <a href="<%=request.getContextPath()%>/ShowBookListByTypeIdServlet?nowPage=<%=(nowPage+1)%>&booktypeId=<%=request.getParameter("booktypeId")%>">��һҳ</a>
			 <%}%>  
         <input type="text" value="<%=nowPage%>" size="1" onblur="gotoNowPage(this.value)"></input>
			<select onchange="gotoNowPage(this.value)">
					<% for(int i = 1;i<=pageCount;i++){%>
					<option value="<%=i%>" <% if(i == nowPage){%>selected<%}%>
					>��"<%=i%>"ҳ 
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
	<a href="#">��˾���</a><span>|</span><a href="#">��������</a><span>|</span><a href="#">��˽����</a><span>|</span><a href="#">��ѯ�ȵ�</a><span>|</span><a href="#">������ļ</a><span>|</span><a href="#">���ͷ�ʽ</a><span>|</span><a href="#">��ϵ����</a>
    </div>
    <div class="footer2">
    @ 2011-2012 ���ҽ���̳� ��Ȩ���У�����������Ȩ����<br />
    �绰:029-62966051 87811277 ���棺029-62966051 ��ICP��1109231�� ����֧�֣�<a href="#">��������</a>

    </div>
</div>
</body>
</html>
