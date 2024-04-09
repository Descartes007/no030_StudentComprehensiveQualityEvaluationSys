<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>用户注册查询</TITLE>
	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>

	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td height="30" colspan="17" background="images/table_header.gif">用户注册列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="yonghuzhuceList.do" name="myform" method="post">
									查询   用户名：<input name="yonghuming" type="text" id="yonghuming" class="form-control2" />  姓名：<input name="xingming" type="text" id="xingming" class="form-control2" /> 性别：<select name='xingbie' id='xingbie' class="form-control2"><option value="">所有</option><option value="男">男</option><option value="女">女</option></select>  出生年月：<input name="chushengnianyue1" type="text" id="chushengnianyue1"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" class="form-control2" />-<input name="chushengnianyue2" type="text" id="chushengnianyue2"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" class="form-control2" />  QQ：<input name="QQ" type="text" id="QQ" class="form-control2"/>  手机：<input name="shouji" type="text" id="shouji" class="form-control2" />  身份证：<input name="shenfenzheng" type="text" id="shenfenzheng" class="form-control2" />
									<input type="submit" value="查询" class="btn btn-info btn-small" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td width="30px" height="30" align="center" bgcolor="#ebf0f7">序号</td>
                            <td height="30" align='center' bgcolor="#ebf0f7">用户名</td>
    <td height="30" align='center' bgcolor="#ebf0f7">密码</td>
    <td height="30" align='center' bgcolor="#ebf0f7">姓名</td>
    <td  width='40' height="30" align='center' bgcolor="#ebf0f7">性别</td>
    <td  width='80' height="30" align='center' bgcolor="#ebf0f7">出生年月</td>
    <td height="30" align='center' bgcolor="#ebf0f7">QQ</td>
    <td height="30" align='center' bgcolor="#ebf0f7">邮箱</td>
    <td height="30" align='center' bgcolor="#ebf0f7">手机</td>
    <td height="30" align='center' bgcolor="#ebf0f7">身份证</td>
    <td  width='90' height="30" align='center' bgcolor="#ebf0f7">头像</td>
    <td height="30" align='center' bgcolor="#ebf0f7">地址</td>
    
    <td  width='80' height="30" align='center' bgcolor="#ebf0f7">是否审核</td>
                            <td width="150px" height="30" align="center" bgcolor="#ebf0f7"> 添加时间 </td>
                            <td width="200" height="30" align="center" bgcolor="#ebf0f7"> 操作 </td>
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
                             <td>${u.yonghuming}</td>
    <td>${u.mima}</td>
    <td>${u.xingming}</td>
    <td align='center'>${u.xingbie}</td>
    <td>${fn:substring(u.chushengnianyue, 0, 10)}</td>
    <td>${u.QQ}</td>
    <td>${u.youxiang}</td>
    <td>${u.shouji}</td>
    <td>${u.shenfenzheng}</td>
    <td width='90' align='center'><a href='${u.touxiang}' target='_blank'><img src='${u.touxiang}' width=88 height=99 border=0 /></a></td>
    <td>${u.dizhi}</td>
    
    <td align='center'> <input  class="btn btn-info btn-small" type="button" value="${u.issh}" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=yonghuzhuce'"/></td>
                              <td align="center"> ${u.addtime } </td>
                              <td width="200" align="center"><a class="btn btn-info btn-small" href="doUpdateYonghuzhuce.do?id=${u.id }">编辑</a>  <a class="btn btn-info btn-small" href="deleteYonghuzhuce.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a class="btn btn-info btn-small" href="yonghuzhuceDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="yonghuzhuceList.do?page=1" >首页</a>
             <a href="yonghuzhuceList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="yonghuzhuceList.do?page=${page.page+1 }">下一页</a>
			<a href="yonghuzhuceList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
