package ie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ie.domain.Project;
import ie.services.MemberService;



@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@GetMapping("/myprojects")
	public String myProjects(Model model) {
		List<Project> myprojects = memberService.findAllProjectsForMember(1);
		model.addAttribute("myprojects", myprojects);
		return "myprojects";
	}
	
	
	
	
	
	
	
	
	
	
	
}
