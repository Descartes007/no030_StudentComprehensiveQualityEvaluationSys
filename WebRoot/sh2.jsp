<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<html>
  <head>
    
    <title>审核</title><link rel="stylesheet" href="css.css" type="text/css">
    

  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<%
if(request.getParameter("ac")!=null){
String sql;
sql="update "+request.getParameter("tablename")+" set issh='"+request.getParameter("issh")+"',shhf='"+request.getParameter("shhf")+"' where id="+request.getParameter("id");
connDbBean.hsgexecute(sql);
out.print("<script>javascript:alert('审核成功！');location.href='"+request.getParameter("tablename")+"List.do';</script>");
}

%>


  <body >
    <form action="sh2.jsp?ac=1" name="form1" method="post">
    <table width="32%" height="193" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="9DC9FF" style="border-collapse:collapse">
    <tr>
      <td colspan="2"><div align="center">在线审核</div></td>
    </tr>
    <tr>
      <td height="58">审核结果：</td>
      <td><select name="issh" id="issh">
        <option value="待审核">待审核</option>
        <option value="已通过">已通过</option>
        <option value="未通过">未通过</option>
      </select>
      <input name="id" type="hidden" id="id" value="<%=request.getParameter("id")%>"><input name="tablename" type="hidden" id="tablename" value="<%=request.getParameter("tablename")%>"></td>
    </tr>
    <tr>
      <td>审核回复：</td>
      <td height="80"><textarea name="shhf" cols="50" rows="5" id="shhf"><%=connDbBean.readzd(request.getParameter("tablename"),"shhf","id",request.getParameter("id"))%></textarea></td>
    </tr>
	<script language="javascript">
	document.form1.issh.value="<%=connDbBean.readzd(request.getParameter("tablename"),"issh","id",request.getParameter("id"))%>";
	</script>
    
    <tr>
      <td colspan="2" align="center"><input name="Submit" type="submit"  value="确定" />
        <input name="Submit2" type="reset" value="重置" /></td>
      </tr>
  </table>
  </form>
  </body>
</html>


