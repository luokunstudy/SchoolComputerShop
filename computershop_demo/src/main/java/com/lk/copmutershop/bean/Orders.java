package com.lk.copmutershop.bean;

import java.util.Date;

public class Orders {
    private Integer orderId;

    private Integer goodsId;

    private String account;

    private Integer number;

    private Double total;

    private Date orderTime;

    private String accountId;

    private String address;
    
    private Goods goods;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", goodsId=" + goodsId + ", account=" + account + ", number=" + number
				+ ", total=" + total + ", orderTime=" + orderTime + ", accountId=" + accountId + ", address=" + address
				+ ", goods=" + goods + "]";
	}

	public Orders(Integer orderId, Integer goodsId, String account, Integer number, Double total, Date orderTime,
			String accountId, String address, Goods goods) {
		super();
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.account = account;
		this.number = number;
		this.total = total;
		this.orderTime = orderTime;
		this.accountId = accountId;
		this.address = address;
		this.goods = goods;
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

   
    
}