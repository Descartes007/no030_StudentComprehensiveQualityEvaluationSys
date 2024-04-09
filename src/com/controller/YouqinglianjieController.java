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

import com.entity.Youqinglianjie;
import com.server.YouqinglianjieServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class YouqinglianjieController {
	@Resource
	private YouqinglianjieServer youqinglianjieService;


   
	@RequestMapping("addYouqinglianjie.do")
	public String addYouqinglianjie(HttpServletRequest request,Youqinglianjie youqinglianjie,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		youqinglianjie.setAddtime(time.toString().substring(0, 19));
		youqinglianjieService.add(youqinglianjie);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "youqinglianjieList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:youqinglianjieList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateYouqinglianjie.do")
	public String doUpdateYouqinglianjie(int id,ModelMap map,Youqinglianjie youqinglianjie){
		youqinglianjie=youqinglianjieService.getById(id);
		map.put("youqinglianjie", youqinglianjie);
		return "youqinglianjie_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("youqinglianjieDetail.do")
	public String youqinglianjieDetail(int id,ModelMap map,Youqinglianjie youqinglianjie){
		youqinglianjie=youqinglianjieService.getById(id);
		map.put("youqinglianjie", youqinglianjie);
		return "youqinglianjie_detail";
	}
//	前台详细
	@RequestMapping("yqljDetail.do")
	public String yqljDetail(int id,ModelMap map,Youqinglianjie youqinglianjie){
		youqinglianjie=youqinglianjieService.getById(id);
		map.put("youqinglianjie", youqinglianjie);
		return "youqinglianjiedetail";
	}
//	
	@RequestMapping("updateYouqinglianjie.do")
	public String updateYouqinglianjie(int id,ModelMap map,Youqinglianjie youqinglianjie,HttpServletRequest request,HttpSession session){
		youqinglianjieService.update(youqinglianjie);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:youqinglianjieList.do";
	}

//	分页查询
	@RequestMapping("youqinglianjieList.do")
	public String youqinglianjieList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Youqinglianjie youqinglianjie, String wangzhanmingcheng, String wangzhi, String LOGO){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(wangzhanmingcheng==null||wangzhanmingcheng.equals("")){pmap.put("wangzhanmingcheng", null);}else{pmap.put("wangzhanmingcheng", wangzhanmingcheng);}
		if(wangzhi==null||wangzhi.equals("")){pmap.put("wangzhi", null);}else{pmap.put("wangzhi", wangzhi);}
		if(LOGO==null||LOGO.equals("")){pmap.put("LOGO", null);}else{pmap.put("LOGO", LOGO);}
		
		int total=youqinglianjieService.getCount(pmap);
		pageBean.setTotal(total);
		List<Youqinglianjie> list=youqinglianjieService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "youqinglianjie_list";
	}
	
	
	
	@RequestMapping("yqljList.do")
	public String yqljList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Youqinglianjie youqinglianjie, String wangzhanmingcheng, String wangzhi, String LOGO){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(wangzhanmingcheng==null||wangzhanmingcheng.equals("")){pmap.put("wangzhanmingcheng", null);}else{pmap.put("wangzhanmingcheng", wangzhanmingcheng);}
		if(wangzhi==null||wangzhi.equals("")){pmap.put("wangzhi", null);}else{pmap.put("wangzhi", wangzhi);}
		if(LOGO==null||LOGO.equals("")){pmap.put("LOGO", null);}else{pmap.put("LOGO", LOGO);}
		
		int total=youqinglianjieService.getCount(pmap);
		pageBean.setTotal(total);
		List<Youqinglianjie> list=youqinglianjieService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "youqinglianjielist";
	}
	
	@RequestMapping("deleteYouqinglianjie.do")
	public String deleteYouqinglianjie(int id,HttpServletRequest request){
		youqinglianjieService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:youqinglianjieList.do";
	}
	
	
}
