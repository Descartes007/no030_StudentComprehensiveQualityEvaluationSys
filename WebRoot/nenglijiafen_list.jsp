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
	<TITLE>能力加分查询</TITLE>
	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td height="30" colspan="17" background="images/table_header.gif">能力加分列表</td>
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
								<form action="nenglijiafenList.do" name="myform" method="post">
									查询   学号：<input name="xuehao" type="text" id="xuehao" class="form-control2" />  姓名：<input name="xingming" type="text" id="xingming" class="form-control2" />  班级：<input name="banji" type="text" id="banji" class="form-control2" />
									<input type="submit" value="查询" class="btn btn-info btn-small" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px" height="30">序号</td>
                            <td align='center' bgcolor='#ebf0f7'>学号</td>    <td align='center' bgcolor='#ebf0f7'>姓名</td>    <td align='center' bgcolor='#ebf0f7'>班级</td>    <td align='center' bgcolor='#ebf0f7'>是否过英语四级</td>    <td align='center' bgcolor='#ebf0f7'>是否过英语六级</td>    <td align='center' bgcolor='#ebf0f7'>是否取得教师资格证</td>    <td align='center' bgcolor='#ebf0f7'>是否为应征入伍返校学习者</td>    <td align='center' bgcolor='#ebf0f7'>服役期间是否立功</td>    <td align='center' bgcolor='#ebf0f7'>其它</td>    <td align='center' bgcolor='#ebf0f7'>加分数</td>    
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.xuehao}</td>    <td>${u.xingming}</td>    <td>${u.banji}</td>    <td>${u.shifouguoyingyusiji}</td>    <td>${u.shifouguoyingyuliuji}</td>    <td>${u.shifouqudejiaoshizigezheng}</td>    <td>${u.shifouweiyingzhengruwufanxiaoxuexizhe}</td>    <td>${u.fuyiqijianshifouligong}</td>    <td>${u.qita}</td>    <td>${u.jiafenshu}</td>    
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a class="btn btn-info btn-small" href="doUpdateNenglijiafen.do?id=${u.id }">编辑</a>  <a class="btn btn-info btn-small" href="deleteNenglijiafen.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a class="btn btn-info btn-small" href="nenglijiafenDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		 <%
			String sql="select * from nenglijiafen where 1=1 ";
				if(request.getParameter("xuehao")=="" ||request.getParameter("xuehao")==null ){}else{String nxuehao=new String(request.getParameter("xuehao").getBytes("8859_1"));if(nxuehao.contains("?")){nxuehao=request.getParameter("xuehao");}sql=sql+" and xuehao like '%"+nxuehao+"%'";}if(request.getParameter("xingming")=="" ||request.getParameter("xingming")==null ){}else{String nxingming=new String(request.getParameter("xingming").getBytes("8859_1"));if(nxingming.contains("?")){nxingming=request.getParameter("xingming");}sql=sql+" and xingming like '%"+nxingming+"%'";}if(request.getParameter("banji")=="" ||request.getParameter("banji")==null ){}else{String nbanji=new String(request.getParameter("banji").getBytes("8859_1"));if(nbanji.contains("?")){nbanji=request.getParameter("banji");}sql=sql+" and banji like '%"+nbanji+"%'";}
			sql+=" order by id desc";
double jiafenshuz=0;
							double zgfjiafenshu=0;double zdfjiafenshu=10000;
							
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						jiafenshuz=jiafenshuz+Float.valueOf(RS_result.getString("jiafenshu")).floatValue();
						
						if(Float.valueOf(RS_result.getString("jiafenshu")).floatValue()>zgfjiafenshu){zgfjiafenshu=Float.valueOf(RS_result.getString("jiafenshu")).floatValue();}						if(Float.valueOf(RS_result.getString("jiafenshu")).floatValue()<zdfjiafenshu){zdfjiafenshu=Float.valueOf(RS_result.getString("jiafenshu")).floatValue();}						
			 }
			%>
		共计加分数:<%=jiafenshuz%>； 其中最高加分数：<%=zgfjiafenshu%>；最低加分数：<%=zdfjiafenshu%>；平均加分数：<%out.print(Math.round(1000*(jiafenshuz/i))/1000.0);%>；
		
			<p align="center" class="fy"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="nenglijiafenList.do?page=1" >首页</a>
             <a href="nenglijiafenList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="nenglijiafenList.do?page=${page.page+1 }">下一页</a>
			<a href="nenglijiafenList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
