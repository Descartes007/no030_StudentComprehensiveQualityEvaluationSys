<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>修改管理员账户</TITLE>
	    <link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">

       
	</head>
<%
  String id="";
//islbd1q 
   %>
<script language="javascript">

function gows()
{
	document.location.href="allusers_add.jsp?id=<%=id%>";
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
			<form action="updateAllusers.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改管理员账号
						  <input type="hidden" name="id" value="${allusers.id}" /></td>
						</tr>
						<tr >
						  <td width="200">用户名：</td>
						  <td><input name='username' type='text' id='username' value='' onblur='hsgcheck()' class="form-control" />&nbsp;*<label id='clabelusername' style="margin-top:16px;" /></td></tr>
		<tr >
		  <td width="200">密码：</td>
		  <td><input name='pwd' type='text' id='pwd' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelpwd' style="margin-top:16px;" /></td></tr>
		<tr >
		  <td width="200">权限：</td>
		  <td><select name="cx" id="cx" class="form-control">
            <option value="普通管理员">普通管理员</option>
            <option value="超级管理员">超级管理员</option>
          </select></td>
		</tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small"/>
						       <input type="reset" value="重置" class="btn btn-info btn-small"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.username.value='${allusers.username}';</script>
	<script language="javascript">document.form1.pwd.value='${allusers.pwd}';</script>
	<script language="javascript">document.form1.cx.value='${allusers.cx}';</script>
	
					 </table>
			</form>
   </body>
</html>



<!--hssgchesck-->


<script language=javascript >  
 
 function checkform(){  
 
	var usernameobj = document.getElementById("username"); if(usernameobj.value==""){document.getElementById("clabelusername").innerHTML="&nbsp;&nbsp;<font color=red>请输入username</font>";return false;}else{document.getElementById("clabelusername").innerHTML="  "; } 
	var pwdobj = document.getElementById("pwd"); if(pwdobj.value==""){document.getElementById("clabelpwd").innerHTML="&nbsp;&nbsp;<font color=red>请输入pwd</font>";return false;}else{document.getElementById("clabelpwd").innerHTML="  "; } 
	


return true;   
}   
popheight=450;
</script>  
