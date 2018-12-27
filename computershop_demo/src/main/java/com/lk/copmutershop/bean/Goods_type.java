package com.lk.copmutershop.bean;

public class Goods_type {
    private Integer typeId;

    private String goodsType;

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

	@Override
	public String toString() {
		return "Goods_type [typeId=" + typeId + ", goodsType=" + goodsType + "]";
	}

	public Goods_type(Integer typeId, String goodsType) {
		super();
		this.typeId = typeId;
		this.goodsType = goodsType;
	}

	public Goods_type() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}