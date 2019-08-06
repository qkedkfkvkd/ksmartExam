package kr.or.ksmart.ksmart_TestPro.EffectTest;

import org.springframework.stereotype.Component;

import kr.or.ksmart.ksmart_TestPro.vo.Member;

@Component 
public class AddMemberEffect {
	public String memberEffectTest(Member member) {
		String result = "";
		// 모든 유효성 검사 통과한 걸로 초기화
		
		if(memberIdChk(member.getMemberId())) {
			result = "아이디에는 공백이 들어갈 수 없습니다.";
			
		} else if(memberPwChk(member.getMemberPw())) {
			result = "암호에는 공백이 들어갈 수 없습니다.";
			
		} else if(memberLevelChk(member.getMemberLevel())) {
			result = "권한에는 공백이 들어갈 수 없습니다.";
			
		} else if(memberNameChk(member.getMemberName())) {
			result = "이름에는 공백이 들어갈 수 없습니다.";
			
		} else if(memberEmailChk(member.getMemberEmail())) {
			result = "이메일이 형식에 어긋납니다.\n"
				   + "이메일에는 반드시 @와 .이 들어가야 합니다.";
		}
		return result;
	}
	
	// 아이디 공백(" ") 여부 체크
	private boolean memberIdChk(String memberId) {
	    for(int i = 0; i < memberId.length(); i++) {
	        if(memberId.charAt(i) == ' ')
	            return true;
	    }
	    return false;
	}
	
	// 비밀번호 공백(" ") 여부 체크
	private boolean memberPwChk(String memberPw) {
		for(int i = 0; i < memberPw.length(); i++) {
	        if(memberPw.charAt(i) == ' ')
	            return true;
	    }
		return false;
	}
	
	// 권한 공백(" ") 여부 체크
	private boolean memberLevelChk(String memberLevel) {
		for(int i = 0; i < memberLevel.length(); i++) {
	        if(memberLevel.charAt(i) == ' ')
	            return true;
	    }
		return false;
	}
	
	// 이름 공백(" ") 여부 체크
	private boolean memberNameChk(String memberName) {
		for(int i = 0; i < memberName.length(); i++) {
	        if(memberName.charAt(i) == ' ')
	            return true;
	    }
		return false;
	}
	
	private boolean memberEmailChk(String memberEmail) {
		String[] emailArr = memberEmail.split("[@.]");
		if(emailArr.length == 3) {
			return true;
		}
		return false;
	}
}
