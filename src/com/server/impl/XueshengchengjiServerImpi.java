package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.XueshengchengjiMapper;
import com.entity.Xueshengchengji;
import com.server.XueshengchengjiServer;
@Service
public class XueshengchengjiServerImpi implements XueshengchengjiServer {
   @Resource
   private XueshengchengjiMapper gdao;
	@Override
	public int add(Xueshengchengji po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Xueshengchengji po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Xueshengchengji> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Xueshengchengji> getsyxueshengchengji1(Map<String, Object> map) {
		return gdao.getsyxueshengchengji1(map);
	}
	public List<Xueshengchengji> getsyxueshengchengji2(Map<String, Object> map) {
		return gdao.getsyxueshengchengji2(map);
	}
	public List<Xueshengchengji> getsyxueshengchengji3(Map<String, Object> map) {
		return gdao.getsyxueshengchengji3(map);
	}
	
	@Override
	public Xueshengchengji quchongXueshengchengji(Map<String, Object> account) {
		return gdao.quchongXueshengchengji(account);
	}

	@Override
	public List<Xueshengchengji> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Xueshengchengji> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Xueshengchengji getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

