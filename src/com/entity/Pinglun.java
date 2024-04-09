package com.entity;

public class Pinglun {
    private Integer id;
	private String xinwenID;
	private String pinglunneirong;
	private String pinglunren;
	private String pingfen;
	private String biao;
	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getXinwenID() {
        return xinwenID;
    }
    public void setXinwenID(String xinwenID) {
        this.xinwenID = xinwenID == null ? null : xinwenID.trim();
    }
	public String getPinglunneirong() {
        return pinglunneirong;
    }
    public void setPinglunneirong(String pinglunneirong) {
        this.pinglunneirong = pinglunneirong == null ? null : pinglunneirong.trim();
    }
	public String getPinglunren() {
        return pinglunren;
    }
    public void setPinglunren(String pinglunren) {
        this.pinglunren = pinglunren == null ? null : pinglunren.trim();
    }
	public String getPingfen() {
        return pingfen;
    }
    public void setPingfen(String pingfen) {
        this.pingfen = pingfen == null ? null : pingfen.trim();
    }
	public String getBiao() {
        return biao;
    }
    public void setBiao(String biao) {
        this.biao = biao == null ? null : biao.trim();
    }
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
