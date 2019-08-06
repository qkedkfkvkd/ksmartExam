package kr.or.ksmart.ksmart_TestPro.vo;

import java.util.Date;

public class Goods {
	private String		goodsCode;
	private String		MemberId;
	private String		goodsName;
	private String		goodsCate;
	private String		goodsPrice;
	private String		goodsColor;
	private String		goodsSize;
	private Date		goodsDate;
	private String		goodsDesc;
	
	////// 검색용
	private String 		goodsSelect;
	private String		goodsSelText;
	private String		firstMoney;				// 최소 가격 (html에서 받을 것)
	private String		lastMoney;				// 최대 가격 (html에서 받을 것)
	
	// 디비 접근시 Integer로 변환
	private int			selectFirstMoney;		// 최소 가격
	private int			selectLastMoney;		// 최대 가격
	
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		System.out.println(goodsCode + " <- goodsCode   setGoodsCode()   Goods.java");
		this.goodsCode = goodsCode;
	}
	public String getMemberId() {
		return MemberId;
	}
	public void setMemberId(String memberId) {
		System.out.println(memberId + " <- memberId   setMemberId()   Goods.java");
		MemberId = memberId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		System.out.println(goodsName + " <- goodsName   goodsName()   Goods.java");
		this.goodsName = goodsName;
	}
	public String getGoodsCate() {
		return goodsCate;
	}
	public void setGoodsCate(String goodsCate) {
		System.out.println(goodsCate + " <- goodsCate   goodsCate()   Goods.java");
		this.goodsCate = goodsCate;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		System.out.println(goodsPrice + " <- goodsPrice   goodsPrice()   Goods.java");
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsColor() {
		return goodsColor;
	}
	public void setGoodsColor(String goodsColor) {
		System.out.println(goodsColor + " <- goodsColor   setGoodsColor()   Goods.java");
		this.goodsColor = goodsColor;
	}
	public String getGoodsSize() {
		return goodsSize;
	}
	public void setGoodsSize(String goodsSize) {
		System.out.println(goodsSize + " <- goodsSize   setGoodsSize()   Goods.java");
		this.goodsSize = goodsSize;
	}
	public Date getGoodsDate() {
		return goodsDate;
	}
	public void setGoodsDate(Date goodsDate) {
		System.out.println(goodsDate + " <- goodsDate   setGoodsDate()   Goods.java");
		this.goodsDate = goodsDate;
	}
	public String getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(String goodsDesc) {
		System.out.println(goodsDesc + " <- goodsDesc   setGoodsDesc()   Goods.java");
		this.goodsDesc = goodsDesc;
	}
	public String getGoodsSelect() {
		return goodsSelect;
	}
	public void setGoodsSelect(String goodsSelect) {
		System.out.println(goodsSelect + " <- goodsSelect   setGoodsSelect()   Goods.java");
		this.goodsSelect = goodsSelect;
	}
	public String getGoodsSelText() {
		return goodsSelText;
	}
	public void setGoodsSelText(String goodsSelText) {
		System.out.println(goodsSelText + " <- goodsSelText   setGoodsSelText()   Goods.java");
		this.goodsSelText = goodsSelText;
	}
	public String getFirstMoney() {
		return firstMoney;
	}
	public void setFirstMoney(String firstMoney) {
		System.out.println(firstMoney + " <- firstMoney   setFirstMoney()   Goods.java");
		this.firstMoney = firstMoney;
	}
	public String getLastMoney() {
		return lastMoney;
	}
	public void setLastMoney(String lastMoney) {
		System.out.println(lastMoney + " <- lastMoney   setLastMoney()   Goods.java");
		this.lastMoney = lastMoney;
	}
	public int getSelectFirstMoney() {
		return selectFirstMoney;
	}
	public void setSelectFirstMoney(int selectFirstMoney) {
		System.out.println(selectFirstMoney + " <- selectFirstMoney   setSelectFirstMoney()   Goods.java");
		this.selectFirstMoney = selectFirstMoney;
	}
	public int getSelectLastMoney() {
		return selectLastMoney;
	}
	public void setSelectLastMoney(int selectLastMoney) {
		System.out.println(selectLastMoney + " <- selectLastMoney   setSelectLastMoney()   Goods.java");
		this.selectLastMoney = selectLastMoney;
	}
	
	
	@Override
	public String toString() {
		return "Goods [goodsCode=" + goodsCode + ", MemberId=" + MemberId + ", goodsName=" + goodsName + ", goodsCate="
				+ goodsCate + ", goodsPrice=" + goodsPrice + ", goodsColor=" + goodsColor + ", goodsSize=" + goodsSize
				+ ", goodsDate=" + goodsDate + ", goodsDesc=" + goodsDesc + "]";
	}
}
