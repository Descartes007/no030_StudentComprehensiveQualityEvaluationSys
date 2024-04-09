package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Youqinglianjie;

public interface YouqinglianjieServer {

  public int add(Youqinglianjie po);

  public int update(Youqinglianjie po);
  
  
  
  public int delete(int id);

  public List<Youqinglianjie> getAll(Map<String,Object> map);
  public List<Youqinglianjie> getsyyouqinglianjie1(Map<String,Object> map);
  public List<Youqinglianjie> getsyyouqinglianjie2(Map<String,Object> map);
  public List<Youqinglianjie> getsyyouqinglianjie3(Map<String,Object> map);
  public Youqinglianjie quchongYouqinglianjie(Map<String, Object> acount);

  public Youqinglianjie getById( int id);

  public List<Youqinglianjie> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Youqinglianjie> select(Map<String, Object> map);
}
//	所有List
