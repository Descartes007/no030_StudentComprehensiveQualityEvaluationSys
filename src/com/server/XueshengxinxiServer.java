package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Xueshengxinxi;

public interface XueshengxinxiServer {

  public int add(Xueshengxinxi po);

  public int update(Xueshengxinxi po);
  
  
  
  public int delete(int id);

  public List<Xueshengxinxi> getAll(Map<String,Object> map);
  public List<Xueshengxinxi> getsyxueshengxinxi1(Map<String,Object> map);
  public List<Xueshengxinxi> getsyxueshengxinxi2(Map<String,Object> map);
  public List<Xueshengxinxi> getsyxueshengxinxi3(Map<String,Object> map);
  public Xueshengxinxi quchongXueshengxinxi(Map<String, Object> acount);

  public Xueshengxinxi getById( int id);

  public List<Xueshengxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Xueshengxinxi> select(Map<String, Object> map);
}
//	所有List
