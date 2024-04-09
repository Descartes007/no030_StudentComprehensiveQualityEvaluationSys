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
		<TITLE>添加学生成绩</TITLE>
	    
 	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">    
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="xueshengchengji_add.jsp?id=<%=id%>&xuehao="+document.form1.xuehao.value;
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="addXueshengchengji.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">添加学生成绩</td>
						</tr>
						<tr ><td width="200">学号：</td><td><select name='xuehao' id='xuehao' class="form-control" onChange='gows();'><%=connDbBean.hsggetoption2("xueshengxinxi","xuehao")%></select>&nbsp;*<label id='clabelxuehao' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming'  class="form-control" >&nbsp;*<label id='clabelxingming' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">性别：</td><td><input name='xingbie' type='text' id='xingbie'  class="form-control" ></td></tr>		<tr ><td width="200">班级：</td><td><input name='banji' type='text' id='banji'  class="form-control" ></td></tr>		<tr ><td width="200">学年：</td><td><select name='xuenian' id='xuenian' class="form-control"><%int nnf=0;for(nnf=2019;nnf>=2010;nnf--){%><option value='<%=nnf%>'><%=nnf%></option><%}%></select></td></tr>		<tr ><td width="200">学期：</td><td><select name='xueqi' id='xueqi' class="form-control"><option value="第一学期">第一学期</option><option value="第二学期">第二学期</option></select></td></tr>		<tr ><td width="200">科目：</td><td><input name='kemu' type='text' id='kemu' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelkemu' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">分数：</td><td><input name='fenshu' type='text' id='fenshu' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelfenshu' style='margin-top:16px;' /></td></tr>		
		
						<tr align='center'   height="22">
						    <td height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small"/>
						       <input type="reset" value="重置" name="Submit2" class="btn btn-info btn-small"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>

<%
if(request.getParameter("xuehao")==null || request.getParameter("xuehao").equals("")){}else{
%>
<script language="javascript">
document.form1.xuehao.value="<%=connDbBean.readzd("xueshengxinxi","xuehao","xuehao",request.getParameter("xuehao"))%>";document.form1.xingming.value="<%=connDbBean.readzd("xueshengxinxi","xingming","xuehao",request.getParameter("xuehao"))%>";document.form1.xingbie.value="<%=connDbBean.readzd("xueshengxinxi","xingbie","xuehao",request.getParameter("xuehao"))%>";document.form1.banji.value="<%=connDbBean.readzd("xueshengxinxi","banji","xuehao",request.getParameter("xuehao"))%>";

</script>
<%
}
%>




<script language=javascript >  
 
 function checkform(){  
 
	var xuehaoobj = document.getElementById("xuehao"); if(xuehaoobj.value==""){document.getElementById("clabelxuehao").innerHTML="&nbsp;&nbsp;<font color=red>请输入学号</font>";return false;}else{document.getElementById("clabelxuehao").innerHTML="  "; } 	var xingmingobj = document.getElementById("xingming"); if(xingmingobj.value==""){document.getElementById("clabelxingming").innerHTML="&nbsp;&nbsp;<font color=red>请输入姓名</font>";return false;}else{document.getElementById("clabelxingming").innerHTML="  "; } 	var kemuobj = document.getElementById("kemu"); if(kemuobj.value==""){document.getElementById("clabelkemu").innerHTML="&nbsp;&nbsp;<font color=red>请输入科目</font>";return false;}else{document.getElementById("clabelkemu").innerHTML="  "; } 	var fenshuobj = document.getElementById("fenshu"); if(fenshuobj.value==""){document.getElementById("clabelfenshu").innerHTML="&nbsp;&nbsp;<font color=red>请输入分数</font>";return false;}else{document.getElementById("clabelfenshu").innerHTML="  "; } 	var fenshuobj = document.getElementById("fenshu"); if(fenshuobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(fenshuobj.value)){document.getElementById("clabelfenshu").innerHTML=""; }else{document.getElementById("clabelfenshu").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}      


return true;   
}   
popheight=450;
</script>  
<script src="images/hsgcommon/jq.js"></script>
<script src="images/hsgcommon/common.js"></script>
<script src="images/hsgcommon/bootbox.js"></script>