package com.lk.computershopbackstage.bean;

public class Goods_type {
    private Integer typeId;

    private String goodsType;
    
    private Goods goods;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "Goods_type [typeId=" + typeId + ", goodsType=" + goodsType + ", goods=" + goods + "]";
	}

	public Goods_type(Integer typeId, String goodsType, Goods goods) {
		super();
		this.typeId = typeId;
		this.goodsType = goodsType;
		this.goods = goods;
	}

	public Goods_type() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}