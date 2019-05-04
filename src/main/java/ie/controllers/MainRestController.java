package ie.controllers;

import ie.services.MemberService;
import ie.services.ProjectService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ie.domain.Project;

@RestController
@RequestMapping("/api")
public class MainRestController {

	@Autowired
	MemberService memberService;

	@Autowired
	ProjectService projectService;

	@GetMapping("/projects")
	List<Project> myRestProjects()
	{
		List<Project> projects = projectService.listAllProjects();
		return projects;
	}

	@PostMapping("/projects")
	List<Project> myRestProjectsList()
	{
		return projectService.listAllProjects();
	}

	@GetMapping("/members")
	List<Project> myRestMemberProjects(int memberId)
	{
		List<Project> projects = memberService.findAllProjectsForMember(memberId);
		return projects;
	}

	@PostMapping("/members")
	List<Project> myRestMemberProjectsList(int memberId)
	{
		return memberService.findAllProjectsForMember(memberId);
	}
}
