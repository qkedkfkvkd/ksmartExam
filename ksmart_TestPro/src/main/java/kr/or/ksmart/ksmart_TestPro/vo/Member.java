package kr.or.ksmart.ksmart_TestPro.vo;

public class Member {
	private String memberId;
	private String memberPw;
	private String memberLevel;
	private String memberName;
	private String memberEmail;
	
	/// 검색 키워드용
	private String memberSelect;
	private String memberSelText;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberSelect() {
		return memberSelect;
	}
	public void setMemberSelect(String memberSelect) {
		this.memberSelect = memberSelect;
	}
	public String getMemberSelText() {
		return memberSelText;
	}
	public void setMemberSelText(String memberSelText) {
		this.memberSelText = memberSelText;
	}
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", memberLevel=" + memberLevel
				+ ", memberName=" + memberName + ", memberEmail=" + memberEmail + "]";
	}
}
