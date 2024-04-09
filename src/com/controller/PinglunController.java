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

import com.entity.Pinglun;
//import com.chengxusheji.po.News;
import com.server.PinglunServer;
import com.util.PageBean;
import net.sf.json.JSONObject;

@Controller
public class PinglunController {
	@Resource
	private PinglunServer pinglunService;


//	
   @RequestMapping("showPinglun.do")
   public String showPinglun(int id,ModelMap map,HttpSession session){
	 /*  Map<String,Object> bmap=new HashMap<String,Object>();
	   bmap.put("uid", id);*/
	  // map.put("blist", pinglunService.getAll(bmap));
	   map.put("pinglun", pinglunService.getById(id));
	   return "read";
   }
   
	@RequestMapping("addPinglun.do")
	public String addPinglun(HttpServletRequest request,Pinglun pinglun,HttpSession session){
		Timestamp time=new Timestamp(System.currentTimeMillis());
		//Users u=(Users)session.getAttribute("user");
		/*if(u==null||u.equals("")){
			return "redirect:showIndex.do";
		}else{*/
			
		    pinglun.setAddtime(time.toString().substring(0, 19));
			pinglunService.add(pinglun);
			session.setAttribute("backxx", "添加成功");
			session.setAttribute("backurl", "hsgpinglun.jsp?ok=1");
			return "redirect:postback.jsp";
			//return "redirect:pinglunList.do";
		/*}*/
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdatePinglun.do")
	public String doUpdatePinglun(int id,ModelMap map,Pinglun pinglun){
		pinglun=pinglunService.getById(id);
		map.put("pinglun", pinglun);
		return "pinglun_updt";
	}
//	后台详细
	@RequestMapping("PinglunDetail.do")
	public String PinglunDetail(int id,ModelMap map,Pinglun pinglun){
		pinglun=pinglunService.getById(id);
		map.put("pinglun", pinglun);
		return "pinglun_detail";
	}
//	前台详细
	@RequestMapping("plDetail.do")
	public String plDetail(int id,ModelMap map,Pinglun pinglun){
		pinglun=pinglunService.getById(id);
		map.put("pinglun", pinglun);
		return "pinglundetail";
	}
//	
	@RequestMapping("updatePinglun.do")
	public String updatePinglun(int id,ModelMap map,Pinglun pinglun){
		pinglunService.update(pinglun);
		return "redirect:pinglunList.do";
	}
//	所有List
//	@RequestMapping("pinglunList.do")
//	public String pinglunList(ModelMap map,HttpSession session){
//		map.put("list", pinglunService.getAll(null));
//		map.put("clist", pinglunService.getAll(null));
//		return "pinglun";
//	}
//	分页查询
	@RequestMapping("pinglunList.do")
	public String pinglunList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Pinglun pinglun, String xinwenID, String pinglunneirong, String pinglunren, String pingfen, String biao){
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
		
		
		if(xinwenID==null||xinwenID.equals("")){pmap.put("xinwenID", null);}else{pmap.put("xinwenID", xinwenID);}
		if(pinglunneirong==null||pinglunneirong.equals("")){pmap.put("pinglunneirong", null);}else{pmap.put("pinglunneirong", pinglunneirong);}
		if(pinglunren==null||pinglunren.equals("")){pmap.put("pinglunren", null);}else{pmap.put("pinglunren", pinglunren);}
		if(pingfen==null||pingfen.equals("")){pmap.put("pingfen", null);}else{pmap.put("pingfen", pingfen);}
		if(biao==null||biao.equals("")){pmap.put("biao", null);}else{pmap.put("biao", biao);}
		
		int total=pinglunService.getCount(pmap);
		pageBean.setTotal(total);
		List<Pinglun> list=pinglunService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "pinglun_list";
	}
	
	@RequestMapping("plList.do")
	public String plList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Pinglun pinglun, String xinwenID, String pinglunneirong, String pinglunren, String pingfen, String biao){
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
		
		
		if(xinwenID==null||xinwenID.equals("")){pmap.put("xinwenID", null);}else{pmap.put("xinwenID", xinwenID);}
		if(pinglunneirong==null||pinglunneirong.equals("")){pmap.put("pinglunneirong", null);}else{pmap.put("pinglunneirong", pinglunneirong);}
		if(pinglunren==null||pinglunren.equals("")){pmap.put("pinglunren", null);}else{pmap.put("pinglunren", pinglunren);}
		if(pingfen==null||pingfen.equals("")){pmap.put("pingfen", null);}else{pmap.put("pingfen", pingfen);}
		if(biao==null||biao.equals("")){pmap.put("biao", null);}else{pmap.put("biao", biao);}
		
		int total=pinglunService.getCount(pmap);
		pageBean.setTotal(total);
		List<Pinglun> list=pinglunService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "pinglunlist";
	}
	
	@RequestMapping("deletePinglun.do")
	public String deletePinglun(int id){
		pinglunService.delete(id);
		return "redirect:pinglunList.do";
	}
	
	
}
