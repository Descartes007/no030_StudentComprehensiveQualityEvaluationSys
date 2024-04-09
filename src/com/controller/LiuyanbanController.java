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

import com.entity.Liuyanban;
import com.server.LiuyanbanServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class LiuyanbanController {
	@Resource
	private LiuyanbanServer liuyanbanService;


   
	@RequestMapping("addLiuyanban.do")
	public String addLiuyanban(HttpServletRequest request,Liuyanban liuyanban,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		liuyanban.setAddtime(time.toString().substring(0, 19));
		liuyanbanService.add(liuyanban);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "liuyanbanList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:liuyanbanList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateLiuyanban.do")
	public String doUpdateLiuyanban(int id,ModelMap map,Liuyanban liuyanban){
		liuyanban=liuyanbanService.getById(id);
		map.put("liuyanban", liuyanban);
		return "liuyanban_updt";
	}
	
	
	
	@RequestMapping("doUpdateLiuyanbanlb.do")
	public String doUpdateLiuyanbanlb(int id,ModelMap map,Liuyanban liuyanban){
		liuyanban=liuyanbanService.getById(id);
		map.put("liuyanban", liuyanban);
		return "liuyanban_updtlb";
	}
	
@RequestMapping("updateLiuyanbanlb.do")
	public String updateLiuyanbanlb(int id,ModelMap map,Liuyanban liuyanban){
		liuyanbanService.updatelb(liuyanban);
		return "redirect:liuyanbanList.do";
	}
	
//	后台详细
	@RequestMapping("liuyanbanDetail.do")
	public String liuyanbanDetail(int id,ModelMap map,Liuyanban liuyanban){
		liuyanban=liuyanbanService.getById(id);
		map.put("liuyanban", liuyanban);
		return "liuyanban_detail";
	}
//	前台详细
	@RequestMapping("lybDetail.do")
	public String lybDetail(int id,ModelMap map,Liuyanban liuyanban){
		liuyanban=liuyanbanService.getById(id);
		map.put("liuyanban", liuyanban);
		return "liuyanbandetail";
	}
//	
	@RequestMapping("updateLiuyanban.do")
	public String updateLiuyanban(int id,ModelMap map,Liuyanban liuyanban,HttpServletRequest request,HttpSession session){
		liuyanbanService.update(liuyanban);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:liuyanbanList.do";
	}

//	分页查询
	@RequestMapping("liuyanbanList.do")
	public String liuyanbanList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Liuyanban liuyanban, String xuehao, String xingming, String banji, String liuyanneirong, String huifu){
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
		if(liuyanneirong==null||liuyanneirong.equals("")){pmap.put("liuyanneirong", null);}else{pmap.put("liuyanneirong", liuyanneirong);}
		if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
		
		int total=liuyanbanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Liuyanban> list=liuyanbanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "liuyanban_list";
	}
	
	@RequestMapping("liuyanban_yanben1.do")
	public String liuyanban_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Liuyanban liuyanban, String xuehao, String xingming, String banji, String liuyanneirong, String huifu){
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
		if(liuyanneirong==null||liuyanneirong.equals("")){pmap.put("liuyanneirong", null);}else{pmap.put("liuyanneirong", liuyanneirong);}
		if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
		
		int total=liuyanbanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Liuyanban> list=liuyanbanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "liuyanban_yanben1";
	}
	@RequestMapping("liuyanban_yanben2.do")
	public String liuyanban_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Liuyanban liuyanban, String xuehao, String xingming, String banji, String liuyanneirong, String huifu){
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
		if(liuyanneirong==null||liuyanneirong.equals("")){pmap.put("liuyanneirong", null);}else{pmap.put("liuyanneirong", liuyanneirong);}
		if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
		
		int total=liuyanbanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Liuyanban> list=liuyanbanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "liuyanban_yanben2";
	}
	@RequestMapping("liuyanban_yanben3.do")
	public String liuyanban_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Liuyanban liuyanban, String xuehao, String xingming, String banji, String liuyanneirong, String huifu){
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
		if(liuyanneirong==null||liuyanneirong.equals("")){pmap.put("liuyanneirong", null);}else{pmap.put("liuyanneirong", liuyanneirong);}
		if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
		
		int total=liuyanbanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Liuyanban> list=liuyanbanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "liuyanban_yanben3";
	}
	@RequestMapping("liuyanban_yanben4.do")
	public String liuyanban_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Liuyanban liuyanban, String xuehao, String xingming, String banji, String liuyanneirong, String huifu){
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
		if(liuyanneirong==null||liuyanneirong.equals("")){pmap.put("liuyanneirong", null);}else{pmap.put("liuyanneirong", liuyanneirong);}
		if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
		
		int total=liuyanbanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Liuyanban> list=liuyanbanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "liuyanban_yanben4";
	}
	@RequestMapping("liuyanban_yanben5.do")
	public String liuyanban_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Liuyanban liuyanban, String xuehao, String xingming, String banji, String liuyanneirong, String huifu){
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
		if(liuyanneirong==null||liuyanneirong.equals("")){pmap.put("liuyanneirong", null);}else{pmap.put("liuyanneirong", liuyanneirong);}
		if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
		
		int total=liuyanbanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Liuyanban> list=liuyanbanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "liuyanban_yanben5";
	}
	
	@RequestMapping("liuyanbanList2.do")
	public String liuyanbanList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Liuyanban liuyanban, String xuehao, String xingming, String banji, String liuyanneirong, String huifu,HttpServletRequest request){
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
		if(liuyanneirong==null||liuyanneirong.equals("")){pmap.put("liuyanneirong", null);}else{pmap.put("liuyanneirong", liuyanneirong);}
		if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
		
		
		int total=liuyanbanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Liuyanban> list=liuyanbanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "liuyanban_list2";
	}
	
	
	@RequestMapping("lybList.do")
	public String lybList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Liuyanban liuyanban, String xuehao, String xingming, String banji, String liuyanneirong, String huifu){
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
		if(liuyanneirong==null||liuyanneirong.equals("")){pmap.put("liuyanneirong", null);}else{pmap.put("liuyanneirong", liuyanneirong);}
		if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
		
		int total=liuyanbanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Liuyanban> list=liuyanbanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "liuyanbanlist";
	}
	@RequestMapping("lybListtp.do")
	public String lybListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Liuyanban liuyanban, String xuehao, String xingming, String banji, String liuyanneirong, String huifu){
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
		if(liuyanneirong==null||liuyanneirong.equals("")){pmap.put("liuyanneirong", null);}else{pmap.put("liuyanneirong", liuyanneirong);}
		if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
		
		int total=liuyanbanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Liuyanban> list=liuyanbanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "liuyanbanlisttp";
	}
	
	@RequestMapping("deleteLiuyanban.do")
	public String deleteLiuyanban(int id,HttpServletRequest request){
		liuyanbanService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:liuyanbanList.do";
	}
	
	
}
