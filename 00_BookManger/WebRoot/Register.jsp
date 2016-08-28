<%@ page language="java" contentType="text/html; charset=gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>易购网 － 填写基本信息</title>
<link href="css/front/register.css" rel="stylesheet" type="text/css" />
<link href="css/front/common.css" rel="stylesheet" type="text/css" />
<link href="css/front/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/j.js"></script>
		<script type="text/javascript" src="js/ajax.js"></script>
		<script language="javascript" src="js/util.js"></script>

		<script type="text/javascript" src="js/front/StringLength.js"></script>
		<script type="text/javascript" src="js/front/base.js"></script>
		
	
</head>

<body >
	<div class="full">

  <div class="t_Top">
	  	<div class="n_dl_logo"><img src="images/front/logo.png" border="0" /></div>
		<div class="n_dl_t"><span class="color_4">云工厂--更多精彩欢迎您</span></div>
		<div class="n_dl_r"><a href="/login.do" class="color_56">登录</a> <span class="color_55">|</span> 易购新手 <span class="color_55">|</span> 网站帮助</div>

		<div class="n_dl_l"></div>
		<div class="n_dl_l_1"></div>
	  </div>
	  <div class="n_dl_c">
	  	<div class="n_dl_yz"><img src="images/front/regis_t.gif" /></div>
		<!-- <ul class="n_zc_yz_1">
				<li>
					<div class="n_zc_yz_1_a">1.填写基本信息</div>
				</li>
				<li>
					<div class="n_zc_yz_1_b">2.手机验证领取优惠券 (可选)</div>
				</li>
				<li>
					<div class="n_zc_yz_1_b">3.注册成功</div>
				</li>
			</ul> 
	   -->
		<div style="clear:both"></div>
		<div class="n_zc">
		<form method="post" id="register" action="<%=request.getContextPath()%>/CustmerRegisterServlet" name="register" >

			  	<input name="source" value="http://www.egou.com/" type="hidden"/>
				<input name="vid" type="hidden" value="" />
				<input name="cid" type="hidden" value="" />
				<input name="wid" type="hidden" value="" />
				<input name="vwid" type="hidden" value="" />
				<input name="fbt" type="hidden" value="" />
		  <table width="780" border="0" cellspacing="0" cellpadding="0">
		  
            <tr>
              <td width="89" height="40" align="right">用户名：</td>

              <td height="40" colspan="3"><input type="text" id="username" name="custName" class="input_35" value="" 
               tabindex="1" onblur="checkNameReg()"/>
              </td>
              <td width="19" height="40" align="center" class="color_1">*</td>
              <td width="465" height="40"><span class="color_4" id="userNameMsg">3-12个字符(包括字母、数字、中文、下划线)</span>
              </td>
            </tr>

           
           
            <tr>
              <td height="40" align="right">密码：</td>
              <td height="40" colspan="3"><input type="password" name="pwd" id="password" class="input_35" 
              tabindex="2" onblur="checkPWDReg()"/>
              </td>
              <td height="40" align="center" class="color_1">*</td>
              <td height="40"><span class="color_4" id="passwordMsg" >6-16个字符，推荐使用英文字母加数字或符号的组合密码</span>
              </td>
            </tr>
           
           
            <tr>
              <td height="40" align="right">确认密码：</td>
              <td height="40" colspan="3"><input type="password" name="repeatPassword" id="repeatPassword"  class="input_35" tabindex="3" onblur="checkRePWDReg()"/>
              </td>
              <td height="40" align="center"><span class="color_1">*</span></td>
              <td height="40"><span class="color_4" id="repeatPasswordMsg">请再次输入您设置的密码，并确保两次输入一致</span>

              </td>
            </tr>
             
            
            <tr>
              <td height="40" align="right">Email地址：</td>
              <td height="40" colspan="3"><input type="text" name="email" id="email" value=""  class="input_35" 
              tabindex="4"  onblur="checkEmailReg()" />
              </td>
              <td height="40" align="center"><span class="color_1">*</span></td>

              <td height="40"><span class="color_4" id="emailMsg">请填写有效的Email地址，以方便您找回用户名和密码</span></td>
               </tr>
            <tr>
            	<td></td>
            	<td>
            	<input type="submit" id="submit" value="提交" onclick="return checkAll()" />&nbsp;&nbsp;
            	</td>
            	<td>
            	 <input type="reset" id="reset" value="重置"/>
            	</td>
            </tr>
          </table>
          </form>
		</div>
		</div>
	  
		<div class="Bottom">
		

<div class="Bottom">
		<div class="Bottom_1" style="margin-top:5px"></div>
		<div class="Bottom_2">

		  <table width="950" cellspacing="0" cellpadding="0">
			<tr>
			  <td colspan="3" align="center"><a href="help/aboutegou.html" target="_blank" class="color">关于易购</a> | <a href="/help/mediumreported.html" target="_blank" class="color">媒体报道</a> | <a href="help/loveletter.html"  class="color_1">易购情书</a> | <a href="/help/advertisement.html" target="_blank" class="color">广告合作</a> | <a href="http://bbs.egou.com/thread.php?fid=16" target="_blank" class="color">建议疑问</a> | <a href="/help/" target="_blank" class="color">网站帮助</a> | <a href="/help/sitemap.html" target="_blank" class="color">网站地图</a> | <a href="/help/links.html" target="_blank" class="color">友情链接</a> |
	   <a href="/help/contactus.html" target="_blank" class="color">联系我们</a></td>

			  </tr>
			<tr>
			  <td width="250"></td>
			  <td width="389" align="center"><span style="color:#666666">Copyright &copy; 2004-2010 by   www.egou.com all rights reserved<br />
				<a href="http://www.emar.com.cn" target="_blank" class="color_2">亿玛在线</a> 旗下网站<a href="http://www.miibeian.gov.cn/" target="_blank" class="color_2">京ICP证080025号</a> </span></td>

			  <td width="309" height="60" align="left" valign="middle"></td>
			</tr>
		  </table>
 		</div>
	</div>
		</div>
	</div>
<script type="text/javascript">
		var xhr;
		
		document.getElementById("username").onfocus = function() {
			document.getElementById("userNameMsg").innerHTML = "3-12个字符(包括字母、数字、中文、下划线)";
		}
		function checkNameReg() {
			var result = true;
			var username = document.getElementById("username").value;
			
			var filter=/^[A-Za-z0-9\u4e00-\u9fa5_-]{3,12}$/; 
			if(username == ""){
				document.getElementById("userNameMsg").innerHTML="<font color='red'>用户名不能为空，请输入</font>";
				return false;
			} 
			if (!filter.test(username)){
 					document.getElementById("userNameMsg").innerHTML="<font color='red'>用户名格式错误，请重新输入</font>";
					return false;
		    }
			xhr = new XMLHttpRequest();
			if(xhr) {
				xhr.onreadystatechange = isExitName(xhr);
				var url = "<%=request.getContextPath()%>/IsExitNameServlet?username="+username;
				xhr.open("post",url,true);
				xhr.send(null);
			}
			return result;
		}
		
		function isExitName(xhr) {
			return function() {
				if(xhr.readyState == 4 && xhr.status == 200) {
					var res = xhr.responseText;
					if("true" == res) {
						document.getElementById("userNameMsg").innerHTML="<font color='red'>用户名已经被注册！</font>";
						document.getElementById("submit").disabled="disabled";
					} else {
						document.getElementById("userNameMsg").innerHTML="<font color='blue'>用户名可用！</font>";
						document.getElementById("submit").disabled="";
					}
				}
			}
		}
		
		document.getElementById("password").onfocus = function() {
				document.getElementById("passwordMsg").innerHTML = "6-16个字符(包括字母、数字)，推荐使用英文字母加数字或符号的组合密码";
		}
		function checkPWDReg() {
			var password = document.getElementById("password").value; 
		 	var filter=/^[A-Za-z0-9]{6,16}$/; 
		 	if(password == "") {
				document.getElementById("passwordMsg").innerHTML="<font color='red'>密码不能为空，请输入</font>";
				return false;
			} else if (!filter.test(password)){
 				document.getElementById("passwordMsg").innerHTML="<font color='red'>密码格式错误，请重新输入</font>";
				return false;
		    } else {
		    	document.getElementById("passwordMsg").innerHTML="<font color='blue'>密码格式正确</font>";
		    	return true;
		    }
			
		}
		
		document.getElementById("repeatPassword").onfocus = function() {
			document.getElementById("repeatPasswordMsg").innerHTML = "请再次输入您设置的密码，并确保两次输入一致";
		}
		function checkRePWDReg() {
			var password = document.getElementById("password").value; 
			var repeatPassword = document.getElementById("repeatPassword").value; 
			if(repeatPassword == "") {
				document.getElementById("repeatPasswordMsg").innerHTML="<font color='red'>两次输入的密码不一致，请重新输入</font>";
				return false;
			}else if (password != repeatPassword){
			     document.getElementById("repeatPasswordMsg").innerHTML="<font color='red'>两次输入的密码不一致，请重新输入</font>";
			     document.getElementById("repeatPassword").value = "";
				result = false;
		    } else {
		    	document.getElementById("repeatPasswordMsg").innerHTML="<font color='blue'>两次输入的密码一致</font>";
		    	return true;
		    }
		}
		
		document.getElementById("email").onfocus = function() {
			document.getElementById("emailMsg").innerHTML = "请填写有效的Email地址，以方便您找回用户名和密码(格式如123@qun.com)";
		}
		function checkEmailReg() {
			var result = true;
			var email = document.getElementById("email").value; 
		 	var emailRegS=/^([a-zA-Z0-9_\-\.\+]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		 	if(email == "") {
				document.getElementById("emailMsg").innerHTML="<font color='red'>email地址不能为空，请输入</font>";
				return false;
			}
		   	if (!emailRegS.test(email)){
			     document.getElementById("emailMsg").innerHTML="<font color='red'>Email地址无效，请填写有效的Email地址</font>";
				return false;
			}
		   	xhr = new XMLHttpRequest();
			if(xhr) {
				xhr.onreadystatechange = isExitEmail(xhr);
				var url = "<%=request.getContextPath()%>/IsExitEmailServlet?email="+email;
				xhr.open("post",url,true);
				xhr.send(null);
			}
		   	return result;
		}
		
		function isExitEmail(xhr) {
			return function() {
				if(xhr.readyState == 4 && xhr.status == 200) {
					var res = xhr.responseText;
					if("true" == res) {
						document.getElementById("emailMsg").innerHTML="<font color='red'>email已经被注册！</font>";
						document.getElementById("submit").disabled="disabled";
					} else {
						document.getElementById("emailMsg").innerHTML="<font color='blue'>email有效！</font>";
						document.getElementById("submit").disabled="";
					}
				}
			}
		}
		
		function checkUserName() {
			var username = document.getElementById("username").value;
			if(username == ""){
				document.getElementById("userNameMsg").innerHTML="<font color='red'>用户名不能为空，请输入</font>";
				return false;
			} 
			return checkNameReg();
		}
		
		function checkPwd() {
			var password = document.getElementById("password").value; 
			if(password == "") {
				document.getElementById("passwordMsg").innerHTML="<font color='red'>密码不能为空，请输入</font>";
				return false;
			}
			return checkPWDReg();
		}
		
		function checkRePwd() {
			var repeatPassword = document.getElementById("repeatPassword").value;
			if(repeatPassword == "") {
				document.getElementById("repeatPasswordMsg").innerHTML="<font color='red'>两次输入的密码不一致，请重新输入</font>";
				return false;
			}
			return checkRePWDReg();
		}
		
		function checkEmail() {
			var email = document.getElementById("email").value;
			if(email == "") {
				document.getElementById("emailMsg").innerHTML="<font color='red'>email地址不能为空，请输入</font>";
				return false;
			}
			return checkRePWDReg();
		}
		
		
		function validateCode(){
		var result = true;
		var checkCode =document.getElementById("randNum").value;
		var checkCodeMsg = document.getElementById("checkCodeMsg");
		if(checkCode == ""){
			checkCodeMsg.innerHTML = "您输入的验证码错误，请重新输入";
			checkCodeMsg.className = 'n_zc_red';
			return false;
		}
		if(checkCode.length != 4){
			checkCodeMsg.innerHTML = "验证码为4位，请重新输入";
			checkCodeMsg.className = 'n_zc_red';
			return false;
		}
		xhr = new XMLHttpRequest();
		if(xhr) {
			xhr.onreadystatechange = isRightCode(xhr);
			var url = "<%=request.getContextPath()%>/IsRightCodeServlet?code="+checkCode;
			xhr.open("post",url,true);
			xhr.send(null);
		}
	   	return result;
	}
		function isRightCode(xhr) {
			return function() {
				if(xhr.readyState == 4 && xhr.status == 200) {
					var checkCodeMsg = document.getElementById("checkCodeMsg");
					var res = xhr.responseText;
					if("false" == res) {
						checkCodeMsg.innerHTML = "验证码错误，请重新输入";
						checkCodeMsg.className = 'n_zc_red';
						document.getElementById("randNum").value = "";
						document.getElementById("submit").disabled="disabled";
					} else {
						checkCodeMsg.className = '';
    					checkCodeMsg.innerHTML = "<font color='blue'>验证码正确！</font>";
						document.getElementById("submit").disabled="";
					}
				}
			}
		}
		
		
		function refreshCode(){
			var img = document.getElementById("img");
			if(img){
				nowDate = new Date();
				img.src = "<%=request.getContextPath()%>/kaptcha?d="+nowDate.getTime();
			}
		}
	 function checkAll(){
    	var result = true;
    	if(!checkUserName())
    		result = false;
   		if(!checkPwd())
    		result = false;
    	if(!checkRePwd())
    		result = false;
    	if(!checkEmail())
    		result = false;
    	if(!validateCode())
    		result = false;
    	return result;
    }
	 function setFocusStyle() {
		 document.getElementById("checkCodeMsg").innerHTML = "";
		 document.getElementById("checkCodeMsg").className = "";
	 }
	 
</script>
</body>

</html>


