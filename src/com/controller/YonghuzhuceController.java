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

import com.entity.Yonghuzhuce;
import com.server.YonghuzhuceServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class YonghuzhuceController {
	@Resource
	private YonghuzhuceServer yonghuzhuceService;


   
	@RequestMapping("addYonghuzhuce.do")
	public String addYonghuzhuce(HttpServletRequest request,Yonghuzhuce yonghuzhuce,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		yonghuzhuce.setAddtime(time.toString().substring(0, 19));
		yonghuzhuceService.add(yonghuzhuce);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "yonghuzhuceList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:yonghuzhuceList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateYonghuzhuce.do")
	public String doUpdateYonghuzhuce(int id,ModelMap map,Yonghuzhuce yonghuzhuce){
		yonghuzhuce=yonghuzhuceService.getById(id);
		map.put("yonghuzhuce", yonghuzhuce);
		return "yonghuzhuce_updt";
	}
	
	@RequestMapping("doUpdateYonghuzhuce2.do")
	public String doUpdateYonghuzhuce2(ModelMap map,Yonghuzhuce yonghuzhuce,HttpServletRequest request){
		yonghuzhuce=yonghuzhuceService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("yonghuzhuce", yonghuzhuce);
		return "yonghuzhuce_updt2";
	}
	
@RequestMapping("updateYonghuzhuce2.do")
	public String updateYonghuzhuce2(int id,ModelMap map,Yonghuzhuce yonghuzhuce){
		yonghuzhuceService.update(yonghuzhuce);
		return "redirect:doUpdateYonghuzhuce2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("yonghuzhuceDetail.do")
	public String yonghuzhuceDetail(int id,ModelMap map,Yonghuzhuce yonghuzhuce){
		yonghuzhuce=yonghuzhuceService.getById(id);
		map.put("yonghuzhuce", yonghuzhuce);
		return "yonghuzhuce_detail";
	}
//	前台详细
	@RequestMapping("yhzcDetail.do")
	public String yhzcDetail(int id,ModelMap map,Yonghuzhuce yonghuzhuce){
		yonghuzhuce=yonghuzhuceService.getById(id);
		map.put("yonghuzhuce", yonghuzhuce);
		return "yonghuzhucedetail";
	}
//	
	@RequestMapping("updateYonghuzhuce.do")
	public String updateYonghuzhuce(int id,ModelMap map,Yonghuzhuce yonghuzhuce,HttpServletRequest request,HttpSession session){
		yonghuzhuceService.update(yonghuzhuce);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:yonghuzhuceList.do";
	}

//	分页查询
	@RequestMapping("yonghuzhuceList.do")
	public String yonghuzhuceList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yonghuzhuce yonghuzhuce, String yonghuming, String mima, String xingming, String xingbie, String chushengnianyue1,String chushengnianyue2, String QQ, String youxiang, String shouji, String shenfenzheng, String touxiang, String dizhi, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(chushengnianyue1==null||chushengnianyue1.equals("")){pmap.put("chushengnianyue1", null);}else{pmap.put("chushengnianyue1", chushengnianyue1);}
		if(chushengnianyue2==null||chushengnianyue2.equals("")){pmap.put("chushengnianyue2", null);}else{pmap.put("chushengnianyue2", chushengnianyue2);}
		if(QQ==null||QQ.equals("")){pmap.put("QQ", null);}else{pmap.put("QQ", QQ);}
		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(touxiang==null||touxiang.equals("")){pmap.put("touxiang", null);}else{pmap.put("touxiang", touxiang);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=yonghuzhuceService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yonghuzhuce> list=yonghuzhuceService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yonghuzhuce_list";
	}
	
	
	
	@RequestMapping("yhzcList.do")
	public String yhzcList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yonghuzhuce yonghuzhuce, String yonghuming, String mima, String xingming, String xingbie, String chushengnianyue1,String chushengnianyue2, String QQ, String youxiang, String shouji, String shenfenzheng, String touxiang, String dizhi, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(chushengnianyue1==null||chushengnianyue1.equals("")){pmap.put("chushengnianyue1", null);}else{pmap.put("chushengnianyue1", chushengnianyue1);}
		if(chushengnianyue2==null||chushengnianyue2.equals("")){pmap.put("chushengnianyue2", null);}else{pmap.put("chushengnianyue2", chushengnianyue2);}
		if(QQ==null||QQ.equals("")){pmap.put("QQ", null);}else{pmap.put("QQ", QQ);}
		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(touxiang==null||touxiang.equals("")){pmap.put("touxiang", null);}else{pmap.put("touxiang", touxiang);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=yonghuzhuceService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yonghuzhuce> list=yonghuzhuceService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yonghuzhucelist";
	}
	
	@RequestMapping("deleteYonghuzhuce.do")
	public String deleteYonghuzhuce(int id,HttpServletRequest request){
		yonghuzhuceService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:yonghuzhuceList.do";
	}
	
	@RequestMapping("quchongYonghuzhuce.do")
	public void quchongYonghuzhuce(Yonghuzhuce yonghuzhuce,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("yonghuming", yonghuzhuce.getYonghuming());
		   System.out.println("yonghuming==="+yonghuzhuce.getYonghuming());
		   System.out.println("yonghuming222==="+yonghuzhuceService.quchongYonghuzhuce(map));
		   JSONObject obj=new JSONObject();
		   if(yonghuzhuceService.quchongYonghuzhuce(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "用户名可以用！");
				  
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
