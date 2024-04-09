package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.XueshengxinxiMapper;
import com.entity.Xueshengxinxi;
import com.server.XueshengxinxiServer;
@Service
public class XueshengxinxiServerImpi implements XueshengxinxiServer {
   @Resource
   private XueshengxinxiMapper gdao;
	@Override
	public int add(Xueshengxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Xueshengxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Xueshengxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Xueshengxinxi> getsyxueshengxinxi1(Map<String, Object> map) {
		return gdao.getsyxueshengxinxi1(map);
	}
	public List<Xueshengxinxi> getsyxueshengxinxi2(Map<String, Object> map) {
		return gdao.getsyxueshengxinxi2(map);
	}
	public List<Xueshengxinxi> getsyxueshengxinxi3(Map<String, Object> map) {
		return gdao.getsyxueshengxinxi3(map);
	}
	
	@Override
	public Xueshengxinxi quchongXueshengxinxi(Map<String, Object> account) {
		return gdao.quchongXueshengxinxi(account);
	}

	@Override
	public List<Xueshengxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Xueshengxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Xueshengxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

