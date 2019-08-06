package kr.or.ksmart.ksmart_TestPro.controller;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.ksmart_TestPro.service.MemberService;
import kr.or.ksmart.ksmart_TestPro.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/memberList")
	public String memberList(Model model) {
		model.addAttribute("memlist", memberService.memberList());
		return "member/mlist/memberList";
	}
	
	@PostMapping("/memberList")
	public String memberList(Member member, Model model) {
		model.addAttribute("memlist", memberService.memberSelectList(member));
		return "member/mlist/memberList";
	}
	
	@GetMapping("/addMember")
	public String addMember() {
		return "member/minsert/addMember";
	}
	
	@PostMapping("/addMember")
	public String addMember(Member member, Model model) {
		int result = memberService.addMember(member, model);
		System.out.println(result + " <- result   modifyMember(Member)   MemberController.java");
		String path = "redirect:/memberList";
		// 유효성 검사 통과하여 회원 리스트로 리다이렉트 하는 경로로 초기화
		
		if(model.containsAttribute("memEff")) {
			path = "member/minsert/addMember";
		}
		
		return path;
	}
	
	@GetMapping("/modifyMember")
	public String modifyMember(@RequestParam(value = "memberId") String memberId, 
			Model model) {
		model.addAttribute("mem", memberService.getMemberById(memberId));
		return "member/mUpdate/modifyMember";
	}
	
	@PostMapping("/modifyMember")
	public String modifyMember(Member member) {
		int result = memberService.modifyMember(member);
		System.out.println(result + " <- result   modifyMember(Member)   MemberController.java");
		return "redirect:/memberList";
	}
	
	@GetMapping("/delMember")
	public String delMember(@RequestParam(value = "memberId") String memberId,
			Model model) {
		model.addAttribute("memId", memberId);
		return "member/mdelete/deleteMember";
	}
	
	@PostMapping("/delMember")
	public String delMember(Member member, HttpSession session, Model model) {
		String memChk = memberService.deleteMember(member);
		// 삭제가 되었는지 확인할 문자열 반환
		
		String path = "/member/mdelete/deleteMember";
		// 삭제 불가했을 경우 이동할 경로로 초기화
		
		if(memChk.equals("")) { // 삭제 성공
			session.invalidate(); // 삭제 성공 시 세션도 날려야한다.
			path = "redirect:/memberList";
			
		} else { // 비번 불일치
			model.addAttribute("memId", member.getMemberId());
			model.addAttribute("result", memChk);
		}
		
		return path;
	}
	
	@GetMapping("/loginMember")
	public String loginMember() {
		return "/login/login";
	}
	
	@PostMapping("/loginMember")
	public String loginMember(Member member, HttpSession session, Model model) {
		System.out.println(member.getMemberId() + " <- member.getMemberId()   "
				+ "loginMember(Member, HttpSession, Model)   MemberController.java");

		System.out.println(member.getMemberPw() + " <- member.getMemberPw()   "
				+ "loginMember(Member, HttpSession, Model)   MemberController.java");
		
		System.out.println(model.getClass().getName() + " <- model   "
				+ "loginMember(Member, HttpSession, Model)   MemberController.java");
		
		String path = "/index";	// 로그인 성공시 인덱스페이지로 갈 수 있게 초기화
		
		Map<String, Object> map = memberService.loginMember(member);
		String result = (String)map.get("result");
		Member resultMem = (Member)map.get("loginMember");
		
		if(result.equals("loginSuccess")) { // 로그인 성공
			session.setAttribute("memId", resultMem.getMemberId());
			session.setAttribute("memName", resultMem.getMemberName());
			session.setAttribute("memLevel", resultMem.getMemberLevel());
			
			System.out.println(session
					+ " <- session   loginMember(Member, Session, Model)   MemberController.java");
			
		} else if(result.equals("pwNotFound")) { // 아이디는 존재하나 비밀번호 불일치
			path = "/login/login";
			model.addAttribute("result", "비밀번호가 일치하지 않습니다.");
		} else { // 존재하지 않는 아이디 입력
			path = "/login/login";
			model.addAttribute("result", "존재하지 않는 아이디 입니다.");
		}
		return path;
	}
	
	@GetMapping("/logoutMember")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
