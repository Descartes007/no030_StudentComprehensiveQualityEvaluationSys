package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Xinwentongzhi;

public interface XinwentongzhiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Xinwentongzhi record);

    int insertSelective(Xinwentongzhi record);

    Xinwentongzhi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Xinwentongzhi record);

    int updateByPrimaryKey(Xinwentongzhi record);
	public Xinwentongzhi quchongXinwentongzhi(Map<String, Object> uname);
	public List<Xinwentongzhi> getAll(Map<String, Object> map);
	
	public List<Xinwentongzhi> getsyxinwentongzhi1(Map<String, Object> map);
	public List<Xinwentongzhi> getsyxinwentongzhi2(Map<String, Object> map);
	public List<Xinwentongzhi> getsyxinwentongzhi3(Map<String, Object> map);
	
	public int getCount(Map<String, Object> po);
	public List<Xinwentongzhi> getByPage(Map<String, Object> map);
	public List<Xinwentongzhi> select(Map<String, Object> map);
//	所有List
}

