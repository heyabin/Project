<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!-- 左边树状列表 导航条-->
		<div class="middle_left">
  		<div class="middle_left1">
	        	<div class="middle_left1title">
	        	<!-- 先通过键得到所有父编号的集合 -->
	            	所有商品分类
	           </div>
            <div class="middle_left1con">
            	<s:iterator value="#session.maps" var="fbt">
            		<div class="l2">
                    	<img src="images/icon.jpg"/>${fbt.key.bookTypeName}：
                	</div>
                	<!-- 通过键得到每一个子类别 -->
                	<s:iterator value="#fbt.value" var="son">
			                <div class="l3">
			                  &nbsp;&nbsp;&nbsp; <a href="<%=request.getContextPath()%>/show_ShowBookListByTypeId.action?bookTypeId=${son.bookTypeId}&page=1">${son.bookTypeName}></a><br/>
			                </div>
			       </s:iterator>         			
            	</s:iterator>
            </div>
        </div>
      <!-- 最新排行显示 -->
        <div class="middle_left3">
        		<h3 class="paihtit">最新排行</h3>
        		<s:iterator value="#session.rxBooks" var="bookInfo">
        		<a href="<%=request.getContextPath()%>/show_ShowBookInfo?bookId=${bookInfo.bookId}">${bookInfo.bookName}</a>
				</s:iterator>
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
