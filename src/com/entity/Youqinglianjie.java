package com.entity;

public class Youqinglianjie {
    private Integer id;
	private String wangzhanmingcheng;
	private String wangzhi;
	private String LOGO;
	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getWangzhanmingcheng() {
        return wangzhanmingcheng;
    }
    public void setWangzhanmingcheng(String wangzhanmingcheng) {
        this.wangzhanmingcheng = wangzhanmingcheng == null ? null : wangzhanmingcheng.trim();
    }
	public String getWangzhi() {
        return wangzhi;
    }
    public void setWangzhi(String wangzhi) {
        this.wangzhi = wangzhi == null ? null : wangzhi.trim();
    }
	public String getLOGO() {
        return LOGO;
    }
    public void setLOGO(String LOGO) {
        this.LOGO = LOGO == null ? null : LOGO.trim();
    }
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
