package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Allusers;

public interface AllusersServer {

//  验证后台登录
  public Allusers allusersLogin(Map<String, Object> po);

  public int add(Allusers po);

  public int update(Allusers po);

  public int delete(int id);

  public List<Allusers> getAll(Map<String,Object> map);

  public Allusers quchongAllusers(Map<String, Object> map);

  public Allusers getById( int id);

  public List<Allusers> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Allusers> select(Map<String, Object> map);
}
//	所有List
