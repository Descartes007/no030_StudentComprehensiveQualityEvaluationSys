package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JiaoshixinxiMapper;
import com.entity.Jiaoshixinxi;
import com.server.JiaoshixinxiServer;
@Service
public class JiaoshixinxiServerImpi implements JiaoshixinxiServer {
   @Resource
   private JiaoshixinxiMapper gdao;
	@Override
	public int add(Jiaoshixinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jiaoshixinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jiaoshixinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jiaoshixinxi> getsyjiaoshixinxi1(Map<String, Object> map) {
		return gdao.getsyjiaoshixinxi1(map);
	}
	public List<Jiaoshixinxi> getsyjiaoshixinxi2(Map<String, Object> map) {
		return gdao.getsyjiaoshixinxi2(map);
	}
	public List<Jiaoshixinxi> getsyjiaoshixinxi3(Map<String, Object> map) {
		return gdao.getsyjiaoshixinxi3(map);
	}
	
	@Override
	public Jiaoshixinxi quchongJiaoshixinxi(Map<String, Object> account) {
		return gdao.quchongJiaoshixinxi(account);
	}

	@Override
	public List<Jiaoshixinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jiaoshixinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jiaoshixinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

