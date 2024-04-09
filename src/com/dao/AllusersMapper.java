package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Allusers;


public interface AllusersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Allusers record);

    int insertSelective(Allusers record);

    Allusers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Allusers record);

    int updateByPrimaryKey(Allusers record);
	public Allusers quchongAllusers(Map<String, Object> uname);
	public List<Allusers> getAll(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Allusers> getByPage(Map<String, Object> map);
	public List<Allusers> select(Map<String, Object> map);
	
	public Allusers allusersLogin(Map<String, Object> po);
//	所有List
}

