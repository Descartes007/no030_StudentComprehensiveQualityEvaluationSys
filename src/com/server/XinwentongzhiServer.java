package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Xinwentongzhi;

public interface XinwentongzhiServer {

  public int add(Xinwentongzhi po);

  public int update(Xinwentongzhi po);

  public int delete(int id);

  public List<Xinwentongzhi> getAll(Map<String,Object> map);
  public List<Xinwentongzhi> getsyxinwentongzhi1(Map<String,Object> map);
  public List<Xinwentongzhi> getsyxinwentongzhi2(Map<String,Object> map);
  public List<Xinwentongzhi> getsyxinwentongzhi3(Map<String,Object> map);

  public Xinwentongzhi quchongXinwentongzhi(String account);

  public Xinwentongzhi getById( int id);

  public List<Xinwentongzhi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Xinwentongzhi> select(Map<String, Object> map);
}
//	所有List
