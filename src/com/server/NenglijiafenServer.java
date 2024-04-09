package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Nenglijiafen;

public interface NenglijiafenServer {

  public int add(Nenglijiafen po);

  public int update(Nenglijiafen po);
  
  
  
  public int delete(int id);

  public List<Nenglijiafen> getAll(Map<String,Object> map);
  public List<Nenglijiafen> getsynenglijiafen1(Map<String,Object> map);
  public List<Nenglijiafen> getsynenglijiafen2(Map<String,Object> map);
  public List<Nenglijiafen> getsynenglijiafen3(Map<String,Object> map);
  public Nenglijiafen quchongNenglijiafen(Map<String, Object> acount);

  public Nenglijiafen getById( int id);

  public List<Nenglijiafen> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Nenglijiafen> select(Map<String, Object> map);
}
//	所有List
