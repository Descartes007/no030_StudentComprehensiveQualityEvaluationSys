package com.entity;

public class Jiangchengxinxi {
    private Integer id;
	private String jiangchengbianhao;
	private String jiangchengbiaoti;
	private String jiangchengneirong;
	private String jiangchengfenshu;
	private String shijian;
	private String lururen;
	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getJiangchengbianhao() {
        return jiangchengbianhao;
    }
    public void setJiangchengbianhao(String jiangchengbianhao) {
        this.jiangchengbianhao = jiangchengbianhao == null ? null : jiangchengbianhao.trim();
    }
	public String getJiangchengbiaoti() {
        return jiangchengbiaoti;
    }
    public void setJiangchengbiaoti(String jiangchengbiaoti) {
        this.jiangchengbiaoti = jiangchengbiaoti == null ? null : jiangchengbiaoti.trim();
    }
	public String getJiangchengneirong() {
        return jiangchengneirong;
    }
    public void setJiangchengneirong(String jiangchengneirong) {
        this.jiangchengneirong = jiangchengneirong == null ? null : jiangchengneirong.trim();
    }
	public String getJiangchengfenshu() {
        return jiangchengfenshu;
    }
    public void setJiangchengfenshu(String jiangchengfenshu) {
        this.jiangchengfenshu = jiangchengfenshu == null ? null : jiangchengfenshu.trim();
    }
	public String getShijian() {
        return shijian;
    }
    public void setShijian(String shijian) {
        this.shijian = shijian == null ? null : shijian.trim();
    }
	public String getLururen() {
        return lururen;
    }
    public void setLururen(String lururen) {
        this.lururen = lururen == null ? null : lururen.trim();
    }
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
