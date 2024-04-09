<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>用户注册详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">

  </head>

  <body >

  用户注册详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>用户名：</td><td width='39%'>${yonghuzhuce.yonghuming}</td>
<td  rowspan=10 align=center><a href=${yonghuzhuce.touxiang} target=_blank><img src=${yonghuzhuce.touxiang} width=228 height=215 border=0></a></td></tr><tr>
<td width='11%' height=44>密码：</td><td width='39%'>${yonghuzhuce.mima}</td>
</tr><tr>
<td width='11%' height=44>姓名：</td><td width='39%'>${yonghuzhuce.xingming}</td>
</tr><tr>
<td width='11%' height=44>性别：</td><td width='39%'>${yonghuzhuce.xingbie}</td>
</tr><tr>
<td width='11%' height=44>出生年月：</td><td width='39%'>${yonghuzhuce.chushengnianyue}</td>
</tr><tr>
<td width='11%' height=44>QQ：</td><td width='39%'>${yonghuzhuce.QQ}</td>
</tr><tr>
<td width='11%' height=44>邮箱：</td><td width='39%'>${yonghuzhuce.youxiang}</td>
</tr><tr>
<td width='11%' height=44>手机：</td><td width='39%'>${yonghuzhuce.shouji}</td>
</tr><tr>
<td width='11%' height=44>身份证：</td><td width='39%'>${yonghuzhuce.shenfenzheng}</td>
</tr><tr>

<td width='11%' height=44>地址：</td><td width='39%'>${yonghuzhuce.dizhi}</td>
</tr><tr>

<td width='11%' height=100  >备注：</td><td width='39%' colspan=2 height=100 >${yonghuzhuce.beizhu}</td></tr><tr><td height="45" colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()"  class="btn btn-info btn-small" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" class="btn btn-info btn-small" /></td></tr>
    
  </table>

  </body>
</html>

