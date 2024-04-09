package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jiaoshixinxi;

public interface JiaoshixinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jiaoshixinxi record);

    int insertSelective(Jiaoshixinxi record);

    Jiaoshixinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jiaoshixinxi record);
	
    int updateByPrimaryKey(Jiaoshixinxi record);
	public Jiaoshixinxi quchongJiaoshixinxi(Map<String, Object> gonghao);
	public List<Jiaoshixinxi> getAll(Map<String, Object> map);
	public List<Jiaoshixinxi> getsyjiaoshixinxi1(Map<String, Object> map);
	public List<Jiaoshixinxi> getsyjiaoshixinxi3(Map<String, Object> map);
	public List<Jiaoshixinxi> getsyjiaoshixinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jiaoshixinxi> getByPage(Map<String, Object> map);
	public List<Jiaoshixinxi> select(Map<String, Object> map);
//	所有List
}

