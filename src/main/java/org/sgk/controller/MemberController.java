package org.sgk.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.sgk.domain.Member;
import org.sgk.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	private MemberService memberService;
	private Validator validator;

	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
		ValidatorFactory validatorFactory = Validation
				.buildDefaultValidatorFactory();
		this.validator = validatorFactory.getValidator();
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	private String setupForm(Model model) {
		model.addAttribute("member", new Member());
		model.addAttribute("guests", memberService.list());
		return "memberForm";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	private String submitform(@ModelAttribute("member") Member member,
			BindingResult result, Model model) {
		Set<ConstraintViolation<Member>> violations = validator
				.validate(member);
		for (ConstraintViolation<Member> violation : violations) {
			String propertyPath = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			result.addError(new FieldError("member", propertyPath, "Invalid "
					+ propertyPath + " (" + message + ")"));
		}
		if(result.hasErrors())
		{
			return "memberForm";
		}
		else
		{
			memberService.addMember(member);
			return "redirect:list";
		}
	}
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	private String showAllMember(Model model)
	{
		model.addAttribute("members", memberService.list());
		return "memberList";
	}
	
	@RequestMapping(value="summary*",method=RequestMethod.GET)
	private String generateSummary(Model model)
	{
		model.addAttribute("members", memberService.list());
		return "summary";
	}

	@RequestMapping(value = { "remove", "delete" }, method = RequestMethod.GET)
	public String removeMember(
			@RequestParam(value = "memberName") String memberName) {
		memberService.removeMember(memberName);
		return "redirect:list";
	}

	@RequestMapping(value = "display/{user}")
	public String removeMember(
			@RequestParam(value = "memberName") String memberName,
			@PathVariable String user) {
		return "redirect:";
	}
}
