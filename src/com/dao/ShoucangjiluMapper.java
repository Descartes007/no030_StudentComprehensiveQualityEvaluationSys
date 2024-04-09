package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shoucangjilu;

public interface ShoucangjiluMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shoucangjilu record);

    int insertSelective(Shoucangjilu record);

    Shoucangjilu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shoucangjilu record);

    int updateByPrimaryKey(Shoucangjilu record);
	public Shoucangjilu quchongShoucangjilu(Map<String, Object> uname);
	public List<Shoucangjilu> getAll(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shoucangjilu> getByPage(Map<String, Object> map);
	public List<Shoucangjilu> select(Map<String, Object> map);
//	所有List
}

