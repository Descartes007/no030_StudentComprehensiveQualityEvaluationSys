<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<%@ page isELIgnored="false" %> 

<html>
  <head>
    
    <title>修改密码</title>
	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">
    

  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>

<script>
function check()
{
	if(document.form1.ymm.value=="")
	{
		bootbox.alert("请输入原密码");
		document.form1.ymm.focus();
		return false;
	}
	if(document.form1.xmm1.value=="")
	{
		bootbox.alert("请输入新密码");
		document.form1.xmm1.focus();
		return false;
	}
	if(document.form1.xmm2.value=="")
	{
		bootbox.alert("请输入确认密码");
		document.form1.xmm2.focus();
		return false;
	}
	if (document.form1.xmm1.value!=document.form1.xmm2.value)
	{
		bootbox.alert("对不起，两次密码不一至，请重新输入");
		document.form1.xmm1.value="";
		document.form1.xmm2.value="";
		document.form1.xmm1.focus();
		return false;
	}
}

</script>
<%
if(request.getParameter("updt")!=null)
{
String sql="";
sql="select id from allusers where username='"+request.getSession().getAttribute("username")+"' and pwd='"+request.getParameter("ymm")+"'";
 ResultSet RS_result=connDbBean.executeQuery(sql);
 if(RS_result.next())
 {
 	sql="update allusers set pwd='"+request.getParameter("xmm1")+"' where username='"+request.getSession().getAttribute("username")+"' ";
	connDbBean.hsgexecute(sql);
	out.print("<script>javascript:alert('操作成功！');location.href='sy.jsp';</script>");
 }
 else
 {
	out.print("<script>javascript:alert('原密码不正确！');location.href='sy.jsp';</script>");
 }
}
%>
  <body >
    <form action="" name="form1" method="post">
    <table width="32%" height="126" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="9DC9FF" style="border-collapse:collapse">
    <tr>
      <td colspan="2"><div align="center">修改密码</div></td>
    </tr>
    <tr>
      <td>原密码：</td>
      <td><input name="ymm" type="text" id="ymm" class="form-control"/></td>
    </tr>
    <tr>
      <td>新密码：</td>
      <td><input name="xmm1" type="password" id="xmm1" class="form-control"/></td>
    </tr>
    <tr>
      <td>确认密码：</td>
      <td><input name="xmm2" type="password" id="xmm2" class="form-control"/></td>
    </tr>
    <tr>
      <td height="45" colspan="2" align="center"><input name="updt" type="hidden" id="updt" value="1">
      <input name="Submit" type="submit"  onClick="return check()" value="确定" class="btn btn-info btn-small" />
      <input name="Submit2" type="reset" value="重置" class="btn btn-info btn-small" /></td>
      </tr>
  </table>
  </form>
  </body>
</html>

<script src="images/hsgcommon/jq.js"></script>
<script src="images/hsgcommon/common.js"></script>
<script src="images/hsgcommon/bootbox.js"></script>
