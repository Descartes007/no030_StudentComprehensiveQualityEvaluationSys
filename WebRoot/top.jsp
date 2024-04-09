<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<%
if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")=="")
{
	out.print("<script>javascript:alert('sorry,please relogin！');window.parent.location.href='login.jsp';</script>");
	out.close();
}
%>
<body bgcolor="339999" >
<table width="100%"  border="0" cellspacing="0" cellpadding="0" height="94" background="images/1.gif">
  <tr>
    <td valign="top" ><table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="301"><table width="100%" align="center" height="34" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><div style="font-family:宋体; color:#FFFFFF;  WIDTH: 100%; FONT-WEIGHT: bold; FONT-SIZE: 19pt; margin-top:5pt">
                <div align="center">综合素质测评</div>
            </div></td>
          </tr>
        </table></td>
       
        <td width="1098"  align="right"><table width="100%" height="85" border="0">
          
          <tr>
            <td align="right"><font color="#FFFFFF" style="font-size:12px">当前用户：${sessionScope.username}&nbsp;&nbsp;权限：${sessionScope.cx}&nbsp;&nbsp;&nbsp;&nbsp;</font><a href="logout.jsp" target="_parent"><font color="#FFFFFF">退出</font></a></td>
          </tr>
        </table></td>
      </tr>
    </table> </td>
  </tr>
</table>

</body>
</html>
