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

import com.entity.Jiaoshixinxi;
import com.server.JiaoshixinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class JiaoshixinxiController {
	@Resource
	private JiaoshixinxiServer jiaoshixinxiService;


   
	@RequestMapping("addJiaoshixinxi.do")
	public String addJiaoshixinxi(HttpServletRequest request,Jiaoshixinxi jiaoshixinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		jiaoshixinxi.setAddtime(time.toString().substring(0, 19));
		jiaoshixinxiService.add(jiaoshixinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "jiaoshixinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:jiaoshixinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateJiaoshixinxi.do")
	public String doUpdateJiaoshixinxi(int id,ModelMap map,Jiaoshixinxi jiaoshixinxi){
		jiaoshixinxi=jiaoshixinxiService.getById(id);
		map.put("jiaoshixinxi", jiaoshixinxi);
		return "jiaoshixinxi_updt";
	}
	
	@RequestMapping("doUpdateJiaoshixinxi2.do")
	public String doUpdateJiaoshixinxi2(ModelMap map,Jiaoshixinxi jiaoshixinxi,HttpServletRequest request){
		jiaoshixinxi=jiaoshixinxiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("jiaoshixinxi", jiaoshixinxi);
		return "jiaoshixinxi_updt2";
	}
	
@RequestMapping("updateJiaoshixinxi2.do")
	public String updateJiaoshixinxi2(int id,ModelMap map,Jiaoshixinxi jiaoshixinxi){
		jiaoshixinxiService.update(jiaoshixinxi);
		return "redirect:doUpdateJiaoshixinxi2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("jiaoshixinxiDetail.do")
	public String jiaoshixinxiDetail(int id,ModelMap map,Jiaoshixinxi jiaoshixinxi){
		jiaoshixinxi=jiaoshixinxiService.getById(id);
		map.put("jiaoshixinxi", jiaoshixinxi);
		return "jiaoshixinxi_detail";
	}
//	前台详细
	@RequestMapping("jsxxDetail.do")
	public String jsxxDetail(int id,ModelMap map,Jiaoshixinxi jiaoshixinxi){
		jiaoshixinxi=jiaoshixinxiService.getById(id);
		map.put("jiaoshixinxi", jiaoshixinxi);
		return "jiaoshixinxidetail";
	}
//	
	@RequestMapping("updateJiaoshixinxi.do")
	public String updateJiaoshixinxi(int id,ModelMap map,Jiaoshixinxi jiaoshixinxi,HttpServletRequest request,HttpSession session){
		jiaoshixinxiService.update(jiaoshixinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:jiaoshixinxiList.do";
	}

//	分页查询
	@RequestMapping("jiaoshixinxiList.do")
	public String jiaoshixinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaoshixinxi jiaoshixinxi, String gonghao, String mima, String xingming, String xingbie, String shenfenzheng, String dianhua, String zhicheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=jiaoshixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaoshixinxi> list=jiaoshixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaoshixinxi_list";
	}
	
	@RequestMapping("jiaoshixinxi_yanben1.do")
	public String jiaoshixinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaoshixinxi jiaoshixinxi, String gonghao, String mima, String xingming, String xingbie, String shenfenzheng, String dianhua, String zhicheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=jiaoshixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaoshixinxi> list=jiaoshixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaoshixinxi_yanben1";
	}
	@RequestMapping("jiaoshixinxi_yanben2.do")
	public String jiaoshixinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaoshixinxi jiaoshixinxi, String gonghao, String mima, String xingming, String xingbie, String shenfenzheng, String dianhua, String zhicheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=jiaoshixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaoshixinxi> list=jiaoshixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaoshixinxi_yanben2";
	}
	@RequestMapping("jiaoshixinxi_yanben3.do")
	public String jiaoshixinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaoshixinxi jiaoshixinxi, String gonghao, String mima, String xingming, String xingbie, String shenfenzheng, String dianhua, String zhicheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=jiaoshixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaoshixinxi> list=jiaoshixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaoshixinxi_yanben3";
	}
	@RequestMapping("jiaoshixinxi_yanben4.do")
	public String jiaoshixinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaoshixinxi jiaoshixinxi, String gonghao, String mima, String xingming, String xingbie, String shenfenzheng, String dianhua, String zhicheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=jiaoshixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaoshixinxi> list=jiaoshixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaoshixinxi_yanben4";
	}
	@RequestMapping("jiaoshixinxi_yanben5.do")
	public String jiaoshixinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaoshixinxi jiaoshixinxi, String gonghao, String mima, String xingming, String xingbie, String shenfenzheng, String dianhua, String zhicheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=jiaoshixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaoshixinxi> list=jiaoshixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaoshixinxi_yanben5";
	}
	
	
	
	@RequestMapping("jsxxList.do")
	public String jsxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaoshixinxi jiaoshixinxi, String gonghao, String mima, String xingming, String xingbie, String shenfenzheng, String dianhua, String zhicheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=jiaoshixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaoshixinxi> list=jiaoshixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaoshixinxilist";
	}
	@RequestMapping("jsxxListtp.do")
	public String jsxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaoshixinxi jiaoshixinxi, String gonghao, String mima, String xingming, String xingbie, String shenfenzheng, String dianhua, String zhicheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=jiaoshixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaoshixinxi> list=jiaoshixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaoshixinxilisttp";
	}
	
	@RequestMapping("deleteJiaoshixinxi.do")
	public String deleteJiaoshixinxi(int id,HttpServletRequest request){
		jiaoshixinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:jiaoshixinxiList.do";
	}
	
	@RequestMapping("quchongJiaoshixinxi.do")
	public void quchongJiaoshixinxi(Jiaoshixinxi jiaoshixinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("gonghao", jiaoshixinxi.getGonghao());
		   System.out.println("gonghao==="+jiaoshixinxi.getGonghao());
		   System.out.println("gonghao222==="+jiaoshixinxiService.quchongJiaoshixinxi(map));
		   JSONObject obj=new JSONObject();
		   if(jiaoshixinxiService.quchongJiaoshixinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "工号可以用！");
				  
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
