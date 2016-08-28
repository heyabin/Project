<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.CustomerInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.List"%>
<%@page import="enetiy.BookInfo"%>
<%@page import="enetiy.News"%>
<%@page import="enetiy.BookType"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	List<BookInfo> zxBooks = (List<BookInfo>)request.getAttribute("zxBooks");
	List<BookInfo> rxBooks = (List<BookInfo>)request.getAttribute("rxBooks");
	List<BookInfo> tjBooks = (List<BookInfo>)request.getAttribute("tjBooks");
	List<News> listNews = (List<News>) request.getAttribute("listNews");
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>�����</title>
		<meta name="keywords" content="�ؼ���" />
		<meta name="description" content="ҳ������" />
		<link rel="stylesheet" href="style/public.css" type="text/css" />
		<link rel="stylesheet" href="style/index.css" type="text/css" />
		<script src="js/banner.js" type="text/javascript">
</script>
	</head>
	<body>
		<!-- top1 -->
		<div class="top1">
	<div class="top1_1">
   	��ӭ��������������̳ǣ�
   	<%if(session.getAttribute("customerInfo") == null) {%>
   	�û�����<input type="text" name="name" class="inputsty"> ���룺<input type="text" name="password" class="inputsty"> <a href="#">��������?</a> 
   	<input type="button" value="��¼" class="btn1">  <input type="button" value="ע��" class="btn1">	
   	<%} else {
   		CustomerInfo customerInfo = (CustomerInfo)session.getAttribute("customerInfo");
   		%>	
   		��ӭ��:<%=customerInfo.getCustName() %>
   	<%}
   	%>
   	</div>
			<div class="top1_2">
				<div class="top1_2_l">
					<ul class="yudingCon">
						<li>
							����:
							<input type="text" name="" class="kuang" />
						</li>
						<li>
							����:
							<input type="text" name="" class="kuang" />
						</li>
						<li class="ribtn">
							<input type="image" src="images/btn.gif" class="btn" />
						</li>
					</ul>
				</div>
				<div class="top1_2_r">
					<ul class="other">
						<li>
							<a href="gwc.jsp"><img src="images/car.gif">
									<br />
									���ﳵ
							</a>
						</li>
						<li>
							<a href="#"><img src="images/car.gif">
									<br />
									������ѯ 
							</a>
						</li>
						<li>
							<a href="#"><img src="images/car.gif">
									<br />
									�ҵĿռ�
							</a>
						</li>
						<li>
							<a href="#"><img src="images/car.gif">
									<br />
									������� 
							</a>
						</li>
					</ul>
					<ul class="menu">
						<li>
							<a href="index.html">��ҳ</a>
						</li>
						<li>
							<a href="prolist.html">����</a>
						</li>
						<li>
							<a href="pro_show.html">��ѧ</a>
						</li>
						<li>
							<a href="#">������ϵ</a>
						</li>
						<li>
							<a href="#">�Ļ�</a>
						</li>
						<li>
							<a href="#">��Ӫ</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- middle -->
		<div class="middle">

			<%@ include file="leftInclude.jsp"%>

			<div class="middle_right">
				<div class="middle_right1L">
					<DIV id=idContainer2 class=container>
						<TABLE id=idSlider2 border=0 cellSpacing=0 cellPadding=0>
							<TBODY>
								<TR>
									<TD class=td_f>
										<A href="#"><IMG src="images/01.jpg">
										</A>
									</TD>
									<TD class=td_f>
										<A href="#"><IMG src="images/02.jpg">
										</A>
									</TD>
									<TD class=td_f>
										<A href="#"><IMG src="images/03.jpg">
										</A>
									</TD>
									<TD class=td_f>
										<A href="#"><IMG src="images/04.jpg">
										</A>
									</TD>
									<TD class=td_f>
										<A href="#"><IMG src="images/05.jpg">
										</A>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
						<UL id=idNum class=num></UL>
					</DIV>

					<SCRIPT>
	var forEach = function(array, callback, thisObject){
		if(array.forEach){
			array.forEach(callback, thisObject);
		}else{
			for (var i = 0, len = array.length; i < len; i++) { callback.call(thisObject, array[i], i, array); }
		}
	}
	
	var st = new SlideTrans("idContainer2", "idSlider2", 5, { Vertical: false });
	
	var nums = [];
	//��������
	for(var i = 0, n = st._count - 1; i <= n;){
		(nums[i] = $("idNum").appendChild(document.createElement("li"))).innerHTML = ++i;
	}
	
	forEach(nums, function(o, i){
		o.onmouseover = function(){ o.className = "on"; st.Auto = false; st.Run(i); }
		o.onmouseout = function(){ o.className = ""; st.Auto = true; st.Run(); }
	})
	
	//���ð�ť��ʽ
	st.onStart = function(){
		forEach(nums, function(o, i){ o.className = st.Index == i ? "on" : ""; })
	}
	st.Run();
</SCRIPT>
				</div>
				<div class="middle_right1R">
					<div class="middle_right1Rtitle">
					</div>
					<div class="middle_right1Rcon">
						<ul>
							<!-- ������Ѷ���� -->
							<%
								for (News news : listNews) {
							%>
							<li>
								<a ><%=news.getContext()%></a>
							</li>
							<%
								}
							%>
						</ul>
					</div>
					<div class="middle_right1Rimg">
						<img src="images/middle_right1Rimg.jpg" />
					</div>
				</div>
				<div class="middle_right2">
					<div class="middle_right2Rtitle">
						������Ʒ
						<i>New book</i>
					</div>
					<div class="middle_right2Rcon">
						<ul>
							<%
								for (BookInfo bookInfo : zxBooks) {
							%>
							<li>
								<a
									href="<%=request.getContextPath()%>/ShowBookInfoServlet?id=<%=bookInfo.getBookId()%>"><img
										src="<%=request.getContextPath()%>/background/imgsd/<%=bookInfo.getBigImg()%>" />
								</a>
								<a
									href="<%=request.getContextPath()%>/ShowBookInfoServlet?id=<%=bookInfo.getBookId()%>"><%=bookInfo.getBookName()%></a>
								<span class="borline">�г���:<%=bookInfo.getPrice()%></span>
								<span>�̳Ǽۣ�<%=bookInfo.getHyprice()%></span>
								<input type="button" class="btn3" value=" " />
							</li>
							<%
								}
							%>
						</ul>
					</div>
				</div>
				<div class="middle_right2">
					<div class="middle_right2Rtitle title2">
						������Ʒ
						<i>hot book</i>
					</div>
					<div class="middle_right2Rcon">
						<ul>
							<li>
								<%
									for (BookInfo bookInfo : rxBooks) {
								%>
								<li>
									<a
										href="<%=request.getContextPath()%>/ShowBookInfoServlet?id=<%=bookInfo.getBookId()%>"><img
											src="<%=request.getContextPath()%>/background/imgsd/<%=bookInfo.getBigImg()%>" />
									</a>
									<a
										href="<%=request.getContextPath()%>/ShowBookInfoServlet?id=<%=bookInfo.getBookId()%>"><%=bookInfo.getBookName()%></a>
									<span class="borline">�г���:<%=bookInfo.getPrice()%></span>
									<span>�̳Ǽۣ�<%=bookInfo.getHyprice()%></span>
									<input type="button" class="btn3" value=" " />
								</li>
								<%
									}
								%>
							
						</ul>
					</div>
				</div>
				<div class="middle_right3">
					<!--�Ƽ���Ʒ  -->
					<div class="middle_right3Rtitle"></div>
					<div class="middle_right3Rcon">
						<ul>
							<%
							for(int i=0; i < 6; i++) {
                        	BookInfo bookInfo = tjBooks.get(i);
                        	%>
                        	<li>
							<a
								href="<%=request.getContextPath()%>/ShowBookInfoServlet?id=<%=bookInfo.getBookId()%>">
								<img src="<%=request.getContextPath()%>/background/imgsd/<%=bookInfo.getBigImg()%>" />
							</a>
							<a
								href="<%=request.getContextPath()%>/ShowBookInfoServlet?id=<%=bookInfo.getBookId()%>"><%=bookInfo.getBookName()%></a>
							<span class="borline">�г��ۣ���<%=bookInfo.getPrice()%></span>
							<br />
							<span>�̳Ǽۣ���<%=bookInfo.getHyprice()%></span>
						</li>
                            
							
							<%
							}
							%>
						</ul>
					</div>
				</div>

			</div>
		</div>
		<div class="clear">
			<img src="#" width="1" height="1">
		</div>
		<!-- footer -->
		<div class="footer">
			<ul class="lbox">
				<li>
					<a href="#">�˿ͱض�</a>
				</li>
				<li>
					<a href="#">�����ļ���״̬</a>
				</li>
				<li>
					<a href="#">��Ա�ȼ��ۿ�</a>
				</li>
				<li>
					<a href="#">���ֽ����ƻ�</a>
				</li>
				<li>
					<a href="#">�˿ͱض�</a>
				</li>
				<li>
					<a href="#">��Ʒ�˻���֤</a>
				</li>
			</ul>
			<ul class="lbox">
				<li>
					<a href="#">�˿ͱض�</a>
				</li>
				<li>
					<a href="#">�����ļ���״̬</a>
				</li>
				<li>
					<a href="#">��Ա�ȼ��ۿ�</a>
				</li>
				<li>
					<a href="#">���ֽ����ƻ�</a>
				</li>
				<li>
					<a href="#">�˿ͱض�</a>
				</li>
				<li>
					<a href="#">��Ʒ�˻���֤</a>
				</li>
			</ul>
			<ul class="lbox">
				<li>
					<a href="#">�˿ͱض�</a>
				</li>
				<li>
					<a href="#">�����ļ���״̬</a>
				</li>
				<li>
					<a href="#">��Ա�ȼ��ۿ�</a>
				</li>
				<li>
					<a href="#">���ֽ����ƻ�</a>
				</li>
				<li>
					<a href="#">�˿ͱض�</a>
				</li>
				<li>
					<a href="#">��Ʒ�˻���֤</a>
				</li>
			</ul>
			<ul class="lbox nolbox">
				<li>
					<a href="#">�˿ͱض�</a>
				</li>
				<li>
					<a href="#">�����ļ���״̬</a>
				</li>
				<li>
					<a href="#">��Ա�ȼ��ۿ�</a>
				</li>
				<li>
					<a href="#">���ֽ����ƻ�</a>
				</li>
				<li>
					<a href="#">�˿ͱض�</a>
				</li>
				<li>
					<a href="#">��Ʒ�˻���֤</a>
				</li>
			</ul>




		</div>
		<!-- footer1 -->
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
			��Ȩ���У�www.xubangyiliao.com
			<br />
			�绰:029-62966051 87811277 ���棺029-62966051 ��ICP��1109231��
		</div>
	</body>
</html>
