package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Jiangchengxinxi;
import com.server.JiangchengxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class JiangchengxinxiController {
	@Resource
	private JiangchengxinxiServer jiangchengxinxiService;


   
	@RequestMapping("addJiangchengxinxi.do")
	public String addJiangchengxinxi(HttpServletRequest request,Jiangchengxinxi jiangchengxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		jiangchengxinxi.setAddtime(time.toString().substring(0, 19));
		jiangchengxinxiService.add(jiangchengxinxi);
		
			String sql="";
	sql="update xueshengxinxi set jisuanchuxueshengcaoxingcepingfen=jisuanchuxueshengcaoxingcepingfen+"+jiangchengxinxi.getJiangchengfenshu()+" where xuehao='"+jiangchengxinxi.getLururen()+"'";
	db dbo = new db();
	dbo.hsgexecute(sql);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "jiangchengxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:jiangchengxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateJiangchengxinxi.do")
	public String doUpdateJiangchengxinxi(int id,ModelMap map,Jiangchengxinxi jiangchengxinxi){
		jiangchengxinxi=jiangchengxinxiService.getById(id);
		map.put("jiangchengxinxi", jiangchengxinxi);
		return "jiangchengxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("jiangchengxinxiDetail.do")
	public String jiangchengxinxiDetail(int id,ModelMap map,Jiangchengxinxi jiangchengxinxi){
		jiangchengxinxi=jiangchengxinxiService.getById(id);
		map.put("jiangchengxinxi", jiangchengxinxi);
		return "jiangchengxinxi_detail";
	}
//	前台详细
	@RequestMapping("jcxxDetail.do")
	public String jcxxDetail(int id,ModelMap map,Jiangchengxinxi jiangchengxinxi){
		jiangchengxinxi=jiangchengxinxiService.getById(id);
		map.put("jiangchengxinxi", jiangchengxinxi);
		return "jiangchengxinxidetail";
	}
//	
	@RequestMapping("updateJiangchengxinxi.do")
	public String updateJiangchengxinxi(int id,ModelMap map,Jiangchengxinxi jiangchengxinxi,HttpServletRequest request,HttpSession session){
		jiangchengxinxiService.update(jiangchengxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:jiangchengxinxiList.do";
	}

//	分页查询
	@RequestMapping("jiangchengxinxiList.do")
	public String jiangchengxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiangchengxinxi jiangchengxinxi, String jiangchengbianhao, String jiangchengbiaoti, String jiangchengneirong, String jiangchengfenshu, String shijian1,String shijian2, String lururen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jiangchengbianhao==null||jiangchengbianhao.equals("")){pmap.put("jiangchengbianhao", null);}else{pmap.put("jiangchengbianhao", jiangchengbianhao);}
		if(jiangchengbiaoti==null||jiangchengbiaoti.equals("")){pmap.put("jiangchengbiaoti", null);}else{pmap.put("jiangchengbiaoti", jiangchengbiaoti);}
		if(jiangchengneirong==null||jiangchengneirong.equals("")){pmap.put("jiangchengneirong", null);}else{pmap.put("jiangchengneirong", jiangchengneirong);}
		if(jiangchengfenshu==null||jiangchengfenshu.equals("")){pmap.put("jiangchengfenshu", null);}else{pmap.put("jiangchengfenshu", jiangchengfenshu);}
		if(shijian1==null||shijian1.equals("")){pmap.put("shijian1", null);}else{pmap.put("shijian1", shijian1);}
		if(shijian2==null||shijian2.equals("")){pmap.put("shijian2", null);}else{pmap.put("shijian2", shijian2);}
		if(lururen==null||lururen.equals("")){pmap.put("lururen", null);}else{pmap.put("lururen", lururen);}
		
		int total=jiangchengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiangchengxinxi> list=jiangchengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiangchengxinxi_list";
	}
	
	@RequestMapping("jiangchengxinxi_yanben1.do")
	public String jiangchengxinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiangchengxinxi jiangchengxinxi, String jiangchengbianhao, String jiangchengbiaoti, String jiangchengneirong, String jiangchengfenshu, String shijian1,String shijian2, String lururen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jiangchengbianhao==null||jiangchengbianhao.equals("")){pmap.put("jiangchengbianhao", null);}else{pmap.put("jiangchengbianhao", jiangchengbianhao);}
		if(jiangchengbiaoti==null||jiangchengbiaoti.equals("")){pmap.put("jiangchengbiaoti", null);}else{pmap.put("jiangchengbiaoti", jiangchengbiaoti);}
		if(jiangchengneirong==null||jiangchengneirong.equals("")){pmap.put("jiangchengneirong", null);}else{pmap.put("jiangchengneirong", jiangchengneirong);}
		if(jiangchengfenshu==null||jiangchengfenshu.equals("")){pmap.put("jiangchengfenshu", null);}else{pmap.put("jiangchengfenshu", jiangchengfenshu);}
		if(shijian1==null||shijian1.equals("")){pmap.put("shijian1", null);}else{pmap.put("shijian1", shijian1);}
		if(shijian2==null||shijian2.equals("")){pmap.put("shijian2", null);}else{pmap.put("shijian2", shijian2);}
		if(lururen==null||lururen.equals("")){pmap.put("lururen", null);}else{pmap.put("lururen", lururen);}
		
		int total=jiangchengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiangchengxinxi> list=jiangchengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiangchengxinxi_yanben1";
	}
	@RequestMapping("jiangchengxinxi_yanben2.do")
	public String jiangchengxinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiangchengxinxi jiangchengxinxi, String jiangchengbianhao, String jiangchengbiaoti, String jiangchengneirong, String jiangchengfenshu, String shijian1,String shijian2, String lururen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jiangchengbianhao==null||jiangchengbianhao.equals("")){pmap.put("jiangchengbianhao", null);}else{pmap.put("jiangchengbianhao", jiangchengbianhao);}
		if(jiangchengbiaoti==null||jiangchengbiaoti.equals("")){pmap.put("jiangchengbiaoti", null);}else{pmap.put("jiangchengbiaoti", jiangchengbiaoti);}
		if(jiangchengneirong==null||jiangchengneirong.equals("")){pmap.put("jiangchengneirong", null);}else{pmap.put("jiangchengneirong", jiangchengneirong);}
		if(jiangchengfenshu==null||jiangchengfenshu.equals("")){pmap.put("jiangchengfenshu", null);}else{pmap.put("jiangchengfenshu", jiangchengfenshu);}
		if(shijian1==null||shijian1.equals("")){pmap.put("shijian1", null);}else{pmap.put("shijian1", shijian1);}
		if(shijian2==null||shijian2.equals("")){pmap.put("shijian2", null);}else{pmap.put("shijian2", shijian2);}
		if(lururen==null||lururen.equals("")){pmap.put("lururen", null);}else{pmap.put("lururen", lururen);}
		
		int total=jiangchengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiangchengxinxi> list=jiangchengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiangchengxinxi_yanben2";
	}
	@RequestMapping("jiangchengxinxi_yanben3.do")
	public String jiangchengxinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiangchengxinxi jiangchengxinxi, String jiangchengbianhao, String jiangchengbiaoti, String jiangchengneirong, String jiangchengfenshu, String shijian1,String shijian2, String lururen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jiangchengbianhao==null||jiangchengbianhao.equals("")){pmap.put("jiangchengbianhao", null);}else{pmap.put("jiangchengbianhao", jiangchengbianhao);}
		if(jiangchengbiaoti==null||jiangchengbiaoti.equals("")){pmap.put("jiangchengbiaoti", null);}else{pmap.put("jiangchengbiaoti", jiangchengbiaoti);}
		if(jiangchengneirong==null||jiangchengneirong.equals("")){pmap.put("jiangchengneirong", null);}else{pmap.put("jiangchengneirong", jiangchengneirong);}
		if(jiangchengfenshu==null||jiangchengfenshu.equals("")){pmap.put("jiangchengfenshu", null);}else{pmap.put("jiangchengfenshu", jiangchengfenshu);}
		if(shijian1==null||shijian1.equals("")){pmap.put("shijian1", null);}else{pmap.put("shijian1", shijian1);}
		if(shijian2==null||shijian2.equals("")){pmap.put("shijian2", null);}else{pmap.put("shijian2", shijian2);}
		if(lururen==null||lururen.equals("")){pmap.put("lururen", null);}else{pmap.put("lururen", lururen);}
		
		int total=jiangchengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiangchengxinxi> list=jiangchengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiangchengxinxi_yanben3";
	}
	@RequestMapping("jiangchengxinxi_yanben4.do")
	public String jiangchengxinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiangchengxinxi jiangchengxinxi, String jiangchengbianhao, String jiangchengbiaoti, String jiangchengneirong, String jiangchengfenshu, String shijian1,String shijian2, String lururen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jiangchengbianhao==null||jiangchengbianhao.equals("")){pmap.put("jiangchengbianhao", null);}else{pmap.put("jiangchengbianhao", jiangchengbianhao);}
		if(jiangchengbiaoti==null||jiangchengbiaoti.equals("")){pmap.put("jiangchengbiaoti", null);}else{pmap.put("jiangchengbiaoti", jiangchengbiaoti);}
		if(jiangchengneirong==null||jiangchengneirong.equals("")){pmap.put("jiangchengneirong", null);}else{pmap.put("jiangchengneirong", jiangchengneirong);}
		if(jiangchengfenshu==null||jiangchengfenshu.equals("")){pmap.put("jiangchengfenshu", null);}else{pmap.put("jiangchengfenshu", jiangchengfenshu);}
		if(shijian1==null||shijian1.equals("")){pmap.put("shijian1", null);}else{pmap.put("shijian1", shijian1);}
		if(shijian2==null||shijian2.equals("")){pmap.put("shijian2", null);}else{pmap.put("shijian2", shijian2);}
		if(lururen==null||lururen.equals("")){pmap.put("lururen", null);}else{pmap.put("lururen", lururen);}
		
		int total=jiangchengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiangchengxinxi> list=jiangchengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiangchengxinxi_yanben4";
	}
	@RequestMapping("jiangchengxinxi_yanben5.do")
	public String jiangchengxinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiangchengxinxi jiangchengxinxi, String jiangchengbianhao, String jiangchengbiaoti, String jiangchengneirong, String jiangchengfenshu, String shijian1,String shijian2, String lururen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jiangchengbianhao==null||jiangchengbianhao.equals("")){pmap.put("jiangchengbianhao", null);}else{pmap.put("jiangchengbianhao", jiangchengbianhao);}
		if(jiangchengbiaoti==null||jiangchengbiaoti.equals("")){pmap.put("jiangchengbiaoti", null);}else{pmap.put("jiangchengbiaoti", jiangchengbiaoti);}
		if(jiangchengneirong==null||jiangchengneirong.equals("")){pmap.put("jiangchengneirong", null);}else{pmap.put("jiangchengneirong", jiangchengneirong);}
		if(jiangchengfenshu==null||jiangchengfenshu.equals("")){pmap.put("jiangchengfenshu", null);}else{pmap.put("jiangchengfenshu", jiangchengfenshu);}
		if(shijian1==null||shijian1.equals("")){pmap.put("shijian1", null);}else{pmap.put("shijian1", shijian1);}
		if(shijian2==null||shijian2.equals("")){pmap.put("shijian2", null);}else{pmap.put("shijian2", shijian2);}
		if(lururen==null||lururen.equals("")){pmap.put("lururen", null);}else{pmap.put("lururen", lururen);}
		
		int total=jiangchengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiangchengxinxi> list=jiangchengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiangchengxinxi_yanben5";
	}
	
	@RequestMapping("jiangchengxinxiList2.do")
	public String jiangchengxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiangchengxinxi jiangchengxinxi, String jiangchengbianhao, String jiangchengbiaoti, String jiangchengneirong, String jiangchengfenshu, String shijian1,String shijian2, String lururen,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("lururen", (String)request.getSession().getAttribute("username"));
		if(jiangchengbianhao==null||jiangchengbianhao.equals("")){pmap.put("jiangchengbianhao", null);}else{pmap.put("jiangchengbianhao", jiangchengbianhao);}
		if(jiangchengbiaoti==null||jiangchengbiaoti.equals("")){pmap.put("jiangchengbiaoti", null);}else{pmap.put("jiangchengbiaoti", jiangchengbiaoti);}
		if(jiangchengneirong==null||jiangchengneirong.equals("")){pmap.put("jiangchengneirong", null);}else{pmap.put("jiangchengneirong", jiangchengneirong);}
		if(jiangchengfenshu==null||jiangchengfenshu.equals("")){pmap.put("jiangchengfenshu", null);}else{pmap.put("jiangchengfenshu", jiangchengfenshu);}
		if(shijian1==null||shijian1.equals("")){pmap.put("shijian1", null);}else{pmap.put("shijian1", shijian1);}
		if(shijian2==null||shijian2.equals("")){pmap.put("shijian2", null);}else{pmap.put("shijian2", shijian2);}
		
		
		int total=jiangchengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiangchengxinxi> list=jiangchengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiangchengxinxi_list2";
	}
	
	
	@RequestMapping("jcxxList.do")
	public String jcxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiangchengxinxi jiangchengxinxi, String jiangchengbianhao, String jiangchengbiaoti, String jiangchengneirong, String jiangchengfenshu, String shijian1,String shijian2, String lururen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jiangchengbianhao==null||jiangchengbianhao.equals("")){pmap.put("jiangchengbianhao", null);}else{pmap.put("jiangchengbianhao", jiangchengbianhao);}
		if(jiangchengbiaoti==null||jiangchengbiaoti.equals("")){pmap.put("jiangchengbiaoti", null);}else{pmap.put("jiangchengbiaoti", jiangchengbiaoti);}
		if(jiangchengneirong==null||jiangchengneirong.equals("")){pmap.put("jiangchengneirong", null);}else{pmap.put("jiangchengneirong", jiangchengneirong);}
		if(jiangchengfenshu==null||jiangchengfenshu.equals("")){pmap.put("jiangchengfenshu", null);}else{pmap.put("jiangchengfenshu", jiangchengfenshu);}
		if(shijian1==null||shijian1.equals("")){pmap.put("shijian1", null);}else{pmap.put("shijian1", shijian1);}
		if(shijian2==null||shijian2.equals("")){pmap.put("shijian2", null);}else{pmap.put("shijian2", shijian2);}
		if(lururen==null||lururen.equals("")){pmap.put("lururen", null);}else{pmap.put("lururen", lururen);}
		
		int total=jiangchengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiangchengxinxi> list=jiangchengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiangchengxinxilist";
	}
	@RequestMapping("jcxxListtp.do")
	public String jcxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiangchengxinxi jiangchengxinxi, String jiangchengbianhao, String jiangchengbiaoti, String jiangchengneirong, String jiangchengfenshu, String shijian1,String shijian2, String lururen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jiangchengbianhao==null||jiangchengbianhao.equals("")){pmap.put("jiangchengbianhao", null);}else{pmap.put("jiangchengbianhao", jiangchengbianhao);}
		if(jiangchengbiaoti==null||jiangchengbiaoti.equals("")){pmap.put("jiangchengbiaoti", null);}else{pmap.put("jiangchengbiaoti", jiangchengbiaoti);}
		if(jiangchengneirong==null||jiangchengneirong.equals("")){pmap.put("jiangchengneirong", null);}else{pmap.put("jiangchengneirong", jiangchengneirong);}
		if(jiangchengfenshu==null||jiangchengfenshu.equals("")){pmap.put("jiangchengfenshu", null);}else{pmap.put("jiangchengfenshu", jiangchengfenshu);}
		if(shijian1==null||shijian1.equals("")){pmap.put("shijian1", null);}else{pmap.put("shijian1", shijian1);}
		if(shijian2==null||shijian2.equals("")){pmap.put("shijian2", null);}else{pmap.put("shijian2", shijian2);}
		if(lururen==null||lururen.equals("")){pmap.put("lururen", null);}else{pmap.put("lururen", lururen);}
		
		int total=jiangchengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiangchengxinxi> list=jiangchengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiangchengxinxilisttp";
	}
	
	@RequestMapping("deleteJiangchengxinxi.do")
	public String deleteJiangchengxinxi(int id,HttpServletRequest request){
		jiangchengxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:jiangchengxinxiList.do";
	}
	
	@RequestMapping("quchongJiangchengxinxi.do")
	public void quchongJiangchengxinxi(Jiangchengxinxi jiangchengxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("jiangchengbianhao", jiangchengxinxi.getJiangchengbianhao());
		   System.out.println("jiangchengbianhao==="+jiangchengxinxi.getJiangchengbianhao());
		   System.out.println("jiangchengbianhao222==="+jiangchengxinxiService.quchongJiangchengxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(jiangchengxinxiService.quchongJiangchengxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "奖惩编号可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
