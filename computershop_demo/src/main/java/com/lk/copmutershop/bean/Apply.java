package com.lk.copmutershop.bean;

import java.util.Date;

public class Apply {


    private Integer applyId;

    private Integer goodsId;

    private String account;

    private Date applyTime;

    private String applyDescribe;

    private Integer status;
    
    private Goods goods;

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

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

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyDescribe() {
        return applyDescribe;
    }

    public void setApplyDescribe(String applyDescribe) {
        this.applyDescribe = applyDescribe == null ? null : applyDescribe.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "Apply [applyId=" + applyId + ", goodsId=" + goodsId + ", account=" + account + ", applyTime="
				+ applyTime + ", applyDescribe=" + applyDescribe + ", status=" + status + ", goods=" + goods + "]";
	}

	public Apply(Integer applyId, Integer goodsId, String account, Date applyTime, String applyDescribe, Integer status,
			Goods goods) {
		super();
		this.applyId = applyId;
		this.goodsId = goodsId;
		this.account = account;
		this.applyTime = applyTime;
		this.applyDescribe = applyDescribe;
		this.status = status;
		this.goods = goods;
	}

	public Apply() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    
}