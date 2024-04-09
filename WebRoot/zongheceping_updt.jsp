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
		<TITLE>修改综合测评</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="zongheceping_add.jsp?id=<%=id%>";
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
			<form action="updateZongheceping.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改综合测评<input type="hidden" name="id" value="${zongheceping.id}" /></td>
						</tr>
						<tr ><td width="200">学号：</td><td><select name='xuehao' id='xuehao' class="form-control" onChange='gows();'><%=connDbBean.hsggetoption2("xueshengxinxi","xuehao")%></select>&nbsp;*<label id='clabelxuehao' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming'  class="form-control" >&nbsp;*<label id='clabelxingming' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">班级：</td><td><input name='banji' type='text' id='banji'  class="form-control" ></td></tr>		<tr ><td width="200">计算出学生操行测评分：</td><td><input name='jisuanchuxueshengcaoxingcepingfen' type='text' id='jisuanchuxueshengcaoxingcepingfen'  class="form-control" ></td></tr>		<tr ><td width="200">智育测评得分：</td><td><input name='zhiyucepingdefen' type='text' id='zhiyucepingdefen'  class="form-control" ></td></tr>		<tr ><td width="200">能力加分项得分：</td><td><input name='nenglijiafenxiangdefen' type='text' id='nenglijiafenxiangdefen'  class="form-control" ></td></tr>		<tr ><td width="200">综合得分：</td><td><input name='zonghedefen' type='text' id='zonghedefen' value='' onblur='' class="form-control" readonly='readonly' /> 此项不必填写，系统自动计算</td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.xuehao.value='${zongheceping.xuehao}';</script>	<script language="javascript">document.form1.xingming.value='${zongheceping.xingming}';</script>	<script language="javascript">document.form1.banji.value='${zongheceping.banji}';</script>	<script language="javascript">document.form1.jisuanchuxueshengcaoxingcepingfen.value='${zongheceping.jisuanchuxueshengcaoxingcepingfen}';</script>	<script language="javascript">document.form1.zhiyucepingdefen.value='${zongheceping.zhiyucepingdefen}';</script>	<script language="javascript">document.form1.nenglijiafenxiangdefen.value='${zongheceping.nenglijiafenxiangdefen}';</script>	<script language="javascript">document.form1.zonghedefen.value='${zongheceping.zonghedefen}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var xuehaoobj = document.getElementById("xuehao"); if(xuehaoobj.value==""){document.getElementById("clabelxuehao").innerHTML="&nbsp;&nbsp;<font color=red>请输入学号</font>";return false;}else{document.getElementById("clabelxuehao").innerHTML="  "; } 	var xingmingobj = document.getElementById("xingming"); if(xingmingobj.value==""){document.getElementById("clabelxingming").innerHTML="&nbsp;&nbsp;<font color=red>请输入姓名</font>";return false;}else{document.getElementById("clabelxingming").innerHTML="  "; } 	var zonghedefenh=0;if(document.getElementById("jisuanchuxueshengcaoxingcepingfen").value!=""){zonghedefenh=zonghedefenh+parseFloat(document.getElementById("jisuanchuxueshengcaoxingcepingfen").value);}if(document.getElementById("zhiyucepingdefen").value!=""){zonghedefenh=zonghedefenh+parseFloat(document.getElementById("zhiyucepingdefen").value);}if(document.getElementById("nenglijiafenxiangdefen").value!=""){zonghedefenh=zonghedefenh+parseFloat(document.getElementById("nenglijiafenxiangdefen").value);}document.getElementById("zonghedefen").value=zonghedefenh;;	


return true;   
}   
popheight=450;
</script>  
