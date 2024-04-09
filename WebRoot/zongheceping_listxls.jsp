<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="zonghecepinghsgb" scope="page" class="com.bean.ZonghecepingBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=zongheceping.xls");
%>
<html>
  <head>
    <title>综合测评</title>
  </head>

  <body >
 <%
			String sql="select * from zongheceping  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>学号</td>    <td align='center' bgcolor='#ebf0f7'>姓名</td>    <td align='center' bgcolor='#ebf0f7'>班级</td>    <td align='center' bgcolor='#ebf0f7'>计算出学生操行测评分</td>    <td align='center' bgcolor='#ebf0f7'>智育测评得分</td>    <td align='center' bgcolor='#ebf0f7'>能力加分项得分</td>    <td align='center' bgcolor='#ebf0f7'>综合得分</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=zonghecepinghsgb.getAllZongheceping(9);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.xuehao}</td>    <td>${u.xingming}</td>    <td>${u.banji}</td>    <td>${u.jisuanchuxueshengcaoxingcepingfen}</td>    <td>${u.zhiyucepingdefen}</td>    <td>${u.nenglijiafenxiangdefen}</td>    <td>${u.zonghedefen}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

