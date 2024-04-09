package com.entity;

public class Liuyanban {
    private Integer id;
	private String xuehao;
	private String xingming;
	private String banji;
	private String liuyanneirong;
	private String huifu;
	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getXuehao() {
        return xuehao;
    }
    public void setXuehao(String xuehao) {
        this.xuehao = xuehao == null ? null : xuehao.trim();
    }
	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
        this.xingming = xingming == null ? null : xingming.trim();
    }
	public String getBanji() {
        return banji;
    }
    public void setBanji(String banji) {
        this.banji = banji == null ? null : banji.trim();
    }
	public String getLiuyanneirong() {
        return liuyanneirong;
    }
    public void setLiuyanneirong(String liuyanneirong) {
        this.liuyanneirong = liuyanneirong == null ? null : liuyanneirong.trim();
    }
	public String getHuifu() {
        return huifu;
    }
    public void setHuifu(String huifu) {
        this.huifu = huifu == null ? null : huifu.trim();
    }
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
