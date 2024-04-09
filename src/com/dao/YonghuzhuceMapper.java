package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Yonghuzhuce;

public interface YonghuzhuceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Yonghuzhuce record);

    int insertSelective(Yonghuzhuce record);

    Yonghuzhuce selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Yonghuzhuce record);
	
    int updateByPrimaryKey(Yonghuzhuce record);
	public Yonghuzhuce quchongYonghuzhuce(Map<String, Object> yonghuming);
	public List<Yonghuzhuce> getAll(Map<String, Object> map);
	public List<Yonghuzhuce> getsyyonghuzhuce1(Map<String, Object> map);
	public List<Yonghuzhuce> getsyyonghuzhuce3(Map<String, Object> map);
	public List<Yonghuzhuce> getsyyonghuzhuce2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Yonghuzhuce> getByPage(Map<String, Object> map);
	public List<Yonghuzhuce> select(Map<String, Object> map);
//	所有List
}

