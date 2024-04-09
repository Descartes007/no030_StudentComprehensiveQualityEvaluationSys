<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>能力加分详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  能力加分详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>学号：</td><td width='39%'>${nenglijiafen.xuehao}</td>     <td width='11%'>姓名：</td><td width='39%'>${nenglijiafen.xingming}</td></tr><tr>     <td width='11%'>班级：</td><td width='39%'>${nenglijiafen.banji}</td>     <td width='11%'>是否过英语四级：</td><td width='39%'>${nenglijiafen.shifouguoyingyusiji}</td></tr><tr>     <td width='11%'>是否过英语六级：</td><td width='39%'>${nenglijiafen.shifouguoyingyuliuji}</td>     <td width='11%'>是否取得教师资格证：</td><td width='39%'>${nenglijiafen.shifouqudejiaoshizigezheng}</td></tr><tr>     <td width='11%'>是否为应征入伍返校学习者：</td><td width='39%'>${nenglijiafen.shifouweiyingzhengruwufanxiaoxuexizhe}</td>     <td width='11%'>服役期间是否立功：</td><td width='39%'>${nenglijiafen.fuyiqijianshifouligong}</td></tr><tr>     <td width='11%'>其它：</td><td width='39%'>${nenglijiafen.qita}</td>     <td width='11%'>加分数：</td><td width='39%'>${nenglijiafen.jiafenshu}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

