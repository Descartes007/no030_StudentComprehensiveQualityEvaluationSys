package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jiangchengxinxi;

public interface JiangchengxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jiangchengxinxi record);

    int insertSelective(Jiangchengxinxi record);

    Jiangchengxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jiangchengxinxi record);
	
    int updateByPrimaryKey(Jiangchengxinxi record);
	public Jiangchengxinxi quchongJiangchengxinxi(Map<String, Object> lururen);
	public List<Jiangchengxinxi> getAll(Map<String, Object> map);
	public List<Jiangchengxinxi> getsyjiangchengxinxi1(Map<String, Object> map);
	public List<Jiangchengxinxi> getsyjiangchengxinxi3(Map<String, Object> map);
	public List<Jiangchengxinxi> getsyjiangchengxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jiangchengxinxi> getByPage(Map<String, Object> map);
	public List<Jiangchengxinxi> select(Map<String, Object> map);
//	所有List
}

