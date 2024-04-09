package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Xueshengchengji;

public interface XueshengchengjiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Xueshengchengji record);

    int insertSelective(Xueshengchengji record);

    Xueshengchengji selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Xueshengchengji record);
	
    int updateByPrimaryKey(Xueshengchengji record);
	public Xueshengchengji quchongXueshengchengji(Map<String, Object> xuehao);
	public List<Xueshengchengji> getAll(Map<String, Object> map);
	public List<Xueshengchengji> getsyxueshengchengji1(Map<String, Object> map);
	public List<Xueshengchengji> getsyxueshengchengji3(Map<String, Object> map);
	public List<Xueshengchengji> getsyxueshengchengji2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Xueshengchengji> getByPage(Map<String, Object> map);
	public List<Xueshengchengji> select(Map<String, Object> map);
//	所有List
}

