<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>奖惩信息详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  奖惩信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>奖惩编号：</td><td width='39%'>${jiangchengxinxi.jiangchengbianhao}</td>     <td width='11%'>奖惩标题：</td><td width='39%'>${jiangchengxinxi.jiangchengbiaoti}</td></tr><tr>     <td width='11%'>奖惩内容：</td><td width='39%'>${jiangchengxinxi.jiangchengneirong}</td>     <td width='11%'>奖惩分数：</td><td width='39%'>${jiangchengxinxi.jiangchengfenshu}</td></tr><tr>     <td width='11%'>时间：</td><td width='39%'>${jiangchengxinxi.shijian}</td>     <td width='11%'>录入人：</td><td width='39%'>${jiangchengxinxi.lururen}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

