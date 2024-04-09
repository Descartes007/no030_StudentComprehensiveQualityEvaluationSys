package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jiaoshixinxi;

public interface JiaoshixinxiServer {

  public int add(Jiaoshixinxi po);

  public int update(Jiaoshixinxi po);
  
  
  
  public int delete(int id);

  public List<Jiaoshixinxi> getAll(Map<String,Object> map);
  public List<Jiaoshixinxi> getsyjiaoshixinxi1(Map<String,Object> map);
  public List<Jiaoshixinxi> getsyjiaoshixinxi2(Map<String,Object> map);
  public List<Jiaoshixinxi> getsyjiaoshixinxi3(Map<String,Object> map);
  public Jiaoshixinxi quchongJiaoshixinxi(Map<String, Object> acount);

  public Jiaoshixinxi getById( int id);

  public List<Jiaoshixinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jiaoshixinxi> select(Map<String, Object> map);
}
//	所有List
