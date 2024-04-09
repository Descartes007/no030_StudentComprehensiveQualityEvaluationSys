package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Youqinglianjie;

public interface YouqinglianjieMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Youqinglianjie record);

    int insertSelective(Youqinglianjie record);

    Youqinglianjie selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Youqinglianjie record);
	
    int updateByPrimaryKey(Youqinglianjie record);
	public Youqinglianjie quchongYouqinglianjie(Map<String, Object> wangzhanmingcheng);
	public List<Youqinglianjie> getAll(Map<String, Object> map);
	public List<Youqinglianjie> getsyyouqinglianjie1(Map<String, Object> map);
	public List<Youqinglianjie> getsyyouqinglianjie3(Map<String, Object> map);
	public List<Youqinglianjie> getsyyouqinglianjie2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Youqinglianjie> getByPage(Map<String, Object> map);
	public List<Youqinglianjie> select(Map<String, Object> map);
//	所有List
}

