package ie.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ie.domain.*;
import ie.services.*;

@Controller
public class PledgeController {
	
	@Autowired
	PledgeService pledgeService;
	@Autowired
	ProjectService projectService;
	@Autowired
	MemberService memberService;
	
	
	@GetMapping("/newpledge")
	public String addNewPledgeForm(Model model)
	{
		Pledge pledge = new Pledge();		
		model.addAttribute("pledge", pledge);
		model.addAttribute("projects", projectService.listAllProjects());
		
		return "newpledge";
	}
	
	@PostMapping("/newpledge")
	public String addNewPledgeSave(@Valid Pledge pledge, BindingResult binding, RedirectAttributes redirectAttributes)
	{
		pledge.setMember(memberService.findMember(1)); //CHANGE TO ACTUAL MEMBER
		if (binding.hasErrors())
			return "newpledge";
		
		if (pledgeService.addPledge(pledge) == null)
		{
		redirectAttributes.addFlashAttribute("duplicate", true);
		return "redirect:"+pledge.getProject().getProjectId();
		}
		
		return "redirect:"+pledge.getProject().getProjectId();	//******Get rid of parenthesis maybe****
	}
	
	

	
}
