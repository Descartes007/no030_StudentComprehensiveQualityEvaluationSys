package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jiangchengxinxi;

public interface JiangchengxinxiServer {

  public int add(Jiangchengxinxi po);

  public int update(Jiangchengxinxi po);
  
  
  
  public int delete(int id);

  public List<Jiangchengxinxi> getAll(Map<String,Object> map);
  public List<Jiangchengxinxi> getsyjiangchengxinxi1(Map<String,Object> map);
  public List<Jiangchengxinxi> getsyjiangchengxinxi2(Map<String,Object> map);
  public List<Jiangchengxinxi> getsyjiangchengxinxi3(Map<String,Object> map);
  public Jiangchengxinxi quchongJiangchengxinxi(Map<String, Object> acount);

  public Jiangchengxinxi getById( int id);

  public List<Jiangchengxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jiangchengxinxi> select(Map<String, Object> map);
}
//	所有List
