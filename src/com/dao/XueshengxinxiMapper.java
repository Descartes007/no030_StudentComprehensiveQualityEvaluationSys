package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Xueshengxinxi;

public interface XueshengxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Xueshengxinxi record);

    int insertSelective(Xueshengxinxi record);

    Xueshengxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Xueshengxinxi record);
	
    int updateByPrimaryKey(Xueshengxinxi record);
	public Xueshengxinxi quchongXueshengxinxi(Map<String, Object> xuehao);
	public List<Xueshengxinxi> getAll(Map<String, Object> map);
	public List<Xueshengxinxi> getsyxueshengxinxi1(Map<String, Object> map);
	public List<Xueshengxinxi> getsyxueshengxinxi3(Map<String, Object> map);
	public List<Xueshengxinxi> getsyxueshengxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Xueshengxinxi> getByPage(Map<String, Object> map);
	public List<Xueshengxinxi> select(Map<String, Object> map);
//	所有List
}

