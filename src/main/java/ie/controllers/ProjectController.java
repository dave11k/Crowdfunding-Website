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

import ie.domain.Pledge;
import ie.domain.Project;
import ie.services.MemberService;
import ie.services.*;
import ie.dao.*;

@Controller
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	@Autowired
	ProjectDao projectDao;
	@Autowired
	MemberService memberService;
	@Autowired
	PledgeService pledgeService;
	
	
	@GetMapping("/viewproject/{id}")
	public String viewProject(@PathVariable("id") int id, Model model) {
		Project project = projectService.findProject(id);
		model.addAttribute("project", project);
		
		List<Pledge> pledges = pledgeService.findAllPledgesForProject(id);
		model.addAttribute("pledges", pledges);
		
		return "viewproject";
	}
	
	@GetMapping("/viewprojects")
	public String viewProjects(Model model) {
		List<Project> projects = projectService.listAllProjects();
		model.addAttribute("projects", projects);
		return "viewprojects";
	}
	
	@GetMapping("/newproject")
	public String addNewProjectForm(Model model)
	{
		Project project = new Project();		
		model.addAttribute("project", project);
		
		return "newproject";
	}
	
	@PostMapping("/newproject")
	public String addNewProjectSave(@Valid Project project, BindingResult binding, RedirectAttributes redirectAttributes)
	{
		project.setDateCreation(LocalDate.now());
		project.setMember(memberService.findMember(1));	//Make actual current user*************
		if (binding.hasErrors())
			return "newproject";
		
		if (projectService.addProject(project))
			return "redirect:myprojects";
		
		redirectAttributes.addFlashAttribute("duplicate", true);
		return "redirect:newproject";	
	}
	
	
	@GetMapping("/editproject/{id}")
	public String editProjectForm(@PathVariable("id") int id, Model model)
	{
		//Project project = new Project();
		Project project = new Project();
		model.addAttribute("project", project);
		model.addAttribute("id", id);
		
		return "editproject";
	}
	
	@PostMapping("/editproject/{id}")
	public String editProjectSave(@Valid Project project, @PathVariable("id") int id, BindingResult binding, RedirectAttributes redirectAttributes)
	{
		if (binding.hasErrors())
			return "/editproject/" + id;
		
		if (projectService.editDescription(id, project.getDescription()))
			return "redirect:viewproject/"+id;
		
		redirectAttributes.addFlashAttribute("duplicate", true);
		return "redirect:" + id;	
	}
	

}
