package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Pinglun;

public interface PinglunMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pinglun record);

    int insertSelective(Pinglun record);

    Pinglun selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pinglun record);

    int updateByPrimaryKey(Pinglun record);
	public Pinglun quchongPinglun(Map<String, Object> uname);
	public List<Pinglun> getAll(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Pinglun> getByPage(Map<String, Object> map);
	public List<Pinglun> select(Map<String, Object> map);
//	所有List
}

