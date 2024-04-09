package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Yonghuzhuce;

public interface YonghuzhuceServer {

  public int add(Yonghuzhuce po);

  public int update(Yonghuzhuce po);
  
  
  
  public int delete(int id);

  public List<Yonghuzhuce> getAll(Map<String,Object> map);
  public List<Yonghuzhuce> getsyyonghuzhuce1(Map<String,Object> map);
  public List<Yonghuzhuce> getsyyonghuzhuce2(Map<String,Object> map);
  public List<Yonghuzhuce> getsyyonghuzhuce3(Map<String,Object> map);
  public Yonghuzhuce quchongYonghuzhuce(Map<String, Object> acount);

  public Yonghuzhuce getById( int id);

  public List<Yonghuzhuce> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Yonghuzhuce> select(Map<String, Object> map);
}
//	所有List
