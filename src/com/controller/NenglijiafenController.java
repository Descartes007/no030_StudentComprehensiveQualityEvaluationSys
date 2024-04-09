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

import com.entity.Nenglijiafen;
import com.server.NenglijiafenServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class NenglijiafenController {
	@Resource
	private NenglijiafenServer nenglijiafenService;


   
	@RequestMapping("addNenglijiafen.do")
	public String addNenglijiafen(HttpServletRequest request,Nenglijiafen nenglijiafen,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		nenglijiafen.setAddtime(time.toString().substring(0, 19));
		nenglijiafenService.add(nenglijiafen);
		
				String sql="";
	sql="update xueshengxinxi set nenglijiafenxiangdefen=nenglijiafenxiangdefen+"+nenglijiafen.getJiafenshu()+" where xuehao='"+nenglijiafen.getXuehao()+"'";
	db dbo = new db();
	dbo.hsgexecute(sql);

		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "nenglijiafenList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:nenglijiafenList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateNenglijiafen.do")
	public String doUpdateNenglijiafen(int id,ModelMap map,Nenglijiafen nenglijiafen){
		nenglijiafen=nenglijiafenService.getById(id);
		map.put("nenglijiafen", nenglijiafen);
		return "nenglijiafen_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("nenglijiafenDetail.do")
	public String nenglijiafenDetail(int id,ModelMap map,Nenglijiafen nenglijiafen){
		nenglijiafen=nenglijiafenService.getById(id);
		map.put("nenglijiafen", nenglijiafen);
		return "nenglijiafen_detail";
	}
//	前台详细
	@RequestMapping("nljfDetail.do")
	public String nljfDetail(int id,ModelMap map,Nenglijiafen nenglijiafen){
		nenglijiafen=nenglijiafenService.getById(id);
		map.put("nenglijiafen", nenglijiafen);
		return "nenglijiafendetail";
	}
//	
	@RequestMapping("updateNenglijiafen.do")
	public String updateNenglijiafen(int id,ModelMap map,Nenglijiafen nenglijiafen,HttpServletRequest request,HttpSession session){
		nenglijiafenService.update(nenglijiafen);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:nenglijiafenList.do";
	}

//	分页查询
	@RequestMapping("nenglijiafenList.do")
	public String nenglijiafenList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Nenglijiafen nenglijiafen, String xuehao, String xingming, String banji, String shifouguoyingyusiji, String shifouguoyingyuliuji, String shifouqudejiaoshizigezheng, String shifouweiyingzhengruwufanxiaoxuexizhe, String fuyiqijianshifouligong, String qita, String jiafenshu1,String jiafenshu2){
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
		if(shifouguoyingyusiji==null||shifouguoyingyusiji.equals("")){pmap.put("shifouguoyingyusiji", null);}else{pmap.put("shifouguoyingyusiji", shifouguoyingyusiji);}
		if(shifouguoyingyuliuji==null||shifouguoyingyuliuji.equals("")){pmap.put("shifouguoyingyuliuji", null);}else{pmap.put("shifouguoyingyuliuji", shifouguoyingyuliuji);}
		if(shifouqudejiaoshizigezheng==null||shifouqudejiaoshizigezheng.equals("")){pmap.put("shifouqudejiaoshizigezheng", null);}else{pmap.put("shifouqudejiaoshizigezheng", shifouqudejiaoshizigezheng);}
		if(shifouweiyingzhengruwufanxiaoxuexizhe==null||shifouweiyingzhengruwufanxiaoxuexizhe.equals("")){pmap.put("shifouweiyingzhengruwufanxiaoxuexizhe", null);}else{pmap.put("shifouweiyingzhengruwufanxiaoxuexizhe", shifouweiyingzhengruwufanxiaoxuexizhe);}
		if(fuyiqijianshifouligong==null||fuyiqijianshifouligong.equals("")){pmap.put("fuyiqijianshifouligong", null);}else{pmap.put("fuyiqijianshifouligong", fuyiqijianshifouligong);}
		if(qita==null||qita.equals("")){pmap.put("qita", null);}else{pmap.put("qita", qita);}
		if(jiafenshu1==null||jiafenshu1.equals("")){pmap.put("jiafenshu1", null);}else{pmap.put("jiafenshu1", jiafenshu1);}
		if(jiafenshu2==null||jiafenshu2.equals("")){pmap.put("jiafenshu2", null);}else{pmap.put("jiafenshu2", jiafenshu2);}
		
		int total=nenglijiafenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Nenglijiafen> list=nenglijiafenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "nenglijiafen_list";
	}
	
	@RequestMapping("nenglijiafen_yanben1.do")
	public String nenglijiafen_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Nenglijiafen nenglijiafen, String xuehao, String xingming, String banji, String shifouguoyingyusiji, String shifouguoyingyuliuji, String shifouqudejiaoshizigezheng, String shifouweiyingzhengruwufanxiaoxuexizhe, String fuyiqijianshifouligong, String qita, String jiafenshu1,String jiafenshu2){
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
		if(shifouguoyingyusiji==null||shifouguoyingyusiji.equals("")){pmap.put("shifouguoyingyusiji", null);}else{pmap.put("shifouguoyingyusiji", shifouguoyingyusiji);}
		if(shifouguoyingyuliuji==null||shifouguoyingyuliuji.equals("")){pmap.put("shifouguoyingyuliuji", null);}else{pmap.put("shifouguoyingyuliuji", shifouguoyingyuliuji);}
		if(shifouqudejiaoshizigezheng==null||shifouqudejiaoshizigezheng.equals("")){pmap.put("shifouqudejiaoshizigezheng", null);}else{pmap.put("shifouqudejiaoshizigezheng", shifouqudejiaoshizigezheng);}
		if(shifouweiyingzhengruwufanxiaoxuexizhe==null||shifouweiyingzhengruwufanxiaoxuexizhe.equals("")){pmap.put("shifouweiyingzhengruwufanxiaoxuexizhe", null);}else{pmap.put("shifouweiyingzhengruwufanxiaoxuexizhe", shifouweiyingzhengruwufanxiaoxuexizhe);}
		if(fuyiqijianshifouligong==null||fuyiqijianshifouligong.equals("")){pmap.put("fuyiqijianshifouligong", null);}else{pmap.put("fuyiqijianshifouligong", fuyiqijianshifouligong);}
		if(qita==null||qita.equals("")){pmap.put("qita", null);}else{pmap.put("qita", qita);}
		if(jiafenshu1==null||jiafenshu1.equals("")){pmap.put("jiafenshu1", null);}else{pmap.put("jiafenshu1", jiafenshu1);}
		if(jiafenshu2==null||jiafenshu2.equals("")){pmap.put("jiafenshu2", null);}else{pmap.put("jiafenshu2", jiafenshu2);}
		
		int total=nenglijiafenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Nenglijiafen> list=nenglijiafenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "nenglijiafen_yanben1";
	}
	@RequestMapping("nenglijiafen_yanben2.do")
	public String nenglijiafen_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Nenglijiafen nenglijiafen, String xuehao, String xingming, String banji, String shifouguoyingyusiji, String shifouguoyingyuliuji, String shifouqudejiaoshizigezheng, String shifouweiyingzhengruwufanxiaoxuexizhe, String fuyiqijianshifouligong, String qita, String jiafenshu1,String jiafenshu2){
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
		if(shifouguoyingyusiji==null||shifouguoyingyusiji.equals("")){pmap.put("shifouguoyingyusiji", null);}else{pmap.put("shifouguoyingyusiji", shifouguoyingyusiji);}
		if(shifouguoyingyuliuji==null||shifouguoyingyuliuji.equals("")){pmap.put("shifouguoyingyuliuji", null);}else{pmap.put("shifouguoyingyuliuji", shifouguoyingyuliuji);}
		if(shifouqudejiaoshizigezheng==null||shifouqudejiaoshizigezheng.equals("")){pmap.put("shifouqudejiaoshizigezheng", null);}else{pmap.put("shifouqudejiaoshizigezheng", shifouqudejiaoshizigezheng);}
		if(shifouweiyingzhengruwufanxiaoxuexizhe==null||shifouweiyingzhengruwufanxiaoxuexizhe.equals("")){pmap.put("shifouweiyingzhengruwufanxiaoxuexizhe", null);}else{pmap.put("shifouweiyingzhengruwufanxiaoxuexizhe", shifouweiyingzhengruwufanxiaoxuexizhe);}
		if(fuyiqijianshifouligong==null||fuyiqijianshifouligong.equals("")){pmap.put("fuyiqijianshifouligong", null);}else{pmap.put("fuyiqijianshifouligong", fuyiqijianshifouligong);}
		if(qita==null||qita.equals("")){pmap.put("qita", null);}else{pmap.put("qita", qita);}
		if(jiafenshu1==null||jiafenshu1.equals("")){pmap.put("jiafenshu1", null);}else{pmap.put("jiafenshu1", jiafenshu1);}
		if(jiafenshu2==null||jiafenshu2.equals("")){pmap.put("jiafenshu2", null);}else{pmap.put("jiafenshu2", jiafenshu2);}
		
		int total=nenglijiafenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Nenglijiafen> list=nenglijiafenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "nenglijiafen_yanben2";
	}
	@RequestMapping("nenglijiafen_yanben3.do")
	public String nenglijiafen_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Nenglijiafen nenglijiafen, String xuehao, String xingming, String banji, String shifouguoyingyusiji, String shifouguoyingyuliuji, String shifouqudejiaoshizigezheng, String shifouweiyingzhengruwufanxiaoxuexizhe, String fuyiqijianshifouligong, String qita, String jiafenshu1,String jiafenshu2){
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
		if(shifouguoyingyusiji==null||shifouguoyingyusiji.equals("")){pmap.put("shifouguoyingyusiji", null);}else{pmap.put("shifouguoyingyusiji", shifouguoyingyusiji);}
		if(shifouguoyingyuliuji==null||shifouguoyingyuliuji.equals("")){pmap.put("shifouguoyingyuliuji", null);}else{pmap.put("shifouguoyingyuliuji", shifouguoyingyuliuji);}
		if(shifouqudejiaoshizigezheng==null||shifouqudejiaoshizigezheng.equals("")){pmap.put("shifouqudejiaoshizigezheng", null);}else{pmap.put("shifouqudejiaoshizigezheng", shifouqudejiaoshizigezheng);}
		if(shifouweiyingzhengruwufanxiaoxuexizhe==null||shifouweiyingzhengruwufanxiaoxuexizhe.equals("")){pmap.put("shifouweiyingzhengruwufanxiaoxuexizhe", null);}else{pmap.put("shifouweiyingzhengruwufanxiaoxuexizhe", shifouweiyingzhengruwufanxiaoxuexizhe);}
		if(fuyiqijianshifouligong==null||fuyiqijianshifouligong.equals("")){pmap.put("fuyiqijianshifouligong", null);}else{pmap.put("fuyiqijianshifouligong", fuyiqijianshifouligong);}
		if(qita==null||qita.equals("")){pmap.put("qita", null);}else{pmap.put("qita", qita);}
		if(jiafenshu1==null||jiafenshu1.equals("")){pmap.put("jiafenshu1", null);}else{pmap.put("jiafenshu1", jiafenshu1);}
		if(jiafenshu2==null||jiafenshu2.equals("")){pmap.put("jiafenshu2", null);}else{pmap.put("jiafenshu2", jiafenshu2);}
		
		int total=nenglijiafenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Nenglijiafen> list=nenglijiafenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "nenglijiafen_yanben3";
	}
	@RequestMapping("nenglijiafen_yanben4.do")
	public String nenglijiafen_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Nenglijiafen nenglijiafen, String xuehao, String xingming, String banji, String shifouguoyingyusiji, String shifouguoyingyuliuji, String shifouqudejiaoshizigezheng, String shifouweiyingzhengruwufanxiaoxuexizhe, String fuyiqijianshifouligong, String qita, String jiafenshu1,String jiafenshu2){
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
		if(shifouguoyingyusiji==null||shifouguoyingyusiji.equals("")){pmap.put("shifouguoyingyusiji", null);}else{pmap.put("shifouguoyingyusiji", shifouguoyingyusiji);}
		if(shifouguoyingyuliuji==null||shifouguoyingyuliuji.equals("")){pmap.put("shifouguoyingyuliuji", null);}else{pmap.put("shifouguoyingyuliuji", shifouguoyingyuliuji);}
		if(shifouqudejiaoshizigezheng==null||shifouqudejiaoshizigezheng.equals("")){pmap.put("shifouqudejiaoshizigezheng", null);}else{pmap.put("shifouqudejiaoshizigezheng", shifouqudejiaoshizigezheng);}
		if(shifouweiyingzhengruwufanxiaoxuexizhe==null||shifouweiyingzhengruwufanxiaoxuexizhe.equals("")){pmap.put("shifouweiyingzhengruwufanxiaoxuexizhe", null);}else{pmap.put("shifouweiyingzhengruwufanxiaoxuexizhe", shifouweiyingzhengruwufanxiaoxuexizhe);}
		if(fuyiqijianshifouligong==null||fuyiqijianshifouligong.equals("")){pmap.put("fuyiqijianshifouligong", null);}else{pmap.put("fuyiqijianshifouligong", fuyiqijianshifouligong);}
		if(qita==null||qita.equals("")){pmap.put("qita", null);}else{pmap.put("qita", qita);}
		if(jiafenshu1==null||jiafenshu1.equals("")){pmap.put("jiafenshu1", null);}else{pmap.put("jiafenshu1", jiafenshu1);}
		if(jiafenshu2==null||jiafenshu2.equals("")){pmap.put("jiafenshu2", null);}else{pmap.put("jiafenshu2", jiafenshu2);}
		
		int total=nenglijiafenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Nenglijiafen> list=nenglijiafenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "nenglijiafen_yanben4";
	}
	@RequestMapping("nenglijiafen_yanben5.do")
	public String nenglijiafen_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Nenglijiafen nenglijiafen, String xuehao, String xingming, String banji, String shifouguoyingyusiji, String shifouguoyingyuliuji, String shifouqudejiaoshizigezheng, String shifouweiyingzhengruwufanxiaoxuexizhe, String fuyiqijianshifouligong, String qita, String jiafenshu1,String jiafenshu2){
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
		if(shifouguoyingyusiji==null||shifouguoyingyusiji.equals("")){pmap.put("shifouguoyingyusiji", null);}else{pmap.put("shifouguoyingyusiji", shifouguoyingyusiji);}
		if(shifouguoyingyuliuji==null||shifouguoyingyuliuji.equals("")){pmap.put("shifouguoyingyuliuji", null);}else{pmap.put("shifouguoyingyuliuji", shifouguoyingyuliuji);}
		if(shifouqudejiaoshizigezheng==null||shifouqudejiaoshizigezheng.equals("")){pmap.put("shifouqudejiaoshizigezheng", null);}else{pmap.put("shifouqudejiaoshizigezheng", shifouqudejiaoshizigezheng);}
		if(shifouweiyingzhengruwufanxiaoxuexizhe==null||shifouweiyingzhengruwufanxiaoxuexizhe.equals("")){pmap.put("shifouweiyingzhengruwufanxiaoxuexizhe", null);}else{pmap.put("shifouweiyingzhengruwufanxiaoxuexizhe", shifouweiyingzhengruwufanxiaoxuexizhe);}
		if(fuyiqijianshifouligong==null||fuyiqijianshifouligong.equals("")){pmap.put("fuyiqijianshifouligong", null);}else{pmap.put("fuyiqijianshifouligong", fuyiqijianshifouligong);}
		if(qita==null||qita.equals("")){pmap.put("qita", null);}else{pmap.put("qita", qita);}
		if(jiafenshu1==null||jiafenshu1.equals("")){pmap.put("jiafenshu1", null);}else{pmap.put("jiafenshu1", jiafenshu1);}
		if(jiafenshu2==null||jiafenshu2.equals("")){pmap.put("jiafenshu2", null);}else{pmap.put("jiafenshu2", jiafenshu2);}
		
		int total=nenglijiafenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Nenglijiafen> list=nenglijiafenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "nenglijiafen_yanben5";
	}
	
	@RequestMapping("nenglijiafenList2.do")
	public String nenglijiafenList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Nenglijiafen nenglijiafen, String xuehao, String xingming, String banji, String shifouguoyingyusiji, String shifouguoyingyuliuji, String shifouqudejiaoshizigezheng, String shifouweiyingzhengruwufanxiaoxuexizhe, String fuyiqijianshifouligong, String qita, String jiafenshu1,String jiafenshu2,HttpServletRequest request){
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
		if(shifouguoyingyusiji==null||shifouguoyingyusiji.equals("")){pmap.put("shifouguoyingyusiji", null);}else{pmap.put("shifouguoyingyusiji", shifouguoyingyusiji);}
		if(shifouguoyingyuliuji==null||shifouguoyingyuliuji.equals("")){pmap.put("shifouguoyingyuliuji", null);}else{pmap.put("shifouguoyingyuliuji", shifouguoyingyuliuji);}
		if(shifouqudejiaoshizigezheng==null||shifouqudejiaoshizigezheng.equals("")){pmap.put("shifouqudejiaoshizigezheng", null);}else{pmap.put("shifouqudejiaoshizigezheng", shifouqudejiaoshizigezheng);}
		if(shifouweiyingzhengruwufanxiaoxuexizhe==null||shifouweiyingzhengruwufanxiaoxuexizhe.equals("")){pmap.put("shifouweiyingzhengruwufanxiaoxuexizhe", null);}else{pmap.put("shifouweiyingzhengruwufanxiaoxuexizhe", shifouweiyingzhengruwufanxiaoxuexizhe);}
		if(fuyiqijianshifouligong==null||fuyiqijianshifouligong.equals("")){pmap.put("fuyiqijianshifouligong", null);}else{pmap.put("fuyiqijianshifouligong", fuyiqijianshifouligong);}
		if(qita==null||qita.equals("")){pmap.put("qita", null);}else{pmap.put("qita", qita);}
		if(jiafenshu1==null||jiafenshu1.equals("")){pmap.put("jiafenshu1", null);}else{pmap.put("jiafenshu1", jiafenshu1);}
		if(jiafenshu2==null||jiafenshu2.equals("")){pmap.put("jiafenshu2", null);}else{pmap.put("jiafenshu2", jiafenshu2);}
		
		
		int total=nenglijiafenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Nenglijiafen> list=nenglijiafenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "nenglijiafen_list2";
	}
	
	
	@RequestMapping("nljfList.do")
	public String nljfList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Nenglijiafen nenglijiafen, String xuehao, String xingming, String banji, String shifouguoyingyusiji, String shifouguoyingyuliuji, String shifouqudejiaoshizigezheng, String shifouweiyingzhengruwufanxiaoxuexizhe, String fuyiqijianshifouligong, String qita, String jiafenshu1,String jiafenshu2){
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
		if(shifouguoyingyusiji==null||shifouguoyingyusiji.equals("")){pmap.put("shifouguoyingyusiji", null);}else{pmap.put("shifouguoyingyusiji", shifouguoyingyusiji);}
		if(shifouguoyingyuliuji==null||shifouguoyingyuliuji.equals("")){pmap.put("shifouguoyingyuliuji", null);}else{pmap.put("shifouguoyingyuliuji", shifouguoyingyuliuji);}
		if(shifouqudejiaoshizigezheng==null||shifouqudejiaoshizigezheng.equals("")){pmap.put("shifouqudejiaoshizigezheng", null);}else{pmap.put("shifouqudejiaoshizigezheng", shifouqudejiaoshizigezheng);}
		if(shifouweiyingzhengruwufanxiaoxuexizhe==null||shifouweiyingzhengruwufanxiaoxuexizhe.equals("")){pmap.put("shifouweiyingzhengruwufanxiaoxuexizhe", null);}else{pmap.put("shifouweiyingzhengruwufanxiaoxuexizhe", shifouweiyingzhengruwufanxiaoxuexizhe);}
		if(fuyiqijianshifouligong==null||fuyiqijianshifouligong.equals("")){pmap.put("fuyiqijianshifouligong", null);}else{pmap.put("fuyiqijianshifouligong", fuyiqijianshifouligong);}
		if(qita==null||qita.equals("")){pmap.put("qita", null);}else{pmap.put("qita", qita);}
		if(jiafenshu1==null||jiafenshu1.equals("")){pmap.put("jiafenshu1", null);}else{pmap.put("jiafenshu1", jiafenshu1);}
		if(jiafenshu2==null||jiafenshu2.equals("")){pmap.put("jiafenshu2", null);}else{pmap.put("jiafenshu2", jiafenshu2);}
		
		int total=nenglijiafenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Nenglijiafen> list=nenglijiafenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "nenglijiafenlist";
	}
	@RequestMapping("nljfListtp.do")
	public String nljfListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Nenglijiafen nenglijiafen, String xuehao, String xingming, String banji, String shifouguoyingyusiji, String shifouguoyingyuliuji, String shifouqudejiaoshizigezheng, String shifouweiyingzhengruwufanxiaoxuexizhe, String fuyiqijianshifouligong, String qita, String jiafenshu1,String jiafenshu2){
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
		if(shifouguoyingyusiji==null||shifouguoyingyusiji.equals("")){pmap.put("shifouguoyingyusiji", null);}else{pmap.put("shifouguoyingyusiji", shifouguoyingyusiji);}
		if(shifouguoyingyuliuji==null||shifouguoyingyuliuji.equals("")){pmap.put("shifouguoyingyuliuji", null);}else{pmap.put("shifouguoyingyuliuji", shifouguoyingyuliuji);}
		if(shifouqudejiaoshizigezheng==null||shifouqudejiaoshizigezheng.equals("")){pmap.put("shifouqudejiaoshizigezheng", null);}else{pmap.put("shifouqudejiaoshizigezheng", shifouqudejiaoshizigezheng);}
		if(shifouweiyingzhengruwufanxiaoxuexizhe==null||shifouweiyingzhengruwufanxiaoxuexizhe.equals("")){pmap.put("shifouweiyingzhengruwufanxiaoxuexizhe", null);}else{pmap.put("shifouweiyingzhengruwufanxiaoxuexizhe", shifouweiyingzhengruwufanxiaoxuexizhe);}
		if(fuyiqijianshifouligong==null||fuyiqijianshifouligong.equals("")){pmap.put("fuyiqijianshifouligong", null);}else{pmap.put("fuyiqijianshifouligong", fuyiqijianshifouligong);}
		if(qita==null||qita.equals("")){pmap.put("qita", null);}else{pmap.put("qita", qita);}
		if(jiafenshu1==null||jiafenshu1.equals("")){pmap.put("jiafenshu1", null);}else{pmap.put("jiafenshu1", jiafenshu1);}
		if(jiafenshu2==null||jiafenshu2.equals("")){pmap.put("jiafenshu2", null);}else{pmap.put("jiafenshu2", jiafenshu2);}
		
		int total=nenglijiafenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Nenglijiafen> list=nenglijiafenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "nenglijiafenlisttp";
	}
	
	@RequestMapping("deleteNenglijiafen.do")
	public String deleteNenglijiafen(int id,HttpServletRequest request){
		nenglijiafenService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:nenglijiafenList.do";
	}
	
	
}
