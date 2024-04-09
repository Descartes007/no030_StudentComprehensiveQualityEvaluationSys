<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>学生成绩详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  学生成绩详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>学号：</td><td width='39%'>${xueshengchengji.xuehao}</td>     <td width='11%'>姓名：</td><td width='39%'>${xueshengchengji.xingming}</td></tr><tr>     <td width='11%'>性别：</td><td width='39%'>${xueshengchengji.xingbie}</td>     <td width='11%'>班级：</td><td width='39%'>${xueshengchengji.banji}</td></tr><tr>     <td width='11%'>学年：</td><td width='39%'>${xueshengchengji.xuenian}</td>     <td width='11%'>学期：</td><td width='39%'>${xueshengchengji.xueqi}</td></tr><tr>     <td width='11%'>科目：</td><td width='39%'>${xueshengchengji.kemu}</td>     <td width='11%'>分数：</td><td width='39%'>${xueshengchengji.fenshu}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

