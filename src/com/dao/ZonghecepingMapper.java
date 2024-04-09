package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Zongheceping;

public interface ZonghecepingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zongheceping record);

    int insertSelective(Zongheceping record);

    Zongheceping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zongheceping record);
	
    int updateByPrimaryKey(Zongheceping record);
	public Zongheceping quchongZongheceping(Map<String, Object> xuehao);
	public List<Zongheceping> getAll(Map<String, Object> map);
	public List<Zongheceping> getsyzongheceping1(Map<String, Object> map);
	public List<Zongheceping> getsyzongheceping3(Map<String, Object> map);
	public List<Zongheceping> getsyzongheceping2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Zongheceping> getByPage(Map<String, Object> map);
	public List<Zongheceping> select(Map<String, Object> map);
//	所有List
}

