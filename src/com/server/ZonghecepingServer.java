package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Zongheceping;

public interface ZonghecepingServer {

  public int add(Zongheceping po);

  public int update(Zongheceping po);
  
  
  
  public int delete(int id);

  public List<Zongheceping> getAll(Map<String,Object> map);
  public List<Zongheceping> getsyzongheceping1(Map<String,Object> map);
  public List<Zongheceping> getsyzongheceping2(Map<String,Object> map);
  public List<Zongheceping> getsyzongheceping3(Map<String,Object> map);
  public Zongheceping quchongZongheceping(Map<String, Object> acount);

  public Zongheceping getById( int id);

  public List<Zongheceping> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Zongheceping> select(Map<String, Object> map);
}
//	所有List
