package com.lk.copmutershop.bean;

import java.util.Date;

public class Goods {
    private Integer goodsId;

    private String account;

    private String goodsName;

    private String goodsPhone;

    private Integer typeId;

    private Double goodsPrice;

    private Double goodsOldprice;

    private String tradeMode;

    private Date relaseTime;

    private String goodsDescribe;

    private String goodsCategory;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsPhone() {
        return goodsPhone;
    }

    public void setGoodsPhone(String goodsPhone) {
        this.goodsPhone = goodsPhone == null ? null : goodsPhone.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Double getGoodsOldprice() {
        return goodsOldprice;
    }

    public void setGoodsOldprice(Double goodsOldprice) {
        this.goodsOldprice = goodsOldprice;
    }

    public String getTradeMode() {
        return tradeMode;
    }

    public void setTradeMode(String tradeMode) {
        this.tradeMode = tradeMode == null ? null : tradeMode.trim();
    }

    public Date getRelaseTime() {
        return relaseTime;
    }

    public void setRelaseTime(Date relaseTime) {
        this.relaseTime = relaseTime;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe == null ? null : goodsDescribe.trim();
    }

    public String getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory == null ? null : goodsCategory.trim();
    }

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", account=" + account + ", goodsName=" + goodsName + ", goodsPhone="
				+ goodsPhone + ", typeId=" + typeId + ", goodsPrice=" + goodsPrice + ", goodsOldprice=" + goodsOldprice
				+ ", tradeMode=" + tradeMode + ", relaseTime=" + relaseTime + ", goodsDescribe=" + goodsDescribe
				+ ", goodsCategory=" + goodsCategory + "]";
	}

	public Goods(Integer goodsId, String account, String goodsName, String goodsPhone, Integer typeId,
			Double goodsPrice, Double goodsOldprice, String tradeMode, Date relaseTime, String goodsDescribe,
			String goodsCategory) {
		super();
		this.goodsId = goodsId;
		this.account = account;
		this.goodsName = goodsName;
		this.goodsPhone = goodsPhone;
		this.typeId = typeId;
		this.goodsPrice = goodsPrice;
		this.goodsOldprice = goodsOldprice;
		this.tradeMode = tradeMode;
		this.relaseTime = relaseTime;
		this.goodsDescribe = goodsDescribe;
		this.goodsCategory = goodsCategory;
	}

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}