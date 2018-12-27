package com.lk.copmutershop.bean;

import java.util.Date;

public class Goods_need {
    private Integer mseeageId;

    private String account;

    private String goodsName;

    private String goodsDescribe;

    private String tradeMode;

    private String contact;

    private Date relaseTime;

    public Integer getMseeageId() {
        return mseeageId;
    }

    public void setMseeageId(Integer mseeageId) {
        this.mseeageId = mseeageId;
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

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe == null ? null : goodsDescribe.trim();
    }

    public String getTradeMode() {
        return tradeMode;
    }

    public void setTradeMode(String tradeMode) {
        this.tradeMode = tradeMode == null ? null : tradeMode.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public Date getRelaseTime() {
        return relaseTime;
    }

    public void setRelaseTime(Date relaseTime) {
        this.relaseTime = relaseTime;
    }

	@Override
	public String toString() {
		return "Goods_need [mseeageId=" + mseeageId + ", account=" + account + ", goodsName=" + goodsName
				+ ", goodsDescribe=" + goodsDescribe + ", tradeMode=" + tradeMode + ", contact=" + contact
				+ ", relaseTime=" + relaseTime + "]";
	}

	public Goods_need(Integer mseeageId, String account, String goodsName, String goodsDescribe, String tradeMode,
			String contact, Date relaseTime) {
		super();
		this.mseeageId = mseeageId;
		this.account = account;
		this.goodsName = goodsName;
		this.goodsDescribe = goodsDescribe;
		this.tradeMode = tradeMode;
		this.contact = contact;
		this.relaseTime = relaseTime;
	}

	public Goods_need() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}