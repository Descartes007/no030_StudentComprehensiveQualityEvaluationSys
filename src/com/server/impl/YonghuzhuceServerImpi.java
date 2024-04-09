package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.YonghuzhuceMapper;
import com.entity.Yonghuzhuce;
import com.server.YonghuzhuceServer;
@Service
public class YonghuzhuceServerImpi implements YonghuzhuceServer {
   @Resource
   private YonghuzhuceMapper gdao;
	@Override
	public int add(Yonghuzhuce po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Yonghuzhuce po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Yonghuzhuce> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Yonghuzhuce> getsyyonghuzhuce1(Map<String, Object> map) {
		return gdao.getsyyonghuzhuce1(map);
	}
	public List<Yonghuzhuce> getsyyonghuzhuce2(Map<String, Object> map) {
		return gdao.getsyyonghuzhuce2(map);
	}
	public List<Yonghuzhuce> getsyyonghuzhuce3(Map<String, Object> map) {
		return gdao.getsyyonghuzhuce3(map);
	}
	
	@Override
	public Yonghuzhuce quchongYonghuzhuce(Map<String, Object> account) {
		return gdao.quchongYonghuzhuce(account);
	}

	@Override
	public List<Yonghuzhuce> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Yonghuzhuce> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Yonghuzhuce getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

