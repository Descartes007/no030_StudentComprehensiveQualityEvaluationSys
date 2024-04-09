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
import com.server.AllusersServer;


import com.util.PageBean;
import net.sf.json.JSONObject;

@Controller
public class hsgloginController {
	@Resource
	private AllusersServer allusersService;




	
	@RequestMapping("hsglogin.do")
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
