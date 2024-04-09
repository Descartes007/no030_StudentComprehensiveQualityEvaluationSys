<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<%@ page isELIgnored="false" %> 


<%
String yuan=request.getParameter("yuan");
String id=request.getParameter("id");
String tablename=request.getParameter("tablename");
String sql="";
if(yuan.equals("是"))
{
	sql="update "+request.getParameter("tablename")+" set issh='否' where id="+request.getParameter("id");
}
else
{
	sql="update "+request.getParameter("tablename")+" set issh='是' where id="+request.getParameter("id");
}


connDbBean.hsgexecute(sql);
out.print("<script>javascript:alert('审核成功！');location.href='"+request.getParameter("tablename")+"List.do';</script>");


%>



