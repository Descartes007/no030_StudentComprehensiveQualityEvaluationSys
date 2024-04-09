package com.entity;

public class Shoucangjilu {
    private Integer id;
	private String username;
	private String xwid;
	private String ziduan;
	private String biao;
	private String biaoj;
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
	public String getXwid() {
        return xwid;
    }
    public void setXwid(String xwid) {
        this.xwid = xwid == null ? null : xwid.trim();
    }
	public String getZiduan() {
        return ziduan;
    }
    public void setZiduan(String ziduan) {
        this.ziduan = ziduan == null ? null : ziduan.trim();
    }
	public String getBiao() {
        return biao;
    }
    public void setBiao(String biao) {
        this.biao = biao == null ? null : biao.trim();
    }
    public String getBiaoj() {
        return biaoj;
    }
    public void setBiaoj(String biaoj) {
        this.biaoj = biaoj == null ? null : biaoj.trim();
    }
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
