<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:useBean id="code" scope="page" class="com.util.CheckCode" />
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>无标题文档</title>

<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="images/style.css" tppabs="css/style.css" />
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
body,td,th {
	font-size: 0.28em;
}
</style>
<script src="images/jquery.js"></script>
<script src="images/verificationNumbers.js" tppabs="images/verificationNumbers.js"></script>
<script src="images/Particleground.js" tppabs="images/Particleground.js"></script>
<script>
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });
  //验证码
  createCode();
  //测试提交，对接程序删除即可
  $(".submit_btn").click(function(){
	  location.href="javascrpt:;"/*tpa=http://***index.html*/;
	  });
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
	<script type="text/javascript">
	function hsgchecklogin() {
	if(document.f11.username.value=="" || document.f11.pwd.value=="" || document.f11.pagerandom.value=="")
	{
		alert("请输入完整");
		return false;
	}
	if (document.f11.pagerandom.value != document.f11.yzm.value) {
			alert("验证码错误！");
			document.f11.pagerandom.focus();
			return false;
	}
	
	}
	</script>    
<body>
<dl class="admin_login">
 <dt>
  
  <strong><font color=white>综合素质测评</font></strong>
  <em>Management System</em>
 </dt>
 <form name="f11" id="f11" method="post" action="hsgloginyanzheng.jsp">
 <dd class="user_icon">
  <input type="text" placeholder="账号" class="login_txtbx" name="username" id="username"/>
 </dd>
 <dd class="pwd_icon">
  <input type="password" placeholder="密码" class="login_txtbx" name="pwd" id="pwd"/>
 </dd>
 <dd>
 <div style="padding-top:10px;">
  <font color=white>权限：</font><select name="cx" id="cx">
              <option value="管理员">管理员</option>
<option value="教师">教师</option>
<option value="学生">学生</option>

            </select>
	</div>	
 </dd>
 <dd class="val_icon">
  <div class="checkcode">
    <input type="text"  placeholder="验证码" maxlength="4" class="login_txtbx" id="pagerandom" name="pagerandom">
   
  </div>
 &nbsp; <font style="cursor:pointer; position:absolute; padding-top:10px; "> <%
								String yzm=code.getCheckCode();
								%>  <input type="hidden" name="yzm" value="<%=yzm %>" >
								  <font color="#FFFFFF"><%=yzm %></font></font>
 </dd>
 <dd>
 	<input type="submit" name="Submit" value="登陆" onClick="return hsgchecklogin();" class="submit_btn">
 
 </dd>
 <dd>

 </dd>
 
 </form>
</dl>
</body>
</html>
