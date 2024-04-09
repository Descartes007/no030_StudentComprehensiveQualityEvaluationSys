package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JiangchengxinxiMapper;
import com.entity.Jiangchengxinxi;
import com.server.JiangchengxinxiServer;
@Service
public class JiangchengxinxiServerImpi implements JiangchengxinxiServer {
   @Resource
   private JiangchengxinxiMapper gdao;
	@Override
	public int add(Jiangchengxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jiangchengxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jiangchengxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jiangchengxinxi> getsyjiangchengxinxi1(Map<String, Object> map) {
		return gdao.getsyjiangchengxinxi1(map);
	}
	public List<Jiangchengxinxi> getsyjiangchengxinxi2(Map<String, Object> map) {
		return gdao.getsyjiangchengxinxi2(map);
	}
	public List<Jiangchengxinxi> getsyjiangchengxinxi3(Map<String, Object> map) {
		return gdao.getsyjiangchengxinxi3(map);
	}
	
	@Override
	public Jiangchengxinxi quchongJiangchengxinxi(Map<String, Object> account) {
		return gdao.quchongJiangchengxinxi(account);
	}

	@Override
	public List<Jiangchengxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jiangchengxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jiangchengxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

