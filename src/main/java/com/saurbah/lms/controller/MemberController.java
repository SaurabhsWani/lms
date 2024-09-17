package com.saurbah.lms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.saurbah.lms.model.Member;
import com.saurbah.lms.repo.MemberRepository;

@Controller
public class MemberController {

	@Autowired
	private MemberRepository repository;

	@GetMapping("/members")
	public String listMember(Model model) {
		model.addAttribute("members", repository.findAll());
		return "members";
	}

	@GetMapping("/member/new")
	public String showCreateForm(Model model) {
		Member member = new Member();
		model.addAttribute("member", member);
		return "create_member";
	}

	@PostMapping("/members")
	public String saveMember(@ModelAttribute Member member) {
		repository.save(member);
		return "redirect:/members";
	}

	@GetMapping("/member/{id}")
	public String getEditMemberForm(Model model, @PathVariable("id") Long id) {
		Optional<Member> member = repository.findById(id);
		if (member.isPresent()) {
			model.addAttribute("member", member);
		} else {
			return "redirect:/members";
		}
		return "update_member";
	}

	@PostMapping("/member/update")
	public String updateMember(Model model, @ModelAttribute Member member) {
		repository.save(member);
		return "redirect:/members";
	}
}
