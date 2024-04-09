package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Xueshengchengji;

public interface XueshengchengjiServer {

  public int add(Xueshengchengji po);

  public int update(Xueshengchengji po);
  
  
  
  public int delete(int id);

  public List<Xueshengchengji> getAll(Map<String,Object> map);
  public List<Xueshengchengji> getsyxueshengchengji1(Map<String,Object> map);
  public List<Xueshengchengji> getsyxueshengchengji2(Map<String,Object> map);
  public List<Xueshengchengji> getsyxueshengchengji3(Map<String,Object> map);
  public Xueshengchengji quchongXueshengchengji(Map<String, Object> acount);

  public Xueshengchengji getById( int id);

  public List<Xueshengchengji> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Xueshengchengji> select(Map<String, Object> map);
}
//	所有List
