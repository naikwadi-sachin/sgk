package org.sgk.controller;

import org.sgk.domain.Member;
import org.sgk.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

	private MemberService memberService;

	public MemberController() {
		// TODO Auto-generated constructor stub
	}
	
	//@Autowired
	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	@RequestMapping("member/add")
	public String addMember(Model model)
	{
		model.addAttribute("member", new Member());
		model.addAttribute("guests", memberService.list());
		return "memberList";
	}
	
	@RequestMapping(value = {"member/remove","member/delete"}, method = RequestMethod.GET)
	public String removeMember(@RequestParam(value="memberName") String memberName)
	{
		memberService.removeMember(memberName);
		return "redirect:";
	}
	
	@RequestMapping(value="display/{user}")
	public String removeMember(@RequestParam(value="memberName") String memberName, @PathVariable String user)
	{
		return "redirect:";
	}
}
