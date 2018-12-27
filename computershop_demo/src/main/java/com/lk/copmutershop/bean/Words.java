package com.lk.copmutershop.bean;

import java.util.Date;

public class Words {
    private Integer wordsId;

    private String account;

    private Integer goodsId;

    private String wordsContent;

    private Date wordsTime;

    public Integer getWordsId() {
        return wordsId;
    }

    public void setWordsId(Integer wordsId) {
        this.wordsId = wordsId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getWordsContent() {
        return wordsContent;
    }

    public void setWordsContent(String wordsContent) {
        this.wordsContent = wordsContent == null ? null : wordsContent.trim();
    }

    public Date getWordsTime() {
        return wordsTime;
    }

    public void setWordsTime(Date wordsTime) {
        this.wordsTime = wordsTime;
    }

	@Override
	public String toString() {
		return "Words [wordsId=" + wordsId + ", account=" + account + ", goodsId=" + goodsId + ", wordsContent="
				+ wordsContent + ", wordsTime=" + wordsTime + "]";
	}

	public Words(Integer wordsId, String account, Integer goodsId, String wordsContent, Date wordsTime) {
		super();
		this.wordsId = wordsId;
		this.account = account;
		this.goodsId = goodsId;
		this.wordsContent = wordsContent;
		this.wordsTime = wordsTime;
	}

	public Words() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}