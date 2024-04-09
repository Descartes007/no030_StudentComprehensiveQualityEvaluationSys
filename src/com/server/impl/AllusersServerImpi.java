package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.AllusersMapper;
import com.entity.Allusers;

import com.server.AllusersServer;
@Service
public class AllusersServerImpi implements AllusersServer {
   @Resource
   private AllusersMapper gdao;
   
   @Override
	public Allusers allusersLogin(Map<String, Object> po) {
		System.out.println("userdao---");
		return gdao.allusersLogin(po);
	}
   
	@Override
	public int add(Allusers po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Allusers po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Allusers> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}

	@Override
	public Allusers quchongAllusers(Map<String, Object> account) {
		return null;
	}

	@Override
	public List<Allusers> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Allusers> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Allusers getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

