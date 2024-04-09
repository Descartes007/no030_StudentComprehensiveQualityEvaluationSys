package com.entity;

public class Xueshengchengji {
    private Integer id;
	private String xuehao;
	private String xingming;
	private String xingbie;
	private String banji;
	private String xuenian;
	private String xueqi;
	private String kemu;
	private String fenshu;
	
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
	public String getXingbie() {
        return xingbie;
    }
    public void setXingbie(String xingbie) {
        this.xingbie = xingbie == null ? null : xingbie.trim();
    }
	public String getBanji() {
        return banji;
    }
    public void setBanji(String banji) {
        this.banji = banji == null ? null : banji.trim();
    }
	public String getXuenian() {
        return xuenian;
    }
    public void setXuenian(String xuenian) {
        this.xuenian = xuenian == null ? null : xuenian.trim();
    }
	public String getXueqi() {
        return xueqi;
    }
    public void setXueqi(String xueqi) {
        this.xueqi = xueqi == null ? null : xueqi.trim();
    }
	public String getKemu() {
        return kemu;
    }
    public void setKemu(String kemu) {
        this.kemu = kemu == null ? null : kemu.trim();
    }
	public String getFenshu() {
        return fenshu;
    }
    public void setFenshu(String fenshu) {
        this.fenshu = fenshu == null ? null : fenshu.trim();
    }
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
