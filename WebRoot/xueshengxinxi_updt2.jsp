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
		<TITLE>修改学生信息</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>


	<body>
			<form action="updateXueshengxinxi2.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改学生信息<input type="hidden" name="id" value="${xueshengxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">学号：</td><td><input name='xuehao' type='text' id='xuehao' value='' onblur='hsgcheck()' class="form-control" />&nbsp;*<label id='clabelxuehao' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelmima' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelxingming' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">性别：</td><td><select name='xingbie' id='xingbie' class="form-control"><option value="男">男</option><option value="女">女</option></select></td></tr>		<tr ><td width="200">身份证：</td><td><input name='shenfenzheng' type='text' id='shenfenzheng' value='' onblur='checkform()' size='50' class="form-control" style="width:600px;" />&nbsp;*<label id='clabelshenfenzheng' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">电话：</td><td><input name='dianhua' type='text' id='dianhua' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabeldianhua' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">班级：</td><td><input name='banji' type='text' id='banji' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">是否挂科：</td><td><input name='shifouguake' type='text' id='shifouguake' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">是否参加新媒体设计大赛：</td><td><input name='shifoucanjiaxinmeitishejidasai' type='text' id='shifoucanjiaxinmeitishejidasai' value='' onblur='' class="form-control" /></td></tr>		<tr 0><td width="200">是否在贫困库中：</td><td><input name='shifouzaipinkunkuzhong' type='text' id='shifouzaipinkunkuzhong' value='' onblur='' class="form-control" /></td></tr>		<tr 1><td width="200">是否建档立卡：</td><td><input name='shifoujiandanglika' type='text' id='shifoujiandanglika' value='' onblur='' class="form-control" /></td></tr>		<tr 2><td width="200">计算出学生操行测评分：</td><td><input name='jisuanchuxueshengcaoxingcepingfen' type='text' id='jisuanchuxueshengcaoxingcepingfen' value='' onblur='' class="form-control" /></td></tr>		<tr 3><td width="200">智育测评得分：</td><td><input name='zhiyucepingdefen' type='text' id='zhiyucepingdefen' value='' onblur='' class="form-control" /></td></tr>		<tr 4><td width="200">能力加分项得分：</td><td><input name='nenglijiafenxiangdefen' type='text' id='nenglijiafenxiangdefen' value='' onblur='' class="form-control" /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.xuehao.value='${xueshengxinxi.xuehao}';</script>	<script language="javascript">document.form1.mima.value='${xueshengxinxi.mima}';</script>	<script language="javascript">document.form1.xingming.value='${xueshengxinxi.xingming}';</script>	<script language="javascript">document.form1.xingbie.value='${xueshengxinxi.xingbie}';</script>	<script language="javascript">document.form1.shenfenzheng.value='${xueshengxinxi.shenfenzheng}';</script>	<script language="javascript">document.form1.dianhua.value='${xueshengxinxi.dianhua}';</script>	<script language="javascript">document.form1.banji.value='${xueshengxinxi.banji}';</script>	<script language="javascript">document.form1.shifouguake.value='${xueshengxinxi.shifouguake}';</script>	<script language="javascript">document.form1.shifoucanjiaxinmeitishejidasai.value='${xueshengxinxi.shifoucanjiaxinmeitishejidasai}';</script>	<script language="javascript">document.form1.shifouzaipinkunkuzhong.value='${xueshengxinxi.shifouzaipinkunkuzhong}';</script>	<script language="javascript">document.form1.shifoujiandanglika.value='${xueshengxinxi.shifoujiandanglika}';</script>	<script language="javascript">document.form1.jisuanchuxueshengcaoxingcepingfen.value='${xueshengxinxi.jisuanchuxueshengcaoxingcepingfen}';</script>	<script language="javascript">document.form1.zhiyucepingdefen.value='${xueshengxinxi.zhiyucepingdefen}';</script>	<script language="javascript">document.form1.nenglijiafenxiangdefen.value='${xueshengxinxi.nenglijiafenxiangdefen}';</script>	
					 </table>
			</form>
   </body>
</html>



<!--hssgchesck-->


<script language=javascript >  
 
 function checkform(){  
 
	var xuehaoobj = document.getElementById("xuehao"); if(xuehaoobj.value==""){document.getElementById("clabelxuehao").innerHTML="&nbsp;&nbsp;<font color=red>请输入学号</font>";return false;}else{document.getElementById("clabelxuehao").innerHTML="  "; } 	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 	var xingmingobj = document.getElementById("xingming"); if(xingmingobj.value==""){document.getElementById("clabelxingming").innerHTML="&nbsp;&nbsp;<font color=red>请输入姓名</font>";return false;}else{document.getElementById("clabelxingming").innerHTML="  "; } 	var shenfenzhengobj = document.getElementById("shenfenzheng"); if(shenfenzhengobj.value==""){document.getElementById("clabelshenfenzheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入身份证</font>";return false;}else{document.getElementById("clabelshenfenzheng").innerHTML="  "; } 	var shenfenzhengobj = document.getElementById("shenfenzheng"); if(shenfenzhengobj.value!=""){ if(/^\d{15}$|^\d{18}$|^\d{17}[xX]$/.test(shenfenzhengobj.value)){document.getElementById("clabelshenfenzheng").innerHTML=""; }else{document.getElementById("clabelshenfenzheng").innerHTML="&nbsp;&nbsp;<font color=red>必需身份证格式</font>"; return false;}}      var dianhuaobj = document.getElementById("dianhua"); if(dianhuaobj.value==""){document.getElementById("clabeldianhua").innerHTML="&nbsp;&nbsp;<font color=red>请输入电话</font>";return false;}else{document.getElementById("clabeldianhua").innerHTML="  "; } 	var dianhuaobj = document.getElementById("dianhua"); if(dianhuaobj.value!=""){ if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(dianhuaobj.value) || /^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(dianhuaobj.value)){document.getElementById("clabeldianhua").innerHTML=""; }else{document.getElementById("clabeldianhua").innerHTML="&nbsp;&nbsp;<font color=red>必需电话格式[7或8位电话，或11位手机]</font>"; return false;}}      


return true;   
}   
popheight=450;
</script>  
