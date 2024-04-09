<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<%@ page isELIgnored="false" %> 
<html>
<head>
<title>性别统计</title>
<script src="echarts.min.js"></script>
</head>
<body >
<%
String sql;
int i=0;
String tleixing="";
sql="select distinct(xingbie) as ss from xueshengxinxi";
ResultSet RS_resultxwlb=connDbBean.executeQuery(sql);
  while(RS_resultxwlb.next()){
  i++;
  tleixing=tleixing+"'"+RS_resultxwlb.getString("ss")+"',";
  }
 if(i>0)
 {
 	tleixing=tleixing.substring(0,tleixing.length()-1);
 }
String[] b = tleixing.split(",");
String x="";
String ttz="";
for(int i2=0;i2<b.length;i2++){
	sql="select count(id) as bbb from xueshengxinxi where xingbie="+b[i2]+"";
	 RS_resultxwlb=connDbBean.executeQuery(sql);
				 if(RS_resultxwlb.next()){
				 
	
 		ttz=RS_resultxwlb.getString("bbb");
  	}
	x=x+"{value: "+ttz+" , name:"+b[i2]+"},";
}
%>
<div id="main" style="width:100%;height:480px" ></div>
<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('main'));
        window.onresize = myChart.resize;
    var option = {
        title: {
            text: '性别统计图'
        },
        tooltip: {},
        legend: {
            data:[<%=tleixing%>]
        },
        grid: {
                left: '5%',
                right: '5%',
                bottom: '5%',
                width: '90%',
                containLabel: true
            },
        xAxis: {
        },
        yAxis: {
          data: []
        },
        series: [
             {
                name: '性别比例',
                type: 'pie',
                radius: 150,
        center: ['50%', '50%'],
                data: [<%=x%>]
            },

        ]
    };
    myChart.setOption(option);
</script>  
    
</body>
</html>


