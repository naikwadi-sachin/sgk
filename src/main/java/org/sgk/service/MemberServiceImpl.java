package org.sgk.service;

import java.util.ArrayList;
import java.util.List;

import org.sgk.domain.Member;

public class MemberServiceImpl implements MemberService{

	private List<Member> memberList = new ArrayList<Member>();
	@Override
	public List<Member> list() {
		return memberList;
	}

	@Override
	public void removeMember(String memberName) {
		
	}

	@Override
	public void addMember(Member member) {
		memberList.add(member);
	}

}
