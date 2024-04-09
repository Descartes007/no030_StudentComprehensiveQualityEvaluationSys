package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Liuyanban;

public interface LiuyanbanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Liuyanban record);

    int insertSelective(Liuyanban record);

    Liuyanban selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Liuyanban record);
	int updateByPrimaryKeySelectivelb(Liuyanban record);
    int updateByPrimaryKey(Liuyanban record);
	public Liuyanban quchongLiuyanban(Map<String, Object> xuehao);
	public List<Liuyanban> getAll(Map<String, Object> map);
	public List<Liuyanban> getsyliuyanban1(Map<String, Object> map);
	public List<Liuyanban> getsyliuyanban3(Map<String, Object> map);
	public List<Liuyanban> getsyliuyanban2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Liuyanban> getByPage(Map<String, Object> map);
	public List<Liuyanban> select(Map<String, Object> map);
//	所有List
}

