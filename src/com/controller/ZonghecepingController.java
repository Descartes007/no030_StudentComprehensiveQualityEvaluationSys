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

import com.entity.Zongheceping;
import com.server.ZonghecepingServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ZonghecepingController {
	@Resource
	private ZonghecepingServer zonghecepingService;


   
	@RequestMapping("addZongheceping.do")
	public String addZongheceping(HttpServletRequest request,Zongheceping zongheceping,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		zongheceping.setAddtime(time.toString().substring(0, 19));
		zonghecepingService.add(zongheceping);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "zonghecepingList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:zonghecepingList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateZongheceping.do")
	public String doUpdateZongheceping(int id,ModelMap map,Zongheceping zongheceping){
		zongheceping=zonghecepingService.getById(id);
		map.put("zongheceping", zongheceping);
		return "zongheceping_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("zonghecepingDetail.do")
	public String zonghecepingDetail(int id,ModelMap map,Zongheceping zongheceping){
		zongheceping=zonghecepingService.getById(id);
		map.put("zongheceping", zongheceping);
		return "zongheceping_detail";
	}
//	前台详细
	@RequestMapping("zhcpDetail.do")
	public String zhcpDetail(int id,ModelMap map,Zongheceping zongheceping){
		zongheceping=zonghecepingService.getById(id);
		map.put("zongheceping", zongheceping);
		return "zonghecepingdetail";
	}
//	
	@RequestMapping("updateZongheceping.do")
	public String updateZongheceping(int id,ModelMap map,Zongheceping zongheceping,HttpServletRequest request,HttpSession session){
		zonghecepingService.update(zongheceping);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:zonghecepingList.do";
	}

//	分页查询
	@RequestMapping("zonghecepingList.do")
	public String zonghecepingList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zongheceping zongheceping, String xuehao, String xingming, String banji, String jisuanchuxueshengcaoxingcepingfen, String zhiyucepingdefen, String nenglijiafenxiangdefen, String zonghedefen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(jisuanchuxueshengcaoxingcepingfen==null||jisuanchuxueshengcaoxingcepingfen.equals("")){pmap.put("jisuanchuxueshengcaoxingcepingfen", null);}else{pmap.put("jisuanchuxueshengcaoxingcepingfen", jisuanchuxueshengcaoxingcepingfen);}
		if(zhiyucepingdefen==null||zhiyucepingdefen.equals("")){pmap.put("zhiyucepingdefen", null);}else{pmap.put("zhiyucepingdefen", zhiyucepingdefen);}
		if(nenglijiafenxiangdefen==null||nenglijiafenxiangdefen.equals("")){pmap.put("nenglijiafenxiangdefen", null);}else{pmap.put("nenglijiafenxiangdefen", nenglijiafenxiangdefen);}
		if(zonghedefen==null||zonghedefen.equals("")){pmap.put("zonghedefen", null);}else{pmap.put("zonghedefen", zonghedefen);}
		
		int total=zonghecepingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zongheceping> list=zonghecepingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zongheceping_list";
	}
	
		@RequestMapping("zonghecepingListjs.do")
	public String zonghecepingListjs(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zongheceping zongheceping, String xuehao, String xingming, String banji, String jisuanchuxueshengcaoxingcepingfen, String zhiyucepingdefen, String nenglijiafenxiangdefen, String zonghedefen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(jisuanchuxueshengcaoxingcepingfen==null||jisuanchuxueshengcaoxingcepingfen.equals("")){pmap.put("jisuanchuxueshengcaoxingcepingfen", null);}else{pmap.put("jisuanchuxueshengcaoxingcepingfen", jisuanchuxueshengcaoxingcepingfen);}
		if(zhiyucepingdefen==null||zhiyucepingdefen.equals("")){pmap.put("zhiyucepingdefen", null);}else{pmap.put("zhiyucepingdefen", zhiyucepingdefen);}
		if(nenglijiafenxiangdefen==null||nenglijiafenxiangdefen.equals("")){pmap.put("nenglijiafenxiangdefen", null);}else{pmap.put("nenglijiafenxiangdefen", nenglijiafenxiangdefen);}
		if(zonghedefen==null||zonghedefen.equals("")){pmap.put("zonghedefen", null);}else{pmap.put("zonghedefen", zonghedefen);}
		
		int total=zonghecepingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zongheceping> list=zonghecepingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zongheceping_listjs";
	}
	
	@RequestMapping("zongheceping_yanben1.do")
	public String zongheceping_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zongheceping zongheceping, String xuehao, String xingming, String banji, String jisuanchuxueshengcaoxingcepingfen, String zhiyucepingdefen, String nenglijiafenxiangdefen, String zonghedefen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(jisuanchuxueshengcaoxingcepingfen==null||jisuanchuxueshengcaoxingcepingfen.equals("")){pmap.put("jisuanchuxueshengcaoxingcepingfen", null);}else{pmap.put("jisuanchuxueshengcaoxingcepingfen", jisuanchuxueshengcaoxingcepingfen);}
		if(zhiyucepingdefen==null||zhiyucepingdefen.equals("")){pmap.put("zhiyucepingdefen", null);}else{pmap.put("zhiyucepingdefen", zhiyucepingdefen);}
		if(nenglijiafenxiangdefen==null||nenglijiafenxiangdefen.equals("")){pmap.put("nenglijiafenxiangdefen", null);}else{pmap.put("nenglijiafenxiangdefen", nenglijiafenxiangdefen);}
		if(zonghedefen==null||zonghedefen.equals("")){pmap.put("zonghedefen", null);}else{pmap.put("zonghedefen", zonghedefen);}
		
		int total=zonghecepingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zongheceping> list=zonghecepingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zongheceping_yanben1";
	}
	@RequestMapping("zongheceping_yanben2.do")
	public String zongheceping_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zongheceping zongheceping, String xuehao, String xingming, String banji, String jisuanchuxueshengcaoxingcepingfen, String zhiyucepingdefen, String nenglijiafenxiangdefen, String zonghedefen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(jisuanchuxueshengcaoxingcepingfen==null||jisuanchuxueshengcaoxingcepingfen.equals("")){pmap.put("jisuanchuxueshengcaoxingcepingfen", null);}else{pmap.put("jisuanchuxueshengcaoxingcepingfen", jisuanchuxueshengcaoxingcepingfen);}
		if(zhiyucepingdefen==null||zhiyucepingdefen.equals("")){pmap.put("zhiyucepingdefen", null);}else{pmap.put("zhiyucepingdefen", zhiyucepingdefen);}
		if(nenglijiafenxiangdefen==null||nenglijiafenxiangdefen.equals("")){pmap.put("nenglijiafenxiangdefen", null);}else{pmap.put("nenglijiafenxiangdefen", nenglijiafenxiangdefen);}
		if(zonghedefen==null||zonghedefen.equals("")){pmap.put("zonghedefen", null);}else{pmap.put("zonghedefen", zonghedefen);}
		
		int total=zonghecepingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zongheceping> list=zonghecepingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zongheceping_yanben2";
	}
	@RequestMapping("zongheceping_yanben3.do")
	public String zongheceping_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zongheceping zongheceping, String xuehao, String xingming, String banji, String jisuanchuxueshengcaoxingcepingfen, String zhiyucepingdefen, String nenglijiafenxiangdefen, String zonghedefen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(jisuanchuxueshengcaoxingcepingfen==null||jisuanchuxueshengcaoxingcepingfen.equals("")){pmap.put("jisuanchuxueshengcaoxingcepingfen", null);}else{pmap.put("jisuanchuxueshengcaoxingcepingfen", jisuanchuxueshengcaoxingcepingfen);}
		if(zhiyucepingdefen==null||zhiyucepingdefen.equals("")){pmap.put("zhiyucepingdefen", null);}else{pmap.put("zhiyucepingdefen", zhiyucepingdefen);}
		if(nenglijiafenxiangdefen==null||nenglijiafenxiangdefen.equals("")){pmap.put("nenglijiafenxiangdefen", null);}else{pmap.put("nenglijiafenxiangdefen", nenglijiafenxiangdefen);}
		if(zonghedefen==null||zonghedefen.equals("")){pmap.put("zonghedefen", null);}else{pmap.put("zonghedefen", zonghedefen);}
		
		int total=zonghecepingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zongheceping> list=zonghecepingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zongheceping_yanben3";
	}
	@RequestMapping("zongheceping_yanben4.do")
	public String zongheceping_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zongheceping zongheceping, String xuehao, String xingming, String banji, String jisuanchuxueshengcaoxingcepingfen, String zhiyucepingdefen, String nenglijiafenxiangdefen, String zonghedefen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(jisuanchuxueshengcaoxingcepingfen==null||jisuanchuxueshengcaoxingcepingfen.equals("")){pmap.put("jisuanchuxueshengcaoxingcepingfen", null);}else{pmap.put("jisuanchuxueshengcaoxingcepingfen", jisuanchuxueshengcaoxingcepingfen);}
		if(zhiyucepingdefen==null||zhiyucepingdefen.equals("")){pmap.put("zhiyucepingdefen", null);}else{pmap.put("zhiyucepingdefen", zhiyucepingdefen);}
		if(nenglijiafenxiangdefen==null||nenglijiafenxiangdefen.equals("")){pmap.put("nenglijiafenxiangdefen", null);}else{pmap.put("nenglijiafenxiangdefen", nenglijiafenxiangdefen);}
		if(zonghedefen==null||zonghedefen.equals("")){pmap.put("zonghedefen", null);}else{pmap.put("zonghedefen", zonghedefen);}
		
		int total=zonghecepingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zongheceping> list=zonghecepingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zongheceping_yanben4";
	}
	@RequestMapping("zongheceping_yanben5.do")
	public String zongheceping_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zongheceping zongheceping, String xuehao, String xingming, String banji, String jisuanchuxueshengcaoxingcepingfen, String zhiyucepingdefen, String nenglijiafenxiangdefen, String zonghedefen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(jisuanchuxueshengcaoxingcepingfen==null||jisuanchuxueshengcaoxingcepingfen.equals("")){pmap.put("jisuanchuxueshengcaoxingcepingfen", null);}else{pmap.put("jisuanchuxueshengcaoxingcepingfen", jisuanchuxueshengcaoxingcepingfen);}
		if(zhiyucepingdefen==null||zhiyucepingdefen.equals("")){pmap.put("zhiyucepingdefen", null);}else{pmap.put("zhiyucepingdefen", zhiyucepingdefen);}
		if(nenglijiafenxiangdefen==null||nenglijiafenxiangdefen.equals("")){pmap.put("nenglijiafenxiangdefen", null);}else{pmap.put("nenglijiafenxiangdefen", nenglijiafenxiangdefen);}
		if(zonghedefen==null||zonghedefen.equals("")){pmap.put("zonghedefen", null);}else{pmap.put("zonghedefen", zonghedefen);}
		
		int total=zonghecepingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zongheceping> list=zonghecepingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zongheceping_yanben5";
	}
	
	@RequestMapping("zonghecepingList2.do")
	public String zonghecepingList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zongheceping zongheceping, String xuehao, String xingming, String banji, String jisuanchuxueshengcaoxingcepingfen, String zhiyucepingdefen, String nenglijiafenxiangdefen, String zonghedefen,HttpServletRequest request){
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
		
		pmap.put("xuehao", (String)request.getSession().getAttribute("username"));
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(jisuanchuxueshengcaoxingcepingfen==null||jisuanchuxueshengcaoxingcepingfen.equals("")){pmap.put("jisuanchuxueshengcaoxingcepingfen", null);}else{pmap.put("jisuanchuxueshengcaoxingcepingfen", jisuanchuxueshengcaoxingcepingfen);}
		if(zhiyucepingdefen==null||zhiyucepingdefen.equals("")){pmap.put("zhiyucepingdefen", null);}else{pmap.put("zhiyucepingdefen", zhiyucepingdefen);}
		if(nenglijiafenxiangdefen==null||nenglijiafenxiangdefen.equals("")){pmap.put("nenglijiafenxiangdefen", null);}else{pmap.put("nenglijiafenxiangdefen", nenglijiafenxiangdefen);}
		if(zonghedefen==null||zonghedefen.equals("")){pmap.put("zonghedefen", null);}else{pmap.put("zonghedefen", zonghedefen);}
		
		
		int total=zonghecepingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zongheceping> list=zonghecepingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zongheceping_list2";
	}
	
	
	@RequestMapping("zhcpList.do")
	public String zhcpList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zongheceping zongheceping, String xuehao, String xingming, String banji, String jisuanchuxueshengcaoxingcepingfen, String zhiyucepingdefen, String nenglijiafenxiangdefen, String zonghedefen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(jisuanchuxueshengcaoxingcepingfen==null||jisuanchuxueshengcaoxingcepingfen.equals("")){pmap.put("jisuanchuxueshengcaoxingcepingfen", null);}else{pmap.put("jisuanchuxueshengcaoxingcepingfen", jisuanchuxueshengcaoxingcepingfen);}
		if(zhiyucepingdefen==null||zhiyucepingdefen.equals("")){pmap.put("zhiyucepingdefen", null);}else{pmap.put("zhiyucepingdefen", zhiyucepingdefen);}
		if(nenglijiafenxiangdefen==null||nenglijiafenxiangdefen.equals("")){pmap.put("nenglijiafenxiangdefen", null);}else{pmap.put("nenglijiafenxiangdefen", nenglijiafenxiangdefen);}
		if(zonghedefen==null||zonghedefen.equals("")){pmap.put("zonghedefen", null);}else{pmap.put("zonghedefen", zonghedefen);}
		
		int total=zonghecepingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zongheceping> list=zonghecepingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zonghecepinglist";
	}
	@RequestMapping("zhcpListtp.do")
	public String zhcpListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zongheceping zongheceping, String xuehao, String xingming, String banji, String jisuanchuxueshengcaoxingcepingfen, String zhiyucepingdefen, String nenglijiafenxiangdefen, String zonghedefen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(jisuanchuxueshengcaoxingcepingfen==null||jisuanchuxueshengcaoxingcepingfen.equals("")){pmap.put("jisuanchuxueshengcaoxingcepingfen", null);}else{pmap.put("jisuanchuxueshengcaoxingcepingfen", jisuanchuxueshengcaoxingcepingfen);}
		if(zhiyucepingdefen==null||zhiyucepingdefen.equals("")){pmap.put("zhiyucepingdefen", null);}else{pmap.put("zhiyucepingdefen", zhiyucepingdefen);}
		if(nenglijiafenxiangdefen==null||nenglijiafenxiangdefen.equals("")){pmap.put("nenglijiafenxiangdefen", null);}else{pmap.put("nenglijiafenxiangdefen", nenglijiafenxiangdefen);}
		if(zonghedefen==null||zonghedefen.equals("")){pmap.put("zonghedefen", null);}else{pmap.put("zonghedefen", zonghedefen);}
		
		int total=zonghecepingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zongheceping> list=zonghecepingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zonghecepinglisttp";
	}
	
	@RequestMapping("deleteZongheceping.do")
	public String deleteZongheceping(int id,HttpServletRequest request){
		zonghecepingService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:zonghecepingList.do";
	}
	
	
}
