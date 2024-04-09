<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="xueshengxinxihsgb" scope="page" class="com.bean.XueshengxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=xueshengxinxi.xls");
%>
<html>
  <head>
    <title>学生信息</title>
  </head>

  <body >
 <%
			String sql="select * from xueshengxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>学号</td>    <td align='center' bgcolor='#ebf0f7'>密码</td>    <td align='center' bgcolor='#ebf0f7'>姓名</td>    <td  width='40' align='center' bgcolor='#ebf0f7'>性别</td>    <td align='center' bgcolor='#ebf0f7'>身份证</td>    <td align='center' bgcolor='#ebf0f7'>电话</td>    <td align='center' bgcolor='#ebf0f7'>班级</td>    <td align='center' bgcolor='#ebf0f7'>是否挂科</td>    <td align='center' bgcolor='#ebf0f7'>是否参加新媒体设计大赛</td>    <td align='center' bgcolor='#ebf0f7'>是否在贫困库中</td>    <td align='center' bgcolor='#ebf0f7'>是否建档立卡</td>    <td align='center' bgcolor='#ebf0f7'>计算出学生操行测评分</td>    <td align='center' bgcolor='#ebf0f7'>智育测评得分</td>    <td align='center' bgcolor='#ebf0f7'>能力加分项得分</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=xueshengxinxihsgb.getAllXueshengxinxi(16);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.xuehao}</td>    <td>${u.mima}</td>    <td>${u.xingming}</td>    <td align='center' bgcolor='#ebf0f7'>${u.xingbie}</td>    <td>${u.shenfenzheng}</td>    <td>${u.dianhua}</td>    <td>${u.banji}</td>    <td>${u.shifouguake}</td>    <td>${u.shifoucanjiaxinmeitishejidasai}</td>    <td>${u.shifouzaipinkunkuzhong}</td>    <td>${u.shifoujiandanglika}</td>    <td>${u.jisuanchuxueshengcaoxingcepingfen}</td>    <td>${u.zhiyucepingdefen}</td>    <td>${u.nenglijiafenxiangdefen}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

