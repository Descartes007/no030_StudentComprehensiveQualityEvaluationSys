package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.YouqinglianjieMapper;
import com.entity.Youqinglianjie;
import com.server.YouqinglianjieServer;
@Service
public class YouqinglianjieServerImpi implements YouqinglianjieServer {
   @Resource
   private YouqinglianjieMapper gdao;
	@Override
	public int add(Youqinglianjie po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Youqinglianjie po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Youqinglianjie> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Youqinglianjie> getsyyouqinglianjie1(Map<String, Object> map) {
		return gdao.getsyyouqinglianjie1(map);
	}
	public List<Youqinglianjie> getsyyouqinglianjie2(Map<String, Object> map) {
		return gdao.getsyyouqinglianjie2(map);
	}
	public List<Youqinglianjie> getsyyouqinglianjie3(Map<String, Object> map) {
		return gdao.getsyyouqinglianjie3(map);
	}
	
	@Override
	public Youqinglianjie quchongYouqinglianjie(Map<String, Object> account) {
		return gdao.quchongYouqinglianjie(account);
	}

	@Override
	public List<Youqinglianjie> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Youqinglianjie> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Youqinglianjie getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

