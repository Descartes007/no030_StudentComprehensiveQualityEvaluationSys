package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Liuyanban;

public interface LiuyanbanServer {

  public int add(Liuyanban po);

  public int update(Liuyanban po);
  
  public int updatelb(Liuyanban po);
  
  public int delete(int id);

  public List<Liuyanban> getAll(Map<String,Object> map);
  public List<Liuyanban> getsyliuyanban1(Map<String,Object> map);
  public List<Liuyanban> getsyliuyanban2(Map<String,Object> map);
  public List<Liuyanban> getsyliuyanban3(Map<String,Object> map);
  public Liuyanban quchongLiuyanban(Map<String, Object> acount);

  public Liuyanban getById( int id);

  public List<Liuyanban> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Liuyanban> select(Map<String, Object> map);
}
//	所有List
