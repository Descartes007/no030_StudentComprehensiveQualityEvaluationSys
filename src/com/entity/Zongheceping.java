package com.entity;

public class Zongheceping {
    private Integer id;
	private String xuehao;
	private String xingming;
	private String banji;
	private String jisuanchuxueshengcaoxingcepingfen;
	private String zhiyucepingdefen;
	private String nenglijiafenxiangdefen;
	private String zonghedefen;
	
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
	public String getJisuanchuxueshengcaoxingcepingfen() {
        return jisuanchuxueshengcaoxingcepingfen;
    }
    public void setJisuanchuxueshengcaoxingcepingfen(String jisuanchuxueshengcaoxingcepingfen) {
        this.jisuanchuxueshengcaoxingcepingfen = jisuanchuxueshengcaoxingcepingfen == null ? null : jisuanchuxueshengcaoxingcepingfen.trim();
    }
	public String getZhiyucepingdefen() {
        return zhiyucepingdefen;
    }
    public void setZhiyucepingdefen(String zhiyucepingdefen) {
        this.zhiyucepingdefen = zhiyucepingdefen == null ? null : zhiyucepingdefen.trim();
    }
	public String getNenglijiafenxiangdefen() {
        return nenglijiafenxiangdefen;
    }
    public void setNenglijiafenxiangdefen(String nenglijiafenxiangdefen) {
        this.nenglijiafenxiangdefen = nenglijiafenxiangdefen == null ? null : nenglijiafenxiangdefen.trim();
    }
	public String getZonghedefen() {
        return zonghedefen;
    }
    public void setZonghedefen(String zonghedefen) {
        this.zonghedefen = zonghedefen == null ? null : zonghedefen.trim();
    }
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
