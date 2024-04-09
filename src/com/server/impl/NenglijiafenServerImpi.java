package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.NenglijiafenMapper;
import com.entity.Nenglijiafen;
import com.server.NenglijiafenServer;
@Service
public class NenglijiafenServerImpi implements NenglijiafenServer {
   @Resource
   private NenglijiafenMapper gdao;
	@Override
	public int add(Nenglijiafen po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Nenglijiafen po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Nenglijiafen> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Nenglijiafen> getsynenglijiafen1(Map<String, Object> map) {
		return gdao.getsynenglijiafen1(map);
	}
	public List<Nenglijiafen> getsynenglijiafen2(Map<String, Object> map) {
		return gdao.getsynenglijiafen2(map);
	}
	public List<Nenglijiafen> getsynenglijiafen3(Map<String, Object> map) {
		return gdao.getsynenglijiafen3(map);
	}
	
	@Override
	public Nenglijiafen quchongNenglijiafen(Map<String, Object> account) {
		return gdao.quchongNenglijiafen(account);
	}

	@Override
	public List<Nenglijiafen> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Nenglijiafen> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Nenglijiafen getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

