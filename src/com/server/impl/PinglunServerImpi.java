package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.PinglunMapper;
import com.entity.Pinglun;
import com.server.PinglunServer;
@Service
public class PinglunServerImpi implements PinglunServer {
   @Resource
   private PinglunMapper gdao;
	@Override
	public int add(Pinglun po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Pinglun po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Pinglun> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}

	@Override
	public Pinglun quchongPinglun(Map<String, Object> account) {
		return null;
	}

	@Override
	public List<Pinglun> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Pinglun> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Pinglun getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

