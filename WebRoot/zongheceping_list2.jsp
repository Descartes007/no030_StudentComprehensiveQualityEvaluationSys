<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>综合测评查询</TITLE>
	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">
	</head>
	   <script language="javascript">
		   function zhifu(id,biao)
           {
                   window.location.href="zhifu/index.jsp?id="+id+"&biao="+biao;
           }
       </script>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">综合测评列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="zonghecepingList2.do" name="myform" method="post">
									查询   学号：<input name="xuehao" type="text" id="xuehao" class="form-control2" />  姓名：<input name="xingming" type="text" id="xingming" class="form-control2" />  班级：<input name="banji" type="text" id="banji" class="form-control2" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td width="30px" height="30" align="center" bgcolor="#ebf0f7">序号</td>
                            <td align='center' bgcolor='#ebf0f7'>学号</td>    <td align='center' bgcolor='#ebf0f7'>姓名</td>    <td align='center' bgcolor='#ebf0f7'>班级</td>    <td align='center' bgcolor='#ebf0f7'>计算出学生操行测评分</td>    <td align='center' bgcolor='#ebf0f7'>智育测评得分</td>    <td align='center' bgcolor='#ebf0f7'>能力加分项得分</td>    <td align='center' bgcolor='#ebf0f7'>综合得分</td>    
                            <td width="150px" height="30" align="center" bgcolor="#ebf0f7"> 添加时间 </td>
                            <td width="150px" height="30" align="center" bgcolor="#ebf0f7"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td height="45" align="center"><%=i%></td>
                             <td>${u.xuehao}</td>    <td>${u.xingming}</td>    <td>${u.banji}</td>    <td>${u.jisuanchuxueshengcaoxingcepingfen}</td>    <td>${u.zhiyucepingdefen}</td>    <td>${u.nenglijiafenxiangdefen}</td>    <td>${u.zonghedefen}</td>    
                              <td height="45" align="center"> ${u.addtime } </td>
                              <td height="45" align="center"><a class="btn btn-info btn-small" href="doUpdateZongheceping.do?id=${u.id }">编辑</a>  <a class="btn btn-info btn-small" href="deleteZongheceping.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a class="btn btn-info btn-small" href="zonghecepingDetail.do?id=${u.id }">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		 <%
			String sql="select * from zongheceping where xuehao='"+(String)request.getSession().getAttribute("username")+"'  ";
				if(request.getParameter("xuehao")=="" ||request.getParameter("xuehao")==null ){}else{String nxuehao=new String(request.getParameter("xuehao").getBytes("8859_1"));if(nxuehao.contains("?")){nxuehao=request.getParameter("xuehao");}sql=sql+" and xuehao like '%"+nxuehao+"%'";}if(request.getParameter("xingming")=="" ||request.getParameter("xingming")==null ){}else{String nxingming=new String(request.getParameter("xingming").getBytes("8859_1"));if(nxingming.contains("?")){nxingming=request.getParameter("xingming");}sql=sql+" and xingming like '%"+nxingming+"%'";}if(request.getParameter("banji")=="" ||request.getParameter("banji")==null ){}else{String nbanji=new String(request.getParameter("banji").getBytes("8859_1"));if(nbanji.contains("?")){nbanji=request.getParameter("banji");}sql=sql+" and banji like '%"+nbanji+"%'";}
			sql+=" order by id desc";
double zonghedefenz=0;
							double zgfzonghedefen=0;double zdfzonghedefen=10000;
							
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						zonghedefenz=zonghedefenz+Float.valueOf(RS_result.getString("zonghedefen")).floatValue();
						
						if(Float.valueOf(RS_result.getString("zonghedefen")).floatValue()>zgfzonghedefen){zgfzonghedefen=Float.valueOf(RS_result.getString("zonghedefen")).floatValue();}						if(Float.valueOf(RS_result.getString("zonghedefen")).floatValue()<zdfzonghedefen){zdfzonghedefen=Float.valueOf(RS_result.getString("zonghedefen")).floatValue();}						
			 }
			%>
		共计综合得分:<%=zonghedefenz%>； 其中最高综合得分：<%=zgfzonghedefen%>；最低综合得分：<%=zdfzonghedefen%>；平均综合得分：<%out.print(Math.round(1000*(zonghedefenz/i))/1000.0);%>；
		
			<p align="center" class="fy"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="zonghecepingList2.do?page=1" >首页</a>
             <a href="zonghecepingList2.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="zonghecepingList2.do?page=${page.page+1 }">下一页</a>
			<a href="zonghecepingList2.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
