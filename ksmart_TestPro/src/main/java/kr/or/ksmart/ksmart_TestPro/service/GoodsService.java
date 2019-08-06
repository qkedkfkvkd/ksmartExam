package kr.or.ksmart.ksmart_TestPro.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.ksmart_TestPro.mapper.GoodsMapper;
import kr.or.ksmart.ksmart_TestPro.mapper.MemberMapper;
import kr.or.ksmart.ksmart_TestPro.vo.Goods;
import kr.or.ksmart.ksmart_TestPro.vo.Member;

@Service
@Transactional
public class GoodsService {
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Autowired
	private MemberMapper memberMapper;
	
	public List<Map<String, Object>> goodsList() {
		List<Map<String, Object>> maplist = goodsMapper.goodsList();
		return maplist;
	}
	
	public List<Map<String, Object>> goodsSearchList(Goods goods) {
		if(!goods.getGoodsSelText().equals("")) {
			String selectText = goods.getGoodsSelText();
			goods.setGoodsSelText("%"+selectText+"%");
		}
		
		/*
		 * if(!goods.getFirstMoney().equals("") && !goods.getLastMoney().equals("")) {
		 * goods.setSelectFirstMoney(Integer.parseInt(goods.getFirstMoney()));
		 * goods.setSelectLastMoney(Integer.parseInt(goods.getLastMoney()));
		 * 
		 * } else if (!goods.getFirstMoney().equals("")) {
		 * goods.setSelectFirstMoney(Integer.parseInt(goods.getFirstMoney())); } else {
		 * goods.setSelectLastMoney(Integer.parseInt(goods.getLastMoney())); }
		 */
		
		List<Map<String, Object>> maplist = goodsMapper.goodsSearchList(goods);
		return maplist;
	}
	
	public int addGoods(Goods goods, HttpSession session) {
		//int maxCode = goodsMapper.getGoodsMaxCode();
		//System.out.println(maxCode + " <- maxCode   addGoods()   GoodsService.java");
		//maxCode++;
		//goods.setGoodsCode("goods_" + maxCode);
		goods.setMemberId((String)session.getAttribute("memId"));
		
		int result = goodsMapper.addGoods(goods);
		return result;
	}
	
	public Goods getGoodsByCode(String goodsCode) {
		Goods goods = goodsMapper.getGoodsByCode(goodsCode);
		return goods;
	}
	
	public int modifyGoods(Goods goods) {
		int result = goodsMapper.modifyGoods(goods);
		return result;
	}
	
	public String deleteGoods(String goodsCode, String memberId, String memberPw) {
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		String result = "";
		
		if(memberMapper.loginMember(member) == null) { // 비번 불일치
			result = "pwNeq";
			
		} else {
			int resultInt = goodsMapper.deleteGoods(goodsCode);
			System.out.println(resultInt + " <- resultInt   deleteGoods()   GoodsService.java");
		}
		return result;
	}
}
