package kr.or.ksmart.ksmart_TestPro.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.ksmart_TestPro.service.GoodsService;
import kr.or.ksmart.ksmart_TestPro.vo.Goods;

@Controller
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	@GetMapping("/goodsList")
	public String goodsList(Model model) {
		model.addAttribute("maplist", goodsService.goodsList());
		return "/goods/glist/goodsList";
	}
	
	@PostMapping("/goodsSearch")
	public String goodsSearch(Goods goods, Model model) {
		//System.out.println("상품 검색리스트 - 컨트롤러");
		model.addAttribute("maplist", goodsService.goodsSearchList(goods));
		return "/goods/glist/goodsList";
	}
	
	@GetMapping("/addGoods")
	public String addGoods() {
		return "/goods/ginsert/addGoods";
	}
	
	@PostMapping("/addGoods")
	public String addGoods(Goods goods, HttpSession session, Model model) {
		System.out.println("상품 추가 - 컨트롤러");
		int result = goodsService.addGoods(goods, session);
		System.out.println(result + " <- result   addGoods()   GoodsController.java");
		return "redirect:/goodsList";
	}
	
	@GetMapping("/modifyGoods")		// required = true : 해당 변수는 반드시 받아야한다. 안 받을시 에러
	public String modifyGoods(@RequestParam(value = "goodsCode" /*, required = false*/) String goodsCode,
			Model model) {
		model.addAttribute("goods", goodsService.getGoodsByCode(goodsCode));
		return "/goods/gUpdate/modifyGoods";
	}
	
	@PostMapping("/modifyGoods")
	public String modifyGoods(Goods goods, Model model) {
		System.out.println("상품 수정 - 컨트롤러");
		System.out.println(goods + " <- goods   modifyGoods(Goods, Model)   GoodsController.java");
		int result = goodsService.modifyGoods(goods);
		System.out.println(result + " <- result   addGoods()   GoodsController.java");
		return "redirect:/goodsList";
	}
	
	@GetMapping("/deleteGoods")		// required = true : 해당 변수는 반드시 받아야한다. 안 받을시 에러
	public String deleteGoods(@RequestParam(value = "goodsCode" /*, required = false*/) String goodsCode,
			/* HttpSession session, */ Model model) {
		System.out.println(goodsCode + " <- goodsCode   deleteGoods()   GoodsController.java");
		//System.out.println((String)session.getAttribute("memId")
		//				+ " <- session.memId   deleteGoods()   GoodsController.java");
		model.addAttribute("goodsCode", goodsCode);
		System.out.println(model + " <- model   deleteGoods()   GoodsController.java");
		return "goods/gdelete/delGoods";
	}
	
	@PostMapping("/deleteGoods")
	public String deleteGoods(
			@RequestParam(value = "goodsCode") String goodsCode,
			@RequestParam(value = "memberId") String memberId,
			@RequestParam(value = "memberPw") String memberPw,
			Model model) {
		System.out.println(goodsCode + " <- goodsCode   deleteGoods()   GoodsController.java");
		System.out.println(memberId + " <- memberId   deleteGoods()   GoodsController.java");
		System.out.println(memberPw + " <- memberPw   deleteGoods()   GoodsController.java");
		
		String result = goodsService.deleteGoods(goodsCode, memberId, memberPw);
		System.out.println(result + " <- deleteGoods()   GoodsController.java");
		
		String path = "";
		
		if(result.equals("pwNeq")) { // 비번 불일치
			path = "goods/gdelete/delGoods";
			model.addAttribute("goodsCode", goodsCode);
			model.addAttribute("result", "비밀번호가 일치하지 않습니다.");
			
		} else { // 비번 일치시 상품 삭제 후 리스트로 이동
			path = "redirect:/goodsList";
		}
		return path;
	}
}
