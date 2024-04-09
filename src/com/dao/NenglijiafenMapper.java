package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Nenglijiafen;

public interface NenglijiafenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Nenglijiafen record);

    int insertSelective(Nenglijiafen record);

    Nenglijiafen selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Nenglijiafen record);
	
    int updateByPrimaryKey(Nenglijiafen record);
	public Nenglijiafen quchongNenglijiafen(Map<String, Object> xuehao);
	public List<Nenglijiafen> getAll(Map<String, Object> map);
	public List<Nenglijiafen> getsynenglijiafen1(Map<String, Object> map);
	public List<Nenglijiafen> getsynenglijiafen3(Map<String, Object> map);
	public List<Nenglijiafen> getsynenglijiafen2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Nenglijiafen> getByPage(Map<String, Object> map);
	public List<Nenglijiafen> select(Map<String, Object> map);
//	所有List
}

