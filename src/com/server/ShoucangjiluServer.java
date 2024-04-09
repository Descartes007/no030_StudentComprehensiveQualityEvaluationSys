package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shoucangjilu;

public interface ShoucangjiluServer {

  public int add(Shoucangjilu po);

  public int update(Shoucangjilu po);

  public int delete(int id);

  public List<Shoucangjilu> getAll(Map<String,Object> map);

  public Shoucangjilu quchongShoucangjilu(Map<String, Object> map);

  public Shoucangjilu getById( int id);

  public List<Shoucangjilu> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shoucangjilu> select(Map<String, Object> map);
}
//	所有List
