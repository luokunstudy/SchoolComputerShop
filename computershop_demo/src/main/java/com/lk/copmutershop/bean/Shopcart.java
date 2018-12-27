package com.lk.copmutershop.bean;

public class Shopcart {
    private Integer cartId;

    private String account;

    private Integer goodsId;

    private String accountId;
    
    private Goods goods;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "Shopcart [cartId=" + cartId + ", account=" + account + ", goodsId=" + goodsId + ", accountId="
				+ accountId + ", goods=" + goods + "]";
	}

	public Shopcart(Integer cartId, String account, Integer goodsId, String accountId, Goods goods) {
		super();
		this.cartId = cartId;
		this.account = account;
		this.goodsId = goodsId;
		this.accountId = accountId;
		this.goods = goods;
	}

	public Shopcart() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}