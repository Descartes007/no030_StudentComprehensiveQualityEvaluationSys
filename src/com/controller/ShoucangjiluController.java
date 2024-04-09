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

import com.entity.Shoucangjilu;
//import com.chengxusheji.po.News;
import com.server.ShoucangjiluServer;
import com.util.PageBean;
import net.sf.json.JSONObject;

@Controller
public class ShoucangjiluController {
	@Resource
	private ShoucangjiluServer shoucangjiluService;


//	
   @RequestMapping("showShoucangjilu.do")
   public String showShoucangjilu(int id,ModelMap map,HttpSession session){
	 /*  Map<String,Object> bmap=new HashMap<String,Object>();
	   bmap.put("uid", id);*/
	  // map.put("blist", shoucangjiluService.getAll(bmap));
	   map.put("shoucangjilu", shoucangjiluService.getById(id));
	   return "read";
   }
   
	@RequestMapping("addShoucangjilu.do")
	public String addShoucangjilu(HttpServletRequest request,Shoucangjilu shoucangjilu,HttpSession session){
		Timestamp time=new Timestamp(System.currentTimeMillis());
		//Users u=(Users)session.getAttribute("user");
		/*if(u==null||u.equals("")){
			return "redirect:showIndex.do";
		}else{*/
			
		    shoucangjilu.setAddtime(time.toString().substring(0, 19));
			shoucangjiluService.add(shoucangjilu);
			session.setAttribute("backxx", "添加成功");
			session.setAttribute("backurl", "shoucangjiluList.do");
			return "redirect:postback.jsp";
			//return "redirect:shoucangjiluList.do";
		/*}*/
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShoucangjilu.do")
	public String doUpdateShoucangjilu(int id,ModelMap map,Shoucangjilu shoucangjilu){
		shoucangjilu=shoucangjiluService.getById(id);
		map.put("shoucangjilu", shoucangjilu);
		return "shoucangjilu_updt";
	}
//	后台详细
	@RequestMapping("ShoucangjiluDetail.do")
	public String ShoucangjiluDetail(int id,ModelMap map,Shoucangjilu shoucangjilu){
		shoucangjilu=shoucangjiluService.getById(id);
		map.put("shoucangjilu", shoucangjilu);
		return "shoucangjilu_detail";
	}
//	前台详细
	@RequestMapping("scjlDetail.do")
	public String scjlDetail(int id,ModelMap map,Shoucangjilu shoucangjilu){
		shoucangjilu=shoucangjiluService.getById(id);
		map.put("shoucangjilu", shoucangjilu);
		return "shoucangjiludetail";
	}
//	
	@RequestMapping("updateShoucangjilu.do")
	public String updateShoucangjilu(int id,ModelMap map,Shoucangjilu shoucangjilu){
		shoucangjiluService.update(shoucangjilu);
		return "redirect:shoucangjiluList.do";
	}
//	所有List
//	@RequestMapping("shoucangjiluList.do")
//	public String shoucangjiluList(ModelMap map,HttpSession session){
//		map.put("list", shoucangjiluService.getAll(null));
//		map.put("clist", shoucangjiluService.getAll(null));
//		return "shoucangjilu";
//	}
//	分页查询
	@RequestMapping("shoucangjiluList.do")
	public String shoucangjiluList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shoucangjilu shoucangjilu, String username, String xwid, String ziduan, String biao){
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
		
		
		if(username==null||username.equals("")){pmap.put("username", null);}else{pmap.put("username", username);}
		if(xwid==null||xwid.equals("")){pmap.put("xwid", null);}else{pmap.put("xwid", xwid);}
		if(ziduan==null||ziduan.equals("")){pmap.put("ziduan", null);}else{pmap.put("ziduan", ziduan);}
		if(biao==null||biao.equals("")){pmap.put("biao", null);}else{pmap.put("biao", biao);}
		
		int total=shoucangjiluService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shoucangjilu> list=shoucangjiluService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shoucangjilu_list";
	}
	
	@RequestMapping("shoucangjiluList2.do")
	public String shoucangjiluList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shoucangjilu shoucangjilu, String username, String xwid, String ziduan, String biao,HttpServletRequest request){
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
		
		pmap.put("username", (String)request.getSession().getAttribute("username"));
		if(xwid==null||xwid.equals("")){pmap.put("xwid", null);}else{pmap.put("xwid", xwid);}
		if(ziduan==null||ziduan.equals("")){pmap.put("ziduan", null);}else{pmap.put("ziduan", ziduan);}
		if(biao==null||biao.equals("")){pmap.put("biao", null);}else{pmap.put("biao", biao);}
		
		int total=shoucangjiluService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shoucangjilu> list=shoucangjiluService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shoucangjilu_list2";
	}
	
	@RequestMapping("scjlList.do")
	public String scjlList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shoucangjilu shoucangjilu, String username, String xwid, String ziduan, String biao){
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
		
		
		if(username==null||username.equals("")){pmap.put("username", null);}else{pmap.put("username", username);}
		if(xwid==null||xwid.equals("")){pmap.put("xwid", null);}else{pmap.put("xwid", xwid);}
		if(ziduan==null||ziduan.equals("")){pmap.put("ziduan", null);}else{pmap.put("ziduan", ziduan);}
		if(biao==null||biao.equals("")){pmap.put("biao", null);}else{pmap.put("biao", biao);}
		
		int total=shoucangjiluService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shoucangjilu> list=shoucangjiluService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shoucangjilulist";
	}
	
	@RequestMapping("deleteShoucangjilu.do")
	public String deleteShoucangjilu(int id,HttpServletRequest request){
		shoucangjiluService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
	}
	
	
}
