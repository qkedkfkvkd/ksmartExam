package kr.or.ksmart.ksmart_TestPro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.ksmart_TestPro.vo.Member;

@Mapper
public interface MemberMapper {
	public List<Member> memberList();
	public List<Member> memberSelectList(Member member);
	public int addMember(Member member);
	public Member getMemberById(String memberId);
	public int modifyMember(Member member);
	public int deleteMember(Member member);
	public Member loginMember(Member member);
}
