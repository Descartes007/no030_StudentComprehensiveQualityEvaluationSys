<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="jiangchengxinxihsgb" scope="page" class="com.bean.JiangchengxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=jiangchengxinxi.xls");
%>
<html>
  <head>
    <title>奖惩信息</title>
  </head>

  <body >
 <%
			String sql="select * from jiangchengxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>奖惩编号</td>    <td align='center' bgcolor='#ebf0f7'>奖惩标题</td>        <td align='center' bgcolor='#ebf0f7'>奖惩分数</td>    <td  width='65' align='center' bgcolor='#ebf0f7'>时间</td>    <td align='center' bgcolor='#ebf0f7'>录入人</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=jiangchengxinxihsgb.getAllJiangchengxinxi(8);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.jiangchengbianhao}</td>    <td>${u.jiangchengbiaoti}</td>        <td>${u.jiangchengfenshu}</td>    <td>${u.shijian}</td>    <td>${u.lururen}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

