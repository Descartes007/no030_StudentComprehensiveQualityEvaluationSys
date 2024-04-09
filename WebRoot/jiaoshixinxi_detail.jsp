<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>教师信息详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  教师信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>工号：</td><td width='39%'>${jiaoshixinxi.gonghao}</td>     <td width='11%'>密码：</td><td width='39%'>${jiaoshixinxi.mima}</td></tr><tr>     <td width='11%'>姓名：</td><td width='39%'>${jiaoshixinxi.xingming}</td>     <td width='11%'>性别：</td><td width='39%'>${jiaoshixinxi.xingbie}</td></tr><tr>     <td width='11%'>身份证：</td><td width='39%'>${jiaoshixinxi.shenfenzheng}</td>     <td width='11%'>电话：</td><td width='39%'>${jiaoshixinxi.dianhua}</td></tr><tr>     <td width='11%'>职称：</td><td width='39%'>${jiaoshixinxi.zhicheng}</td>     <td width='11%'>备注：</td><td width='39%'>${jiaoshixinxi.beizhu}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

