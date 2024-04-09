<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>综合测评详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  综合测评详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>学号：</td><td width='39%'>${zongheceping.xuehao}</td>     <td width='11%'>姓名：</td><td width='39%'>${zongheceping.xingming}</td></tr><tr>     <td width='11%'>班级：</td><td width='39%'>${zongheceping.banji}</td>     <td width='11%'>计算出学生操行测评分：</td><td width='39%'>${zongheceping.jisuanchuxueshengcaoxingcepingfen}</td></tr><tr>     <td width='11%'>智育测评得分：</td><td width='39%'>${zongheceping.zhiyucepingdefen}</td>     <td width='11%'>能力加分项得分：</td><td width='39%'>${zongheceping.nenglijiafenxiangdefen}</td></tr><tr>     <td width='11%'>综合得分：</td><td width='39%'>${zongheceping.zonghedefen}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

