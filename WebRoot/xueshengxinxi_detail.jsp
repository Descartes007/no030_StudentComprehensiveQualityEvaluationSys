<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>学生信息详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  学生信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>学号：</td><td width='39%'>${xueshengxinxi.xuehao}</td>     <td width='11%'>密码：</td><td width='39%'>${xueshengxinxi.mima}</td></tr><tr>     <td width='11%'>姓名：</td><td width='39%'>${xueshengxinxi.xingming}</td>     <td width='11%'>性别：</td><td width='39%'>${xueshengxinxi.xingbie}</td></tr><tr>     <td width='11%'>身份证：</td><td width='39%'>${xueshengxinxi.shenfenzheng}</td>     <td width='11%'>电话：</td><td width='39%'>${xueshengxinxi.dianhua}</td></tr><tr>     <td width='11%'>班级：</td><td width='39%'>${xueshengxinxi.banji}</td>     <td width='11%'>是否挂科：</td><td width='39%'>${xueshengxinxi.shifouguake}</td></tr><tr>     <td width='11%'>是否参加新媒体设计大赛：</td><td width='39%'>${xueshengxinxi.shifoucanjiaxinmeitishejidasai}</td>     <td width='11%'>是否在贫困库中：</td><td width='39%'>${xueshengxinxi.shifouzaipinkunkuzhong}</td></tr><tr>     <td width='11%'>是否建档立卡：</td><td width='39%'>${xueshengxinxi.shifoujiandanglika}</td>     <td width='11%'>计算出学生操行测评分：</td><td width='39%'>${xueshengxinxi.jisuanchuxueshengcaoxingcepingfen}</td></tr><tr>     <td width='11%'>智育测评得分：</td><td width='39%'>${xueshengxinxi.zhiyucepingdefen}</td>     <td width='11%'>能力加分项得分：</td><td width='39%'>${xueshengxinxi.nenglijiafenxiangdefen}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

