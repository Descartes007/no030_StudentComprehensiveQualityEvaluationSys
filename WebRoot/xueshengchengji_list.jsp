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
	<TITLE>学生成绩查询</TITLE>
	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td height="30" colspan="17" background="images/table_header.gif">学生成绩列表</td>
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
								<form action="xueshengchengjiList.do" name="myform" method="post">
									查询   学号：<input name="xuehao" type="text" id="xuehao" class="form-control2" />  姓名：<input name="xingming" type="text" id="xingming" class="form-control2" />  性别：<input name="xingbie" type="text" id="xingbie" class="form-control2" />  学年：<select name='xuenian' id='xuenian' class="form-control2"><option value="">所有</option><%int nnf=0;for(nnf=2016;nnf>=2010;nnf--){%><option value='<%=nnf%>'><%=nnf%></option><%}%></select> 学期：<select name='xueqi' id='xueqi' class="form-control2"><option value="">所有</option><option value="第一学期">第一学期</option><option value="第二学期">第二学期</option></select>  科目：<input name="kemu" type="text" id="kemu" class="form-control2" />
									<input type="submit" value="查询" class="btn btn-info btn-small" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px" height="30">序号</td>
                            <td align='center' bgcolor='#ebf0f7'>学号</td>    <td align='center' bgcolor='#ebf0f7'>姓名</td>    <td  width='40' align='center' bgcolor='#ebf0f7'>性别</td>    <td align='center' bgcolor='#ebf0f7'>班级</td>    <td align='center' bgcolor='#ebf0f7'>学年</td>    <td align='center' bgcolor='#ebf0f7'>学期</td>    <td align='center' bgcolor='#ebf0f7'>科目</td>    <td align='center' bgcolor='#ebf0f7'>分数</td>    
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
                             <td>${u.xuehao}</td>    <td>${u.xingming}</td>    <td align='center' bgcolor='#ebf0f7'>${u.xingbie}</td>    <td>${u.banji}</td>    <td>${u.xuenian}</td>    <td>${u.xueqi}</td>    <td>${u.kemu}</td>    <td>${u.fenshu}</td>    
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a class="btn btn-info btn-small" href="doUpdateXueshengchengji.do?id=${u.id }">编辑</a>  <a class="btn btn-info btn-small" href="deleteXueshengchengji.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a class="btn btn-info btn-small" href="xueshengchengjiDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		 <%
			String sql="select * from xueshengchengji where 1=1 ";
				if(request.getParameter("xuehao")=="" ||request.getParameter("xuehao")==null ){}else{String nxuehao=new String(request.getParameter("xuehao").getBytes("8859_1"));if(nxuehao.contains("?")){nxuehao=request.getParameter("xuehao");}sql=sql+" and xuehao like '%"+nxuehao+"%'";}if(request.getParameter("xingming")=="" ||request.getParameter("xingming")==null ){}else{String nxingming=new String(request.getParameter("xingming").getBytes("8859_1"));if(nxingming.contains("?")){nxingming=request.getParameter("xingming");}sql=sql+" and xingming like '%"+nxingming+"%'";}if(request.getParameter("xingbie")=="" ||request.getParameter("xingbie")==null ){}else{String nxingbie=new String(request.getParameter("xingbie").getBytes("8859_1"));if(nxingbie.contains("?")){nxingbie=request.getParameter("xingbie");}sql=sql+" and xingbie like '%"+nxingbie+"%'";}if(request.getParameter("xuenian")=="" ||request.getParameter("xuenian")==null ){}else{sql=sql+" and xuenian like '%"+request.getParameter("xuenian")+"%'";}if(request.getParameter("xueqi")=="" ||request.getParameter("xueqi")==null ){}else{sql=sql+" and xueqi like '%"+request.getParameter("xueqi")+"%'";}if(request.getParameter("kemu")=="" ||request.getParameter("kemu")==null ){}else{String nkemu=new String(request.getParameter("kemu").getBytes("8859_1"));if(nkemu.contains("?")){nkemu=request.getParameter("kemu");}sql=sql+" and kemu like '%"+nkemu+"%'";}
			sql+=" order by id desc";
double fenshuz=0;
							double zgffenshu=0;double zdffenshu=10000;
							
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						fenshuz=fenshuz+Float.valueOf(RS_result.getString("fenshu")).floatValue();
						
						if(Float.valueOf(RS_result.getString("fenshu")).floatValue()>zgffenshu){zgffenshu=Float.valueOf(RS_result.getString("fenshu")).floatValue();}						if(Float.valueOf(RS_result.getString("fenshu")).floatValue()<zdffenshu){zdffenshu=Float.valueOf(RS_result.getString("fenshu")).floatValue();}						
			 }
			%>
		共计分数:<%=fenshuz%>； 其中最高分数：<%=zgffenshu%>；最低分数：<%=zdffenshu%>；平均分数：<%out.print(Math.round(1000*(fenshuz/i))/1000.0);%>；
		
			<p align="center" class="fy"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="xueshengchengjiList.do?page=1" >首页</a>
             <a href="xueshengchengjiList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="xueshengchengjiList.do?page=${page.page+1 }">下一页</a>
			<a href="xueshengchengjiList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
