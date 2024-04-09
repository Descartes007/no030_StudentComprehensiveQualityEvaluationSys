package com.entity;

public class Xinwentongzhi {
    private Integer id;
	private String biaoti;
	private String leibie;
	private String neirong;
	private String shouyetupian;
	private String dianjilv;
	private String tianjiaren;
	private String zhaiyao;
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getBiaoti() {
        return biaoti;
    }
    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti == null ? null : biaoti.trim();
    }
	public String getLeibie() {
        return leibie;
    }
    public void setLeibie(String leibie) {
        this.leibie = leibie == null ? null : leibie.trim();
    }
	public String getNeirong() {
        return neirong;
    }
    public void setNeirong(String neirong) {
        this.neirong = neirong == null ? null : neirong.trim();
    }
	public String getShouyetupian() {
        return shouyetupian;
    }
    public void setShouyetupian(String shouyetupian) {
        this.shouyetupian = shouyetupian == null ? null : shouyetupian.trim();
    }
	public String getDianjilv() {
        return dianjilv;
    }
    public void setDianjilv(String dianjilv) {
        this.dianjilv = dianjilv == null ? null : dianjilv.trim();
    }
	public String getTianjiaren() {
        return tianjiaren;
    }
    public void setTianjiaren(String tianjiaren) {
        this.tianjiaren = tianjiaren == null ? null : tianjiaren.trim();
    }
	public String getZhaiyao() {
        return zhaiyao;
    }
    public void setZhaiyao(String zhaiyao) {
        this.zhaiyao = zhaiyao == null ? null : zhaiyao.trim();
    }
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
