<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%@page import="enetiy.BookType"%>
<%@page import="enetiy.BookInfo"%>

<div class="middle_left">

    <%
	List<BookInfo> rxBooks2 = (List<BookInfo>)request.getAttribute("rxBooks");
	Map<BookType, List<BookType>> maps = (Map<BookType, List<BookType>>)request.getAttribute("maps");

     %>

  		<div class="middle_left1">
  		<!-- ������Ʒ���� --><!-- �ȵõ����м���ֵ keySet()����-->
        	<div class="middle_left1title">
            	������Ʒ����
            </div>
            <div class="middle_left1con">
            	<%
            	Set<BookType> fbts = maps.keySet();
            		for(BookType fbt : fbts) {%>
            		<div class="l2">
                    	<img src="images/icon.jpg"/><%=fbt.getBookTypeName()%>��
                	</div>
                	<%
                	//ͨ�����õ�ÿһ�������
                		List<BookType> sons = maps.get(fbt);
                		for(BookType son : sons) {%>	
			                <div class="l3">
			                  &nbsp;&nbsp;&nbsp; <a href="<%=request.getContextPath()%>/ShowBookListByTypeIdServlet?booktypeId=<%=son.getBookTypeId()%>&nowPage=1"><%=son.getBookTypeName()%></a><br />
			                </div>			
                	
                	<%	}
                	%>	
            	<%}%>
            </div>
            <div class="zzzz">
            
            </div>
        </div>
      <!-- ����������ʾ -->
        <div class="middle_left3">
        		<h3 class="paihtit">��������</h3>
        	<%for(BookInfo bookInfo : rxBooks2) {%>
        		<a href="<%=request.getContextPath()%>/ShowBookInfoServlet?id=<%=bookInfo.getBookId()%>"><%=bookInfo.getBookName()%></a>
			<%}%>
        </div> 
        <div class="middle_left2">
        	<img src="images/1.jpg">
        </div>
        <div class="middle_left2">
            <img src="images/2.jpg">
        </div>
         <div class="middle_left2">
            <img src="images/3.jpg">
         </div>
    </div>
