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

import com.entity.Xueshengchengji;
import com.server.XueshengchengjiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class XueshengchengjiController {
	@Resource
	private XueshengchengjiServer xueshengchengjiService;


   
	@RequestMapping("addXueshengchengji.do")
	public String addXueshengchengji(HttpServletRequest request,Xueshengchengji xueshengchengji,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		xueshengchengji.setAddtime(time.toString().substring(0, 19));
		xueshengchengjiService.add(xueshengchengji);
		
		String sql="";
	sql="update xueshengxinxi set zhiyucepingdefen=zhiyucepingdefen+"+xueshengchengji.getFenshu()+" where xuehao='"+xueshengchengji.getXuehao()+"'";
	db dbo = new db();
	dbo.hsgexecute(sql);

		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "xueshengchengjiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:xueshengchengjiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateXueshengchengji.do")
	public String doUpdateXueshengchengji(int id,ModelMap map,Xueshengchengji xueshengchengji){
		xueshengchengji=xueshengchengjiService.getById(id);
		map.put("xueshengchengji", xueshengchengji);
		return "xueshengchengji_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("xueshengchengjiDetail.do")
	public String xueshengchengjiDetail(int id,ModelMap map,Xueshengchengji xueshengchengji){
		xueshengchengji=xueshengchengjiService.getById(id);
		map.put("xueshengchengji", xueshengchengji);
		return "xueshengchengji_detail";
	}
//	前台详细
	@RequestMapping("xscjDetail.do")
	public String xscjDetail(int id,ModelMap map,Xueshengchengji xueshengchengji){
		xueshengchengji=xueshengchengjiService.getById(id);
		map.put("xueshengchengji", xueshengchengji);
		return "xueshengchengjidetail";
	}
//	
	@RequestMapping("updateXueshengchengji.do")
	public String updateXueshengchengji(int id,ModelMap map,Xueshengchengji xueshengchengji,HttpServletRequest request,HttpSession session){
		xueshengchengjiService.update(xueshengchengji);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:xueshengchengjiList.do";
	}

//	分页查询
	@RequestMapping("xueshengchengjiList.do")
	public String xueshengchengjiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengchengji xueshengchengji, String xuehao, String xingming, String xingbie, String banji, String xuenian, String xueqi, String kemu, String fenshu1,String fenshu2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(xuenian==null||xuenian.equals("")){pmap.put("xuenian", null);}else{pmap.put("xuenian", xuenian);}
		if(xueqi==null||xueqi.equals("")){pmap.put("xueqi", null);}else{pmap.put("xueqi", xueqi);}
		if(kemu==null||kemu.equals("")){pmap.put("kemu", null);}else{pmap.put("kemu", kemu);}
		if(fenshu1==null||fenshu1.equals("")){pmap.put("fenshu1", null);}else{pmap.put("fenshu1", fenshu1);}
		if(fenshu2==null||fenshu2.equals("")){pmap.put("fenshu2", null);}else{pmap.put("fenshu2", fenshu2);}
		
		int total=xueshengchengjiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengchengji> list=xueshengchengjiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengchengji_list";
	}
	
	@RequestMapping("xueshengchengji_yanben1.do")
	public String xueshengchengji_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengchengji xueshengchengji, String xuehao, String xingming, String xingbie, String banji, String xuenian, String xueqi, String kemu, String fenshu1,String fenshu2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(xuenian==null||xuenian.equals("")){pmap.put("xuenian", null);}else{pmap.put("xuenian", xuenian);}
		if(xueqi==null||xueqi.equals("")){pmap.put("xueqi", null);}else{pmap.put("xueqi", xueqi);}
		if(kemu==null||kemu.equals("")){pmap.put("kemu", null);}else{pmap.put("kemu", kemu);}
		if(fenshu1==null||fenshu1.equals("")){pmap.put("fenshu1", null);}else{pmap.put("fenshu1", fenshu1);}
		if(fenshu2==null||fenshu2.equals("")){pmap.put("fenshu2", null);}else{pmap.put("fenshu2", fenshu2);}
		
		int total=xueshengchengjiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengchengji> list=xueshengchengjiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengchengji_yanben1";
	}
	@RequestMapping("xueshengchengji_yanben2.do")
	public String xueshengchengji_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengchengji xueshengchengji, String xuehao, String xingming, String xingbie, String banji, String xuenian, String xueqi, String kemu, String fenshu1,String fenshu2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(xuenian==null||xuenian.equals("")){pmap.put("xuenian", null);}else{pmap.put("xuenian", xuenian);}
		if(xueqi==null||xueqi.equals("")){pmap.put("xueqi", null);}else{pmap.put("xueqi", xueqi);}
		if(kemu==null||kemu.equals("")){pmap.put("kemu", null);}else{pmap.put("kemu", kemu);}
		if(fenshu1==null||fenshu1.equals("")){pmap.put("fenshu1", null);}else{pmap.put("fenshu1", fenshu1);}
		if(fenshu2==null||fenshu2.equals("")){pmap.put("fenshu2", null);}else{pmap.put("fenshu2", fenshu2);}
		
		int total=xueshengchengjiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengchengji> list=xueshengchengjiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengchengji_yanben2";
	}
	@RequestMapping("xueshengchengji_yanben3.do")
	public String xueshengchengji_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengchengji xueshengchengji, String xuehao, String xingming, String xingbie, String banji, String xuenian, String xueqi, String kemu, String fenshu1,String fenshu2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(xuenian==null||xuenian.equals("")){pmap.put("xuenian", null);}else{pmap.put("xuenian", xuenian);}
		if(xueqi==null||xueqi.equals("")){pmap.put("xueqi", null);}else{pmap.put("xueqi", xueqi);}
		if(kemu==null||kemu.equals("")){pmap.put("kemu", null);}else{pmap.put("kemu", kemu);}
		if(fenshu1==null||fenshu1.equals("")){pmap.put("fenshu1", null);}else{pmap.put("fenshu1", fenshu1);}
		if(fenshu2==null||fenshu2.equals("")){pmap.put("fenshu2", null);}else{pmap.put("fenshu2", fenshu2);}
		
		int total=xueshengchengjiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengchengji> list=xueshengchengjiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengchengji_yanben3";
	}
	@RequestMapping("xueshengchengji_yanben4.do")
	public String xueshengchengji_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengchengji xueshengchengji, String xuehao, String xingming, String xingbie, String banji, String xuenian, String xueqi, String kemu, String fenshu1,String fenshu2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(xuenian==null||xuenian.equals("")){pmap.put("xuenian", null);}else{pmap.put("xuenian", xuenian);}
		if(xueqi==null||xueqi.equals("")){pmap.put("xueqi", null);}else{pmap.put("xueqi", xueqi);}
		if(kemu==null||kemu.equals("")){pmap.put("kemu", null);}else{pmap.put("kemu", kemu);}
		if(fenshu1==null||fenshu1.equals("")){pmap.put("fenshu1", null);}else{pmap.put("fenshu1", fenshu1);}
		if(fenshu2==null||fenshu2.equals("")){pmap.put("fenshu2", null);}else{pmap.put("fenshu2", fenshu2);}
		
		int total=xueshengchengjiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengchengji> list=xueshengchengjiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengchengji_yanben4";
	}
	@RequestMapping("xueshengchengji_yanben5.do")
	public String xueshengchengji_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengchengji xueshengchengji, String xuehao, String xingming, String xingbie, String banji, String xuenian, String xueqi, String kemu, String fenshu1,String fenshu2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(xuenian==null||xuenian.equals("")){pmap.put("xuenian", null);}else{pmap.put("xuenian", xuenian);}
		if(xueqi==null||xueqi.equals("")){pmap.put("xueqi", null);}else{pmap.put("xueqi", xueqi);}
		if(kemu==null||kemu.equals("")){pmap.put("kemu", null);}else{pmap.put("kemu", kemu);}
		if(fenshu1==null||fenshu1.equals("")){pmap.put("fenshu1", null);}else{pmap.put("fenshu1", fenshu1);}
		if(fenshu2==null||fenshu2.equals("")){pmap.put("fenshu2", null);}else{pmap.put("fenshu2", fenshu2);}
		
		int total=xueshengchengjiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengchengji> list=xueshengchengjiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengchengji_yanben5";
	}
	
	@RequestMapping("xueshengchengjiList2.do")
	public String xueshengchengjiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengchengji xueshengchengji, String xuehao, String xingming, String xingbie, String banji, String xuenian, String xueqi, String kemu, String fenshu1,String fenshu2,HttpServletRequest request){
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
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(xuenian==null||xuenian.equals("")){pmap.put("xuenian", null);}else{pmap.put("xuenian", xuenian);}
		if(xueqi==null||xueqi.equals("")){pmap.put("xueqi", null);}else{pmap.put("xueqi", xueqi);}
		if(kemu==null||kemu.equals("")){pmap.put("kemu", null);}else{pmap.put("kemu", kemu);}
		if(fenshu1==null||fenshu1.equals("")){pmap.put("fenshu1", null);}else{pmap.put("fenshu1", fenshu1);}
		if(fenshu2==null||fenshu2.equals("")){pmap.put("fenshu2", null);}else{pmap.put("fenshu2", fenshu2);}
		
		
		int total=xueshengchengjiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengchengji> list=xueshengchengjiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengchengji_list2";
	}
	
	
	@RequestMapping("xscjList.do")
	public String xscjList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengchengji xueshengchengji, String xuehao, String xingming, String xingbie, String banji, String xuenian, String xueqi, String kemu, String fenshu1,String fenshu2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(xuenian==null||xuenian.equals("")){pmap.put("xuenian", null);}else{pmap.put("xuenian", xuenian);}
		if(xueqi==null||xueqi.equals("")){pmap.put("xueqi", null);}else{pmap.put("xueqi", xueqi);}
		if(kemu==null||kemu.equals("")){pmap.put("kemu", null);}else{pmap.put("kemu", kemu);}
		if(fenshu1==null||fenshu1.equals("")){pmap.put("fenshu1", null);}else{pmap.put("fenshu1", fenshu1);}
		if(fenshu2==null||fenshu2.equals("")){pmap.put("fenshu2", null);}else{pmap.put("fenshu2", fenshu2);}
		
		int total=xueshengchengjiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengchengji> list=xueshengchengjiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengchengjilist";
	}
	@RequestMapping("xscjListtp.do")
	public String xscjListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengchengji xueshengchengji, String xuehao, String xingming, String xingbie, String banji, String xuenian, String xueqi, String kemu, String fenshu1,String fenshu2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}
		if(xuenian==null||xuenian.equals("")){pmap.put("xuenian", null);}else{pmap.put("xuenian", xuenian);}
		if(xueqi==null||xueqi.equals("")){pmap.put("xueqi", null);}else{pmap.put("xueqi", xueqi);}
		if(kemu==null||kemu.equals("")){pmap.put("kemu", null);}else{pmap.put("kemu", kemu);}
		if(fenshu1==null||fenshu1.equals("")){pmap.put("fenshu1", null);}else{pmap.put("fenshu1", fenshu1);}
		if(fenshu2==null||fenshu2.equals("")){pmap.put("fenshu2", null);}else{pmap.put("fenshu2", fenshu2);}
		
		int total=xueshengchengjiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengchengji> list=xueshengchengjiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengchengjilisttp";
	}
	
	@RequestMapping("deleteXueshengchengji.do")
	public String deleteXueshengchengji(int id,HttpServletRequest request){
		xueshengchengjiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:xueshengchengjiList.do";
	}
	
	
}
