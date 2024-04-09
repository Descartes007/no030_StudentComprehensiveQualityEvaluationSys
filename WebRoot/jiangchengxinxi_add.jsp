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
		<TITLE>添加奖惩信息</TITLE>
	    
 	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">    
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="jiangchengxinxi_add.jsp?id=<%=id%>";
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
			<form action="addJiangchengxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">添加奖惩信息</td>
						</tr>
						<tr ><td width="200">奖惩编号：</td><td><input name='jiangchengbianhao' type='text' id='jiangchengbianhao' value='' onblur='hsgcheck()' class="form-control" />&nbsp;*<label id='clabeljiangchengbianhao' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">奖惩标题：</td><td><input name='jiangchengbiaoti' type='text' id='jiangchengbiaoti' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabeljiangchengbiaoti' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">奖惩内容：</td><td><textarea name='jiangchengneirong' cols='50' rows='5' id='jiangchengneirong' onblur='checkform()' class="form-control" style="width:600px; height:80px;" ></textarea>&nbsp;*<label id='clabeljiangchengneirong' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">奖惩分数：</td><td><input name='jiangchengfenshu' type='text' id='jiangchengfenshu' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabeljiangchengfenshu' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">时间：</td><td><input name='shijian' type='text' id='shijian' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})"  class="form-control" />&nbsp;*<label id='clabelshijian' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">录入人：</td><td><input name='lururen' type='text' id='lururen' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		
		
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




<script language=javascript >  
function hsgcheck() {
		var jiangchengbianhao = $("#jiangchengbianhao").val();
		if(jiangchengbianhao==""||(jiangchengbianhao.length<3||jiangchengbianhao.length>12)){
			 $("#clabeljiangchengbianhao").html("<font color=red>奖惩编号不能为空且长度在3～12位之间！</font>");
			 $("input[id=jiangchengbianhao]").focus();
			 $("#querenzhuce").attr("disabled","disabled");
			 return false;
		} 
		else
		{
			$("#clabeljiangchengbianhao").html("");
			$.ajax({
				url : "quchongJiangchengxinxi.do",
				type : "post",
				data : "jiangchengbianhao=" + jiangchengbianhao,
				dataType : "json",
				success:function(result){
				if(result.info=="ng"){
					$("#clabeljiangchengbianhao").html("<font color=red>奖惩编号已存在，请更换！</font>");
					$("input[id=jiangchengbianhao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
				else
				{
					$("#querenzhuce").removeAttr("disabled");
				}
				},
				error:function(){
					$("#clabeljiangchengbianhao").html("系统异常，请检查错误！");
					$("input[id=jiangchengbianhao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
			});
		}
	}
</script>


<script language=javascript >  
 
 function checkform(){  
 
	var jiangchengbianhaoobj = document.getElementById("jiangchengbianhao"); if(jiangchengbianhaoobj.value==""){document.getElementById("clabeljiangchengbianhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入奖惩编号</font>";return false;}else{document.getElementById("clabeljiangchengbianhao").innerHTML="  "; } 	var jiangchengbiaotiobj = document.getElementById("jiangchengbiaoti"); if(jiangchengbiaotiobj.value==""){document.getElementById("clabeljiangchengbiaoti").innerHTML="&nbsp;&nbsp;<font color=red>请输入奖惩标题</font>";return false;}else{document.getElementById("clabeljiangchengbiaoti").innerHTML="  "; } 	var jiangchengneirongobj = document.getElementById("jiangchengneirong"); if(jiangchengneirongobj.value==""){document.getElementById("clabeljiangchengneirong").innerHTML="&nbsp;&nbsp;<font color=red>请输入奖惩内容</font>";return false;}else{document.getElementById("clabeljiangchengneirong").innerHTML="  "; } 	var jiangchengfenshuobj = document.getElementById("jiangchengfenshu"); if(jiangchengfenshuobj.value==""){document.getElementById("clabeljiangchengfenshu").innerHTML="&nbsp;&nbsp;<font color=red>请输入奖惩分数</font>";return false;}else{document.getElementById("clabeljiangchengfenshu").innerHTML="  "; } 	var shijianobj = document.getElementById("shijian"); if(shijianobj.value==""){document.getElementById("clabelshijian").innerHTML="&nbsp;&nbsp;<font color=red>请输入时间</font>";return false;}else{document.getElementById("clabelshijian").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
<script src="images/hsgcommon/jq.js"></script>
<script src="images/hsgcommon/common.js"></script>
<script src="images/hsgcommon/bootbox.js"></script>