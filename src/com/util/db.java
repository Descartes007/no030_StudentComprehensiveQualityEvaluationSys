package com.util;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.HashMap;

import java.sql.SQLException;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.util.Constant;


public class db {
	 //private String dbDriver="com.microsoft.jdbc.sqlserver.SQLServerDriver";
	// private String sConnStr = "jdbc:microsoft:sqlserver://localhost:1433;databasename=ssmzhszcphsg7590B4";

	 private String dbDriver="com.mysql.jdbc.Driver";
	 private String sConnStr = "jdbc:mysql://localhost:3306/no30_zhszcphsg?useUnicode=true&amp;amp;amp;amp;amp;characterEncoding=utf8";

	 // private String dbDriver="net.sourceforge.jtds.jdbc.Driver";
	// private String sConnStr = "jdbc:jtds:sqlserver://127.0.0.1:1433;databaseName=ssmzhszcphsg7590B4";


	 private String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	 private List list;
	  public Connection connect = null;
	  public ResultSet rs=null;
	  public String nsa="root";
	  public String nmm="1025";
	  public db() {
	    try {

	      Class.forName(dbDriver).newInstance();
	    }
	    catch (Exception ex) {
	      System.out.println("12121");
	    }
	  }


	  public ResultSet executeQuery(String sql) {
			try{
				connect=DriverManager.getConnection(sConnStr,nsa,nmm);
				Statement stmt=connect.createStatement();
				rs=stmt.executeQuery(sql);
			}catch(SQLException ex){
				System.err.println(ex.getMessage());
			}
			return rs;
		}


	  public String hsggetoption(String ntable,String nzd){
			StringBuffer imgStr = new StringBuffer();
			imgStr.append("");

			String sql="";
			sql="select "+nzd+" from "+ntable+" order by id desc";
			System.out.print(sql);
			try{
				connect=DriverManager.getConnection(sConnStr,nsa,nmm);
				Statement stmt=connect.createStatement();
				rs=stmt.executeQuery(sql);

				while(rs.next()){
					imgStr.append("<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>\n");
				}
				return imgStr.toString();
			}catch(Exception e){
				e.printStackTrace();
				return imgStr.toString();
			}
		}
	  public String hsggetoption2(String ntable,String nzd){
			StringBuffer imgStr = new StringBuffer();
			imgStr.append("");
			imgStr.append("<option value=''>请选择</option>\n");

			String sql="";
			sql="select "+nzd+" from "+ntable+" order by id desc";
			try{
				connect=DriverManager.getConnection(sConnStr,nsa,nmm);
				Statement stmt=connect.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					imgStr.append("<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>\n");
				}
				return imgStr.toString();
			}catch(Exception e){
				e.printStackTrace();
				return imgStr.toString();
			}
		}
	  public String hsggetoptiond(String ntable,String nzd,String nwbk){
			StringBuffer imgStr = new StringBuffer();
			imgStr.append("");

			String sql="";
			sql="select "+nzd+" from "+ntable+" order by id desc";
			System.out.print(sql);
			try{
				connect=DriverManager.getConnection(sConnStr,nsa,nmm);
				Statement stmt=connect.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					imgStr.append("<a onClick=\"hsgxia2shxurxu('"+rs.getString(1)+"','"+nwbk+"')\" style='cursor:pointer'>"+rs.getString(1)+"</a>\n");
				}
				return imgStr.toString();
			}catch(Exception e){
				e.printStackTrace();
				return imgStr.toString();
			}
		}



	  public int hsgexecute(String sql){

			int i=0;
			try{

				 connect=DriverManager.getConnection(sConnStr,nsa,nmm);
					Statement stmt=connect.createStatement();
					i = stmt.executeUpdate(sql);
				if(i == 1){
					return i;
				}
				else{
					return i;
				}
			}catch(Exception e){
				e.printStackTrace();
				return Constant.SYSTEM_ERROR;
			}
		}

	  public synchronized static String getID() {

			Random random = new Random();
			StringBuffer ret = new StringBuffer(20);
			java.util.Date date = new java.util.Date();
			java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("MMddHHmmss", java.util.Locale.CHINA);
			ret.append(format.format(date));
			String rand = String.valueOf(Math.abs(random.nextInt()));
			//ret.append(getDateStr());
			ret.append(rand.substring(0,4));

			return ret.toString();
		}

	  public static int getBetweenDayNumber(String dateA, String dateB) {
			long dayNumber = 0;
			//1小时=60分钟=3600秒=3600000
			long mins = 60L * 1000L;
			//long day= 24L * 60L * 60L * 1000L;计算天数之差
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try {
			   java.util.Date d1 = df.parse(dateA);
			   java.util.Date d2 = df.parse(dateB);
			   dayNumber = (d2.getTime() - d1.getTime()) / mins;
			} catch (Exception e) {
			   e.printStackTrace();
			}
			return (int) dayNumber;
		}

	  public List getShouyebht(){
			String sql = "select id,biaoti,shouyetupian from xinwentongzhi where leibie='站内新闻' order by id desc";
			list = new ArrayList();
			try{
				connect=DriverManager.getConnection(sConnStr,nsa,nmm);
				Statement stmt=connect.createStatement();
				rs=stmt.executeQuery(sql);

				while(rs.next()){
					List list2=new ArrayList();
					list2.add(rs.getString(1));
					list2.add(rs.getString(2));
					list2.add(rs.getString(3));


					list.add(list2);
				}
				return list;
			}catch(Exception e){
				e.printStackTrace();
				return list;
			}
		}

		//读取新闻类别


		public String getxwlb(){
			StringBuffer imgStr = new StringBuffer();
			imgStr.append("");

			String sql="";
			sql="select distinct(leibie) as ss from xinwentongzhi where leibie<>'变幻图'";
			System.out.print(sql);
			try{
				connect=DriverManager.getConnection(sConnStr,nsa,nmm);
				Statement stmt=connect.createStatement();
				rs=stmt.executeQuery(sql);

				while(rs.next()){
					imgStr.append("<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>\n");
				}
				return imgStr.toString();
			}catch(Exception e){
				e.printStackTrace();
				return imgStr.toString();
			}
		}



		public String readzd(String ntable,String nzd,String tjzd,String tjz){
			String sql = "select "+nzd+" from "+ntable+" where "+tjzd+"='"+tjz+"' ";

			try{

				connect=DriverManager.getConnection(sConnStr,nsa,nmm);
				Statement stmt=connect.createStatement();
				rs=stmt.executeQuery(sql);
				rs.next();
				String dir = rs.getString(1);
				return dir;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}

		public String getddnr(String nuser){

			String sql = "select shangpinmingcheng,goumaishuliang from goumaijilu where goumairen = '"+nuser+"' and issh='否' ";
			System.out.print(sql);


			String ddnr="";
			try{
				connect=DriverManager.getConnection(sConnStr,nsa,nmm);
				Statement stmt=connect.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){

						ddnr=ddnr+"商品名称："+rs.getString(1)+"，购买数量："+rs.getString(2)+"；\r\n";
				}
				return ddnr;
			}catch(Exception e){
				e.printStackTrace();
				return ddnr;
			}



		}

		public List<HashMap> select(String sql)
		{
			System.out.println(sql);
			List<HashMap> list = new ArrayList();
			try {
				connect=DriverManager.getConnection(sConnStr,nsa,nmm);
				Statement stmt=connect.createStatement();
				rs=stmt.executeQuery(sql);


			    ResultSet rs = stmt.executeQuery(sql);
			    ResultSetMetaData rsmd = rs.getMetaData();

			    while(rs.next())
			    {
			    	HashMap map = new HashMap();
			    	int i = rsmd.getColumnCount();
			    	for(int j=1;j<=i;j++)
			    	{
			    		if(!rsmd.getColumnName(j).equals("ID"))
			    		{
			    			String str = rs.getString(j)==null?"": rs.getString(j);
			    			if(str.equals("null"))str = "";
			    			map.put(rsmd.getColumnName(j), str);
			    		}
			    		else
			    			map.put("id", rs.getString(j));
			    	}
			    	list.add(map);
			    }
			    rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block

				if(sql.equals("show tables"))
				list = select("select table_name from   INFORMATION_SCHEMA.tables");
				else
					e.printStackTrace();
			}
			return list;
		}

		public List<HashMap> select(String sql, int pageno, int rowsize) {
			List<HashMap> list=new ArrayList<HashMap>();
			List<HashMap> mlist=new ArrayList<HashMap>();
			try{
				list=this.select(sql);
				int min = (pageno-1)*rowsize;
				int max = pageno*rowsize;

				for(int i=0;i<list.size();i++)
				{

					if(!(i<min||i>(max-1)))
					{
					mlist.add(list.get(i));
					}
				}
			}catch(RuntimeException re){
				re.printStackTrace();
				throw re;
			}


			return mlist;
		}

		public List<HashMap> getpinglun(String nbiao,String nid) {

			List<HashMap> list = new ArrayList();
			try {
				connect=DriverManager.getConnection(sConnStr,nsa,nmm);
				Statement stmt=connect.createStatement();
				String tsql="select * from pinglun where biao='"+nbiao+"' and xinwenID='"+nid+"'";
				rs=stmt.executeQuery(tsql);


			    ResultSet rs = stmt.executeQuery(tsql);
			    ResultSetMetaData rsmd = rs.getMetaData();

			    while(rs.next())
			    {
			    	HashMap map = new HashMap();
			    	int i = rsmd.getColumnCount();
			    	for(int j=1;j<=i;j++)
			    	{
			    		if(!rsmd.getColumnName(j).equals("ID"))
			    		{
			    			String str = rs.getString(j)==null?"": rs.getString(j);
			    			if(str.equals("null"))str = "";
			    			map.put(rsmd.getColumnName(j), str);
			    		}
			    		else
			    			map.put("id", rs.getString(j));
			    	}
			    	list.add(map);
			    }
			    rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block


			}
			return list;
		}

		 //	该方法返回一个table 用于流动图片
		public String DynamicImage(int width,int height){

			StringBuffer imgStr = new StringBuffer();
			StringBuffer thePics1 = new StringBuffer();
			StringBuffer theLinks1 = new StringBuffer();
			StringBuffer theTexts1 = new StringBuffer();

			imgStr.append("<div id=picViwer1  style='background-color: #ffffff' align=center></div><SCRIPT src='js/dynamicImage.js' type=text/javascript></SCRIPT>\n<script language=JavaScript>\n");
			thePics1.append("var thePics1=\n'");
			theLinks1.append("var theLinks1='");
			theTexts1.append("var theTexts1='");

			List<HashMap> co = this.select("select * from xinwentongzhi where shouyetupian<>'' and shouyetupian<>'null'  and shouyetupian  like '%.jpg' order by id desc",1,6);
			int i = co.size();

			int j = 0;
			for(HashMap b:co)
			{
				j++;
			int id = Integer.parseInt(b.get("id").toString()) ;
			String title = Info.subStr(b.get("biaoti").toString(), 21) ;

			String url = ""+b.get("shouyetupian");

			String purl = "xwtzDetail.do?id="+b.get("id");

			if(j!=i){
			thePics1.append(url.replaceAll("\n", "")+"|");
			theLinks1.append(purl+"|");
			theTexts1.append(title+"|");
			}
			if(j==i)
			{
				thePics1.append(url.replaceAll("\n", ""));
				theLinks1.append("xwtzDetail.do?id="+b.get("id"));
				theTexts1.append(title);
			}

			}
		   thePics1.append("';");

			theLinks1.append("';");
			theTexts1.append("';");
			imgStr.append(thePics1+"\n");
			imgStr.append(theLinks1+"\n");
			imgStr.append(theTexts1+"\n");
			imgStr.append("\n setPic(thePics1,theLinks1,theTexts1,"+width+","+height+",'picViwer1');</script>");
			return imgStr.toString();
		}


		//读取当前时间
		public String getdate(){
			String tt=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
			return tt;
		}
		public String gettime(){
		  String tt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
			return tt;
		}

		 //读取论坛文章数
		public int getwzs(String nbk){

		int i=0;
		try{
				connect=DriverManager.getConnection(sConnStr,nsa,nmm);
				Statement stmt=connect.createStatement();
				rs=stmt.executeQuery("select * from tiezi where bankuai='"+nbk+"' and fid=0");
				while(rs.next()){
					i++;
				}
				return i;
			}catch(Exception e){
				e.printStackTrace();
				return 0;
			}
		}
	  //读取版块帖子数
		public int gettzs(String tzid){

		int i=0;
		try{
				connect=DriverManager.getConnection(sConnStr,nsa,nmm);
				Statement stmt=connect.createStatement();
				rs=stmt.executeQuery("select * from tiezi where fid="+tzid+"");
				while(rs.next()){
					i++;
				}
				return i;
			}catch(Exception e){
				e.printStackTrace();
				return 0;
			}
		}
		public synchronized static String ensubStr(Object source,int length) {
			String msource = db.filterStrIgnoreCase(source.toString(), "<", ">");
			if(msource.length()>length)
			{
				msource=msource.substring(0,length)+"...";
			}
			return msource;
		}
		public static String filterStrIgnoreCase(String source, String from, String to){
	        String sourceLowcase=source.toLowerCase();
	        String sub1,sub2,subLowcase1,subLowcase2;
	        sub1=sub2=subLowcase1=subLowcase2="";
	        int start=0,end;
	        boolean done=true;
	        if(source==null) return null;
	        if(from==null||from.equals("")||to==null||to.equals(""))
	         return source;
	        while(done){
	         start=sourceLowcase.indexOf(from,start);
	         if(start==-1) {
	          break;
	         }
	         subLowcase1=sourceLowcase.substring(0,start);
	         sub1=source.substring(0,start);
	         end=sourceLowcase.indexOf(to,start);
	         if(end==-1){
	          end=sourceLowcase.indexOf("/>",start);
	          if(end==-1) {
	           done=false;
	          }
	         }
	         else{
	          end=end+to.length();
	          subLowcase2=sourceLowcase.substring(end,source.length());
	          sub2=source.substring(end,source.length());
	          sourceLowcase=subLowcase1+subLowcase2;
	          source=sub1+sub2;
	         }
	         //System.out.println(start+" "+end);
	        }
	        return source;
	   }
}



