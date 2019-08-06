package kr.or.ksmart.ksmart_TestPro.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import kr.or.ksmart.ksmart_TestPro.EffectTest.AddMemberEffect;
import kr.or.ksmart.ksmart_TestPro.mapper.MemberMapper;
import kr.or.ksmart.ksmart_TestPro.vo.Member;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private AddMemberEffect memeff;
	
	public List<Member> memberList() {
		List<Member> memlist = memberMapper.memberList();
		return memlist;
	}
	
	public List<Member> memberSelectList(Member member) {
		String selectText = member.getMemberSelText();
		member.setMemberSelText("%"+selectText+"%");
		List<Member> memlist = memberMapper.memberSelectList(member);
		return memlist;
	}
	
	public int addMember(Member member, Model model) {
		String memEff = memeff.memberEffectTest(member);
		int returnInt = 0;
		// 유효성 검사 불통과로 초기화
		
		if(memEff.equals("")) { // 유효성 검사 통과시
			returnInt = memberMapper.addMember(member);
			
		} else { // 유효성 검사 불통과 -> 전달된 메세지가 존재
			model.addAttribute("memEff", memEff);
		}
		
		return returnInt;
	}
	
	public Member getMemberById(String memberId) {
		Member member = memberMapper.getMemberById(memberId);
		return member;
	}
	
	public int modifyMember(Member member) {
		int result = memberMapper.modifyMember(member);
		return result;
	}
	
	public String deleteMember(Member member) {
		int resultInt = memberMapper.deleteMember(member);
		
		String result = "";
		// 삭제 성공으로 초기화
		
		if(resultInt == 0) { // 비번 불일치 시 삭제 불가
			result = "비밀번호가 일치하지 않습니다.";
		}
		
		return result;
	}
	
	public Map<String, Object> loginMember(Member member) {
		Member loginMember = memberMapper.loginMember(member);
		// 로그인 수행
		
		String result = "loginSuccess";
		// 로그인 성공 메세지를 리턴하도록 초기화한다.
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(loginMember == null) {	// 로그인 불가
			Member memberIdChk = memberMapper.getMemberById(member.getMemberId());
			result = "idNotFound";
			// Member memberIdChk가 null이라면 아이디가 존재하지 않는 것이다.
			
			if(memberIdChk != null) {
				result = "pwNotFound";
				// 값이 있다면 아이디는 존재하는 것이므로 비밀번호 불일치
			}
		}
		
		map.put("result", result);
		map.put("loginMember", loginMember);
		return map;
	}
}
