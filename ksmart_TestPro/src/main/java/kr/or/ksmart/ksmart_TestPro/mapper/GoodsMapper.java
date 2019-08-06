package kr.or.ksmart.ksmart_TestPro.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.ksmart_TestPro.vo.Goods;

@Mapper
public interface GoodsMapper {
	public List<Map<String, Object>> goodsList();
	// 회원 - 상품 테이블 조인
	
	public List<Map<String, Object>> goodsSearchList(Goods goods);
	// 회원아이디, 회원명, 상품명, 상품카테고리, 최소가격을 키워드로 하고
	// 입력칸에 입력값을 넣어서 회원-상품 테이블 조인
	
	public int getGoodsMaxCode();
	// 상품 코드 중 숫자 최대값 계산
	
	public int addGoods(Goods goods);
	// 상품 추가
	
	public Goods getGoodsByCode(String goodsCode);
	// 상품 객체 한개 반환
	
	public int modifyGoods(Goods goods);
	// 상품 수정
	
	public int deleteGoods(String goodsCode);
	// 상품 삭제
}
