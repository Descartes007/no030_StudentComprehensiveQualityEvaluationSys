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

import com.entity.Allusers;
//import com.chengxusheji.po.News;
import com.server.AllusersServer;
import com.util.PageBean;
import net.sf.json.JSONObject;

@Controller
public class AllusersController {
	@Resource
	private AllusersServer allusersService;


//	
   @RequestMapping("showAllusers.do")
   public String showAllusers(int id,ModelMap map,HttpSession session){
	 /*  Map<String,Object> bmap=new HashMap<String,Object>();
	   bmap.put("uid", id);*/
	  // map.put("blist", allusersService.getAll(bmap));
	   map.put("allusers", allusersService.getById(id));
	   return "read";
   }
   
	@RequestMapping("addAllusers.do")
	public String addAllusers(HttpServletRequest request,Allusers allusers,HttpSession session){
		Timestamp time=new Timestamp(System.currentTimeMillis());
		//Users u=(Users)session.getAttribute("user");
		/*if(u==null||u.equals("")){
			return "redirect:showIndex.do";
		}else{*/
			//bbs.setUid(u.getId());
			/*bbs.setPubtime(time.toString());
			bbs.setIsdel("1");*/
		    allusers.setAddtime(time.toString().substring(0, 19));
			allusersService.add(allusers);
			return "redirect:allusersList.do";
		/*}*/
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateAllusers.do")
	public String doUpdateAllusers(int id,ModelMap map,Allusers allusers){
		allusers=allusersService.getById(id);
		map.put("allusers", allusers);
		return "allusers_updt";
	}
//	
	@RequestMapping("updateAllusers.do")
	public String updateAllusers(int id,ModelMap map,Allusers allusers){
		allusersService.update(allusers);
		return "redirect:allusersList.do";
	}
//	所有List
//	@RequestMapping("allusersList.do")
//	public String allusersList(ModelMap map,HttpSession session){
//		map.put("list", allusersService.getAll(null));
//		map.put("clist", allusersService.getAll(null));
//		return "allusers";
//	}
//	分页查询
	@RequestMapping("allusersList.do")
	public String goodList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Allusers allusers, String username, String pwd, String cx){
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
		Map<String, Object> bmap=new HashMap<String, Object>();
		Map<String,Object> cmap=new HashMap<String,Object>();
		/*pmap.put("uid",  ((Users)session.getAttribute("user")).getId());
		bmap.put("uid", ((Users)session.getAttribute("user")).getId());*/
		if(username==null||username.equals("")){pmap.put("username", null);cmap.put("username", null);}else{pmap.put("username", username);cmap.put("username", username);}
		if(pwd==null||pwd.equals("")){pmap.put("pwd", null);cmap.put("pwd", null);}else{pmap.put("pwd", pwd);cmap.put("pwd", pwd);}
		if(cx==null||cx.equals("")){pmap.put("cx", null);cmap.put("cx", null);}else{pmap.put("cx", cx);cmap.put("cx", cx);}
		
		int total=allusersService.getCount(bmap);
		pageBean.setTotal(total);
		List<Allusers> list=allusersService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "allusers_list";
	}
//   分页模糊查询
	@RequestMapping("vagueAllusersList.do")
	public String vagueAllusersList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),PageBean.PAGESIZE);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", pageBean.getPageSize());
		Map<String, Object> bmap=new HashMap<String, Object>();
		/*pmap.put("uid",  ((Users)session.getAttribute("user")).getId());
		bmap.put("uid",  ((Users)session.getAttribute("user")).getId());*/
		int total=allusersService.getCount(bmap);
		pageBean.setTotal(total);
		List<Allusers> list=allusersService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 2);
		return "queryallusers";
	}
	@RequestMapping("deleteAllusers.do")
	public String deleteAllusers(int id){
		allusersService.delete(id);
		return "redirect:allusersList.do";
	}
	
	@RequestMapping("quchongAllusers.do")
	public void quchongAllusers(Allusers allusers,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("username", allusers.getUsername());
		   System.out.println("username==="+allusers.getUsername());
		   System.out.println("username222==="+allusersService.quchongAllusers(map));
		   JSONObject obj=new JSONObject();
		   if(allusersService.quchongAllusers(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "username可以用！");
				  
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
	
	@RequestMapping("Alluserslogin.do")
	public String checkAllusersLogin(Allusers allusers, HttpSession session) {
		Map<String,Object> u=new HashMap<String,Object>();
		System.out.println("name===" + allusers.getUsername());
		u.put("username",allusers.getUsername());
		//u.put("utype", "用户");
		//Md5.MD5HexEncode(user.getPassword())
		u.put("pwd",allusers.getPwd());
		allusers = allusersService.allusersLogin(u);
		if (allusers != null) {
			session.setAttribute("username", allusers);
			System.out.println("username=" + allusers);
			session.removeAttribute("suc");
			return "redirect:index.do";
		} else {
			System.out.println("usernafwfwwme=");
			session.setAttribute("suc", "登录失败！用户名或密码错误！");
			return "login";
		}

	}
}
