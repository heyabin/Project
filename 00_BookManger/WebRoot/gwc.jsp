<%@ page language="java"  contentType="text/html; charset=gbk"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.Collection"%>
<%@page import="servert.gwc.Gwc"%>
<%@page import="servert.gwc.GwcItem"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta name="viewport" content="width=1024" />
<title>�ҵĹ����</title>
<link rel="stylesheet" type="text/css" href="style/style.css" />
<link rel="stylesheet" href="style/public.css" type="text/css" />
<script type="text/javaScript">
	function changeNum(id, num) {
		if(isNaN(num)) {
			alert("��������������!");
			return;
		}
		if(num < 1) {
			alert("����������ڵ���һ!");
			return;
		}
		location = "<%=request.getContextPath()%>/UpdateGwcItemNumServlet?id=" + id + "&num=" +num;
	}
</script>
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
				<li><a href="<%=request.getContextPath()%>/MyKJ" class="bg_cart btn_check_order""><img src="images/car.gif">�ҵĿռ�</a></li>
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
<div class="content">
    	  <div class="title1"></div>
        <!-- ����� -->
        <dl id="myCartTitle">
        	<dt>����ѡ����Ʒ</dt>
        	<dd>���� <a href="#">��¼</a>����Ʒ�����ñ��浽���ҵĹ������</dd>        </dl>
			<div class="clear"><img src="#" width="1" height="1"></div>
			<div id="myCartTable">
		<table width="100%" border="0" cellspacing="" cellpadding="5">
		  <tr>
			<th>��Ʒ����</th>
			<th>���ۣ�Ԫ��</th>
			<th>����</th>
			<th>�Ż�</th>
			<th>С�ƣ�Ԫ��</th>
			<th>����</th>
		  </tr>
		  <%
		  if(session.getAttribute("gwc")== null){
			  
		  }else{
		  Gwc gwc = (Gwc)session.getAttribute("gwc");
		  Collection<GwcItem> gwcItems = gwc.getItemNum();
		  for(GwcItem item : gwcItems) {
		  %>
			  
		  <tr>
			<td align="left" width="400">
			<div class="shpic">
				<a href="<%=request.getContextPath()%>/ShowBookInfoServlet?id=<%=item.getBookId()%>"><img src="<%=request.getContextPath()%>/background/imgsd/<%=item.getSmallImg()%>"/></a>
			</div>
			<span class="shname">
			<a href="<%=request.getContextPath()%>/ShowBookInfoServlet?id=<%=item.getBookId()%>"><%=item.getBookName()%></a>
			<br />
			   </span></td>
			<td align="center" width="100">
			�� �� ��<%=item.getHyprice()%>
			<span class="fccc"><del> <br />
		        �г��ۣ�<%=item.getPrice()%></del></span></td>
			<td align="center" width="70">
			<a title="��-" 
			onclick="changeNum('<%=item.getBookId()%>','<%=item.getNum() - 1%>');" style="cursor:pointer" class="btn_minus_s">-</a>  
				<!-- ���� -->
				<input value="<%=item.getNum()%>" onchange="changeNum('<%=item.getBookId()%>', this.value);" name="text" type="text" class="text_num"id="num_2073165120748"  size="2" maxlength="2" autocomplete="off" now_data2073165120748="1"/>
			<a title="��+" onclick="changeNum('<%=item.getBookId()%>','<%=item.getNum() + 1%>');" style="cursor:pointer" class="btn_plus_s">+</a></td>
			<!-- �Ż� -->
			<td align="center" width="50"><%=((item.getPrice() - item.getHyprice()) * item.getNum()) %></td>
			<!-- С�� -->
			<td align="center" width="60"><%=item.getNum() * item.getHyprice() %></td>
			
			<td align="center" width="100"><span class="cols col-7"><a onclick="add_favorites('2073165120748','20731651148');" style="cursor:pointer">�����ղ�</a> | 
			<a onclick="return confirm('��ȷ��Ҫɾ��<%=item.getBookName()%>��?');" href="<%=request.getContextPath()%>/DeleteGwcItemServlet?id=<%=item.getBookId()%>" style="cursor:pointer">ɾ��</a></span></td>
		  </tr>
		  <%}
		  %>
		  <tr><td colspan="6" align="right" class="zongj">
		  �ܼۣ�$<%=gwc.getOldPrices()%>Ԫ    
		  �Żݣ�$<%=gwc.getYhPrices()%>Ԫ
          <input type="hidden" name="packagehidden" id="packagehidden" value=""> 
                      = ��Ʒ�ܼ�(�����˷�)��
          <span class="fred"><%=gwc.getOldHyPrices()%>Ԫ</span>  ��ã�0 ���ֵ�</td>
		  </tr>
		  <tr><td colspan="6"><div class="left">
		  			<!-- �������� -->
					 <a href="<%=request.getContextPath()%>/InitSevert" class="btn_clear_cart"><img src="images/jxgw.png"></a>
                    <!-- ��չ��ﳵ -->
                    <a  onclick="return confirm('��ȷ��Ҫ��չ��ﳵ��?');" href="<%=request.getContextPath()%>/ClearGwcServlet?id" class="btn_clear_cart"><img src="images/qkgw.png"></a>
                    </div>
					 <div class="right" >
					<a href="<%=request.getContextPath()%>/InitOrderServert" class="bg_cart btn_check_order" ><img src="images/jies.png"></a>
					</div>
         </td></tr>
		</table>
		<%
		  }
		%>
		</div>
		<div id="interested">
			<h3>�����ܸ���Ȥ�ı���&hellip;</h3>
				<a href="#" class="J_ClearBrowse clear" style="display: none;">���</a>
			<div class="con">
				<ul class="tabs" id="menu3">
					<li onmouseOver="settab(3,0)"  class="current "><a href="#"><span>����ղص�</span></a></li>
					<li onmouseOver="settab(3,1)"><a href="#"><span>����������</span></a></li>
					<li onmouseOver="settab(3,2)"><a href="#"><span>����ϲ����</span></a></li>
				</ul>
						<div id="main3">
							<ul class="pannel">
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα�����</span> <span  class="fred">��299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα���������</span> <span  class="fred">��299</span></a> </li>
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα���������</span> <span  class="fred">��299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα���������</span> <span  class="fred">��299</span></a></li>
							</ul>
						
						<ul class="pannel" style="display:none; ">
								<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα�����</span> <span  class="fred">��299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα���������</span> <span  class="fred">��299</span></a> </li>
								<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα�����������</span> <span  class="fred">��299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα��������� </span> <span  class="fred">��299</span></a></li></ul>
						<ul class="pannel"  style="display:none; ">
									<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα���������</span> <span  class="fred">��299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα��������� </span> <span  class="fred">��299</span></a> </li>
								<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">M�����Ͽڵİ����Ͽα���������</span> <span  class="fred">��299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα���������</span> <span  class="fred">��299</span></a></li>
						</ul>         
			  </div></div>
		</div>
		
		<div class="clear"><img src="#" width="1" height="1"></div>  	
</div>
	<!-- footer -->
<div class="footer">
	<ul class="lbox">
    	<li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">�����ļ���״̬</a></li>
        <li><a href="#">��Ա�ȼ��ۿ�</a></li>
        <li><a href="#">���ֽ����ƻ�</a></li>
        <li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">��Ʒ�˻���֤</a></li>
    </ul>
    <ul class="lbox">
    	<li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">�����ļ���״̬</a></li>
        <li><a href="#">��Ա�ȼ��ۿ�</a></li>
        <li><a href="#">���ֽ����ƻ�</a></li>
        <li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">��Ʒ�˻���֤</a></li>
    </ul>
   	<ul class="lbox">
    	<li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">�����ļ���״̬</a></li>
        <li><a href="#">��Ա�ȼ��ۿ�</a></li>
        <li><a href="#">���ֽ����ƻ�</a></li>
        <li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">��Ʒ�˻���֤</a></li>
    </ul>
   	<ul class="lbox nolbox">
    	<li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">�����ļ���״̬</a></li>
        <li><a href="#">��Ա�ȼ��ۿ�</a></li>
        <li><a href="#">���ֽ����ƻ�</a></li>
        <li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">��Ʒ�˻���֤</a></li>
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
��Ȩ���У�www.xubangyiliao.com<br />
�绰:029-62966051 87811277 ���棺029-62966051 ��ICP��1109231��
</div>

</body>

</html>

