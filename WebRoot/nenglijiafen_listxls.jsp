<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="nenglijiafenhsgb" scope="page" class="com.bean.NenglijiafenBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=nenglijiafen.xls");
%>
<html>
  <head>
    <title>能力加分</title>
  </head>

  <body >
 <%
			String sql="select * from nenglijiafen  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>学号</td>    <td align='center' bgcolor='#ebf0f7'>姓名</td>    <td align='center' bgcolor='#ebf0f7'>班级</td>    <td align='center' bgcolor='#ebf0f7'>是否过英语四级</td>    <td align='center' bgcolor='#ebf0f7'>是否过英语六级</td>    <td align='center' bgcolor='#ebf0f7'>是否取得教师资格证</td>    <td align='center' bgcolor='#ebf0f7'>是否为应征入伍返校学习者</td>    <td align='center' bgcolor='#ebf0f7'>服役期间是否立功</td>    <td align='center' bgcolor='#ebf0f7'>其它</td>    <td align='center' bgcolor='#ebf0f7'>加分数</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=nenglijiafenhsgb.getAllNenglijiafen(12);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.xuehao}</td>    <td>${u.xingming}</td>    <td>${u.banji}</td>    <td>${u.shifouguoyingyusiji}</td>    <td>${u.shifouguoyingyuliuji}</td>    <td>${u.shifouqudejiaoshizigezheng}</td>    <td>${u.shifouweiyingzhengruwufanxiaoxuexizhe}</td>    <td>${u.fuyiqijianshifouligong}</td>    <td>${u.qita}</td>    <td>${u.jiafenshu}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

