package org.sgk.service;

import java.util.List;

import org.sgk.domain.Member;

public interface MemberService {

	public List<Member> list();
	public void removeMember(String memberName);
	
}
