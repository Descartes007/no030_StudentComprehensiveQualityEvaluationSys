<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
    
    <title>跳转去向</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
 <BODY leftMargin=5 topMargin=5 rightMargin=5>
 <P align=center>&nbsp;</P>
 <P align=center>&nbsp;</P>
 <P align=center>&nbsp;</P>
 <P align=center>
 <script language="javascript">
 alert('<%=request.getSession().getAttribute("backxx")%>');
 location.href='<%=request.getSession().getAttribute("backurl")%>';
 </script>
 
 </P>
 </BODY>
</html>

