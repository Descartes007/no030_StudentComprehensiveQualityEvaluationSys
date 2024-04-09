package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ZonghecepingMapper;
import com.entity.Zongheceping;
import com.server.ZonghecepingServer;
@Service
public class ZonghecepingServerImpi implements ZonghecepingServer {
   @Resource
   private ZonghecepingMapper gdao;
	@Override
	public int add(Zongheceping po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Zongheceping po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Zongheceping> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Zongheceping> getsyzongheceping1(Map<String, Object> map) {
		return gdao.getsyzongheceping1(map);
	}
	public List<Zongheceping> getsyzongheceping2(Map<String, Object> map) {
		return gdao.getsyzongheceping2(map);
	}
	public List<Zongheceping> getsyzongheceping3(Map<String, Object> map) {
		return gdao.getsyzongheceping3(map);
	}
	
	@Override
	public Zongheceping quchongZongheceping(Map<String, Object> account) {
		return gdao.quchongZongheceping(account);
	}

	@Override
	public List<Zongheceping> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Zongheceping> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Zongheceping getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

