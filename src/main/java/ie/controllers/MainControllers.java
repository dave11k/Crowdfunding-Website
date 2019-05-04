package ie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ie.dao.*;
import ie.domain.*;
import ie.services.*;

@Controller
public class MainControllers {
	
	@Autowired
	MemberService memberService;
	@Autowired
	PledgeService pledgeService;
	@Autowired
	ProjectService projectService;
	
	@GetMapping(value="/")
	public String handleIndexRequest() {
		return "index";
	}
	
	
	
	
}
