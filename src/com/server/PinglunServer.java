package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Pinglun;

public interface PinglunServer {

  public int add(Pinglun po);

  public int update(Pinglun po);

  public int delete(int id);

  public List<Pinglun> getAll(Map<String,Object> map);

  public Pinglun quchongPinglun(Map<String, Object> map);

  public Pinglun getById( int id);

  public List<Pinglun> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Pinglun> select(Map<String, Object> map);
}
//	所有List
